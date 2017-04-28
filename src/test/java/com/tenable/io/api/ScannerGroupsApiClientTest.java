package com.tenable.io.api;


import com.tenable.io.api.scannerGroups.models.ScannerGroup;

import com.tenable.io.api.scannerGroups.models.ScannerGroupType;
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
public class ScannerGroupsApiClientTest extends TestBase {
    @Test
    public void testScannerGroups() throws Exception {
        TenableIoClient apiClient = new TenableIoClient();

        //create scanner group
        String name = getNewTestScannerGroupName();
        ScannerGroup createdGroup = apiClient.getScannerGroupsApi().create( name, ScannerGroupType.LOAD_BALANCING );
        assertNotNull( createdGroup );
        assertTrue( createdGroup.getType() == ScannerGroupType.LOAD_BALANCING || createdGroup.getType() == ScannerGroupType.SCANNER_POOL );

        /* TODO: error {"error":"Adding a scanner pool to another scanner pool is not allowed."}
        //add scanner
        List<Scanner> scanners = apiClient.getScannersApi().list();
        apiClient.getScannerGroupsApi().addScanner(createdGroup.getId(), scanners.get(3).getId());

        //list scanners, verify added
        List<Scanner> scannersInGroup = apiClient.getScannerGroupsApi().listScanners(createdGroup.getId());
        assertNotNull(scannersInGroup);
        assertTrue(scannersInGroup.size() == 1);

        //remove scanner
        apiClient.getScannerGroupsApi().deleteScanner(createdGroup.getId(), scanners.get(3).getId());

        //list scanners, verify removed
        scannersInGroup = apiClient.getScannerGroupsApi().listScanners(createdGroup.getId());
        assertNotNull(scannersInGroup);
        assertTrue(scannersInGroup.size() == 0);
        */

        //edit name
        String updatedName = getNewTestScannerGroupName();
        apiClient.getScannerGroupsApi().edit( createdGroup.getId(), updatedName );

        //get detail and verify name updated
        ScannerGroup detail = apiClient.getScannerGroupsApi().details( createdGroup.getId() );
        assertNotNull( detail );
        assertTrue( detail.getName().equals( updatedName ) );

        //delete scanner group
        apiClient.getScannerGroupsApi().delete( createdGroup.getId() );

        //verify deleted
        List<ScannerGroup> scannerGroups = apiClient.getScannerGroupsApi().list();
        ScannerGroup deletedGroup = null;
        if( scannerGroups != null ) {
            for( ScannerGroup group : scannerGroups ) {
                if( group.getName().equals( updatedName ) ) {
                    deletedGroup = group;
                }
            }
        }
        assertNull( deletedGroup );
    }


    @Before
    @After
    public void cleanup() throws TenableIoException {
        TenableIoClient apiClient = new TenableIoClient();

        deleteTestScannerGroups( apiClient );
    }
}
