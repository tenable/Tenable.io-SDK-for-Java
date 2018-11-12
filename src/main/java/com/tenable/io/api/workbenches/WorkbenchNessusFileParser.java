package com.tenable.io.api.workbenches;


import com.tenable.io.api.models.*;
import com.tenable.io.api.workbenches.models.nessus.*;
import com.tenable.io.core.exceptions.TenableIoException;
import com.tenable.io.core.utilities.*;
import com.tenable.io.core.utilities.models.DefaultXmlObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class WorkbenchNessusFileParser {
    private static Logger logger = LoggerFactory.getLogger( WorkbenchNessusFileParser.class );

    private int pagesize;
    private File fileToParse;
    private NessusFileParser parser;
    private Map<String, NessusObject> nessusObjectByName;


    /**
     * Instantiates a new Workbench nessus file parser in non-paginated mode.
     *
     * @param fileToParse the file to parse
     */
    public WorkbenchNessusFileParser( File fileToParse ) {
        nessusObjectByName = new HashMap<>(4);
        nessusObjectByName.put( "report", new ReportObject() );
        nessusObjectByName.put( "reporthost", new AssetWithVulnerabilitiesObject() );
        nessusObjectByName.put( "hostproperties", new AssetObject() );
        nessusObjectByName.put( "reportitem", new VulnerabilityObject() );

        this.fileToParse = fileToParse;
        this.pagesize = 0;
    }


    /**
     * Instantiates a new Workbench nessus file parser in paginated mode.
     *
     * @param fileToParse the file to parse
     * @param pagesize    the page size
     */
    public WorkbenchNessusFileParser( File fileToParse, int pagesize ) {
        this( fileToParse );
        this.pagesize = pagesize;
    }


    /**
     * Parse the whole nessus file object, regardless of the pagination parameters.
     * Note: calling this method after calling getNextPage() one or more times will lead to unpredictable results
     *
     * @return A Report object containing the entire deserialized nessus file object
     * @throws TenableIoException thrown if a parameter is invalid or the nessus file cannot be found or when encountering deserialization error
     */
    public Report parseAll() throws TenableIoException {
        if( this.parser  == null )
            this.parser = new NessusFileParserBuilder()
                    .withNessusObjectByNameMap( nessusObjectByName )
                    .withNessusFile( fileToParse )
                    .build();

        return (Report)parser.parseAll( "Report" );
    }


    /**
     * Parses the next page's worth of AssetVulnerabilities object and returns it.
     * Returns an empty list if the last items has been reached.
     *
     * @return the next page's worth of AssetVulnerabilities object
     * @throws TenableIoException thrown if a parameter is invalid or the nessus file cannot be found or when encountering deserialization error
     */
    public List<AssetVulnerabilities> getNextAssetPage() throws TenableIoException {
        return (List)getNextPage( "reporthost" );
    }


    /**
     * Parses the next page's worth of Vulnerability object and returns it.
     * Returns an empty list if the last items has been reached.
     *
     * @return the next page's worth of Vulnerability object
     * @throws TenableIoException thrown if a parameter is invalid or the nessus file cannot be found or when encountering deserialization error
     */
    public List<Vulnerability> getNextVulnerabilitiesPage() throws TenableIoException {
        return (List)getNextPage( "reportitem" );
    }


    private List<Object> getNextPage( String paginatedObjectName ) throws TenableIoException {
        if( this.parser  == null )
            this.parser = new NessusFileParserBuilder()
                    .withNessusObjectByNameMap( nessusObjectByName )
                    .withNessusFile( fileToParse )
                    .withPagesize( pagesize )
                    .withPaginateObjectName( paginatedObjectName )
                    .build();

        return parser.getNextPage();
    }


    // ************** Objects specific parsers ****************
    private class ReportObject extends NessusObject<Report> {
        @Override
        public Report create( String nodeName, Map<String, String> attributes ) {
            return new Report().withName( attributes.get( "name" ) );
        }


        @Override
        public void gotChild( Report currentObject, Object child ) {
            if( child instanceof AssetVulnerabilities )
                currentObject.addAssetWithVulnerabilities( (AssetVulnerabilities)child );
        }
    }


    private class AssetWithVulnerabilitiesObject extends NessusObject<AssetVulnerabilities> {
        @Override
        public AssetVulnerabilities create( String nodeName, Map<String, String> attributes ) {
            return new AssetVulnerabilities().withName( attributes.get( "name" ) );
        }


        @Override
        public void gotChild( AssetVulnerabilities currentObject, Object child ) {
            if( child instanceof Asset )
                currentObject.setAsset( (Asset)child );
            else if( child instanceof Vulnerability )
                currentObject.addVulnerability( (Vulnerability)child );
        }
    }


    private class AssetObject extends NessusObject<Asset> {
        @Override
        public Asset create( String nodeName, Map<String, String> attributes ) {
            return new Asset();
        }

        @Override
        public void gotChild( Asset currentObject, Object child ) {
            if( child instanceof DefaultXmlObject ) {
                DefaultXmlObject c = (DefaultXmlObject)child;
                if( c.getName().toLowerCase() == "tag" ) {
                    String tagName = c.getAttributes().get( "name" ).toLowerCase();
                    String tagValue = c.getValue();
                    try {
                        switch( tagName ) {
                            case "bios-uuid":
                                currentObject.setBiosUuid( UUID.fromString( tagValue ) );
                                break;
                            case "host-fqdn":
                                currentObject.setHostFqdn( tagValue );
                                break;
                            case "hostname":
                                currentObject.setHostName( tagValue );
                                break;
                            case "host-ip":
                                String[] ipChunks = tagValue.split( "\\." );
                                if( ipChunks.length == 4 ) {
                                    byte[] hostIp = new byte[4];
                                    for( int i = 0; i < 4; i++ )
                                        hostIp[i] = (byte)Integer.parseInt( ipChunks[i] );

                                    InetAddress address = InetAddress.getByAddress( tagValue, hostIp );
                                    if( address instanceof Inet4Address )
                                        currentObject.setHostIpV4( (Inet4Address)address );
                                }
                                break;
                            case "host-uuid":
                                currentObject.setId( UUID.fromString( tagValue ) );
                                break;
                            case "host_start":
                                currentObject.setLastHostScanStart( DateHelper.parseIso8601Date( tagValue ) );
                                break;
                            case "host_end":
                                currentObject.setLastHostScanEnd( DateHelper.parseIso8601Date( tagValue ) );
                                break;
                            case "lastauthenticatedresults":
                                currentObject.setLastAuthenticatedResult( DateHelper.parseIso8601Date( tagValue ) );
                                break;
                            case "local-checks-proto":
                                currentObject.setLastAuthenticatedScanProto( tagValue );
                                break;
                            case "mac-macaddress":
                                String[] macs = tagValue.split( "\n" );
                                for( String mac : macs ) {
                                    mac = mac.trim();
                                    if( mac.length() > 0 ) // the last mac is typically a sequence of spaces
                                        currentObject.addMacAddress( MacAddressHelper.parse( mac ) );
                                }
                                break;
                            case "mcafee-epo-guid":
                                currentObject.setMcAfeeApoGuid( UUID.fromString( tagValue ) );
                                break;
                            case "netbios-name":
                                currentObject.setNetbiosName( tagValue );
                                break;
                            case "operating-system":
                                currentObject.setOperatingSystem( tagValue );
                                break;
                            case "system-type":
                                currentObject.setSystemType( tagValue );
                                break;
                        }
                    } catch( Exception e ) {
                        logger.warn( String.format( "Exception when parsing Host Properties tag \'%s\' with value \'%s\'", tagName, tagValue ), e );
                    }
                }
            }
        }
    }


    private class VulnerabilityObject extends NessusObject<Vulnerability> {
        @Override
        public Vulnerability create( String nodeName, Map<String, String> attributes ) {
            SeverityLevel severityLevel = SeverityLevel.INFO;
            try {
                severityLevel = SeverityLevel.forIntValue( Integer.parseInt( attributes.get( "severity" ) ) );
            } catch( TenableIoException e ) {
                // Should never happen, but log error just in case
                logger.error( String.format( "Exception when parsing a ReportItem (pluginID: %s) SeverityLevel of \'%s\'.", attributes.get( "pluginid" ), attributes.get( "severity" ) ), e );
            }

            return new Vulnerability()
                    .withSeverity( severityLevel )
                    .withProtocol( attributes.get( "protocol" ) )
                    .withPluginFamily( attributes.get( "pluginfaimily" ) )
                    .withPort( Integer.parseInt( attributes.get( "port" ) ) )
                    .withPluginID( Long.parseLong( attributes.get( "pluginid" ) ) )
                    .withPluginName( attributes.get( "pluginname" ) );
        }


        @Override
        public void gotChild( Vulnerability currentObject, Object child ) {
            if( child instanceof DefaultXmlObject ) {
                DefaultXmlObject c = (DefaultXmlObject)child;
                String childName = c.getName().toLowerCase();
                String childValue = c.getValue();

                try {
                    switch( childName ) {
                        case "bid":
                            currentObject.addBid( childValue );
                            break;
                        case "canvas_package":
                            currentObject.setCanvasPackage( childValue );
                            break;
                        case "cve":
                            currentObject.addCve( childValue );
                            break;
                        case "cvss_base_score":
                            currentObject.setCvssBaseScore( Float.parseFloat( childValue ) );
                            break;
                        case "cvss_temporal_score":
                            currentObject.setCvssTemporalScore( Float.parseFloat( childValue ) );
                            break;
                        case "cvss_temporal_vector":
                            currentObject.setCvssTemporalVector( childValue );
                            break;
                        case "cvss_vector":
                            currentObject.setCvssVector( childValue );
                            break;
                        case "cvss3_base_score":
                            currentObject.setCvss3BaseScore( Float.parseFloat( childValue ) );
                            break;
                        case "cvss3_temporal_score":
                            currentObject.setCvss3TemporalScore( Float.parseFloat( childValue ) );
                            break;
                        case "cvss3_temporal_vector":
                            currentObject.setCvss3TemporalVector( childValue );
                            break;
                        case "cvss3_vector":
                            currentObject.setCvss3Vector( childValue );
                            break;
                        case "d2_elliot_name":
                            currentObject.setD2ElliotName( childValue );
                            break;
                        case "description":
                            currentObject.setDescription( childValue );
                            break;
                        case "exploit_available":
                            currentObject.setExploitAvailable( Boolean.parseBoolean( childValue ) );
                            break;
                        case "exploited_by_nessus":
                            currentObject.setExploitedByNessus( Boolean.parseBoolean( childValue ) );
                            break;
                        case "exploit_framework_canvas":
                            currentObject.setExploitFrameworkCanvas( Boolean.parseBoolean( childValue ) );
                            break;
                        case "exploit_framework_core":
                            currentObject.setExploitFrameworkCore( Boolean.parseBoolean( childValue ) );
                            break;
                        case "exploit_framework_exploithub":
                            currentObject.setExploitFrameworkExploithub( Boolean.parseBoolean( childValue ) );
                            break;
                        case "exploit_framework_metasploit":
                            currentObject.setExploitFrameworkMetasploit( Boolean.parseBoolean( childValue ) );
                            break;
                        case "exploit_framework_d2_elliot":
                            currentObject.setExploitFrameworkD2Elliot( Boolean.parseBoolean( childValue ) );
                            break;
                        case "exploited_by_malware":
                            currentObject.setExploitedByMalware( Boolean.parseBoolean( childValue ) );
                            break;
                        case "first_found":
                            currentObject.setFirstFound( DateHelper.parseIso8601Date( childValue ) );
                            break;
                        case "has_patch":
                            currentObject.setHasPatch( Boolean.parseBoolean( childValue ) );
                            break;
                        case "in_the_news":
                            currentObject.setInTheNews( Boolean.parseBoolean( childValue ) );
                            break;
                        case "last_found":
                            currentObject.setLastFound( DateHelper.parseIso8601Date( childValue ) );
                            break;
                        case "last_fixed":
                            currentObject.setLastFixed( DateHelper.parseIso8601Date( childValue ) );
                            break;
                        case "malware":
                            currentObject.setMalware( Boolean.parseBoolean( childValue ) );
                            break;
                        case "metasploit_name":
                            currentObject.setMetasploitName( childValue );
                            break;
                        case "patch_publication_date":
                            currentObject.setPatchPublicationDate( DateHelper.parseIso8601Date( childValue ) );
                            break;
                        case "plugin_modification_date":
                            currentObject.setPluginModificationDate( DateHelper.parseIso8601Date( childValue ) );
                            break;
                        case "plugin_publication_date":
                            currentObject.setPluginPublicationDate( DateHelper.parseIso8601Date( childValue ) );
                            break;
                        case "plugin_output":
                            currentObject.setPluginOutput( childValue );
                            break;
                        case "plugin_type":
                            currentObject.setPluginType( childValue );
                            break;
                        case "plugin_version":
                            currentObject.setPluginVersion( childValue );
                            break;
                        case "solution":
                            currentObject.setSolution( childValue );
                            break;
                        case "risk_factor":
                            currentObject.setRiskFactor( RiskFactor.forValue( childValue ) );
                            break;
                        case "synopsis":
                            currentObject.setSynopsis( childValue );
                            break;
                        case "unsupported_by_vendor":
                            currentObject.setUnsupportedByVendor( Boolean.parseBoolean( childValue ) );
                            break;
                        case "vulnerability_state":
                            currentObject.setVulnerabilityState( VulnerabilityState.forValue( childValue ) );
                            break;
                        case "vuln_publication_date":
                            currentObject.setVulnPublicationDate( DateHelper.parseIso8601Date( childValue ) );
                            break;
                        case "xref":
                            currentObject.addXref( childValue );
                            break;
                        case "see_also":
                            currentObject.addSeeAlso( childValue );
                            break;
                    }
                } catch( Exception e ) {
                    logger.warn( String.format( "Exception when parsing ReportItem child node \'%s\' with value \'%s\'", childName, childValue ), e );
                }
            }
        }
    }
}
