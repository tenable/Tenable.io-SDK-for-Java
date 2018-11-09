package com.tenable.io.api;


import com.tenable.io.api.agentExclusions.AgentExclusionsApi;
import com.tenable.io.api.agentConfig.AgentConfigApi;
import com.tenable.io.api.agentGroups.AgentGroupsApi;
import com.tenable.io.api.agents.AgentsApi;
import com.tenable.io.api.assetImport.AssetImportApi;
import com.tenable.io.api.bulkOperations.BulkAgentApi;
import com.tenable.io.api.containerSecurity.CsTestJobsApi;
import com.tenable.io.api.containerSecurity.CsImagesApi;
import com.tenable.io.api.containerSecurity.CsPolicyApi;
import com.tenable.io.api.containerSecurity.CsReportsApi;
import com.tenable.io.api.editors.EditorApi;
import com.tenable.io.api.exclusions.ExclusionsApi;
import com.tenable.io.api.exports.ExportsApi;
import com.tenable.io.api.file.FileApi;
import com.tenable.io.api.filters.FiltersApi;
import com.tenable.io.api.folders.FolderHelper;
import com.tenable.io.api.folders.FoldersApi;
import com.tenable.io.api.groups.GroupsApi;
import com.tenable.io.api.permissions.PermissionsApi;
import com.tenable.io.api.plugins.PluginsApi;
import com.tenable.io.api.policies.PoliciesApi;
import com.tenable.io.api.scannerGroups.ScannerGroupsApi;
import com.tenable.io.api.scanners.ScannersApi;
import com.tenable.io.api.scans.ScanHelper;
import com.tenable.io.api.scans.ScansApi;
import com.tenable.io.api.server.ServerApi;
import com.tenable.io.api.tags.TagsApi;
import com.tenable.io.api.targetGroups.TargetGroupsApi;
import com.tenable.io.api.users.UsersApi;
import com.tenable.io.api.workbenches.WorkbenchHelper;
import com.tenable.io.api.workbenches.WorkbenchesApi;
import com.tenable.io.core.services.AsyncHttpService;
import com.tenable.io.core.utilities.ApiParametersHelper;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class TenableIoClient implements AutoCloseable {
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
    private TagsApi tagsApi = null;
    private WorkbenchesApi workbenchesApi = null;
    private ScanHelper scanHelper = null;
    private WorkbenchHelper workbenchHelper = null;
    private FolderHelper folderHelper = null;
    private CsImagesApi csImagesApi = null;
    private CsReportsApi csReportsApi = null;
    private CsTestJobsApi csTestJobsApi = null;
    private CsPolicyApi csPolicyApi = null;
    private BulkAgentApi bulkAgentApi = null;
    private AgentExclusionsApi agentExclusionsApi = null;
    private AgentConfigApi agentConfigApi = null;
    private AssetImportApi assetImportApi = null;
    private ExportsApi exportsApi = null;

    /**
     * Instantiates a new Tenable IO client from environment variables.
     * Needs JVM params tenableIoAccessKey and tenableIoSecretKey or environment variables TENABLEIO_ACCESS_KEY and TENABLEIO_SECRET_KEY
     */
    public TenableIoClient() {
        accessKey = ApiParametersHelper.getAccessKey();
        secretKey = ApiParametersHelper.getSecretKey();
        tenableIoScheme = ApiParametersHelper.getTenableIoScheme();
        tenableIoHost = ApiParametersHelper.getTenableIoHost();

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

        tenableIoScheme = ApiParametersHelper.getTenableIoScheme();
        tenableIoHost = ApiParametersHelper.getTenableIoHost();

        asyncHttpService = new AsyncHttpService( accessKey, secretKey );
    }

    /**
     * Instantiates a new Tenable IO client.
     *
     * @param host       io host url
     * @param hostScheme io host scheme
     * @param accessKey  the access key
     * @param secretKey  the secret key
     */
    public TenableIoClient( String host, String hostScheme, String accessKey, String secretKey ) {
        this.accessKey = accessKey;
        this.secretKey = secretKey;

        tenableIoScheme = hostScheme;
        tenableIoHost = host;

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
     * Gets container security container images api.
     *
     * @return the container security container images api.
     */
    synchronized public CsImagesApi getCsImagesApi() {
        if ( csImagesApi == null )
            csImagesApi = new CsImagesApi( asyncHttpService, getTenableIoScheme(), getTenableIoHost() );

        return csImagesApi;
    }

    /**
     * Gets container security container reports api.
     *
     * @return the container security container reports api.
     */
    synchronized public CsReportsApi getCsReportsApi() {
        if ( csReportsApi == null )
            csReportsApi = new CsReportsApi( asyncHttpService, getTenableIoScheme(), getTenableIoHost() );

        return csReportsApi;
    }

    /**
     * Gets container security test jobs api.
     *
     * @return the container security test jobs api
     */
    synchronized public CsTestJobsApi getCsTestJobsApi() {
        if ( csTestJobsApi == null )
            csTestJobsApi = new CsTestJobsApi( asyncHttpService, getTenableIoScheme(), getTenableIoHost() );

        return csTestJobsApi;
    }

    /**
     * Gets cs policy api.
     *
     * @return the cs policy api
     */
    synchronized public CsPolicyApi getCsPolicyApi() {
        if ( csPolicyApi == null )
            csPolicyApi = new CsPolicyApi( asyncHttpService, getTenableIoScheme(), getTenableIoHost() );

        return csPolicyApi;
    }

    /**
     * Gets bulk agent api.
     *
     * @return the bulk agent api
     */
    synchronized public BulkAgentApi getBulkAgentApi() {
        if ( bulkAgentApi == null )
            bulkAgentApi = new BulkAgentApi( asyncHttpService, getTenableIoScheme(), getTenableIoHost() );

        return bulkAgentApi;
    }

    /**
     * Gets agent exclusions api.
     *
     * @return the agent exclusions api
     */
    synchronized public AgentExclusionsApi getAgentExclusionsApi() {
        if ( agentExclusionsApi == null )
            agentExclusionsApi = new AgentExclusionsApi( asyncHttpService, getTenableIoScheme(), getTenableIoHost() );

        return agentExclusionsApi;
    }

    /**
     * Gets agent config api.
     *
     * @return the agent config api
     */
    synchronized public AgentConfigApi getAgentConfigApi() {
        if ( agentConfigApi == null )
            agentConfigApi = new AgentConfigApi( asyncHttpService, getTenableIoScheme(), getTenableIoHost() );

        return agentConfigApi;
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
     * Gets tags api.
     *
     * @return the tags api
     */
    synchronized public TagsApi getTagsApi() {
        if( tagsApi == null )
            tagsApi = new TagsApi( asyncHttpService, getTenableIoScheme(), getTenableIoHost() );

        return tagsApi;
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


    /**
     * Gets asset import api.
     *
     * @return the asset import api
     */
    synchronized public AssetImportApi getAssetImportApi() {
        if( assetImportApi == null )
            assetImportApi = new AssetImportApi( asyncHttpService, getTenableIoScheme(), getTenableIoHost() );

        return assetImportApi;
    }


    /**
     * Gets exports api.
     *
     * @return the exports api
     */
    synchronized public ExportsApi getExportsApi() {
        if( exportsApi == null )
            exportsApi = new ExportsApi( asyncHttpService, getTenableIoScheme(), getTenableIoHost() );

        return exportsApi;
    }


    private String getTenableIoHost() {
        return tenableIoHost;
    }

    private String getTenableIoScheme() {
        return tenableIoScheme;
    }
}
