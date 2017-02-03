package com.tenable.io.api;


import com.tenable.io.api.permissions.models.Permission;

import com.tenable.io.api.policies.models.*;
import org.junit.Test;

import java.io.File;
import java.util.*;


import static org.junit.Assert.*;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class PoliciesApiClientTest extends TestBase {

    @Test
    public void testList() throws Exception {
        TenableIoClient apiClient = new TenableIoClient();
        List<Policy> result = apiClient.getPoliciesApi().list();

        assertNotNull( result );
    }


    @Test
    public void testCreateAndDelete() throws Exception {
        TenableIoClient apiClient = new TenableIoClient();
        PolicyCreateResponse response = apiClient.getPoliciesApi().create( CreateTestPolicy() );
        assertNotNull( response );
        assertTrue( response.getPolicyId() > 0 );

        apiClient.getPoliciesApi().delete( response.getPolicyId() );
    }


    @Test
    public void testCreateAndCopyAndDelete() throws Exception {
        TenableIoClient apiClient = new TenableIoClient();
        PolicyCreateResponse response = apiClient.getPoliciesApi().create( CreateTestPolicy() );
        assertNotNull( response );
        assertTrue( response.getPolicyId() > 0 );

        Policy copy = apiClient.getPoliciesApi().copy( response.getPolicyId() );
        assertNotNull( copy );
        assertTrue( copy.getId() > 0 );

        apiClient.getPoliciesApi().delete( response.getPolicyId() );
        apiClient.getPoliciesApi().delete( copy.getId() );
    }


    @Test
    public void testDetails() throws Exception {
        TenableIoClient apiClient = new TenableIoClient();

        PolicyCreateResponse response = apiClient.getPoliciesApi().create( CreateTestPolicy() );
        assertNotNull( response );
        assertTrue( response.getPolicyId() > 0 );

        PolicyDetail details = apiClient.getPoliciesApi().details( response.getPolicyId() );

        assertNotNull( details );
        assertEquals( details.getSettings().getName(), response.getPolicyName() );

        apiClient.getPoliciesApi().delete( response.getPolicyId() );
    }


    @Test
    public void testConfigure() throws Exception {
        TenableIoClient apiClient = new TenableIoClient();

        //create
        PolicyCreateResponse response = apiClient.getPoliciesApi().create( CreateTestPolicy() );
        assertNotNull( response );
        assertTrue( response.getPolicyId() > 0 );

        //get details
        PolicyDetail details = apiClient.getPoliciesApi().details( response.getPolicyId() );
        assertNotNull( details );
        assertEquals( details.getSettings().getName(), response.getPolicyName() );

        //update policy
        details.getSettings().setName( "updatedName" );
        apiClient.getPoliciesApi().configure( response.getPolicyId(), details );

        //get details again after updated
        PolicyDetail updatedDetails = apiClient.getPoliciesApi().details( response.getPolicyId() );
        assertNotNull( updatedDetails );
        assertEquals( updatedDetails.getSettings().getName(), "updatedName" );

        apiClient.getPoliciesApi().delete( response.getPolicyId() );
    }


    @Test
    public void testExportPolicy() throws Exception {
        TenableIoClient apiClient = new TenableIoClient();
        List<Policy> result = apiClient.getPoliciesApi().list();
        assertNotNull( result );
        assertTrue( result.size() > 0 );

        File export = new File( "C:\\Temp\\test.txt" );
        apiClient.getPoliciesApi().export( result.get( 0 ).getId(), export );

        //verify file downloaded
        assertTrue( export.exists() );
    }


    @Test
    public void testImportPolicy() throws Exception {
        TenableIoClient apiClient = new TenableIoClient();

        String filename = apiClient.getFileApi().upload( new File( "src/test/resources/nessus_policy_test.nessus" ) );
        Policy imported = apiClient.getPoliciesApi().importPolicy( filename );
        assertNotNull( imported );
        assertTrue( imported.getDescription().equals( "test policy" ) );
        apiClient.getPoliciesApi().delete( imported.getId() );

    }


    private PolicyDetail CreateTestPolicy() {
        //credentials
        PolicyCredentials policyCredential = new PolicyCredentials();
        Map<String, Map<String, List<Map<String, String>>>> addCredential = new HashMap<>();
        Map<String, List<Map<String, String>>> credentialCategoryValue = new HashMap<>();
        ArrayList<Map<String, String>> credentialList = new ArrayList<>();
        Map<String, String> credentialPairs = new HashMap<>();
        credentialPairs.put( "auth_check_page", "/user/test.php" );
        credentialPairs.put( "auth_method", "HTTP login form" );
        credentialPairs.put( "auth_regex", "\"[e\"]" );
        credentialPairs.put( "login_page", "/login.php" );
        credentialPairs.put( "login_params", "user=34" );
        credentialPairs.put( "login_submission_page", "/test.php" );
        credentialPairs.put( "password", "mypass" );
        credentialPairs.put( "username", "user" );
        credentialList.add( credentialPairs );
        credentialCategoryValue.put( "HTTP", credentialList );
        addCredential.put( "Plaintext Authentication", credentialCategoryValue );
        policyCredential.setAdd( addCredential );

        //scap
        PolicyScap policyScap = new PolicyScap();
        Map<String, String> scapPair = new HashMap<>();
        List<Map<String, String>> scapList = new ArrayList<>();
        Map<String, List<Map<String, String>>> scapCategory = new HashMap<>();
        scapPair.put( "scapName", "value" );
        scapList.add( scapPair );
        scapCategory.put( "scapCategory", scapList );
        policyScap.setAdd( scapCategory );

        //plugins
        Map<String, PolicyPluginFamily> plugin = new HashMap<>();
        PolicyPluginFamily pluginFamily = new PolicyPluginFamily();
        pluginFamily.setStatus( "status" );
        HashMap<String, String> pluginIndividual = new HashMap<>();
        pluginIndividual.put( "pluginid", "22372" );
        pluginFamily.setIndividual( pluginIndividual );
        plugin.put( "AIX Local Security Checks", pluginFamily );

        //audits
        PolicyAudits audits = new PolicyAudits();
        PolicyAuditFeed auditFeed = new PolicyAuditFeed();
        List<PolicyAudit> auditList = new ArrayList<>();
        PolicyAudit audit = new PolicyAudit();
        Map<String, String> auditVariables = new HashMap<>();
        auditVariables.put( "1", "test" );
        auditVariables.put( "2", "test" );
        auditVariables.put( "3", "test" );
        audit.setId( 1 );
        audit.setVariables( auditVariables );
        auditList.add( audit );
        auditFeed.setAdd( auditList );
        audits.setFeed( auditFeed );

        //permissions
        Permission permission = new Permission();
        permission.setId( 7 );
        permission.setName( getTestUsername( 0 ) );
        permission.setOwner( 1 );
        permission.setType( "user" );
        permission.setPermissions( 128 );

        //settings
        PolicySettings settings = new PolicySettings();
        settings.setName( "testPolicy_" + java.util.UUID.randomUUID().toString().substring( 0, 6 ) );
        settings.setDescription( "test" );
        settings.setAcls( permission );

        PolicyDetail create = new PolicyDetail();
        create.setCredentials( policyCredential );
        create.setScap( policyScap );
        create.setPlugins( plugin );
        //TODO couldn't find examples of valid values to test the following
        //create.setAudits(audits);
        create.setSettings( settings );
        create.setUuid( "c3cbcd46-329f-a9ed-1077-554f8c2af33d0d44f09d736969bf" );

        return create;
    }


}
