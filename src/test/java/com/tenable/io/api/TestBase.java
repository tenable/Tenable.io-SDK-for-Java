package com.tenable.io.api;


import com.tenable.io.api.folders.models.Folder;
import com.tenable.io.api.users.models.User;
import com.tenable.io.api.users.models.UserRole;
import com.tenable.io.core.exceptions.TenableIoException;
import org.junit.After;
import org.junit.Before;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class TestBase {
    private static final String testUsernameBase = "tioTestUsername";
    protected static final String testFolderName = "testFolder";
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
        deleteTestData();
    }


    protected String getTestUsername( int number ) {
        if( getTestDomain() == null )
            throw new IllegalArgumentException( "JVM property \"userDomainName\" needs to be set prior to running the tests" );

        String username = String.format( "%s%d@%s", testUsernameBase, number, getTestDomain() );
        testUsernames.add( username );
        return username;
    }


    protected User createTestUser( TenableIoClient apiClient ) throws Exception {
        return createTestUser( apiClient, 0 );
    }


    protected User createTestUser( TenableIoClient apiClient, int userNumber ) throws Exception {
        User user = apiClient.getUsersApi().create( getTestUsername( userNumber ), "password#1",
                UserRole.BASIC, "test tenable", getTestUsername( userNumber ), "local" );

        return user;
    }


    private void deleteTestData() throws TenableIoException {
        TenableIoClient apiClient = new TenableIoClient();

        //delete potential test users
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

        //delete potential test folder
        List<Folder> folders = apiClient.getFoldersApi().list();
        for( Folder folder : folders ) {
            if( testFolderName.toLowerCase().equals( folder.getName().toLowerCase() ) ) {
                apiClient.getFoldersApi().delete( folder.getId() );
                break;
            }
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
}

