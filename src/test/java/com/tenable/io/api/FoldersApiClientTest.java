package com.tenable.io.api;


import com.tenable.io.api.folders.models.Folder;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class FoldersApiClientTest extends TestBase {
    @Test
    public void testCreateAndDelete() throws Exception {
        TenableIoClient apiClient = new TenableIoClient();
        int folderId = apiClient.getFoldersApi().create( "unitTest" );

        assertTrue( folderId > 0 );

        apiClient.getFoldersApi().delete( folderId );

    }


    @Test
    public void testListFolders() throws Exception {
        TenableIoClient apiClient = new TenableIoClient();
        int folderId = apiClient.getFoldersApi().create( "unitTest" );

        assertTrue( folderId > 0 );

        List<Folder> folders = apiClient.getFoldersApi().list();

        assertNotNull( folders );
        assertTrue( folders.size() > 0 );

        apiClient.getFoldersApi().delete( folderId );
    }


    @Test
    public void testEditFolder() throws Exception {
        TenableIoClient apiClient = new TenableIoClient();
        int folderId = apiClient.getFoldersApi().create( "unitTest" );

        assertTrue( folderId > 0 );

        apiClient.getFoldersApi().edit( folderId, "newName" );

        List<Folder> folders = apiClient.getFoldersApi().list();

        assertNotNull( folders );
        assertTrue( folders.size() > 0 );

        boolean updated = false;
        for( Folder folder : folders ) {
            if( folder.getName().equals( "newName" ) ) {
                updated = true;
                break;
            }
        }

        if( !updated ) {
            fail( "failed to update folder" );
        }

        apiClient.getFoldersApi().delete( folderId );
    }

}
