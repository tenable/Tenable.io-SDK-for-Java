package com.tenable.io.api;


import com.tenable.io.api.agentGroups.AgentGroupsApi;
import com.tenable.io.api.agents.AgentsApi;
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
import com.tenable.io.api.targetGroups.TargetGroupsApi;
import com.tenable.io.api.users.UsersApi;
import com.tenable.io.api.workbenches.WorkbenchHelper;
import com.tenable.io.api.workbenches.WorkbenchesApi;
import com.tenable.io.core.services.AsyncHttpService;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class TenableIoClient implements AutoCloseable {
    private static String DEFAULT_TENABLE_IO_SCHEME = "https";
    private static String DEFAULT_TENABLE_IO_HOST = "cloud.tenable.com";
    private String impersonateUsername = null;

    private String accessKey;
    private String secretKey;
    private String tenableIoHost;
    private String tenableIoScheme;

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
    private TargetGroupsApi targetGroupsApi = null;
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
        accessKey = System.getProperty( "tenableIoAccessKey" );
        secretKey = System.getProperty( "tenableIoSecretKey" );
        tenableIoScheme = System.getProperty( "tenableIoScheme" );
        tenableIoHost = System.getProperty( "tenableIoHost" );

        // if not there, default to environment variables
        if( accessKey == null || secretKey == null ) {
            accessKey = System.getenv( "TENABLEIO_ACCESS_KEY" );
            secretKey = System.getenv( "TENABLEIO_SECRET_KEY" );
        }

        if( tenableIoScheme == null ) {
            tenableIoScheme = System.getProperty( "TENABLE_IO_SCHEME" );
            if( tenableIoScheme == null )
                tenableIoScheme = DEFAULT_TENABLE_IO_SCHEME;
        }

        if( tenableIoHost == null ) {
            tenableIoHost = System.getProperty( "TENABLE_IO_HOST" );
            if( tenableIoHost == null )
                tenableIoHost = DEFAULT_TENABLE_IO_HOST;
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
        this.accessKey = accessKey;
        this.secretKey = secretKey;

        tenableIoScheme = System.getProperty( "tenableIoScheme" );
        tenableIoHost = System.getProperty( "tenableIoHost" );

        if( tenableIoScheme == null ) {
            tenableIoScheme = System.getProperty( "TENABLE_IO_SCHEME" );
            if( tenableIoScheme == null )
                tenableIoScheme = DEFAULT_TENABLE_IO_SCHEME;
        }

        if( tenableIoHost == null ) {
            tenableIoHost = System.getProperty( "TENABLE_IO_HOST" );
            if( tenableIoHost == null )
                tenableIoHost = DEFAULT_TENABLE_IO_HOST;
        }

        asyncHttpService = new AsyncHttpService( accessKey, secretKey );
    }


    /**
     * Instantiates a new Tenable IO client which impersonates the given user.
     * Only used via the {@link #impersonate( String ) impersonate} method
     *
     * @param accessKey the access key
     * @param secretKey the secret key
     * @param impersonateUsername the username to impersonate
     */
    private TenableIoClient( String accessKey, String secretKey, String impersonateUsername ) {
        this.accessKey = accessKey;
        this.secretKey = secretKey;
        this.impersonateUsername = impersonateUsername;

        asyncHttpService = new AsyncHttpService( accessKey, secretKey, impersonateUsername );
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
     * Returns a new client which impersonates the given user
     *
     * @param username The username to impersonate
     * @return The new client, which impersonates the given user
     */
    public TenableIoClient impersonate( String username ) {
        return new TenableIoClient( accessKey, secretKey, username );
    }


    /**
     * Closes this resource, relinquishing any underlying resources.
     * This method is invoked automatically on objects managed by the
     * {@code try}-with-resources statement.
     *
     * @throws Exception if this resource cannot be closed
     */
    @Override
    public void close() throws Exception {
        if( asyncHttpService != null )
            asyncHttpService.close();
    }


    /**
     * Gets users API helper.
     *
     * @return the users API helper
     */
    synchronized public UsersApi getUsersApi() {
        if( usersApi == null )
            usersApi = new UsersApi( asyncHttpService, getTenableIoScheme(), getTenableIoHost() );

        return usersApi;
    }


    /**
     * Gets scans api.
     *
     * @return the scans api
     */
    synchronized public ScansApi getScansApi() {
        if( scansApi == null )
            scansApi = new ScansApi( asyncHttpService, getTenableIoScheme(), getTenableIoHost() );

        return scansApi;
    }


    /**
     * Gets folders api.
     *
     * @return the folders api
     */
    synchronized public FoldersApi getFoldersApi() {
        if( foldersApi == null )
            foldersApi = new FoldersApi( asyncHttpService, getTenableIoScheme(), getTenableIoHost() );

        return foldersApi;
    }


    /**
     * Gets policies api.
     *
     * @return the policies api
     */
    synchronized public PoliciesApi getPoliciesApi() {
        if( policiesApi == null )
            policiesApi = new PoliciesApi( asyncHttpService, getTenableIoScheme(), getTenableIoHost() );

        return policiesApi;
    }


    /**
     * Gets editor api.
     *
     * @return the editor api
     */
    synchronized public EditorApi getEditorApi() {
        if( editorApi == null )
            editorApi = new EditorApi( asyncHttpService, getTenableIoScheme(), getTenableIoHost() );

        return editorApi;
    }


    /**
     * Gets file api.
     *
     * @return the file api
     */
    synchronized public FileApi getFileApi() {
        if( fileApi == null )
            fileApi = new FileApi( asyncHttpService, getTenableIoScheme(), getTenableIoHost() );

        return fileApi;
    }


    /**
     * Gets filters api.
     *
     * @return the filters api
     */
    synchronized public FiltersApi getFiltersApi() {
        if( filtersApi == null )
            filtersApi = new FiltersApi( asyncHttpService, getTenableIoScheme(), getTenableIoHost() );

        return filtersApi;
    }


    /**
     * Gets plugins api.
     *
     * @return the plugins api
     */
    synchronized public PluginsApi getPluginsApi() {
        if( pluginsApi == null )
            pluginsApi = new PluginsApi( asyncHttpService, getTenableIoScheme(), getTenableIoHost() );

        return pluginsApi;
    }


    /**
     * Gets user groups api.
     *
     * @return the user groups api
     */
    synchronized public GroupsApi getUserGroupsApi() {
        if( userGroupsApi == null )
            userGroupsApi = new GroupsApi( asyncHttpService, getTenableIoScheme(), getTenableIoHost() );

        return userGroupsApi;
    }


    /**
     * Gets scanner groups api.
     *
     * @return the scanner groups api
     */
    synchronized public ScannerGroupsApi getScannerGroupsApi() {
        if( scannerGroupsApi == null )
            scannerGroupsApi = new ScannerGroupsApi( asyncHttpService, getTenableIoScheme(), getTenableIoHost() );

        return scannerGroupsApi;
    }


    /**
     * Gets scanners api.
     *
     * @return the scanners api
     */
    synchronized public ScannersApi getScannersApi() {
        if( scannersApi == null )
            scannersApi = new ScannersApi( asyncHttpService, getTenableIoScheme(), getTenableIoHost() );

        return scannersApi;
    }


    /**
     * Gets exclusions api.
     *
     * @return the exclusions api
     */
    synchronized public ExclusionsApi getExclusionsApi() {
        if( exclusionsApi == null )
            exclusionsApi = new ExclusionsApi( asyncHttpService, getTenableIoScheme(), getTenableIoHost() );

        return exclusionsApi;
    }


    /**
     * Gets agents api.
     *
     * @return the agents api
     */
    synchronized public AgentsApi getAgentsApi() {
        if( agentsApi == null )
            agentsApi = new AgentsApi( asyncHttpService, getTenableIoScheme(), getTenableIoHost() );

        return agentsApi;
    }


    /**
     * Gets agent groups api.
     *
     * @return the agent groups api
     */
    synchronized public AgentGroupsApi getAgentGroupsApi() {
        if( agentGroupsApi == null )
            agentGroupsApi = new AgentGroupsApi( asyncHttpService, getTenableIoScheme(), getTenableIoHost() );

        return agentGroupsApi;
    }


    /**
     * Gets asset lists api.
     *
     * @return the asset lists api
     */
    synchronized public TargetGroupsApi getTargetGroupsApi() {
        if( targetGroupsApi == null )
            targetGroupsApi = new TargetGroupsApi( asyncHttpService, getTenableIoScheme(), getTenableIoHost() );

        return targetGroupsApi;
    }


    /**
     * Gets permissions api.
     *
     * @return the permissions api
     */
    synchronized public PermissionsApi getPermissionsApi() {
        if( permissionsApi == null )
            permissionsApi = new PermissionsApi( asyncHttpService, getTenableIoScheme(), getTenableIoHost() );

        return permissionsApi;
    }


    /**
     * Gets server api.
     *
     * @return the server api
     */
    synchronized public ServerApi getServerApi() {
        if( serverApi == null )
            serverApi = new ServerApi( asyncHttpService, getTenableIoScheme(), getTenableIoHost() );

        return serverApi;
    }


    /**
     * Gets workbenches api.
     *
     * @return the workbenches api
     */
    synchronized public WorkbenchesApi getWorkbenchesApi() {
        if( workbenchesApi == null )
            workbenchesApi = new WorkbenchesApi( asyncHttpService, getTenableIoScheme(), getTenableIoHost() );

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


    private String getTenableIoHost() {
        return tenableIoHost;
    }

    private String getTenableIoScheme() {
        return tenableIoScheme;
    }
}
