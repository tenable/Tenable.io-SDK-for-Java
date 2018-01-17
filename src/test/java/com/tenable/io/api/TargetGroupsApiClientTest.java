package com.tenable.io.api;


import com.tenable.io.api.permissions.models.Permission;
import com.tenable.io.api.targetGroups.models.TargetGroup;
import com.tenable.io.api.targetGroups.models.TargetGroupRequest;
import com.tenable.io.api.users.models.User;
import com.tenable.io.core.exceptions.TenableIoException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class TargetGroupsApiClientTest extends TestBase {
    @Test
    public void testTargetGroups() throws Exception {
        //create asset list
        User user = createTestUser( apiClient, 0 );

        Permission permission = new Permission().withType( "default" ).withPermissions( 64 );
        List<Permission> acls = new ArrayList<Permission>();
        acls.add( permission );

        String testName = getNewTestTargetGroupName();

        TargetGroupRequest request = new TargetGroupRequest().withName( testName )
                .withMembers(getTestUsername( 0 ) )
                .withType( "user" )
                .withAcls( acls );

        TargetGroup created = apiClient.getTargetGroupsApi().create( request );
        assertNotNull( created );

        assertTrue( created.getName().equals( testName ) );
        assertTrue( created.getMembers().equals( getTestUsername( 0 ) ) );
        assertNotNull( created.getAcls() );

        //list
        List<TargetGroup> result = apiClient.getTargetGroupsApi().list();
        assertNotNull( result );

        //edit
        String testRename = getNewTestTargetGroupName();
        TargetGroupRequest editRequest = new TargetGroupRequest().withName( testRename );
        apiClient.getTargetGroupsApi().edit( created.getId(), editRequest );

        //details
        TargetGroup detail = apiClient.getTargetGroupsApi().details( created.getId() );
        assertNotNull( detail );
        assertTrue( detail.getName().equals( testRename ) );
        assertTrue( detail.getMembers().equals( getTestUsername( 0 ) ) );
        assertNotNull( detail.getAcls() );

        //delete
        apiClient.getTargetGroupsApi().delete( detail.getId() );

        //verify deleted
        result = apiClient.getTargetGroupsApi().list();
        boolean deleted = true;
        if( result != null ) {
            for( TargetGroup item : result ) {
                if( item.getId() == detail.getId() ) {
                    deleted = false;
                    break;
                }
            }
        }
        assertTrue( deleted );
    }


    @Before
    @After
    public void cleanup() throws TenableIoException {
        deleteTestTargetGroups( apiClient );
    }
}
