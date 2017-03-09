package com.tenable.io.api;


import com.tenable.io.api.assetLists.models.AssetList;
import com.tenable.io.api.assetLists.models.AssetListRequest;
import com.tenable.io.api.permissions.models.Permission;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class AssetListsApiClientTest extends TestBase {

    @Test
    public void testAssetLists() throws Exception {
        TenableIoClient apiClient = new TenableIoClient();

        //create asset list
        Permission permission = new Permission().withType( "default" ).withPermissions( 64 );
        List<Permission> acls = new ArrayList<Permission>();
        acls.add( permission );

        AssetListRequest request = new AssetListRequest().withName( "test" )
                .withMembers(getTestUsername( 0 ) )
                .withType( "user" )
                .withAcls( acls );

        AssetList created = apiClient.getAssetListsApi().create( request );
        assertNotNull( created );
        assertTrue( created.getName().equals( "test" ) );
        assertTrue( created.getMembers().equals( getTestUsername( 0 ) ) );
        assertNotNull( created.getAcls() );

        //list
        List<AssetList> result = apiClient.getAssetListsApi().list();
        assertNotNull( result );

        //edit
        AssetListRequest editRequest = new AssetListRequest().withName( "testrenamed" );
        apiClient.getAssetListsApi().edit( created.getId(), editRequest );

        //details
        AssetList detail = apiClient.getAssetListsApi().details( created.getId() );
        assertNotNull( detail );
        assertTrue( detail.getName().equals( "testrenamed" ) );
        assertTrue( detail.getMembers().equals( getTestUsername( 0 ) ) );
        assertNotNull( detail.getAcls() );

        //delete
        apiClient.getAssetListsApi().delete( detail.getId() );

        //verify deleted
        result = apiClient.getAssetListsApi().list();
        boolean deleted = true;
        if( result != null ) {
            for( AssetList item : result ) {
                if( item.getId() == detail.getId() ) {
                    deleted = false;
                    break;
                }
            }
        }
        assertTrue( deleted );
    }
}
