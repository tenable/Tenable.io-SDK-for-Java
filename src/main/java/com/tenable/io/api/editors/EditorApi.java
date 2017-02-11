package com.tenable.io.api.editors;


import com.fasterxml.jackson.core.type.TypeReference;
import com.tenable.io.api.ApiWrapperBase;
import com.tenable.io.api.editors.models.EditorDetail;
import com.tenable.io.api.editors.models.Template;
import com.tenable.io.api.editors.models.TemplateType;
import com.tenable.io.api.plugins.models.PluginDescription;
import com.tenable.io.core.exceptions.TenableIoException;
import com.tenable.io.core.services.AsyncHttpService;
import com.tenable.io.core.services.HttpFuture;

import java.io.File;
import java.util.List;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class EditorApi extends ApiWrapperBase {

    /**
     * Instantiates a new Editor api.
     *
     * @param asyncHttpService the async http service
     * @param apiScheme        the api scheme
     * @param ApiHost          the api host
     */
    public EditorApi( AsyncHttpService asyncHttpService, String apiScheme, String ApiHost ) {
        super( asyncHttpService, apiScheme, ApiHost );
    }


    /**
     * Returns the template list.
     *
     * @param type the type of templates to retrieve (scan or policy).
     * @return the editor list
     * @throws TenableIoException the tenable IO exception
     */
    public List<Template> list( TemplateType type ) throws TenableIoException {
        HttpFuture httpFuture = asyncHttpService.doGet( createBaseUriBuilder( "/editor/" + type +
                "/templates" ).build() );
        return httpFuture.getAsType( new TypeReference<List<Template>>() {}, "templates" );
    }


    /**
     * Returns details for the given template.
     *
     * @param type the type of template to retrieve (scan or policy).
     * @param uuid the uuid for the template.
     * @return the editor detail
     * @throws TenableIoException the tenable IO exception
     */
    public EditorDetail details( TemplateType type, String uuid ) throws TenableIoException {
        HttpFuture httpFuture = asyncHttpService.doGet( createBaseUriBuilder( "/editor/" + type +
                "/templates/" + uuid ).build() );
        return httpFuture.getAsType( EditorDetail.class );
    }


    /**
     * Returns the editor details object.
     *
     * @param type the type of object (scan or policy).
     * @param id   The unique id of the editor.
     * @return the editor detail
     * @throws TenableIoException the tenable IO exception
     */
    public EditorDetail edit( TemplateType type, int id ) throws TenableIoException {
        HttpFuture httpFuture = asyncHttpService.doGet( createBaseUriBuilder( "/editor/" + type +
                "/" + id ).build() );
        return httpFuture.getAsType( EditorDetail.class );
    }


    /**
     * Returns the plugin description
     *
     * @param policyId the id of the policy to lookup.
     * @param familyId the id of the family to lookup within the policy.
     * @param pluginId the id of the plugin to lookup within the family.
     * @return the plugin description
     * @throws TenableIoException the tenable IO exception
     */
    public PluginDescription pluginDescription( int policyId, int familyId, int pluginId ) throws TenableIoException {
        HttpFuture httpFuture = asyncHttpService.doGet( createBaseUriBuilder( "/editor/policy/" + policyId +
                "/families/" + familyId + "/plugins/" + pluginId ).build() );
        return httpFuture.getAsType( PluginDescription.class );
    }


    /**
     * Export the given audit file.
     *
     * @param type            the type of template to retrieve (scan or policy).
     * @param objectId        the unique id of the object.
     * @param fileId          the id of the file to export.
     * @param destinationFile the destination file
     * @throws TenableIoException the tenable IO exception
     */
    public void audits( String type, int objectId, int fileId, File destinationFile ) throws TenableIoException {
        HttpFuture httpFuture = asyncHttpService.doGetDownload( createBaseUriBuilder( "/editor/" + type +
                "/" + objectId + "/audits/" + fileId ).build(), destinationFile );
        httpFuture.get();
    }


}
