package com.tenable.io.core.utilities;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.tenable.io.api.TenableIoClient;
import com.tenable.io.core.exceptions.TenableIoErrorCode;
import com.tenable.io.core.exceptions.TenableIoException;
import com.tenable.io.core.services.AsyncHttpService;
import com.tenable.io.core.services.HttpFuture;
import com.tenable.io.core.utilities.models.DockerImageUploadData;
import com.tenable.io.core.utilities.models.TokenData;
import org.apache.commons.codec.binary.Base64;
import org.apache.http.Header;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.message.BasicHeader;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class DockerImageHelper {
    private final String REGISTRY_HOST = "registry.cloud.tenable.com";
    private final String REGISTRY_PROTOCOL = "https";

    /**
     * Upload docker image docker image upload data.
     *
     * @param name the name
     * @param tag the tag
     * @param vulnerable the vulnerable
     * @return the docker image upload data
     * @throws TenableIoException the tenable io exception
     */
    public DockerImageUploadData uploadDockerImage( String name, String tag, Boolean vulnerable ) throws TenableIoException {
        SessionIdentifierGenerator hashGen = new SessionIdentifierGenerator();
        name += "_" + hashGen.nextSessionId();

        String filePath = "src/test/resources/scratch.tgz";
        String digestTar = "sha256:188307c3217788f441fa8a31e1bdbc4b4286a12b12da90038a8b1e22241176c5"; // tar
        String digestTgz = "sha256:96626451b6947696c15b96333de54fd329f8f8cb5073163ef881153b37aafe7d"; // tgz

        if (vulnerable) {
            filePath = "src/test/resources/alpine_3_1.tgz";
            digestTar = "sha256:534a5cc0b456e6d82b52614ef3a731e2afc19c89f991c11b41d364727bea7c2d"; // tar
            digestTgz = "sha256:57735dd315307043f9d21fe748f1c5bab781514b4db2c7f8cbac34ba39331178"; // tgz
        }

        // Get Authorization Token for Session
        String token = getAuthorizationToken().getToken();

        // Get upload URL for the layer.
        String headerLocationUrl = getLayerUploadUrl( token, name );

        // Upload the layer as tar-gzip.
        uploadTarZip( token, headerLocationUrl, digestTgz, filePath );

        // Get the layer length.
        int dataSize = getContentLength( token, name, digestTgz );

        // Get upload URL for the config.
        headerLocationUrl = getConfigUploadUrl( token, name );

        // Upload the config.
        String configDigest = uploadConfig( token, digestTar, headerLocationUrl );

        // Get the config length.
        int configSize = getContentLength( token, name, configDigest );

        // Upload the manifest.
        String manifestDigest = uploadManifest( token, name, tag, configSize, configDigest, dataSize, digestTgz );

        String id = configDigest.split( "sha256:" )[1].substring( 0, 12 );
        String digest = manifestDigest.split( "sha256:" )[1];

        return new DockerImageUploadData( name, tag, id, digest );
    }

    /**
     * Delete docker image.
     *
     * @param digest the digest
     * @throws TenableIoException the tenable io exception
     */
    public void deleteDockerImage( String digest ) throws TenableIoException {
        TenableIoClient apiClient = new TenableIoClient();
        apiClient.getCsImagesApi().delete( "library", digest );
    }

    private TokenData getAuthorizationToken() throws TenableIoException {
        List<Header> headers = new ArrayList( 1 );
        String base64Params = Base64.encodeBase64String( ( ApiParametersHelper.getAccessKey() + ":" + ApiParametersHelper.getSecretKey() ).getBytes() ).toString();

        headers.add( new BasicHeader( "Authorization", "Basic " + base64Params ) );

        AsyncHttpService asyncHttpService = new AsyncHttpService( headers );
        HttpFuture httpFuture = asyncHttpService.doGet( getHostUrl( "/v2/token" ).addParameter( "service", "tenable.io" ).build() );
        TokenData tokenData = httpFuture.getAsType( new TypeReference<TokenData>() {} );

        return tokenData;
    }

    private String getLayerUploadUrl( String token, String name ) throws TenableIoException {
        List<Header> headers = new ArrayList( 1 );
        headers.add( getTokenHeader( token ) );
        headers.add( new BasicHeader( "Content-Type", "application/x-www-form-urlencoded" ) );

        StringBuilder hostUrlParams = new StringBuilder();
        hostUrlParams.append( "/v2/" ).append( name ).append( "/blobs/uploads/" );

        AsyncHttpService asyncHttpService = new AsyncHttpService( headers );
        HttpFuture httpFuture = asyncHttpService.doPost( getHostUrl( hostUrlParams.toString() ).build() );

        return httpFuture.getResponseHeaders( "Location" )[0].getValue();
    }

    private void uploadTarZip( String token, String headerLocationUrl, String digestTgz, String filePath ) throws TenableIoException {
        Header[] headersArray = new Header[2];
        headersArray[0] = getTokenHeader( token );
        headersArray[1] = new BasicHeader( "Content-Type", "application/vnd.docker.image.rootfs.diff.tar.gzip" );

        try {
            byte[] fileBinary = Files.readAllBytes( Paths.get( filePath ) );
            URIBuilder uploadUrl = new URIBuilder( headerLocationUrl );
            uploadUrl.addParameter( "digest", digestTgz );

            AsyncHttpService asyncHttpService = new AsyncHttpService( null );
            HttpFuture httpFuture = asyncHttpService.doPut( uploadUrl.build(), ContentType.DEFAULT_BINARY, fileBinary, headersArray );
            httpFuture.get();
        } catch ( Exception e ) {
            throw new TenableIoException( TenableIoErrorCode.Generic, "Error while uploading tar zip.", e );
        }
    }

    private int getContentLength( String token, String name, String digest ) throws TenableIoException {
        List<Header> headers = new ArrayList( 2 );
        headers.add( getTokenHeader( token ) );

        StringBuilder hostUrlParams = new StringBuilder();
        hostUrlParams.append( "/v2/" ).append( name ).append( "/blobs/" ).append( digest );

        try {
            AsyncHttpService asyncHttpService = new AsyncHttpService( headers );
            HttpFuture httpFuture = asyncHttpService.doHead( getHostUrl( hostUrlParams.toString() ).build() );

            return Integer.parseInt( httpFuture.getResponseHeaders( "Content-Length" )[0].getValue() );
        } catch ( Exception e ) {
            return 0;
        }
    }

    private String getConfigUploadUrl( String token, String name ) throws TenableIoException {
        List<Header> headers = new ArrayList( 2 );
        headers.add( getTokenHeader( token ) );
        headers.add( new BasicHeader( "Content-Type", "application/x-www-form-urlencoded" ) );

        StringBuilder hostUrlParams = new StringBuilder();
        hostUrlParams.append( "/v2/" ).append( name ).append( "/blobs/uploads/" );

        AsyncHttpService asyncHttpService = new AsyncHttpService( headers );
        HttpFuture httpFuture = asyncHttpService.doPost( getHostUrl( hostUrlParams.toString() ).build() );

        return httpFuture.getResponseHeaders( "Location" )[0].getValue();
    }

    private String uploadConfig( String token, String digestTar, String headerLocationUrl ) throws TenableIoException {
        Header[] headerArray = new Header[2];
        headerArray[0] = getTokenHeader( token );
        headerArray[1] = new BasicHeader( "Content-Type", "application/vnd.docker.container.image.v1+json" );

        ObjectMapper mapper = new ObjectMapper();

        ObjectNode data = mapper.createObjectNode();
        data.put( "architecture", "amd64" );
        data.set( "config", mapper.createObjectNode() );
        data.put( "created", "1970-01-01T00:00:01Z" );
        data.put( "os", "linux" );

        /* property=history object */

        ObjectNode createdNode = mapper.createObjectNode();
        createdNode.put( "created", "1970-01-01T00:00:01Z" );

        data.set( "history", createdNode );


        /* property=rootfs object */

        ObjectNode rootfsNode = mapper.createObjectNode();
        rootfsNode.put( "type", "layers" );
        rootfsNode.set( "diff_ids", mapper.createArrayNode().add( digestTar ) );

        data.set( "rootfs", rootfsNode );

        try {
            String configDigest = "sha256:" + HashHelper.hashSha256( data.toString() );
            URIBuilder uploadUrl = new URIBuilder( headerLocationUrl );
            uploadUrl.addParameter( "digest", configDigest );

            AsyncHttpService asyncHttpService = new AsyncHttpService( null );
            HttpFuture httpFuture = asyncHttpService.doPut(
                    uploadUrl.build(),
                    ContentType.create( "application/vnd.docker.container.image.v1+json", "UTF-8" ),
                    data.toString().getBytes( "UTF-8" ),
                    headerArray
            );
            httpFuture.get();

            return configDigest;
        } catch ( Exception e ) {
            throw new TenableIoException( TenableIoErrorCode.Generic, "Error while uploading config.", e );
        }
    }

    private String uploadManifest( String token, String name, String tag, int configSize, String configDigest, int dataSize, String digestTgz ) throws TenableIoException {
        List<Header> headers = new ArrayList( 2 );
        headers.add( getTokenHeader( token ) );
        headers.add( new BasicHeader( "Content-Type", "application/vnd.docker.distribution.manifest.v2+json" ) );

        ObjectMapper mapper = new ObjectMapper();

        ObjectNode configNode = mapper.createObjectNode();
        configNode.put( "mediaType", "application/vnd.docker.container.image.v1+json" );
        configNode.put( "size", configSize );
        configNode.put( "digest", configDigest );

        ObjectNode layerNode = mapper.createObjectNode();
        layerNode.put( "mediaType", "application/vnd.docker.image.rootfs.diff.tar.gzip" );
        layerNode.put( "size", dataSize );
        layerNode.put( "digest", digestTgz );

        ObjectNode manifest = mapper.createObjectNode();
        manifest.put( "schemaVersion", 2 );
        manifest.put( "mediaType", "application/vnd.docker.distribution.manifest.v2+json" );
        manifest.set( "config", configNode );
        manifest.set( "layers", mapper.createArrayNode().add( layerNode ) );

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode manifestJson = objectMapper.readTree( manifest.toString() );

            StringBuilder hostUrlParams = new StringBuilder();
            hostUrlParams.append( "/v2/" ).append( name ).append( "/manifests/" ).append( tag );

            AsyncHttpService asyncHttpService = new AsyncHttpService( headers );
            HttpFuture httpFuture = asyncHttpService.doPut( getHostUrl( hostUrlParams.toString() ).build(), manifestJson );

            return httpFuture.getResponseHeaders( "Docker-Content-Digest" )[0].getValue();
        } catch ( Exception e ) {
            throw new TenableIoException( TenableIoErrorCode.Generic, "Error while uploading manifest.", e );
        }
    }

    private Header getTokenHeader( String token ) {
        return new BasicHeader( "Authorization", "Bearer " + token );
    }

    private UriBuilderHelper getHostUrl( String path ) {
        return new UriBuilderHelper( REGISTRY_PROTOCOL, REGISTRY_HOST, path );
    }
}
