package com.tenable.io.api;


import com.tenable.io.api.folders.models.Folder;

import com.tenable.io.core.exceptions.TenableIoException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class FoldersApiClientTest extends TestBase {
    @Test
    public void testCreateAndDelete() throws Exception {
        int folderId = createFolder( apiClient );

        apiClient.getFoldersApi().delete( folderId );
    }


    @Test
    public void testListFolders() throws Exception {
        int folderId = createFolder( apiClient );

        List<Folder> folders = apiClient.getFoldersApi().list();

        assertNotNull( folders );
        assertTrue( folders.size() > 0 );

        apiClient.getFoldersApi().delete( folderId );
    }


    @Test
    public void testEditFolder() throws Exception {
        int folderId = createFolder( apiClient );

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


    private int createFolder( TenableIoClient apiClient ) throws TenableIoException {
        int folderId = apiClient.getFoldersApi().create( getNewTestFolderName() );
        assertTrue( folderId > 0 );
        return folderId;
    }


    @Before
    @After
    public void cleanup() throws TenableIoException {
        deleteTestFolders( apiClient );
    }
}
