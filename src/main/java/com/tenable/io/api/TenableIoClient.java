package com.tenable.io.api;


import com.tenable.io.api.agentGroups.AgentGroupsApi;
import com.tenable.io.api.agents.AgentsApi;
import com.tenable.io.api.assetLists.AssetListsApi;
import com.tenable.io.api.filters.FiltersApi;
import com.tenable.io.api.folders.FolderHelper;
import com.tenable.io.api.permissions.PermissionsApi;
import com.tenable.io.api.scannerGroups.ScannerGroupsApi;
import com.tenable.io.api.editors.EditorApi;
import com.tenable.io.api.file.FileApi;
import com.tenable.io.api.exlusions.ExclusionsApi;
import com.tenable.io.api.folders.FoldersApi;
import com.tenable.io.api.groups.GroupsApi;
import com.tenable.io.api.plugins.PluginsApi;
import com.tenable.io.api.policies.PoliciesApi;
import com.tenable.io.api.scanners.ScannersApi;
import com.tenable.io.api.scans.ScanHelper;
import com.tenable.io.api.scans.ScansApi;
import com.tenable.io.api.server.ServerApi;
import com.tenable.io.api.users.UsersApi;
import com.tenable.io.api.workbenches.WorkbenchHelper;
import com.tenable.io.api.workbenches.WorkbenchesApi;
import com.tenable.io.core.services.AsyncHttpService;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class TenableIoClient {
    private static String TENABLE_IO_SCHEME = "https";
    private static String TENABLE_IO_HOST = "cloud.tenable.com";

    private AsyncHttpService asyncHttpService;
    private UsersApi usersApi = null;
    private ScansApi scansApi = null;
    private FoldersApi foldersApi = null;
    private PoliciesApi policiesApi = null;
    private EditorApi editorApi = null;
    private FileApi fileApi = null;
    private FiltersApi filtersApi = null;
    private PluginsApi pluginsApi = null;
    private GroupsApi userGroupsApi = null;
    private ScannerGroupsApi scannerGroupsApi = null;
    private ScannersApi scannersApi = null;
    private ExclusionsApi exclusionsApi = null;
    private AgentsApi agentsApi = null;
    private AgentGroupsApi agentGroupsApi = null;
    private AssetListsApi assetListsApi = null;
    private PermissionsApi permissionsApi = null;
    private ServerApi serverApi = null;
    private WorkbenchesApi workbenchesApi = null;
    private ScanHelper scanHelper = null;
    private WorkbenchHelper workbenchHelper = null;
    private FolderHelper folderHelper = null;


    /**
     * Instantiates a new Tenable IO client from environment variables.
     * Needs JVM params tenableIoAccessKey and tenableIoSecretKey or environment variables TENABLEIO_ACCESS_KEY and TENABLEIO_SECRET_KEY
     */
    public TenableIoClient() {
        // first check the JVM param
        String accessKey = System.getProperty( "tenableIoAccessKey" );
        String secretKey = System.getProperty( "tenableIoSecretKey" );

        // if not there, default to environment variables
        if( accessKey == null || secretKey == null ) {
            accessKey = System.getenv( "TENABLEIO_ACCESS_KEY" );
            secretKey = System.getenv( "TENABLEIO_SECRET_KEY" );
        }

        asyncHttpService = new AsyncHttpService( accessKey, secretKey );
    }


    /**
     * Instantiates a new Tenable IO client.
     *
     * @param accessKey the access key
     * @param secretKey the secret key
     */
    public TenableIoClient( String accessKey, String secretKey ) {
        asyncHttpService = new AsyncHttpService( accessKey, secretKey );
    }


    /**
     * Instantiates a new Tenable IO client, using the given proxy
     * Note: this constructor is only used for development/debug and TURNS OFF SSL VALIDATION
     *
     * @param asyncHttpService the asyncHttpService to use
     */
    TenableIoClient( AsyncHttpService asyncHttpService ) {
        this.asyncHttpService = asyncHttpService;
    }


    /**
     * Gets users API helper.
     *
     * @return the users API helper
     */
    synchronized public UsersApi getUsersApi() {
        if( usersApi == null )
            usersApi = new UsersApi( asyncHttpService, TENABLE_IO_SCHEME, TENABLE_IO_HOST );

        return usersApi;
    }


    /**
     * Gets scans api.
     *
     * @return the scans api
     */
    synchronized public ScansApi getScansApi() {
        if( scansApi == null )
            scansApi = new ScansApi( asyncHttpService, TENABLE_IO_SCHEME, TENABLE_IO_HOST );

        return scansApi;
    }


    /**
     * Gets folders api.
     *
     * @return the folders api
     */
    synchronized public FoldersApi getFoldersApi() {
        if( foldersApi == null )
            foldersApi = new FoldersApi( asyncHttpService, TENABLE_IO_SCHEME, TENABLE_IO_HOST );

        return foldersApi;
    }


    /**
     * Gets policies api.
     *
     * @return the policies api
     */
    synchronized public PoliciesApi getPoliciesApi() {
        if( policiesApi == null )
            policiesApi = new PoliciesApi( asyncHttpService, TENABLE_IO_SCHEME, TENABLE_IO_HOST );

        return policiesApi;
    }


    /**
     * Gets editor api.
     *
     * @return the editor api
     */
    synchronized public EditorApi getEditorApi() {
        if( editorApi == null )
            editorApi = new EditorApi( asyncHttpService, TENABLE_IO_SCHEME, TENABLE_IO_HOST );

        return editorApi;
    }


    /**
     * Gets file api.
     *
     * @return the file api
     */
    synchronized public FileApi getFileApi() {
        if( fileApi == null )
            fileApi = new FileApi( asyncHttpService, TENABLE_IO_SCHEME, TENABLE_IO_HOST );

        return fileApi;
    }


    /**
     * Gets filters api.
     *
     * @return the filters api
     */
    synchronized public FiltersApi getFiltersApi() {
        if( filtersApi == null )
            filtersApi = new FiltersApi( asyncHttpService, TENABLE_IO_SCHEME, TENABLE_IO_HOST );

        return filtersApi;
    }


    /**
     * Gets plugins api.
     *
     * @return the plugins api
     */
    synchronized public PluginsApi getPluginsApi() {
        if( pluginsApi == null )
            pluginsApi = new PluginsApi( asyncHttpService, TENABLE_IO_SCHEME, TENABLE_IO_HOST );

        return pluginsApi;
    }


    /**
     * Gets user groups api.
     *
     * @return the user groups api
     */
    synchronized public GroupsApi getUserGroupsApi() {
        if( userGroupsApi == null )
            userGroupsApi = new GroupsApi( asyncHttpService, TENABLE_IO_SCHEME, TENABLE_IO_HOST );

        return userGroupsApi;
    }


    /**
     * Gets scanner groups api.
     *
     * @return the scanner groups api
     */
    synchronized public ScannerGroupsApi getScannerGroupsApi() {
        if( scannerGroupsApi == null )
            scannerGroupsApi = new ScannerGroupsApi( asyncHttpService, TENABLE_IO_SCHEME, TENABLE_IO_HOST );

        return scannerGroupsApi;
    }


    /**
     * Gets scanners api.
     *
     * @return the scanners api
     */
    synchronized public ScannersApi getScannersApi() {
        if( scannersApi == null )
            scannersApi = new ScannersApi( asyncHttpService, TENABLE_IO_SCHEME, TENABLE_IO_HOST );

        return scannersApi;
    }


    /**
     * Gets exclusions api.
     *
     * @return the exclusions api
     */
    synchronized public ExclusionsApi getExclusionsApi() {
        if( exclusionsApi == null )
            exclusionsApi = new ExclusionsApi( asyncHttpService, TENABLE_IO_SCHEME, TENABLE_IO_HOST );

        return exclusionsApi;
    }


    /**
     * Gets agents api.
     *
     * @return the agents api
     */
    synchronized public AgentsApi getAgentsApi() {
        if( agentsApi == null )
            agentsApi = new AgentsApi( asyncHttpService, TENABLE_IO_SCHEME, TENABLE_IO_HOST );

        return agentsApi;
    }


    /**
     * Gets agent groups api.
     *
     * @return the agent groups api
     */
    synchronized public AgentGroupsApi getAgentGroupsApi() {
        if( agentGroupsApi == null )
            agentGroupsApi = new AgentGroupsApi( asyncHttpService, TENABLE_IO_SCHEME, TENABLE_IO_HOST );

        return agentGroupsApi;
    }


    /**
     * Gets asset lists api.
     *
     * @return the asset lists api
     */
    synchronized public AssetListsApi getAssetListsApi() {
        if( assetListsApi == null )
            assetListsApi = new AssetListsApi( asyncHttpService, TENABLE_IO_SCHEME, TENABLE_IO_HOST );

        return assetListsApi;
    }


    /**
     * Gets permissions api.
     *
     * @return the permissions api
     */
    synchronized public PermissionsApi getPermissionsApi() {
        if( permissionsApi == null )
            permissionsApi = new PermissionsApi( asyncHttpService, TENABLE_IO_SCHEME, TENABLE_IO_HOST );

        return permissionsApi;
    }


    /**
     * Gets server api.
     *
     * @return the server api
     */
    synchronized public ServerApi getServerApi() {
        if( serverApi == null )
            serverApi = new ServerApi( asyncHttpService, TENABLE_IO_SCHEME, TENABLE_IO_HOST );

        return serverApi;
    }


    /**
     * Gets workbenches api.
     *
     * @return the workbenches api
     */
    synchronized public WorkbenchesApi getWorkbenchesApi() {
        if( workbenchesApi == null )
            workbenchesApi = new WorkbenchesApi( asyncHttpService, TENABLE_IO_SCHEME, TENABLE_IO_HOST );

        return workbenchesApi;
    }


    /**
     * Gets scan helper.
     *
     * @return the scan helper
     */
    synchronized public ScanHelper getScanHelper() {
        if( scanHelper == null )
            scanHelper = new ScanHelper( this );

        return scanHelper;
    }


    /**
     * Gets workbench helper.
     *
     * @return the workbench helper
     */
    synchronized public WorkbenchHelper getWorkbenchHelper() {
        if( workbenchHelper == null )
            workbenchHelper = new WorkbenchHelper( this );

        return workbenchHelper;
    }


    /**
     * Gets folder helper.
     *
     * @return the folder helper
     */
    synchronized public FolderHelper getFolderHelper() {
        if( folderHelper == null )
            folderHelper = new FolderHelper( this );

        return folderHelper;
    }

}
