package com.tenable.io.api;


import com.tenable.io.api.scanners.models.ScanDetail;
import com.tenable.io.api.scanners.models.Scanner;

import com.tenable.io.api.scans.models.*;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class ScannersApiClientTest extends TestBase {

    @Test
    public void testScanners() throws Exception {
        TenableIoClient apiClient = new TenableIoClient();
        List<Scanner> scanners = apiClient.getScannersApi().list();

        assertNotNull( scanners );

        for( Scanner scannerItem : scanners ) {
            Scanner detail = apiClient.getScannersApi().details( scannerItem.getId() );
            assertNotNull( detail );
        }

        //todo
        //not authorized to edit or delete a scanner. can't test this
        //ScannerEditSettings settings = new ScannerEditSettings();
        //settings.setForcePluginUpdate(1);
        //apiClient.getScannersApi().edit(scanners.get(0).getId(), settings);
        //apiClient.getScannersApi().delete(scanners.get(0).getId());

        String key = apiClient.getScannersApi().getScannerKey( scanners.get( 0 ).getId() );
        assertNotNull( key );

        //todo
        //invalid scanner type error
        //AWSTarget target = apiClient.getScannersApi().getAWSTarget(scanners.get(0).getId());

        //todo toggle scan
        //apiClient.getScannersApi().toggleLinkState( scanners.get( 0 ).getId(), 1 );

    }


    @Test
    public void testGetScans() throws Exception {
        TenableIoClient apiClient = new TenableIoClient();
        List<Scanner> scanners = apiClient.getScannersApi().list();

        assertNotNull( scanners );

        for( Scanner scannerItem : scanners ) {
            List<ScanDetail> scanDetails = apiClient.getScannersApi().getScans( scannerItem.getId() );
            //it's possible some scanners don't have any scans
            if(scanDetails != null) {
                assertNotNull( scanDetails.size() > 0 );
            }
        }
    }


    @Test
    public void testControlScans() throws Exception {
        TenableIoClient apiClient = new TenableIoClient();
        List<Scanner> scanners = apiClient.getScannersApi().list();
        assertNotNull( scanners );

        ScanResult newScan = createScan( apiClient, scanners.get( 0 ).getId() );
        assertNotNull( newScan );
        String scan_uuid = apiClient.getScansApi().launch( newScan.getId(), null );

        apiClient.getScannersApi().controlScans( scanners.get( 0 ).getId(), scan_uuid, "stop" );

        ScanDetails details = apiClient.getScansApi().details( newScan.getId() );
        assertNotNull( details );
        assertTrue( details.getInfo().getStatus() == ScanStatus.CANCELED ||
                details.getInfo().getStatus() == ScanStatus.STOPPING ||
                details.getInfo().getStatus() == ScanStatus.STOPPED ||
                details.getInfo().getStatus() == ScanStatus.ABORTED );

        apiClient.getScansApi().delete( newScan.getId() );
    }


    private ScanResult createScan( TenableIoClient apiClient, int scannerId ) throws Exception {
        Settings settings = new Settings()
        .withEnabled( true )
        .withTextTargets(  getScanTextTargets() );
        String scanName = "Test_" + java.util.UUID.randomUUID().toString().substring( 0, 6 );
        settings.withName( scanName )
        .withDescription( "scan description" )
        .withScannerId( scannerId )
        .withLaunch( LaunchFrequency.ON_DEMAND )
        .withStartTime( "20161220110500" );

        //Basic network scan
        //ScanResult result = apiClient.getScansApi().create("731a8e52-3ea6-a291-ec0a-d2ff0619c19d7bd788d6be818b65", settings);
        //host discovery scan
        ScanResult result = apiClient.getScansApi().create( "bbd4f805-3966-d464-b2d1-0079eb89d69708c3a05ec2812bcf", settings );
        assertNotNull( result );
        assertTrue( result.isEnabled() );
        assertTrue( result.getName().equals( scanName ) );
        assertTrue( result.getDescription().equals( "scan description" ) );
        assertTrue( result.getStartTime().equals( "20161220110500" ) );
        return result;
    }

}
