package com.tenable.io.api;


import com.tenable.io.api.accessGroups.models.AccessGroup;
import com.tenable.io.api.assetImport.models.AssetImport;
import com.tenable.io.api.assetImport.models.AssetImportRequest;
import com.tenable.io.api.agentGroups.models.AgentGroup;
import com.tenable.io.api.exclusions.models.Exclusion;
import com.tenable.io.api.folders.models.Folder;
import com.tenable.io.api.groups.models.Group;
import com.tenable.io.api.policies.models.Policy;
import com.tenable.io.api.scannerGroups.models.ScannerGroup;
import com.tenable.io.api.scans.models.Scan;
import com.tenable.io.api.scans.models.ScanDetails;
import com.tenable.io.api.scans.models.ScanListResult;
import com.tenable.io.api.scans.models.ScanStatus;
import com.tenable.io.api.tags.models.TagCategory;
import com.tenable.io.api.targetGroups.models.TargetGroup;
import com.tenable.io.api.users.models.User;
import com.tenable.io.api.users.models.UserRole;
import com.tenable.io.core.exceptions.TenableIoException;
import org.junit.After;
import org.junit.Before;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Random;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class TestBase {
    protected static final String TEST_SCAN_NAME_PREFIX = "tioTestScan_";
    protected static final String TEST_FOLDER_NAME_PREFIX = "tioTestFolder_";
    protected static final String TEST_AGENT_GROUP_NAME_PREFIX = "tioTestAgentGroup_";
    protected static final String TEST_TARGET_GROUP_PREFIX = "tioTestTargetGroup_";
    protected static final String TEST_EXCLUSION_NAME_PREFIX = "tioTestExclusion_";
    protected static final String TEST_GROUP_NAME_PREFIX = "tioTestGroup_";
    protected static final String TEST_POLICY_NAME_PREFIX = "tioTestPolicy_";
    protected static final String TEST_SCANNER_GROUP_NAME_PREFIX = "tioTestScannerGroup_";
    protected static final String TEST_TAG_NAME_PREFIX = "tioTestTag_";
    protected static final String TEST_ACCESS_GROUP_NAME_PREFIX = "tioTestAccessGroup_";


    protected TenableIoClient apiClient = new TenableIoClient();
    private static final String testUsernameBase = "tioTestUsername";
    private Set<String> testUsernames = new HashSet<>();

    // A valid domain name for username
    private String testDomain = System.getProperty( "userDomainName" );
    // Host target to create a scan with. (Warning: do not scan targets that you're not authorized to.)
    private String scanTextTargets = System.getProperty( "scanTextTargets" );
    // Host alternative target to launch a scan with. (Warning: do not scan targets that you're not authorized to.)
    private String scanAltTargets = System.getProperty( "scanAltTargets" );
    // Name of template to create a scan with.
    private String scanTemplateName = System.getProperty( "scanTemplateName" );
    // Name of template to create a policy with.
    private String policyTemplateName = System.getProperty( "policyTemplateName" );


    @Before
    public void preChecksBase() throws TenableIoException {
        deleteTestData();
    }


    @After
    public void cleanupBase() throws TenableIoException {
        try {
            deleteTestData();
        } finally {
            closeClient();
        }
    }


    public String getTestDomain() {
        return testDomain;
    }


    public String getScanTextTargets() {
        return scanTextTargets;
    }


    public String getScanAltTargets() {
        return scanAltTargets;
    }


    public String getScanTemplateName() {
        return scanTemplateName;
    }


    public String getPolicyTemplateName() {
        return policyTemplateName;
    }


    protected String getTestUsername( int number ) {
        if( getTestDomain() == null )
            throw new IllegalArgumentException( "JVM property \"userDomainName\" needs to be set prior to running the tests" );

        String username = String.format( "%s%d@%s", testUsernameBase, number, getTestDomain() );
        testUsernames.add( username );
        return username;
    }


    protected User createTestUser( TenableIoClient apiClient ) throws Exception {
        Random rand = new Random();
        int n = rand.nextInt(50) + 1;
        return createTestUser( apiClient, n );
    }


    protected User createTestUser( TenableIoClient apiClient, int userNumber ) throws Exception {
        User user = apiClient.getUsersApi().create( getTestUsername( userNumber ), "password#1",
                UserRole.BASIC, "test tenable", getTestUsername( userNumber ), "local" );

        return user;
    }


    private void closeClient() {
        try {
            apiClient.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void deleteTestData() throws TenableIoException {
        // delete potential test users
        List<User> users = apiClient.getUsersApi().list();
        if( users != null ) {
            for( User user : users ) {
                boolean deleted = false;
                for( String testUsername: testUsernames ) {
                    if( user.getUsername().toLowerCase().equals( testUsername.toLowerCase() ) ) {
                        apiClient.getUsersApi().delete( user.getId() );
                        deleted = true;
                        break;
                    }
                }

                if( !deleted && user.getUsername().toLowerCase().startsWith( testUsernameBase.toLowerCase() ) ) {
                    apiClient.getUsersApi().delete( user.getId() );
                }
            }
        }
    }


    protected void deleteTestScans( TenableIoClient apiClient ) throws TenableIoException {
        // delete potential test policies
        ScanListResult scanListResult = apiClient.getScansApi().list();
        if( scanListResult != null ) {
            for( Scan scan : scanListResult.getScans() ) {
                if( scan.getName().toLowerCase().startsWith( TEST_SCAN_NAME_PREFIX.toLowerCase() ) ) {
                    try {
                        apiClient.getScanHelper().getScan( scan.getId() ).stop();
                    } catch( TenableIoException te ) {
                        // could be a state conflict if the scan was already stopped
                    }
                    apiClient.getScansApi().delete( scan.getId() );
                }
            }
        }
    }


    protected String getNewTestScanName() {
        return getNewTestName( TEST_SCAN_NAME_PREFIX );
    }


    protected void deleteTestFolders( TenableIoClient apiClient ) throws TenableIoException {
        // delete potential test folders
        List<Folder> folderList = apiClient.getFoldersApi().list();
        if( folderList != null ) {
            for( Folder folder : folderList ) {
                if( folder.getName().toLowerCase().startsWith( TEST_FOLDER_NAME_PREFIX.toLowerCase() ) ) {
                    apiClient.getFoldersApi().delete( folder.getId() );
                }
            }
        }
    }


    protected String getNewTestFolderName() {
        return getNewTestName( TEST_FOLDER_NAME_PREFIX );
    }


    protected void deleteTestAgentGroups( TenableIoClient apiClient ) throws TenableIoException {
        // delete potential test agent groups
        List<AgentGroup> groups = apiClient.getAgentGroupsApi().list();
        if( groups != null ) {
            for( AgentGroup group : groups ) {
                if( group.getName().toLowerCase().startsWith( TEST_AGENT_GROUP_NAME_PREFIX.toLowerCase() ) ) {
                    apiClient.getAgentGroupsApi().delete( group.getId() );
                }
            }
        }
    }


    protected String getNewTestAgentGroupName() {
        return getNewTestName( TEST_AGENT_GROUP_NAME_PREFIX );
    }


    protected void deleteTestTargetGroups( TenableIoClient apiClient ) throws TenableIoException {
        // delete potential test asset lists
        List<TargetGroup> targetGroups = apiClient.getTargetGroupsApi().list();
        if( targetGroups != null ) {
            for( TargetGroup targetGroup : targetGroups ) {
                if( targetGroup.getName().toLowerCase().startsWith( TEST_TARGET_GROUP_PREFIX.toLowerCase() ) ) {
                    apiClient.getTargetGroupsApi().delete( targetGroup.getId() );
                }
            }
        }
    }


    protected String getNewTestTargetGroupName() {
        return getNewTestName( TEST_TARGET_GROUP_PREFIX );
    }


    protected void deleteTestExclusions( TenableIoClient apiClient ) throws TenableIoException {
        // delete potential exclusions
        List<Exclusion> exclusionList = apiClient.getExclusionsApi().list();
        if( exclusionList != null ) {
            for( Exclusion exclusion : exclusionList ) {
                if( exclusion.getName().toLowerCase().startsWith( TEST_EXCLUSION_NAME_PREFIX.toLowerCase() ) ) {
                    apiClient.getExclusionsApi().delete( exclusion.getId() );
                }
            }
        }
    }

    protected String getNewTestExclusionName() {
        return getNewTestName( TEST_EXCLUSION_NAME_PREFIX );
    }


    protected void deleteTestGroups( TenableIoClient apiClient ) throws TenableIoException {
        // delete potential test policies
        List<Group> groups = apiClient.getUserGroupsApi().list();
        if( groups != null ) {
            for( Group group : groups ) {
                if( group.getName().toLowerCase().startsWith( TEST_GROUP_NAME_PREFIX.toLowerCase() ) ) {
                    apiClient.getUserGroupsApi().delete( group.getId() );
                }
            }
        }
    }


    protected String getNewTestGroupName() {
        return getNewTestName( TEST_GROUP_NAME_PREFIX );
    }


    protected void deleteTestPolicies( TenableIoClient apiClient ) throws TenableIoException {
        // delete potential test policies
        List<Policy> policies = apiClient.getPoliciesApi().list();
        if( policies != null ) {
            for( Policy policy : policies ) {
                if( policy.getName().toLowerCase().startsWith( TEST_POLICY_NAME_PREFIX.toLowerCase() ) ) {
                    apiClient.getPoliciesApi().delete( policy.getId() );
                }
            }
        }
    }

    protected String getNewTestPolicyName() {
        return getNewTestName( TEST_POLICY_NAME_PREFIX );
    }


    protected void deleteTestScannerGroups( TenableIoClient apiClient ) throws TenableIoException {
        // delete potential test policies
        List<ScannerGroup> scannerGroups = apiClient.getScannerGroupsApi().list();
        if( scannerGroups != null ) {
            for( ScannerGroup scannerGroup : scannerGroups ) {
                if( scannerGroup.getName().toLowerCase().startsWith( TEST_SCANNER_GROUP_NAME_PREFIX.toLowerCase() ) ) {
                    apiClient.getScannerGroupsApi().delete( scannerGroup.getId() );
                }
            }
        }
    }

    protected String getNewTestScannerGroupName() {
        return getNewTestName( TEST_SCANNER_GROUP_NAME_PREFIX );
    }


    protected void deleteTestTags() throws TenableIoException {
        // delete potential test tags
        TagCategory[] tagCategories = apiClient.getTagsApi().listTagCategories().getCategories();
        if( tagCategories != null ) {
            for( TagCategory tag : tagCategories) {
                if( tag.getName().toLowerCase().startsWith( TEST_TAG_NAME_PREFIX.toLowerCase() ) ) {
                    apiClient.getTagsApi().deleteCategory( tag.getUuid() );
                }
            }
        }
    }

    protected String getNewTestTagName() {
        return getNewTestName( TEST_TAG_NAME_PREFIX );
    }


    protected void deleteTestAccessGroups() throws TenableIoException {
        // delete potential test access groups
        AccessGroup[] accessGroups = apiClient.getAccessGroupsApi().listAccessGroups().getAccessGroups();
        if( accessGroups != null ) {
            for( AccessGroup ag : accessGroups) {
                if( ag.getName().toLowerCase().startsWith( TEST_ACCESS_GROUP_NAME_PREFIX.toLowerCase() ) ) {
                    apiClient.getAccessGroupsApi().deleteAccessGroup( ag.getId() );
                }
            }
        }
    }

    protected String getNewTestAccessGroupName() {
        return getNewTestName( TEST_ACCESS_GROUP_NAME_PREFIX );
    }


    private String getNewTestName( String prefix ) {
        return prefix + java.util.UUID.randomUUID().toString().substring( 0, 6 );
    }


    protected ScanStatus waitForStatus( TenableIoClient apiClient, int scanId, ScanStatus status ) throws TenableIoException, InterruptedException {
        ScanDetails details = apiClient.getScansApi().details( scanId );
        ScanStatus curStatus = details.getInfo().getStatus();
        while ( curStatus != status ) {
            Thread.sleep( 5000 );
            if ( details.getInfo().getScheduleUuid() == null || details.getInfo().getUuid() == null ) {
                details = apiClient.getScansApi().details( scanId );
                curStatus = details.getInfo().getStatus();
            }
            else curStatus = apiClient.getScansApi().getScanHistoryStatus( details.getInfo().getScheduleUuid(), details.getInfo().getUuid() ).getStatus();
        }

        return curStatus;
    }


    protected void importTestAsset() throws TenableIoException {
        // Imports an asset via the asset import API to power other tests
        AssetImport assetToImport = new AssetImport();
        assetToImport.setIpv4( Arrays.asList( "192.168.0.97" ) );
        assetToImport.setOperatingSystem( Arrays.asList( "Linux" ) );
        AssetImportRequest importRequestPayload = new AssetImportRequest().withAssets( Arrays.asList( assetToImport ) ).withSource( "TEST" );
        String import_job = apiClient.getAssetImportApi().importAssets( importRequestPayload );
        waitUntilJobReady( import_job);
        // Add an additional wait for Assets to become available
        try {
            Thread.sleep( 30000 );
        } catch( InterruptedException e ) {
        }
    }

    private void waitUntilJobReady( String jobId ) throws TenableIoException {

        while( !"COMPLETE".equals( apiClient.getAssetImportApi().getAssetImportJob( jobId ).getStatus() ) ) {
            try {
                Thread.sleep( 5000 );
            } catch( InterruptedException e ) {
            }
        }
    }
}

