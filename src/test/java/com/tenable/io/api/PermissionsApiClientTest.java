package com.tenable.io.api;


import com.tenable.io.api.permissions.models.Permission;

import com.tenable.io.api.targetGroups.models.TargetGroup;
import com.tenable.io.api.targetGroups.models.TargetGroupRequest;
import com.tenable.io.core.exceptions.TenableIoException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class PermissionsApiClientTest extends TestBase {
    @Test
    public void testPermission() throws Exception {
        TenableIoClient apiClient = new TenableIoClient();

        //create an asset list with custom permission
        Permission permission = new Permission().withType( "default" ).withPermissions( 64 );
        List<Permission> acls = new ArrayList<Permission>();
        acls.add( permission );

        String testName = getNewTestTargetGroupName();
        TargetGroupRequest request = new TargetGroupRequest().withName( testName ).withMembers( getTestUsername( 0 ) )
        .withType( "user" )
        .withAcls( acls );

        TargetGroup created = apiClient.getTargetGroupsApi().create( request );
        assertNotNull( created );
        assertTrue( created.getName().equals( testName ) );
        assertTrue( created.getMembers().equals( getTestUsername( 0 ) ) );
        assertNotNull( created.getAcls() );

        //get permissions on created object
        List<Permission> result = apiClient.getPermissionsApi().list( "asset-list", created.getId() );
        assertNotNull( result );

        //change permissions on created object
        Permission newPermission = new Permission().withType( "default" ).withPermissions( 32 );
        List<Permission> newAcls = new ArrayList<Permission>();
        newAcls.add( newPermission );
        apiClient.getPermissionsApi().change( "asset-list", created.getId(), newAcls );

        //verify permissions changed
        result = apiClient.getPermissionsApi().list( "asset-list", created.getId() );
        assertNotNull( result );
        boolean foundChanged = false;
        for( Permission item : result ) {
            if( item.getType().equals( "default" ) ) {
                foundChanged = true;
                assertEquals( item.getPermissions(), 32 );
            }
        }
        assertTrue( foundChanged );

        //delete item
        apiClient.getTargetGroupsApi().delete( created.getId() );
    }


    @Before
    @After
    public void cleanup() throws TenableIoException {
        TenableIoClient apiClient = new TenableIoClient();

        deleteTestTargetGroups( apiClient );
    }
}
