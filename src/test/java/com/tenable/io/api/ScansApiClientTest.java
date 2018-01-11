package com.tenable.io.api;


import com.tenable.io.api.editors.models.Template;
import com.tenable.io.api.permissions.models.Permission;
import com.tenable.io.api.policies.models.Policy;
import com.tenable.io.api.scanners.models.Scanner;
import com.tenable.io.api.scans.models.*;
import com.tenable.io.core.exceptions.TenableIoException;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.*;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class ScansApiClientTest extends TestBase {
    @Test
    public void testTimeZones() throws Exception {
        TenableIoClient apiClient = new TenableIoClient();
        TimezonesResult result = apiClient.getScansApi().timezones();

        assertNotNull( result );
        assertNotNull( result.getTimezones() );
        assertTrue( result.getTimezones().size() > 0 );
    }

    @Test
    public void testCreateAndLaunch() throws Exception {
        TenableIoClient apiClient = new TenableIoClient();
        int folderId = apiClient.getFoldersApi().create( getNewTestFolderName() );
        ScanResult result = createScan( apiClient, folderId );

        //launch the scan
        String scanUuid = apiClient.getScansApi().launch( result.getId(), null );
        ScanDetails details = apiClient.getScansApi().details( result.getId() );

        assertEquals( waitForStatus( apiClient, result.getId(), ScanStatus.RUNNING ), ScanStatus.RUNNING );

        assertEquals( waitForStatus( apiClient, result.getId(), ScanStatus.COMPLETED ), ScanStatus.COMPLETED );

        // Scan is used by subsequent tests, so do not delete
        // apiClient.getScansApi().delete( result.getId() );
        // apiClient.getFoldersApi().delete( folderId );
    }

    @Test
    public void testScansList() throws Exception {
        TenableIoClient apiClient = new TenableIoClient();
        ScanListResult result = apiClient.getScansApi().list();
        ScanDetails details = apiClient.getScansApi().details( result.getScans().get( 0 ).getId() );
        assertNotNull( result );
        assertNotNull( details );
    }

    @Test
    public void testPauseAndResume() throws Exception {
        TenableIoClient apiClient = new TenableIoClient();
        int folderId = apiClient.getFoldersApi().create( getNewTestFolderName() );
        ScanResult result = createScan( apiClient, folderId );
        //launch the scan
        String scanUuid = apiClient.getScansApi().launch( result.getId(), null );
        ScanDetails details = apiClient.getScansApi().details( result.getId() );

        assertEquals( waitForStatus( apiClient, result.getId(), ScanStatus.RUNNING ), ScanStatus.RUNNING );
        //pause the scan
        apiClient.getScansApi().pause( result.getId() );
        details = apiClient.getScansApi().details( result.getId() );
        assertEquals( waitForStatus( apiClient, result.getId(), ScanStatus.PAUSED ), ScanStatus.PAUSED );

        //resume
        apiClient.getScansApi().resume( result.getId() );
        details = apiClient.getScansApi().details( result.getId() );
        assertEquals( waitForStatus( apiClient, result.getId(), ScanStatus.RUNNING ), ScanStatus.RUNNING );

        assertEquals( waitForStatus( apiClient, result.getId(), ScanStatus.COMPLETED ), ScanStatus.COMPLETED );

        apiClient.getScansApi().delete( result.getId() );
        apiClient.getFoldersApi().delete( folderId );
    }

    @Test
    public void testStopAndCancel() throws Exception {
        TenableIoClient apiClient = new TenableIoClient();
        int folderId = apiClient.getFoldersApi().create( getNewTestFolderName() );
        ScanResult result = createScan( apiClient, folderId );

        //launch the scan
        String scanUuid = apiClient.getScansApi().launch( result.getId(), null );
        ScanDetails details = apiClient.getScansApi().details( result.getId() );

        assertEquals( waitForStatus( apiClient, result.getId(), ScanStatus.RUNNING ), ScanStatus.RUNNING );

        //stop the scan
        apiClient.getScansApi().stop( result.getId() );
        details = apiClient.getScansApi().details( result.getId() );
        assertEquals( waitForStatus( apiClient, result.getId(), ScanStatus.CANCELED ), ScanStatus.CANCELED );

        apiClient.getScansApi().delete( result.getId() );
        apiClient.getFoldersApi().delete( folderId );
    }


    @Test
    public void testSchedule() throws Exception {
        TenableIoClient apiClient = new TenableIoClient();
        int folderId = apiClient.getFoldersApi().create( getNewTestFolderName() );
        ScanResult result = createScan( apiClient, folderId );

        Settings scanSettings = new Settings();
        scanSettings.setName( getNewTestScanName() );
        scanSettings.setDescription( "new description" );
        scanSettings.setFolderId( folderId );
        scanSettings.setEnabled( false );
        scanSettings.setLaunch( LaunchFrequency.YEARLY );
        scanSettings.setStartTime( "20161221T101010" );
        scanSettings.setTimezone( "pacific" );
        scanSettings.setTextTargets( "google.com" );
        scanSettings.setEmails( getTestUsername( 0 ) );
        Permission permission = new Permission();
        permission.setType( "default" );
        permission.setPermissions( ScanRole.CAN_CONFIGURE.getValue() );
        List<Permission> acls = new ArrayList<Permission>();
        acls.add( permission );
        scanSettings.setAcls( acls );
        RRules rules = new RRules();
        rules.setFreq( "WEEKLY" );
        rules.setInterval( 1 );
        rules.setByWeekDay( "SU,MO" );
        scanSettings.setrRules( rules );

        ScanResult updated = apiClient.getScansApi().configure( result.getId(), null, scanSettings );
        assertTrue( !updated.isEnabled() );

        Schedule schedule = apiClient.getScansApi().schedule( result.getId(), true );
        assertNotNull( schedule );
        assertTrue( schedule.isEnabled() );

        apiClient.getScansApi().delete( result.getId() );
        apiClient.getFoldersApi().delete( folderId );
    }

    @Test
    public void testDownload() throws Exception {
        TenableIoClient apiClient = new TenableIoClient();
        ScanListResult result = apiClient.getScansApi().list();
        ScanDetails details = apiClient.getScansApi().details( result.getScans().get( 0 ).getId() );

        ExportScanSettings settings = new ExportScanSettings();
        settings.setPassword( "test" );
        settings.setChapters( "vuln_hosts_summary;vuln_by_host;compliance_exec;remediations;vuln_by_plugin;compliance" );
        settings.setFormat( FileFormat.NESSUS );

        String fileId = apiClient.getScansApi().exportRequest( result.getScans().get( 0 ).getId(), details.getHistories().get( 0 ).getHistoryId(), settings );
        String status = apiClient.getScansApi().exportStatus( result.getScans().get( 0 ).getId(), fileId );
        while( !status.equals( "ready" ) ) {
            Thread.sleep( 5000 );
            status = apiClient.getScansApi().exportStatus( result.getScans().get( 0 ).getId(), fileId );
        }
        apiClient.getScansApi().exportDownload( result.getScans().get( 0 ).getId(), fileId, new File( "src/test/resources/scan_export.nessus" ) );
    }


    @Test
    public void testCopyScan() throws Exception {
        TenableIoClient apiClient = new TenableIoClient();
        int folderId = apiClient.getFoldersApi().create( getNewTestFolderName() );
        ScanResult newScan = createScan( apiClient, folderId );
        assertNotNull( newScan );
        //copy scan
        String copyName = getNewTestScanName();
        Scan copiedScan = apiClient.getScansApi().copy( newScan.getId(), folderId, copyName );
        assertNotNull( copiedScan );
        assertTrue( copiedScan.getName().equals( copyName ) );
        apiClient.getScansApi().delete( newScan.getId() );
        apiClient.getScansApi().delete( copiedScan.getId() );
        apiClient.getFoldersApi().delete( folderId );
    }


    @Test
    public void testImportScan() throws Exception {
        TenableIoClient apiClient = new TenableIoClient();
        String filename = apiClient.getFileApi().upload( new File( "src/test/resources/sdk_import_test.nessus" ) );
        assertNotNull( filename );
        //password must be the same used when exporting the scan
        Scan imported = apiClient.getScansApi().importFile( filename, "test", "1" );
        assertNotNull( imported );

        apiClient.getScansApi().delete( imported.getId() );
    }


    @Test
    public void testConfigure() throws Exception {
        TenableIoClient apiClient = new TenableIoClient();
        int folderId = apiClient.getFoldersApi().create( getNewTestFolderName() );
        ScanResult newScan = createScan( apiClient, folderId );
        assertNotNull( newScan );
        //configure
        int testScannerId = getTestScannerId( apiClient );
        // import a policy to be used in test
        String filename = apiClient.getFileApi().upload( new File( "src/test/resources/nessus_policy_test.nessus" ) );
        Policy imported = apiClient.getPoliciesApi().importPolicy( filename );
        int randomPolicyId = getRandomPolicyId( apiClient );

        Settings scanSettings = new Settings();
        scanSettings.setName( "newName" );
        scanSettings.setDescription( "new description" );
        scanSettings.setPolicyId( randomPolicyId );
        scanSettings.setFolderId( folderId );
        scanSettings.setScannerId( testScannerId );
        scanSettings.setEnabled( false );
        scanSettings.setLaunch( LaunchFrequency.YEARLY );
        scanSettings.setStartTime( "20161221T101010" );
        scanSettings.setTimezone( "pacific" );
        scanSettings.setTextTargets( "google.com" );
        scanSettings.setEmails( getTestUsername( 0 ) );
        Permission permission = new Permission();
        permission.setType( "default" );
        permission.setPermissions( ScanRole.CAN_CONFIGURE.getValue() );
        List<Permission> acls = new ArrayList<Permission>();
        acls.add( permission );
        scanSettings.setAcls( acls );
        RRules rules = new RRules();
        rules.setFreq( "WEEKLY" );
        rules.setInterval( 1 );
        rules.setByWeekDay( "SU,MO" );
        scanSettings.setrRules( rules );

        ScanResult updated = apiClient.getScansApi().configure( newScan.getId(), null, scanSettings );
        assertNotNull( updated );
        assertTrue( updated.getName().equals( "newName" ) );
        assertTrue( updated.getDescription().equals( "new description" ) );
        assertTrue( !updated.isEnabled() );
        assertTrue( updated.getStartTime().equals( "20161221T101010" ) );
        assertTrue( updated.getTimezone().equals( "pacific" ) );
        assertTrue( updated.getCustomTargets().equals( "google.com" ) );
        assertTrue( updated.getEmails().equals( getTestUsername( 0 ) ) );
        assertTrue( updated.getTagId() == folderId );
        assertTrue( updated.getPolicyId() == randomPolicyId );
        // See bug CI-16748, numeric Id is being returned as null. 
        assertTrue( updated.getScannerId() == 0 );
        assertTrue( updated.getScannerUuid().equals( "00000000-0000-0000-0000-00000000000000000000000000001" ) );
        assertTrue( updated.getrRules().equals( "FREQ=WEEKLY;INTERVAL=1;BYDAY=SU,MO" ) );

        //verify new permissions
        ScanDetails details = apiClient.getScansApi().details( newScan.getId() );
        assertNotNull( details );
        List<Permission> permissions = details.getInfo().getAcls();
        for( Permission item : permissions ) {
            if( item.getType().equals( "default" ) ) {
                assertTrue( item.getPermissions() == ScanRole.CAN_CONFIGURE.getValue() );
            }
        }

        apiClient.getScansApi().delete( newScan.getId() );
        apiClient.getFoldersApi().delete( folderId );
    }

    @Ignore("501 - delete-history not implemented")
    @Test
    public void testDeleteHistory() throws Exception {
        TenableIoClient apiClient = new TenableIoClient();
        int folderId = apiClient.getFoldersApi().create( getNewTestFolderName() );
        ScanResult newScan = createScan( apiClient, folderId );
        assertNotNull( newScan );

        apiClient.getScansApi().launch( newScan.getId(), null );

        ScanDetails details = apiClient.getScansApi().details( newScan.getId() );
        assertEquals( waitForStatus( apiClient, newScan.getId(), ScanStatus.RUNNING ), ScanStatus.RUNNING );

        apiClient.getScansApi().stop( newScan.getId() );

        details = apiClient.getScansApi().details( newScan.getId() );
        assertNotNull( details );
        assertTrue( details.getHistories().size() > 0 );

        apiClient.getScansApi().deleteHistory( newScan.getId(), details.getHistories().get( 0 ).getHistoryId() );

        details = apiClient.getScansApi().details( newScan.getId() );
        assertNotNull( details );
        assertTrue( details.getHistories() == null );

        apiClient.getScansApi().delete( newScan.getId() );
        apiClient.getFoldersApi().delete( folderId );
    }


    private ScanResult createScan( TenableIoClient apiClient, int folderId ) throws TenableIoException {
        Settings settings = new Settings();
        settings.setEnabled( true );
        settings.setTextTargets(  getScanTextTargets() );
        String scanName = getNewTestScanName();
        settings.setName( scanName );
        settings.setDescription( "scan description" );
        settings.setFolderId( folderId );
        settings.setLaunch( LaunchFrequency.ON_DEMAND );
        settings.setStartTime( "20161220110500" );
        String scanTemplateName = getScanTemplateName();
        Template scanTemplateUuid = apiClient.getScanHelper().getTemplateByName( scanTemplateName );


        //Basic network scan
        //ScanResult result = apiClient.getScansApi().create("731a8e52-3ea6-a291-ec0a-d2ff0619c19d7bd788d6be818b65", settings);
        //Scan from configured template name
        ScanResult result = apiClient.getScansApi().create( scanTemplateUuid.getUuid(), settings );
        assertNotNull( result );
        assertTrue( result.isEnabled() );
        assertTrue( result.getName().equals( scanName ) );
        assertTrue( result.getDescription().equals( "scan description" ) );
        assertTrue( result.getTagId() == folderId );
        assertTrue( result.getStartTime().equals( "20161220110500" ) );
        return result;
    }


    private int getTestScannerId( TenableIoClient apiClient ) throws TenableIoException {
        List<Scanner> scanners = apiClient.getScannersApi().list();

        Scanner scanner = scanners.get( 0 );
        for ( Scanner scannerItem : scanners ) {
            scanner = scannerItem;
			if ( scannerItem.getName().equals( "US Cloud Scanner" ) ) {
                break;
            }
		}

        return scanner.getId();
    }


    private int getRandomPolicyId( TenableIoClient apiClient ) throws TenableIoException {
        List<Policy> policies = apiClient.getPoliciesApi().list();
        Random rnd = new Random();
        int index = rnd.nextInt( policies.size() );
        return policies.get( index ).getId();
    }


    @Before
    @After
    public void cleanup() throws TenableIoException {
        TenableIoClient apiClient = new TenableIoClient();

        deleteTestFolders( apiClient );
    }
}
