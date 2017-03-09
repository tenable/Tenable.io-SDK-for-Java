package com.tenable.io.api;


import com.fasterxml.jackson.databind.util.ISO8601DateFormat;
import com.tenable.io.api.models.*;
import com.tenable.io.api.workbenches.WorkbenchNessusFileParser;
import com.tenable.io.api.workbenches.models.nessus.Report;
import com.tenable.io.core.exceptions.TenableIoException;
import com.tenable.io.core.utilities.MacAddressHelper;
import org.junit.Test;

import java.io.File;
import java.text.ParseException;
import java.util.List;
import java.util.UUID;

import static org.junit.Assert.*;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class WorkbenchNessusFileParserTest extends TestBase {
    private static final String testEcportFile = "";

    @Test
    public void testParseAll() throws Exception {
        File export = new File( "src/test/resources/WorbenchNessusParserTestFile.xml" );

        WorkbenchNessusFileParser parser = new WorkbenchNessusFileParser( export );
        Report report = parser.parseAll();

        assertNotNull( report.getAssetsWithVulnerabilities() );

        int[] numVulnsPerAsset = new int[] { 37, 22, 3, 2 };
        assertEquals( report.getAssetsWithVulnerabilities().size(), numVulnsPerAsset.length );

        int i = 0;
        for( AssetVulnerabilities asset : report.getAssetsWithVulnerabilities() ) {
            assertNotNull( asset.getVulnerabilities() );
            assertEquals( asset.getVulnerabilities().size(), numVulnsPerAsset[i++] );
        }

        AssetVulnerabilities assetVulnerabilities = report.getAssetsWithVulnerabilities().get( 0 );
        assertNotNull( assetVulnerabilities.getAsset() );

        checkFirstAsset( assetVulnerabilities.getAsset() );

        checkFithVulnerability( assetVulnerabilities.getVulnerabilities().get( 4 ) );
    }


    @Test
    public void testParseAssetPage() throws Exception {
        File export = new File( "src/test/resources/WorbenchNessusParserTestFile.xml" );

        int pagesize = 2;
        WorkbenchNessusFileParser parser = new WorkbenchNessusFileParser( export, pagesize );

        List<AssetVulnerabilities> page = parser.getNextAssetPage();
        assertNotNull( page );
        assertEquals( page.size(), pagesize );

        int[] numVulnsPerAsset = new int[] { 37, 22, 3, 2 };
        int i = 0;

        for( AssetVulnerabilities assetVulnerabilities : page ) {
            assertNotNull( assetVulnerabilities.getAsset() );
            assertNotNull( assetVulnerabilities.getVulnerabilities() );
            assertEquals( assetVulnerabilities.getVulnerabilities().size(), numVulnsPerAsset[i++] );
        }

        checkFirstAsset( page.get( 0 ).getAsset() );

        checkFithVulnerability( page.get( 0 ).getVulnerabilities().get( 4 ) );

        page = parser.getNextAssetPage();
        assertNotNull( page );
        assertEquals( page.size(), pagesize );

        for( AssetVulnerabilities assetVulnerabilities : page ) {
            assertNotNull( assetVulnerabilities.getAsset() );
            assertNotNull( assetVulnerabilities.getVulnerabilities() );
            assertEquals( assetVulnerabilities.getVulnerabilities().size(), numVulnsPerAsset[i++] );
        }

        page = parser.getNextAssetPage();
        assertNotNull( page );
        assertEquals( page.size(), 0 );
    }


    @Test
    public void testParseVulnerabilityPage() throws Exception {
        File export = new File( "src/test/resources/WorbenchNessusParserTestFile.xml" );

        int pagesize = 10;
        WorkbenchNessusFileParser parser = new WorkbenchNessusFileParser( export, pagesize );

        List<Vulnerability> page = parser.getNextVulnerabilitiesPage();
        assertNotNull( page );
        assertEquals( page.size(), pagesize );

        checkFithVulnerability( page.get( 4 ) );

        int numVulns = page.size();
        while( page.size() != 0 ) {
            page = parser.getNextVulnerabilitiesPage();
            numVulns += page.size();
        }

        assertEquals( numVulns, 64 );
    }


    private void checkFirstAsset( Asset asset ) throws TenableIoException, ParseException {
        assertNotNull( asset.getMacAddresses() );
        assertEquals( asset.getMacAddresses().size(), 6 );
        assertEquals( asset.getMacAddresses().get( 0 ), MacAddressHelper.parse( "14:10:9f:db:1b:db" ) );
        assertEquals( asset.getMacAddresses().get( 1 ), MacAddressHelper.parse( "32:00:19:95:52:81" ) );
        assertEquals( asset.getMacAddresses().get( 2 ), MacAddressHelper.parse( "32:00:19:95:52:80" ) );
        assertEquals( asset.getMacAddresses().get( 3 ), MacAddressHelper.parse( "06:10:9f:db:1b:db" ) );
        assertEquals( asset.getMacAddresses().get( 4 ), MacAddressHelper.parse( "02:50:41:00:01:01" ) );
        assertEquals( asset.getMacAddresses().get( 5 ), MacAddressHelper.parse( "ba:0d:d2:83:3c:80" ) );
        assertEquals( asset.getHostName(), "127.0.0.1" );
        assertEquals( asset.getSystemType(), "general-purpose" );
        assertEquals( asset.getHostFqdn(), "localhost" );
        assertEquals( asset.getLastHostScanStart(), new ISO8601DateFormat().parse( "2016-12-28T20:49:22Z" ) );
        assertEquals( asset.getLastAuthenticatedScanProto(), "local" );
        assertEquals( asset.getOperatingSystem(), "Mac OS X 10.12.1" );
        assertEquals( asset.getLastHostScanEnd(), new ISO8601DateFormat().parse("2016-12-28T20:49:22Z" ) );
        assertEquals( asset.getLastAuthenticatedResult(), new ISO8601DateFormat().parse("2016-12-28T18:55:55Z" ) );
        assertEquals( asset.getHostIpV4().getHostAddress(), "127.0.0.1" );
        assertEquals( asset.getHostUuid(), UUID.fromString( "3ac4028d-c7e4-4545-8fa4-1669f09a89c8" ) );
    }


    private void checkFithVulnerability( Vulnerability vuln ) throws ParseException {
        assertEquals( vuln.getSeverity(), SeverityLevel.HIGH );
        assertEquals( vuln.getProtocol(), "tcp" );
        assertEquals( vuln.getPluginFamily(), "MacOS X Local Security Checks" );
        assertEquals( vuln.getPort(), 0 );
        assertEquals( vuln.getPluginID(), 69347 );
        assertEquals( vuln.getPluginName(), "Adobe Camera Raw Plugin Multiple Vulnerabilities (Mac OS X)" );
        assertNotNull( vuln.getBids() );
        assertEquals( vuln.getBids().size(), 2 );
        assertEquals( vuln.getBids().get( 0 ), "56924" );
        assertEquals( vuln.getBids().get( 1 ), "56922" );
        assertNotNull( vuln.getCves() );
        assertEquals( vuln.getCves().size(), 2 );
        assertEquals( vuln.getCves().get( 0 ), "CVE-2012-5680" );
        assertEquals( vuln.getCves().get( 1 ), "CVE-2012-5679" );
        assertEquals( vuln.getSynopsis(), "The remote host has a software plugin installed that is affected by multiple\n" +
                "                    vulnerabilities.\n" +
                "                " );
        assertEquals( vuln.getCvssTemporalVector(), "E:U/RL:OF/RC:C" );
        assertEquals( vuln.getRiskFactor(), RiskFactor.HIGH );
        assertTrue( vuln.getDescription().startsWith( "The version of the Adobe Camera Raw plugin installed on the remote host is affected by the\n" ) );
        assertTrue( vuln.getDescription().endsWith( "could allow an attacker to execute arbitrary code.\n" +
                "                " ) );
        assertEquals( vuln.getCvssVector(), "AV:N/AC:M/Au:N/C:C/I:C/A:C" );
        assertNotNull( vuln.getXrefs() );
        assertEquals( vuln.getXrefs().size(), 2 );
        assertEquals( vuln.getXrefs().get( 0 ), "OSVDB:88390" );
        assertEquals( vuln.getXrefs().get( 1 ), "OSVDB:88389" );
        assertEquals( vuln.getCvssTemporalScore(), 6.9F, 0 );
        assertEquals( vuln.getVulnPublicationDate(), new ISO8601DateFormat().parse("2012-12-12T00:00:00Z" ) );
        assertEquals( vuln.getPatchPublicationDate(), new ISO8601DateFormat().parse("2012-12-12T00:00:00Z" ) );
        assertNotNull( vuln.getSeeAlsos() );
        assertEquals( vuln.getSeeAlsos().size(), 1 );
        assertEquals( vuln.getSeeAlsos().get( 0 ), "http://secunia.com/secunia_research/2012-31/\n" +
                "                    http://www.adobe.com/support/security/bulletins/apsb12-28.html\n" +
                "                " );
        assertEquals( vuln.getPluginOutput(), "\n" +
                "                    Path : /Library/Application Support/Adobe/Plug-Ins/CS6\n" +
                "                    Installed version : 7.0.0.308\n" +
                "                    Fixed version : 7.3\n" +
                "                " );
        assertEquals( vuln.getPluginPublicationDate(), new ISO8601DateFormat().parse("2013-08-14T00:00:00Z" ) );
        assertEquals( vuln.getExploitAvailable(), false );
        assertEquals( vuln.getCvssBaseScore(), 9.3F, 0 );
        assertEquals( vuln.getSolution(), "Upgrade to Camera Raw Plug-In 6.7.1 / 7.3 or later." );
        assertEquals( vuln.getPluginType(), "local" );
        assertEquals( vuln.getPluginModificationDate(), new ISO8601DateFormat().parse("2013-08-14T00:00:00Z" ) );
    }
}
