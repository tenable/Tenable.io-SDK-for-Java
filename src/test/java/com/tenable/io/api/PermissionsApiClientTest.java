package com.tenable.io.api;


import com.tenable.io.api.assetLists.models.AssetList;
import com.tenable.io.api.assetLists.models.AssetListRequest;
import com.tenable.io.api.permissions.models.Permission;

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
        Permission permission = new Permission();
        permission.setType( "default" );
        permission.setPermissions( 64 );
        List<Permission> acls = new ArrayList<Permission>();
        acls.add( permission );

        AssetListRequest request = new AssetListRequest();
        request.setName( "test" );
        request.setMembers( getTestUsername( 0 ) );
        request.setType( "user" );
        request.setAcls( acls );

        AssetList created = apiClient.getAssetListsApi().create( request );
        assertNotNull( created );
        assertTrue( created.getName().equals( "test" ) );
        assertTrue( created.getMembers().equals( getTestUsername( 0 ) ) );
        assertNotNull( created.getAcls() );

        //get permissions on created object
        List<Permission> result = apiClient.getPermissionsApi().list( "asset-list", created.getId() );
        assertNotNull( result );


        //change permissions on created object
        Permission newPermission = new Permission();
        newPermission.setType( "default" );
        newPermission.setPermissions( 32 );
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
        apiClient.getAssetListsApi().delete( created.getId() );


    }

}
