package com.tenable.io.api.scans;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.tenable.io.api.ApiWrapperBase;
import com.tenable.io.api.plugins.models.PluginOutputResult;
import com.tenable.io.core.exceptions.TenableIoException;
import com.tenable.io.core.services.AsyncHttpService;
import com.tenable.io.core.services.HttpFuture;
import com.tenable.io.api.scans.models.*;
import com.tenable.io.core.utilities.JsonHelper;

import java.io.File;
import java.util.Map;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class ScansApi extends ApiWrapperBase {

    /**
     * Instantiates a new Scans api.
     *
     * @param asyncHttpService the async http service
     * @param apiScheme        the api scheme
     * @param ApiHost          the api host
     */
    public ScansApi( AsyncHttpService asyncHttpService, String apiScheme, String ApiHost ) {
        super( asyncHttpService, apiScheme, ApiHost );
    }


    /**
     * Gets the requested scan attachment file.
     *
     * @param scanId       The id of the scan containing the attachment
     * @param attachmentId The id of the scan attachment
     * @param key          The attachment access token
     * @throws TenableIoException the tenable IO exception
     */
    public void attachments( int scanId, int attachmentId, String key ) throws TenableIoException {
        HttpFuture httpFuture = asyncHttpService.doGet( createBaseUriBuilder( "/scans/" + scanId + "/attachments/" +
                attachmentId ).addParameter( "key", key ).build() );
        httpFuture.get();
    }


    /**
     * Changes the schedule or policy parameters of a scan.
     *
     * @param scanId   The id of the scan to change
     * @param uuid     The uuid for the editor template to use
     * @param settings Settings object to configure a scan
     * @return the configured scan result
     * @throws TenableIoException the tenable IO exception
     */
    public ScanResult configure( int scanId, String uuid, Settings settings ) throws TenableIoException {
        CreateConfigureRequest request = new CreateConfigureRequest().withUuid( uuid ).withSettings( settings );
        HttpFuture httpFuture = asyncHttpService.doPut( createBaseUriBuilder( "/scans/" + scanId ).build(), request );
        return httpFuture.getAsType( ScanResult.class );
    }


    /**
     * Copies the given scan.
     *
     * @param scanId   The id of the scan to export
     * @param folderId The id of the destination folder
     * @param name     The name of the copied scan
     * @return the copied scan
     * @throws TenableIoException the tenable IO exception
     */
    public Scan copy( int scanId, int folderId, String name ) throws TenableIoException {
        CopyRequest request = new CopyRequest().withFolderId( folderId ).withName( name );
        HttpFuture httpFuture = asyncHttpService.doPost( createBaseUriBuilder( "/scans/" + scanId +
                "/copy" ).build(), request );
        return httpFuture.getAsType( Scan.class );
    }


    /**
     * Copies the given scan.
     *
     * @param scanId The id of the scan to export
     * @param name   The name of the copied scan
     * @return the copied scan
     * @throws TenableIoException the tenable IO exception
     */
    public Scan copy( int scanId, String name ) throws TenableIoException {
        CopyRequest request = new CopyRequest().withName( name );
        HttpFuture httpFuture = asyncHttpService.doPost( createBaseUriBuilder( "/scans/" + scanId +
                "/copy" ).build(), request );
        return httpFuture.getAsType( Scan.class );
    }


    /**
     * Copies the given scan.
     *
     * @param scanId   The id of the scan to export
     * @param folderId The id of the destination folder
     * @return the copied scan
     * @throws TenableIoException the tenable IO exception
     */
    public Scan copy( int scanId, int folderId ) throws TenableIoException {
        CopyRequest request = new CopyRequest().withFolderId( folderId );
        HttpFuture httpFuture = asyncHttpService.doPost( createBaseUriBuilder( "/scans/" + scanId +
                "/copy" ).build(), request );
        return httpFuture.getAsType( Scan.class );
    }


    /**
     * Copies the given scan.
     *
     * @param scanId The id of the scan to export
     * @return the copied scan
     * @throws TenableIoException the tenable IO exception
     */
    public Scan copy( int scanId ) throws TenableIoException {
        CopyRequest request = new CopyRequest();
        HttpFuture httpFuture = asyncHttpService.doPost( createBaseUriBuilder( "/scans/" + scanId +
                "/copy" ).build(), request );
        return httpFuture.getAsType( Scan.class );
    }


    /**
     * Creates a scan.
     *
     * @param uuid     The uuid for the editor template to use
     * @param settings the settings object to create a scan
     * @return the scan result
     * @throws TenableIoException the tenable IO exception
     */
    public ScanResult create( String uuid, Settings settings ) throws TenableIoException {
        CreateConfigureRequest request = new CreateConfigureRequest().withUuid( uuid ).withSettings( settings );
        HttpFuture httpFuture = asyncHttpService.doPost( createBaseUriBuilder( "/scans" ).build(), request );
        return httpFuture.getAsType( ScanResult.class, "scan" );
    }


    /**
     * Creates a scan with the global settings.
     *
     * @param uuid     The uuid for the editor template to use
     * @param settings the settings object to create a scan
     * @return the scan result
     * @throws TenableIoException the tenable IO exception
     */
    public ScanResult create( String uuid, Map<String, Object> settings) throws TenableIoException {
        return create(uuid, settings, null);
    }


    /**
     * Creates a scan with the settings and the credentials.
     *
     * @param uuid     The uuid for the editor template to use
     * @param settings the settings object to create a scan
     * @param credentials the credentials object to create a scan
     * @return the scan result
     * @throws TenableIoException the tenable IO exception
     */
    public ScanResult create( String uuid, Map<String, Object> settings, ScanCredentials credentials ) throws TenableIoException {
        CreateConfigureRequestCreds request = new CreateConfigureRequestCreds().withUuid( uuid ).withSettings( settings )
                .withCredentials(credentials);
        HttpFuture httpFuture = asyncHttpService.doPost( createBaseUriBuilder( "/scans" ).build(), request );
        return httpFuture.getAsType( ScanResult.class, "scan" );
    }


    /**
     * Deletes a scan. NOTE: Scans in running, paused or stopping states can not be deleted.
     *
     * @param scanId The id of the scan to delete
     * @throws TenableIoException the tenable IO exception
     */
    public void delete( int scanId ) throws TenableIoException {
        HttpFuture httpFuture = asyncHttpService.doDelete( createBaseUriBuilder( "/scans/" + scanId ).build() );
        httpFuture.get();
    }


    /**
     * Deletes historical results from a scan.
     *
     * @param scanId    The id of the scan
     * @param historyId The id of the results to delete
     * @throws TenableIoException the tenable IO exception
     */
    public void deleteHistory( int scanId, int historyId ) throws TenableIoException {
        HttpFuture httpFuture = asyncHttpService.doDelete( createBaseUriBuilder( "/scans/" + scanId + "/history/" +
                historyId ).build() );
        httpFuture.get();
    }


    /**
     * Returns details for the given scan.
     *
     * @param scanId    The id of the scan to retrieve
     * @param historyId The history_id of the historical data that should be returned
     * @return the scan details
     * @throws TenableIoException the tenable IO exception
     */
    public ScanDetails details( int scanId, int historyId ) throws TenableIoException {
        HttpFuture httpFuture = asyncHttpService.doGet( createBaseUriBuilder( "/scans/" + scanId ).
                addParameter( "history_id", ( (Integer) historyId ).toString() ).build() );
        return httpFuture.getAsType( ScanDetails.class );
    }


    /**
     * Returns details for the given scan.
     *
     * @param scanId The id of the scan to retrieve
     * @return the scan details
     * @throws TenableIoException the tenable IO exception
     */
    public ScanDetails details( int scanId ) throws TenableIoException {
        HttpFuture httpFuture = asyncHttpService.doGet( createBaseUriBuilder( "/scans/" + scanId ).build() );
        return httpFuture.getAsType( ScanDetails.class );
    }


    /**
     * Download an exported scan.
     *
     * @param scanId          The id of the scan to export
     * @param fileId          The id of the file to download (Included in response from /scans/{scan_id}/export)
     * @param destinationFile the file object to return
     * @throws TenableIoException the tenable IO exception
     */
    public void exportDownload( int scanId, int fileId, File destinationFile ) throws TenableIoException {
        HttpFuture httpFuture = asyncHttpService.doGetDownload( createBaseUriBuilder( "/scans/" + scanId +
                "/export/" + fileId + "/download" ).build(), destinationFile );
        httpFuture.get();
    }


    /**
     * Export the given scan. Once requested, the file can be downloaded using the export download method upon
     * receiving a "ready" status from the export status method.
     *
     * @param scanId    the scan id
     * @param historyId the history id
     * @param settings  the ExportScanSettings
     * @return the int
     * @throws TenableIoException the tenable IO exception
     */
    public int exportRequest( int scanId, int historyId, ExportScanSettings settings )
            throws TenableIoException {
        HttpFuture httpFuture = asyncHttpService.doPost( createBaseUriBuilder( "/scans/" + scanId + "/export" ).
                addParameter( "history_id", ( (Integer) historyId ).toString() ).build(), settings );
        return httpFuture.getAsType( int.class, "file" );
    }


    /**
     * Export the given scan. Once requested, the file can be downloaded using the export download method upon
     * receiving a "ready" status from the export status method.
     *
     * @param scanId   the scan id
     * @param settings the ExportScanSettings
     * @return the int
     * @throws TenableIoException the tenable IO exception
     */
    public int exportRequest( int scanId, ExportScanSettings settings )
            throws TenableIoException {
        HttpFuture httpFuture = asyncHttpService.doPost( createBaseUriBuilder( "/scans/" + scanId + "/export" )
                .build(), settings );
        return httpFuture.getAsType( int.class, "file" );
    }


    /**
     * Check the file status of an exported scan. When an export has been requested, it is necessary to poll this
     * endpoint until a "ready" status is returned, at which point the file is complete and can be downloaded using
     * the export download endpoint.
     *
     * @param scanId The id of the scan to export
     * @param fileId The id of the file to poll (Included in response from /scans/{scan_id}/export)
     * @return the status string
     * @throws TenableIoException the tenable IO exception
     */
    public String exportStatus( int scanId, int fileId ) throws TenableIoException {
        HttpFuture httpFuture = asyncHttpService.doGet( createBaseUriBuilder( "/scans/" + scanId + "/export/" +
                fileId + "/status" ).build() );
        return httpFuture.getAsType( String.class, "status" );
    }


    /**
     * Returns details for the given host.
     *
     * @param scanId    The id of the scan to retrieve
     * @param hostId    The id of the host to retrieve
     * @param historyId The history_id of the historical data that should be returned
     * @return the host details
     * @throws TenableIoException the tenable IO exception
     */
    public ScanHostDetails hostDetails( int scanId, int hostId, int historyId ) throws TenableIoException {
        HttpFuture httpFuture = asyncHttpService.doGet( createBaseUriBuilder( "/scans/" + scanId + "/hosts/" +
                hostId ).addParameter( "history_id", ( (Integer) historyId ).toString() ).build() );
        return httpFuture.getAsType( ScanHostDetails.class );
    }


    /**
     * Returns details for the given host.
     *
     * @param scanId The id of the scan to retrieve
     * @param hostId The id of the host to retrieve
     * @return the host details
     * @throws TenableIoException the tenable IO exception
     */
    public ScanHostDetails hostDetails( int scanId, int hostId ) throws TenableIoException {
        HttpFuture httpFuture = asyncHttpService.doGet( createBaseUriBuilder( "/scans/" + scanId + "/hosts/" +
                hostId ).build() );
        return httpFuture.getAsType( ScanHostDetails.class );
    }


    /**
     * Import an existing scan uploaded using file: upload.
     *
     * @param file     The name of the file to import as provided by the response from file: upload
     * @param folderId The id of the destination folder. If not specified, the default folder will be used
     * @param password The password for the file to import (required for nessus.db)
     * @return the scan
     * @throws TenableIoException the tenable IO exception
     */
    public Scan importFile( String file, int folderId, String password, String aggregate  ) throws TenableIoException {
        ImportRequest request = new ImportRequest().withFile( file ).withFolderId( folderId ).withPassword( password );
        HttpFuture httpFuture = asyncHttpService.doPost( createBaseUriBuilder( "/scans/import" )
                .addParameter( "include_aggregate", aggregate ).build(), request );
        return httpFuture.getAsType( Scan.class, "scan" );
    }


    /**
     * Import an existing scan uploaded using file: upload.
     *
     * @param file     The name of the file to import as provided by the response from file: upload
     * @param password The password for the file to import (required for nessus.db)
     * @param aggregate Whether or not the scan details should be included in the Vulnerabilities workbench
     * @return the scan
     * @throws TenableIoException the tenable IO exception
     */
    public Scan importFile( String file, String password, String aggregate ) throws TenableIoException {
        ImportRequest request = new ImportRequest().withFile( file ).withPassword( password );
        HttpFuture httpFuture = asyncHttpService.doPost( createBaseUriBuilder( "/scans/import" )
                .addParameter( "include_aggregate", aggregate ).build(), request );
        return httpFuture.getAsType( Scan.class, "scan" );
    }


    /**
     * Launches a scan.
     *
     * @param scanId     The id of the scan to launch
     * @param altTargets If specified, these targets will be scanned instead of the default. Value can be an array                   where each index is a target, or an array with a single index of comma separated targets.
     * @return the scan uuid
     * @throws TenableIoException the tenable IO exception
     */
    public String launch( int scanId, String[] altTargets ) throws TenableIoException {
        LaunchRequest request = new LaunchRequest().withAltTargets( altTargets );
        HttpFuture httpFuture = asyncHttpService.doPost( createBaseUriBuilder( "/scans/" + scanId +
                "/launch" ).build(), request );
        return httpFuture.getAsType( String.class, "scan_uuid" );
    }


    /**
     * Returns the scan list.
     *
     * @return the scan list result
     * @throws TenableIoException the tenable IO exception
     */
    public ScanListResult list() throws TenableIoException {
        HttpFuture httpFuture = asyncHttpService.doGet( createBaseUriBuilder( "/scans" ).build() );
        return httpFuture.getAsType( ScanListResult.class );
    }


    /**
     * Returns the scan list.
     *
     * @param folderId The id of the folder whose scans should be listed
     * @return the scan list result
     * @throws TenableIoException the tenable IO exception
     */
    public ScanListResult list( int folderId ) throws TenableIoException {
        HttpFuture httpFuture = asyncHttpService.doGet( createBaseUriBuilder( "/scans" ).
                addParameter( "folder_id", ( (Integer) folderId ).toString() ).build() );
        return httpFuture.getAsType( ScanListResult.class );
    }


    /**
     * Returns the scan list.
     *
     * @param lastModificationDate Limit the results to those that have only changed since this time
     * @return the scan list result
     * @throws TenableIoException the tenable IO exception
     */
    public ScanListResult listSince( int lastModificationDate ) throws TenableIoException {
        HttpFuture httpFuture = asyncHttpService.doGet( createBaseUriBuilder( "/scans" ).
                addParameter( "last_modification_date", ( (Integer) lastModificationDate ).toString() ).build() );
        return httpFuture.getAsType( ScanListResult.class );
    }


    /**
     * List scan list result.
     *
     * @param folderId             The id of the folder whose scans should be listed
     * @param lastModificationDate Limit the results to those that have only changed since this time
     * @return the scan list result
     * @throws TenableIoException the tenable IO exception
     */
    public ScanListResult list( int folderId, int lastModificationDate ) throws TenableIoException {
        HttpFuture httpFuture = asyncHttpService.doGet( createBaseUriBuilder( "/scans" ).
                addParameter( "folder_id", ( (Integer) folderId ).toString() ).
                addParameter( "last_modification_date", ( (Integer) lastModificationDate ).toString() ).build() );
        return httpFuture.getAsType( ScanListResult.class );
    }


    /**
     * Pauses a scan.
     *
     * @param scanId The id of the scan to pause
     * @throws TenableIoException the tenable IO exception
     */
    public void pause( int scanId ) throws TenableIoException {
        HttpFuture httpFuture = asyncHttpService.doPost( createBaseUriBuilder( "/scans/" + scanId +
                "/pause" ).build(), new ScheduleRequest() );
        httpFuture.get();
    }


    /**
     * Returns the output for a given plugin.
     *
     * @param scanId    The id of the scan to retrieve
     * @param hostId    The id of the host to retrieve
     * @param pluginId  The id of the plugin to retrieve
     * @param historyId The history_id of the historical data that should be returned
     * @return the plugin output result
     * @throws TenableIoException the tenable IO exception
     */
    public PluginOutputResult pluginOutput( int scanId, int hostId, int pluginId, int historyId )
            throws TenableIoException {
        HttpFuture httpFuture = asyncHttpService.doGet( createBaseUriBuilder( "/scans/" + scanId + "/hosts/" +
                hostId + "/plugins/" + pluginId ).addParameter( "history_id", ( (Integer) historyId ).toString() ).build() );
        return httpFuture.getAsType( PluginOutputResult.class );
    }


    /**
     * Returns the output for a given plugin.
     *
     * @param scanId   The id of the scan to retrieve
     * @param hostId   The id of the host to retrieve
     * @param pluginId The id of the plugin to retrieve
     * @return the plugin output result
     * @throws TenableIoException the tenable IO exception
     */
    public PluginOutputResult pluginOutput( int scanId, int hostId, int pluginId )
            throws TenableIoException {
        HttpFuture httpFuture = asyncHttpService.doGet( createBaseUriBuilder( "/scans/" + scanId + "/hosts/" +
                hostId + "/plugins/" + pluginId ).build() );
        return httpFuture.getAsType( PluginOutputResult.class );
    }


    /**
     * Changes the status of a scan.
     *
     * @param scanId The id of the scan to change
     * @param read   If true, the scan has been read
     * @throws TenableIoException the tenable IO exception
     */
    public void readStatus( int scanId, boolean read ) throws TenableIoException {
        ReadStatusRequest request = new ReadStatusRequest().withRead( read );
        HttpFuture httpFuture = asyncHttpService.doPut( createBaseUriBuilder( "/scans/" + scanId +
                "/status" ).build(), request );
        httpFuture.get();
    }


    /**
     * Resumes a scan.
     *
     * @param scanId The id of the scan to resume
     * @throws TenableIoException the tenable IO exception
     */
    public void resume( int scanId ) throws TenableIoException {
        HttpFuture httpFuture = asyncHttpService.doPost( createBaseUriBuilder( "/scans/" + scanId +
                "/resume" ).build(), new CopyRequest() );
        httpFuture.get();
    }


    /**
     * Enables or disables a scan schedule.
     *
     * @param scanId  The id of the scan
     * @param enabled Enables or disables the scan schedule
     * @return the schedule
     * @throws TenableIoException the tenable IO exception
     */
    public Schedule schedule( int scanId, boolean enabled ) throws TenableIoException {
        ScheduleRequest request = new ScheduleRequest().withEnabled( enabled );
        HttpFuture httpFuture = asyncHttpService.doPut( createBaseUriBuilder( "/scans/" + scanId +
                "/schedule" ).build(), request );
        return httpFuture.getAsType( Schedule.class );
    }


    /**
     * Stops a scan.
     *
     * @param scanId The id of the scan to stop
     * @throws TenableIoException the tenable IO exception
     */
    public void stop( int scanId ) throws TenableIoException {
        HttpFuture httpFuture = asyncHttpService.doPost( createBaseUriBuilder( "/scans/" + scanId +
                "/stop" ).build(), new ScheduleRequest() );
        httpFuture.get();
    }


    /**
     * Returns the timezone list for creating a scan.
     *
     * @return the timezones result
     * @throws TenableIoException the tenable IO exception
     */
    public TimezonesResult timezones() throws TenableIoException {
        HttpFuture httpFuture = asyncHttpService.doGet( createBaseUriBuilder( "/scans/timezones" ).build() );
        return httpFuture.getAsType( TimezonesResult.class );
    }


    /**
     * Move a scan to a folder.
     *
     * @param scanId   The id of the scan to move
     * @param folderId The folder id to move the scan to
     * @throws TenableIoException the tenable IO exception
     */
    public void folder( int scanId, int folderId ) throws TenableIoException {
        MoveToFolderRequest request = new MoveToFolderRequest().withFolderId( folderId );
        HttpFuture httpFuture = asyncHttpService.doPut( createBaseUriBuilder( "/scans/" + scanId +
                "/folder" ).build(), request );
        httpFuture.get();
    }


    /**
     * Gets information about a scan history.
     *
     * @param scheduleUuid The schedule UUID of the scan history to get info for
     * @param historyUuid  The history UUID
     * @return the scan history status
     * @throws TenableIoException the tenable IO exception
     */
    public ScanHistoryInfo getScanHistoryStatus( String scheduleUuid, String historyUuid ) throws TenableIoException {
        HttpFuture httpFuture = asyncHttpService.doGet( createBaseUriBuilder( String.format( "/scans/%s/history/%s", scheduleUuid, historyUuid ) ).build() );
        return httpFuture.getAsType( ScanHistoryInfo.class );
    }


    @JsonInclude( JsonInclude.Include.NON_DEFAULT )
    private class CopyRequest {
        private int folderId;
        private String name;


        /**
         * Gets folder id.
         *
         * @return the folder id
         */
        @JsonProperty( "folder_id" )
        public int getFolderId() {
            return folderId;
        }


        /**
         * Sets folder id.
         *
         * @param folderId the folder id
         */
        @JsonProperty( "folder_id" )
        public void setFolderId( int folderId ) {
            this.folderId = folderId;
        }


        /**
         * Gets name.
         *
         * @return the name
         */
        public String getName() {
            return name;
        }


        /**
         * Sets name.
         *
         * @param name the name
         */
        public void setName( String name ) {
            this.name = name;
        }


        /**
         * Sets folder id.
         *
         * @param folderId the folder id
         * @return the copy request
         */
        public CopyRequest withFolderId( int folderId ) {
            this.folderId = folderId;
            return this;
        }


        /**
         * Sets name.
         *
         * @param name the name
         * @return the copy request
         */
        public CopyRequest withName( String name ) {
            this.name = name;
            return this;
        }
    }

    @JsonInclude( JsonInclude.Include.NON_DEFAULT )
    private class CreateConfigureRequest {
        private String uuid;
        private Settings settings;


        /**
         * Gets uuid.
         *
         * @return the uuid
         */
        public String getUuid() {
            return uuid;
        }


        /**
         * Sets uuid.
         *
         * @param uuid the uuid
         */
        public void setUuid( String uuid ) {
            this.uuid = uuid;
        }


        /**
         * Gets settings.
         *
         * @return the settings
         */
        public Settings getSettings() {
            return settings;
        }


        /**
         * Sets settings.
         *
         * @param settings the settings
         */
        public void setSettings( Settings settings ) {
            this.settings = settings;
        }


        /**
         * Sets settings.
         *
         * @param settings the settings
         * @return the create configure request
         */
        public CreateConfigureRequest withSettings( Settings settings ) {
            this.settings = settings;
            return this;
        }


        /**
         * Sets uuid.
         *
         * @param uuid the uuid
         * @return the create configure request
         */
        public CreateConfigureRequest withUuid( String uuid ) {
            this.uuid = uuid;
            return this;
        }
    }

    @JsonInclude( JsonInclude.Include.NON_DEFAULT )
    private class CreateConfigureRequestCreds {
        private String uuid;
        private ScanCredentials credentials;
        private Map<String, Object> settings;


        /**
         * Gets uuid.
         *
         * @return the uuid
         */
        public String getUuid() {
            return uuid;
        }


        /**
         * Sets uuid.
         *
         * @param uuid the uuid
         */
        public void setUuid( String uuid ) {
            this.uuid = uuid;
        }


        /**
         * Gets settings.
         *
         * @return the settings
         */
        public Map<String, Object> getSettings() {
            return settings;
        }


        /**
         * Sets credentials.
         *
         * @param credentials the credentials
         */
        public void setCredentials( ScanCredentials credentials ) {
            this.credentials = credentials;
        }

        /**
         * Gets credentials.
         *
         * @return the credentials
         */
        public ScanCredentials getCredentials() {
            return credentials;
        }


        /**
         * Sets settings.
         *
         * @param settings the settings
         */
        public void setSettings( Map<String, Object> settings ) {
            this.settings = settings;
        }


        /**
         * Sets settings.
         *
         * @param settings the settings
         * @return the create configure request
         */
        public CreateConfigureRequestCreds withSettings( Map<String, Object> settings ) {
            this.settings = settings;
            return this;
        }

        /**
         * Sets credentials.
         *
         * @param credentials the credentials
         * @return the create configure request
         */
        public CreateConfigureRequestCreds withCredentials( ScanCredentials credentials ) {
            if (credentials == null) {
                credentials = new ScanCredentials();
            }
            this.credentials = credentials;
            return this;
        }


        /**
         * Sets uuid.
         *
         * @param uuid the uuid
         * @return the create configure request
         */
        public CreateConfigureRequestCreds withUuid( String uuid ) {
            this.uuid = uuid;
            return this;
        }
    }

    @JsonInclude( JsonInclude.Include.NON_DEFAULT )
    private class ImportRequest {
        private String file;
        private int folderId;
        private String password;


        /**
         * Gets file.
         *
         * @return the file
         */
        public String getFile() {
            return file;
        }


        /**
         * Sets file.
         *
         * @param file the file
         */
        public void setFile( String file ) {
            this.file = file;
        }


        /**
         * Gets folder id.
         *
         * @return the folder id
         */
        @JsonProperty( "folder_id" )
        public int getFolderId() {
            return folderId;
        }


        /**
         * Sets folder id.
         *
         * @param folderId the folder id
         */
        @JsonProperty( "folder_id" )
        public void setFolderId( int folderId ) {
            this.folderId = folderId;
        }


        /**
         * Gets password.
         *
         * @return the password
         */
        public String getPassword() {
            return password;
        }


        /**
         * Sets password.
         *
         * @param password the password
         */
        public void setPassword( String password ) {
            this.password = password;
        }


        /**
         * Sets file.
         *
         * @param file the file
         * @return the import request
         */
        public ImportRequest withFile( String file ) {
            this.file = file;
            return this;
        }


        /**
         * Sets folder id.
         *
         * @param folderId the folder id
         * @return the import request
         */
        public ImportRequest withFolderId( int folderId ) {
            this.folderId = folderId;
            return this;
        }


        /**
         * Sets password.
         *
         * @param password the password
         * @return the import request
         */
        public ImportRequest withPassword( String password ) {
            this.password = password;
            return this;
        }
    }

    @JsonInclude( JsonInclude.Include.NON_DEFAULT )
    private class LaunchRequest {
        private String[] altTargets;


        /**
         * Get alt targets string [ ].
         *
         * @return the string [ ]
         */
        @JsonProperty( "alt_targets" )
        public String[] getAltTargets() {
            return altTargets;
        }


        /**
         * Sets alt targets.
         *
         * @param altTargets the alt targets
         */
        @JsonProperty( "alt_targets" )
        public void setAltTargets( String[] altTargets ) {
            this.altTargets = altTargets;
        }


        /**
         * Sets alt targets.
         *
         * @param altTargets the alt targets
         * @return the launch request
         */
        public LaunchRequest withAltTargets ( String[] altTargets ) {
            this.altTargets = altTargets;
            return this;
        }
    }

    private class ReadStatusRequest {
        private boolean read;


        /**
         * Is read boolean.
         *
         * @return the boolean
         */
        public boolean isRead() {
            return read;
        }


        /**
         * Sets read.
         *
         * @param read the read
         */
        public void setRead( boolean read ) {
            this.read = read;
        }


        /**
         * Sets read.
         *
         * @param read the read
         * @return the read status request
         */
        public ReadStatusRequest withRead( boolean read ) {
            this.read = read;
            return this;
        }
    }

    @JsonInclude( JsonInclude.Include.NON_DEFAULT )
    private class ScheduleRequest {
        private boolean enabled;


        /**
         * Is enabled boolean.
         *
         * @return the boolean
         */
        public boolean isEnabled() {
            return enabled;
        }


        /**
         * Sets enabled.
         *
         * @param enabled the enabled
         */
        public void setEnabled( boolean enabled ) {
            this.enabled = enabled;
        }


        /**
         * Sets enabled.
         *
         * @param enabled the enabled
         * @return the schedule request
         */
        public ScheduleRequest withEnabled( boolean enabled ) {
            this.enabled = enabled;
            return this;
        }
    }

    @JsonInclude( JsonInclude.Include.NON_DEFAULT )
    private class MoveToFolderRequest {
        private int folderId;


        /**
         * Gets folder id.
         *
         * @return the folder id
         */
        @JsonProperty( "folder_id" )
        public int getFolderId() {
            return folderId;
        }


        /**
         * Sets folder id.
         *
         * @param folderId the folder id
         */
        @JsonProperty( "folder_id" )
        public void setFolderId( int folderId ) {
            this.folderId = folderId;
        }


        /**
         * With folder id move to folder request.
         *
         * @param folderId the folder id
         * @return the move to folder request
         */
        public MoveToFolderRequest withFolderId( int folderId ) {
            this.folderId = folderId;
            return this;
        }
    }
}
