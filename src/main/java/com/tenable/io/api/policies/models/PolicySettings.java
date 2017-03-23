package com.tenable.io.api.policies.models;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.tenable.io.api.permissions.models.Permission;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
@JsonInclude( JsonInclude.Include.NON_DEFAULT )
public class PolicySettings {
    private Permission acls;
    private String additionalSnmpPort1;
    private String additionalSnmpPort2;
    private String additionalSnmpPort3;
    private String adtranAosOfflineConfigs;
    private String allowPostScanEditing;
    private String apmForceUpdates;
    private String apmUpdateTimeout;
    private String arpPing;
    private String avGracePeriod;
    private String awsApNortheast1;
    private String awsApSoutheast1;
    private String awsApSoutheast2;
    private String awsEuWest1;
    private String awsSaEast1;
    private String awsUiRegionType;
    private String awsUsEast1;
    private String awsUsGovWest1;
    private String awsUsWest1;
    private String awsUsWest2;
    private String awsUseHttps;
    private String awsVerifySsl;
    private String brocadeOfflineConfigs;
    private String checkCrl;
    private String ciscoConfigToAudit;
    private String ciscoOfflineConfigs;
    private String dellF10OfflineConfigs;
    private String description;
    private String detectSsl;
    private String displayUnreachableHosts;
    private String dontUseNtlmv1;
    private String enableAdminShares;
    private String enumDomainUsersEndUid;
    private String enumDomainUsersStartUid;
    private String enumLocalUsersEndUid;
    private String enumLocalUsersStartUid;
    private String enumerateAllCiphers;
    private String extremeosOfflineConfigs;
    private String fastNetworkDiscovery;
    private String fireeyeOfflineConfigs;
    private String hostWhitelist;
    private String httpLoginAuthRegexNocase;
    private String httpLoginAuthRegexOnHeaders;
    private String httpLoginInvertAuthRegex;
    private String httpLoginMaxRedir;
    private String httpLoginMethod;
    private String huaweiOfflineConfigs;
    private String icmpPing;
    private String icmpPingRetries;
    private String icmpUnreachMeansHostDown;
    private String junosOfflineConfigs;
    private String logLiveHosts;
    private String logWholeAttack;
    private String maxChecksPerHost;
    private String maxHostsPerScan;
    private String maxSimultTcpSessionsPerHost;
    private String maxSimultTcpSessionsPerScan;
    private String modbusEndReg;
    private String modbusStartReg;
    private String name;
    private String netappOfflineConfigs;
    private String networkReceiveTimeout;
    private String networkType;
    private String neverSendWinCredsInTheClear;
    private String onlyPortscanIfEnumFailed;
    private String patchAuditOverRexec;
    private String patchAuditOverRsh;
    private String patchAuditOverTelnet;
    private String pingTheRemoteHost;
    private String portscanRange;
    private String procurveConfigToAudit;
    private String procurveOfflineConfigs;
    private String providedCredsOnly;
    private String reduceConnectionsOnCongestion;
    private String reportParanoia;
    private String reportSupersededPatches;
    private String reportVerbosity;
    private String requestWindowsDomainInfo;
    private String reverseLookup;
    private String safeChecks;
    private String scanNetwareHosts;
    private String scanNetworkPrinters;
    private String scanWebapps;
    private String silentDependencies;
    private String sliceNetworkAddresses;
    private String smtpDomain;
    private String smtpFrom;
    private String smtpTo;
    private String snmpPort;
    private String snmpScanner;
    private String sonicosOfflineConfigs;
    private String sshClientBanner;
    private String sshKnownHosts;
    private String sshNetstatScanner;
    private String sshPort;
    private String sslProbPorts;
    private String startCotpTsap;
    private String startRemoteRegistry;
    private String stopCotpTsap;
    private String stopScanOnDisconnect;
    private String svcDetectionOnAllPorts;
    private String synFirewallDetection;
    private String synScanner;
    private String tcpPing;
    private String tcpPingDestPorts;
    private String testDefaultOracleAccounts;
    private String testLocalNessusHost;
    private String thoroughTests;
    private String udpPing;
    private String udpScanner;
    private String unscannedClosed;
    private String verifyOpenPorts;
    private String winKnownBadHashes;
    private String winKnownGoodHashes;
    private String wmiNetstatScanner;
    private String wolMacAddresses;
    private String wolWaitTime;


    /**
     * Gets acls.
     *
     * @return the acls
     */
    public Permission getAcls() {
        return acls;
    }


    /**
     * Sets acls.
     *
     * @param acls the acls
     */
    public void setAcls( Permission acls ) {
        this.acls = acls;
    }


    /**
     * Gets additional snmp port 1.
     *
     * @return the additional snmp port 1
     */
    @JsonProperty( "additional_snmp_port1" )
    public String getAdditionalSnmpPort1() {
        return additionalSnmpPort1;
    }


    /**
     * Sets additional snmp port 1.
     *
     * @param additionalSnmpPort1 the additional snmp port 1
     */
    @JsonProperty( "additional_snmp_port1" )
    public void setAdditionalSnmpPort1( String additionalSnmpPort1 ) {
        this.additionalSnmpPort1 = additionalSnmpPort1;
    }


    /**
     * Gets additional snmp port 2.
     *
     * @return the additional snmp port 2
     */
    @JsonProperty( "additional_snmp_port2" )
    public String getAdditionalSnmpPort2() {
        return additionalSnmpPort2;
    }


    /**
     * Sets additional snmp port 2.
     *
     * @param additionalSnmpPort2 the additional snmp port 2
     */
    @JsonProperty( "additional_snmp_port2" )
    public void setAdditionalSnmpPort2( String additionalSnmpPort2 ) {
        this.additionalSnmpPort2 = additionalSnmpPort2;
    }


    /**
     * Gets additional snmp port 3.
     *
     * @return the additional snmp port 3
     */
    @JsonProperty( "additional_snmp_port3" )
    public String getAdditionalSnmpPort3() {
        return additionalSnmpPort3;
    }


    /**
     * Sets additional snmp port 3.
     *
     * @param additionalSnmpPort3 the additional snmp port 3
     */
    @JsonProperty( "additional_snmp_port3" )
    public void setAdditionalSnmpPort3( String additionalSnmpPort3 ) {
        this.additionalSnmpPort3 = additionalSnmpPort3;
    }


    /**
     * Gets adtran aos offline configs.
     *
     * @return the adtran aos offline configs
     */
    @JsonProperty( "adtran_aos_offline_configs" )
    public String getAdtranAosOfflineConfigs() {
        return adtranAosOfflineConfigs;
    }


    /**
     * Sets adtran aos offline configs.
     *
     * @param adtranAosOfflineConfigs the adtran aos offline configs
     */
    @JsonProperty( "adtran_aos_offline_configs" )
    public void setAdtranAosOfflineConfigs( String adtranAosOfflineConfigs ) {
        this.adtranAosOfflineConfigs = adtranAosOfflineConfigs;
    }


    /**
     * Gets allow post scan editing.
     *
     * @return the allow post scan editing
     */
    @JsonProperty( "allow_post_scan_editing" )
    public String getAllowPostScanEditing() {
        return allowPostScanEditing;
    }


    /**
     * Sets allow post scan editing.
     *
     * @param allowPostScanEditing the allow post scan editing
     */
    @JsonProperty( "allow_post_scan_editing" )
    public void setAllowPostScanEditing( String allowPostScanEditing ) {
        this.allowPostScanEditing = allowPostScanEditing;
    }


    /**
     * Gets apm force updates.
     *
     * @return the apm force updates
     */
    @JsonProperty( "apm_force_updates" )
    public String getApmForceUpdates() {
        return apmForceUpdates;
    }


    /**
     * Sets apm force updates.
     *
     * @param apmForceUpdates the apm force updates
     */
    @JsonProperty( "apm_force_updates" )
    public void setApmForceUpdates( String apmForceUpdates ) {
        this.apmForceUpdates = apmForceUpdates;
    }


    /**
     * Gets apm update timeout.
     *
     * @return the apm update timeout
     */
    @JsonProperty( "apm_update_timeout" )
    public String getApmUpdateTimeout() {
        return apmUpdateTimeout;
    }


    /**
     * Sets apm update timeout.
     *
     * @param apmUpdateTimeout the apm update timeout
     */
    @JsonProperty( "apm_update_timeout" )
    public void setApmUpdateTimeout( String apmUpdateTimeout ) {
        this.apmUpdateTimeout = apmUpdateTimeout;
    }


    /**
     * Gets arp ping.
     *
     * @return the arp ping
     */
    @JsonProperty( "arp_ping" )
    public String getArpPing() {
        return arpPing;
    }


    /**
     * Sets arp ping.
     *
     * @param arpPing the arp ping
     */
    @JsonProperty( "arp_ping" )
    public void setArpPing( String arpPing ) {
        this.arpPing = arpPing;
    }


    /**
     * Gets av grace period.
     *
     * @return the av grace period
     */
    @JsonProperty( "av_grace_period" )
    public String getAvGracePeriod() {
        return avGracePeriod;
    }


    /**
     * Sets av grace period.
     *
     * @param avGracePeriod the av grace period
     */
    @JsonProperty( "av_grace_period" )
    public void setAvGracePeriod( String avGracePeriod ) {
        this.avGracePeriod = avGracePeriod;
    }


    /**
     * Gets aws ap northeast 1.
     *
     * @return the aws ap northeast 1
     */
    @JsonProperty( "aws_ap_northeast_1" )
    public String getAwsApNortheast1() {
        return awsApNortheast1;
    }


    /**
     * Sets aws ap northeast 1.
     *
     * @param awsApNortheast1 the aws ap northeast 1
     */
    @JsonProperty( "aws_ap_northeast_1" )
    public void setAwsApNortheast1( String awsApNortheast1 ) {
        this.awsApNortheast1 = awsApNortheast1;
    }


    /**
     * Gets aws ap southeast 1.
     *
     * @return the aws ap southeast 1
     */
    @JsonProperty( "aws_ap_southeast_1" )
    public String getAwsApSoutheast1() {
        return awsApSoutheast1;
    }


    /**
     * Sets aws ap southeast 1.
     *
     * @param awsApSoutheast1 the aws ap southeast 1
     */
    @JsonProperty( "aws_ap_southeast_1" )
    public void setAwsApSoutheast1( String awsApSoutheast1 ) {
        this.awsApSoutheast1 = awsApSoutheast1;
    }


    /**
     * Gets aws ap southeast 2.
     *
     * @return the aws ap southeast 2
     */
    @JsonProperty( "aws_ap_southeast_2" )
    public String getAwsApSoutheast2() {
        return awsApSoutheast2;
    }


    /**
     * Sets aws ap southeast 2.
     *
     * @param awsApSoutheast2 the aws ap southeast 2
     */
    @JsonProperty( "aws_ap_southeast_2" )
    public void setAwsApSoutheast2( String awsApSoutheast2 ) {
        this.awsApSoutheast2 = awsApSoutheast2;
    }


    /**
     * Gets aws eu west 1.
     *
     * @return the aws eu west 1
     */
    @JsonProperty( "aws_eu_west_1" )
    public String getAwsEuWest1() {
        return awsEuWest1;
    }


    /**
     * Sets aws eu west 1.
     *
     * @param awsEuWest1 the aws eu west 1
     */
    @JsonProperty( "aws_eu_west_1" )
    public void setAwsEuWest1( String awsEuWest1 ) {
        this.awsEuWest1 = awsEuWest1;
    }


    /**
     * Gets aws sa east 1.
     *
     * @return the aws sa east 1
     */
    @JsonProperty( "aws_sa_east_1" )
    public String getAwsSaEast1() {
        return awsSaEast1;
    }


    /**
     * Sets aws sa east 1.
     *
     * @param awsSaEast1 the aws sa east 1
     */
    @JsonProperty( "aws_sa_east_1" )
    public void setAwsSaEast1( String awsSaEast1 ) {
        this.awsSaEast1 = awsSaEast1;
    }


    /**
     * Gets aws ui region type.
     *
     * @return the aws ui region type
     */
    @JsonProperty( "aws_ui_region_type" )
    public String getAwsUiRegionType() {
        return awsUiRegionType;
    }


    /**
     * Sets aws ui region type.
     *
     * @param awsUiRegionType the aws ui region type
     */
    @JsonProperty( "aws_ui_region_type" )
    public void setAwsUiRegionType( String awsUiRegionType ) {
        this.awsUiRegionType = awsUiRegionType;
    }


    /**
     * Gets aws us east 1.
     *
     * @return the aws us east 1
     */
    @JsonProperty( "aws_us_east_1" )
    public String getAwsUsEast1() {
        return awsUsEast1;
    }


    /**
     * Sets aws us east 1.
     *
     * @param awsUsEast1 the aws us east 1
     */
    @JsonProperty( "aws_us_east_1" )
    public void setAwsUsEast1( String awsUsEast1 ) {
        this.awsUsEast1 = awsUsEast1;
    }


    /**
     * Gets aws us gov west 1.
     *
     * @return the aws us gov west 1
     */
    @JsonProperty( "aws_us_gov_west_1" )
    public String getAwsUsGovWest1() {
        return awsUsGovWest1;
    }


    /**
     * Sets aws us gov west 1.
     *
     * @param awsUsGovWest1 the aws us gov west 1
     */
    @JsonProperty( "aws_us_gov_west_1" )
    public void setAwsUsGovWest1( String awsUsGovWest1 ) {
        this.awsUsGovWest1 = awsUsGovWest1;
    }


    /**
     * Gets aws us west 1.
     *
     * @return the aws us west 1
     */
    @JsonProperty( "aws_us_west_1" )
    public String getAwsUsWest1() {
        return awsUsWest1;
    }


    /**
     * Sets aws us west 1.
     *
     * @param awsUsWest1 the aws us west 1
     */
    @JsonProperty( "aws_us_west_1" )
    public void setAwsUsWest1( String awsUsWest1 ) {
        this.awsUsWest1 = awsUsWest1;
    }


    /**
     * Gets aws us west 2.
     *
     * @return the aws us west 2
     */
    @JsonProperty( "aws_us_west_2" )
    public String getAwsUsWest2() {
        return awsUsWest2;
    }


    /**
     * Sets aws us west 2.
     *
     * @param awsUsWest2 the aws us west 2
     */
    @JsonProperty( "aws_us_west_2" )
    public void setAwsUsWest2( String awsUsWest2 ) {
        this.awsUsWest2 = awsUsWest2;
    }


    /**
     * Gets aws use https.
     *
     * @return the aws use https
     */
    @JsonProperty( "aws_use_https" )
    public String getAwsUseHttps() {
        return awsUseHttps;
    }


    /**
     * Sets aws use https.
     *
     * @param awsUseHttps the aws use https
     */
    @JsonProperty( "aws_use_https" )
    public void setAwsUseHttps( String awsUseHttps ) {
        this.awsUseHttps = awsUseHttps;
    }


    /**
     * Gets aws verify ssl.
     *
     * @return the aws verify ssl
     */
    @JsonProperty( "aws_verify_ssl" )
    public String getAwsVerifySsl() {
        return awsVerifySsl;
    }


    /**
     * Sets aws verify ssl.
     *
     * @param awsVerifySsl the aws verify ssl
     */
    @JsonProperty( "aws_verify_ssl" )
    public void setAwsVerifySsl( String awsVerifySsl ) {
        this.awsVerifySsl = awsVerifySsl;
    }


    /**
     * Gets brocade offline configs.
     *
     * @return the brocade offline configs
     */
    @JsonProperty( "brocade_offline_configs" )
    public String getBrocadeOfflineConfigs() {
        return brocadeOfflineConfigs;
    }


    /**
     * Sets brocade offline configs.
     *
     * @param brocadeOfflineConfigs the brocade offline configs
     */
    @JsonProperty( "brocade_offline_configs" )
    public void setBrocadeOfflineConfigs( String brocadeOfflineConfigs ) {
        this.brocadeOfflineConfigs = brocadeOfflineConfigs;
    }


    /**
     * Gets check crl.
     *
     * @return the check crl
     */
    @JsonProperty( "check_crl" )
    public String getCheckCrl() {
        return checkCrl;
    }


    /**
     * Sets check crl.
     *
     * @param checkCrl the check crl
     */
    @JsonProperty( "check_crl" )
    public void setCheckCrl( String checkCrl ) {
        this.checkCrl = checkCrl;
    }


    /**
     * Gets cisco config to audit.
     *
     * @return the cisco config to audit
     */
    @JsonProperty( "cisco_config_to_audit" )
    public String getCiscoConfigToAudit() {
        return ciscoConfigToAudit;
    }


    /**
     * Sets cisco config to audit.
     *
     * @param ciscoConfigToAudit the cisco config to audit
     */
    @JsonProperty( "cisco_config_to_audit" )
    public void setCiscoConfigToAudit( String ciscoConfigToAudit ) {
        this.ciscoConfigToAudit = ciscoConfigToAudit;
    }


    /**
     * Gets cisco offline configs.
     *
     * @return the cisco offline configs
     */
    @JsonProperty( "cisco_offline_configs" )
    public String getCiscoOfflineConfigs() {
        return ciscoOfflineConfigs;
    }


    /**
     * Sets cisco offline configs.
     *
     * @param ciscoOfflineConfigs the cisco offline configs
     */
    @JsonProperty( "cisco_offline_configs" )
    public void setCiscoOfflineConfigs( String ciscoOfflineConfigs ) {
        this.ciscoOfflineConfigs = ciscoOfflineConfigs;
    }


    /**
     * Gets dell f 10 offline configs.
     *
     * @return the dell f 10 offline configs
     */
    @JsonProperty( "dell_f10_offline_configs" )
    public String getDellF10OfflineConfigs() {
        return dellF10OfflineConfigs;
    }


    /**
     * Sets dell f 10 offline configs.
     *
     * @param dellF10OfflineConfigs the dell f 10 offline configs
     */
    @JsonProperty( "dell_f10_offline_configs" )
    public void setDellF10OfflineConfigs( String dellF10OfflineConfigs ) {
        this.dellF10OfflineConfigs = dellF10OfflineConfigs;
    }


    /**
     * Gets description.
     *
     * @return the description
     */
    @JsonProperty( "description" )
    public String getDescription() {
        return description;
    }


    /**
     * Sets description.
     *
     * @param description the description
     */
    @JsonProperty( "description" )
    public void setDescription( String description ) {
        this.description = description;
    }


    /**
     * Gets detect ssl.
     *
     * @return the detect ssl
     */
    @JsonProperty( "detect_ssl" )
    public String getDetectSsl() {
        return detectSsl;
    }


    /**
     * Sets detect ssl.
     *
     * @param detectSsl the detect ssl
     */
    @JsonProperty( "detect_ssl" )
    public void setDetectSsl( String detectSsl ) {
        this.detectSsl = detectSsl;
    }


    /**
     * Gets display unreachable hosts.
     *
     * @return the display unreachable hosts
     */
    @JsonProperty( "display_unreachable_hosts" )
    public String getDisplayUnreachableHosts() {
        return displayUnreachableHosts;
    }


    /**
     * Sets display unreachable hosts.
     *
     * @param displayUnreachableHosts the display unreachable hosts
     */
    @JsonProperty( "display_unreachable_hosts" )
    public void setDisplayUnreachableHosts( String displayUnreachableHosts ) {
        this.displayUnreachableHosts = displayUnreachableHosts;
    }


    /**
     * Gets dont use ntlmv 1.
     *
     * @return the dont use ntlmv 1
     */
    @JsonProperty( "dont_use_ntlmv1" )
    public String getDontUseNtlmv1() {
        return dontUseNtlmv1;
    }


    /**
     * Sets dont use ntlmv 1.
     *
     * @param dontUseNtlmv1 the dont use ntlmv 1
     */
    @JsonProperty( "dont_use_ntlmv1" )
    public void setDontUseNtlmv1( String dontUseNtlmv1 ) {
        this.dontUseNtlmv1 = dontUseNtlmv1;
    }


    /**
     * Gets enable admin shares.
     *
     * @return the enable admin shares
     */
    @JsonProperty( "enable_admin_shares" )
    public String getEnableAdminShares() {
        return enableAdminShares;
    }


    /**
     * Sets enable admin shares.
     *
     * @param enableAdminShares the enable admin shares
     */
    @JsonProperty( "enable_admin_shares" )
    public void setEnableAdminShares( String enableAdminShares ) {
        this.enableAdminShares = enableAdminShares;
    }


    /**
     * Gets enum domain users end uid.
     *
     * @return the enum domain users end uid
     */
    @JsonProperty( "enum_domain_users_end_uid" )
    public String getEnumDomainUsersEndUid() {
        return enumDomainUsersEndUid;
    }


    /**
     * Sets enum domain users end uid.
     *
     * @param enumDomainUsersEndUid the enum domain users end uid
     */
    @JsonProperty( "enum_domain_users_end_uid" )
    public void setEnumDomainUsersEndUid( String enumDomainUsersEndUid ) {
        this.enumDomainUsersEndUid = enumDomainUsersEndUid;
    }


    /**
     * Gets enum domain users start uid.
     *
     * @return the enum domain users start uid
     */
    @JsonProperty( "enum_domain_users_start_uid" )
    public String getEnumDomainUsersStartUid() {
        return enumDomainUsersStartUid;
    }


    /**
     * Sets enum domain users start uid.
     *
     * @param enumDomainUsersStartUid the enum domain users start uid
     */
    @JsonProperty( "enum_domain_users_start_uid" )
    public void setEnumDomainUsersStartUid( String enumDomainUsersStartUid ) {
        this.enumDomainUsersStartUid = enumDomainUsersStartUid;
    }


    /**
     * Gets enum local users end uid.
     *
     * @return the enum local users end uid
     */
    @JsonProperty( "enum_local_users_end_uid" )
    public String getEnumLocalUsersEndUid() {
        return enumLocalUsersEndUid;
    }


    /**
     * Sets enum local users end uid.
     *
     * @param enumLocalUsersEndUid the enum local users end uid
     */
    @JsonProperty( "enum_local_users_end_uid" )
    public void setEnumLocalUsersEndUid( String enumLocalUsersEndUid ) {
        this.enumLocalUsersEndUid = enumLocalUsersEndUid;
    }


    /**
     * Gets enum local users start uid.
     *
     * @return the enum local users start uid
     */
    @JsonProperty( "enum_local_users_start_uid" )
    public String getEnumLocalUsersStartUid() {
        return enumLocalUsersStartUid;
    }


    /**
     * Sets enum local users start uid.
     *
     * @param enumLocalUsersStartUid the enum local users start uid
     */
    @JsonProperty( "enum_local_users_start_uid" )
    public void setEnumLocalUsersStartUid( String enumLocalUsersStartUid ) {
        this.enumLocalUsersStartUid = enumLocalUsersStartUid;
    }


    /**
     * Gets enumerate all ciphers.
     *
     * @return the enumerate all ciphers
     */
    @JsonProperty( "enumerate_all_ciphers" )
    public String getEnumerateAllCiphers() {
        return enumerateAllCiphers;
    }


    /**
     * Sets enumerate all ciphers.
     *
     * @param enumerateAllCiphers the enumerate all ciphers
     */
    @JsonProperty( "enumerate_all_ciphers" )
    public void setEnumerateAllCiphers( String enumerateAllCiphers ) {
        this.enumerateAllCiphers = enumerateAllCiphers;
    }


    /**
     * Gets extremeos offline configs.
     *
     * @return the extremeos offline configs
     */
    @JsonProperty( "extremeos_offline_configs" )
    public String getExtremeosOfflineConfigs() {
        return extremeosOfflineConfigs;
    }


    /**
     * Sets extremeos offline configs.
     *
     * @param extremeosOfflineConfigs the extremeos offline configs
     */
    @JsonProperty( "extremeos_offline_configs" )
    public void setExtremeosOfflineConfigs( String extremeosOfflineConfigs ) {
        this.extremeosOfflineConfigs = extremeosOfflineConfigs;
    }


    /**
     * Gets fast network discovery.
     *
     * @return the fast network discovery
     */
    @JsonProperty( "fast_network_discovery" )
    public String getFastNetworkDiscovery() {
        return fastNetworkDiscovery;
    }


    /**
     * Sets fast network discovery.
     *
     * @param fastNetworkDiscovery the fast network discovery
     */
    @JsonProperty( "fast_network_discovery" )
    public void setFastNetworkDiscovery( String fastNetworkDiscovery ) {
        this.fastNetworkDiscovery = fastNetworkDiscovery;
    }


    /**
     * Gets fireeye offline configs.
     *
     * @return the fireeye offline configs
     */
    @JsonProperty( "fireeye_offline_configs" )
    public String getFireeyeOfflineConfigs() {
        return fireeyeOfflineConfigs;
    }


    /**
     * Sets fireeye offline configs.
     *
     * @param fireeyeOfflineConfigs the fireeye offline configs
     */
    @JsonProperty( "fireeye_offline_configs" )
    public void setFireeyeOfflineConfigs( String fireeyeOfflineConfigs ) {
        this.fireeyeOfflineConfigs = fireeyeOfflineConfigs;
    }


    /**
     * Gets host whitelist.
     *
     * @return the host whitelist
     */
    @JsonProperty( "host_whitelist" )
    public String getHostWhitelist() {
        return hostWhitelist;
    }


    /**
     * Sets host whitelist.
     *
     * @param hostWhitelist the host whitelist
     */
    @JsonProperty( "host_whitelist" )
    public void setHostWhitelist( String hostWhitelist ) {
        this.hostWhitelist = hostWhitelist;
    }


    /**
     * Gets http login auth regex nocase.
     *
     * @return the http login auth regex nocase
     */
    @JsonProperty( "http_login_auth_regex_nocase" )
    public String getHttpLoginAuthRegexNocase() {
        return httpLoginAuthRegexNocase;
    }


    /**
     * Sets http login auth regex nocase.
     *
     * @param httpLoginAuthRegexNocase the http login auth regex nocase
     */
    @JsonProperty( "http_login_auth_regex_nocase" )
    public void setHttpLoginAuthRegexNocase( String httpLoginAuthRegexNocase ) {
        this.httpLoginAuthRegexNocase = httpLoginAuthRegexNocase;
    }


    /**
     * Gets http login auth regex on headers.
     *
     * @return the http login auth regex on headers
     */
    @JsonProperty( "http_login_auth_regex_on_headers" )
    public String getHttpLoginAuthRegexOnHeaders() {
        return httpLoginAuthRegexOnHeaders;
    }


    /**
     * Sets http login auth regex on headers.
     *
     * @param httpLoginAuthRegexOnHeaders the http login auth regex on headers
     */
    @JsonProperty( "http_login_auth_regex_on_headers" )
    public void setHttpLoginAuthRegexOnHeaders( String httpLoginAuthRegexOnHeaders ) {
        this.httpLoginAuthRegexOnHeaders = httpLoginAuthRegexOnHeaders;
    }


    /**
     * Gets http login invert auth regex.
     *
     * @return the http login invert auth regex
     */
    @JsonProperty( "http_login_invert_auth_regex" )
    public String getHttpLoginInvertAuthRegex() {
        return httpLoginInvertAuthRegex;
    }


    /**
     * Sets http login invert auth regex.
     *
     * @param httpLoginInvertAuthRegex the http login invert auth regex
     */
    @JsonProperty( "http_login_invert_auth_regex" )
    public void setHttpLoginInvertAuthRegex( String httpLoginInvertAuthRegex ) {
        this.httpLoginInvertAuthRegex = httpLoginInvertAuthRegex;
    }


    /**
     * Gets http login max redir.
     *
     * @return the http login max redir
     */
    @JsonProperty( "http_login_max_redir" )
    public String getHttpLoginMaxRedir() {
        return httpLoginMaxRedir;
    }


    /**
     * Sets http login max redir.
     *
     * @param httpLoginMaxRedir the http login max redir
     */
    @JsonProperty( "http_login_max_redir" )
    public void setHttpLoginMaxRedir( String httpLoginMaxRedir ) {
        this.httpLoginMaxRedir = httpLoginMaxRedir;
    }


    /**
     * Gets http login method.
     *
     * @return the http login method
     */
    @JsonProperty( "http_login_method" )
    public String getHttpLoginMethod() {
        return httpLoginMethod;
    }


    /**
     * Sets http login method.
     *
     * @param httpLoginMethod the http login method
     */
    @JsonProperty( "http_login_method" )
    public void setHttpLoginMethod( String httpLoginMethod ) {
        this.httpLoginMethod = httpLoginMethod;
    }


    /**
     * Gets huawei offline configs.
     *
     * @return the huawei offline configs
     */
    @JsonProperty( "huawei_offline_configs" )
    public String getHuaweiOfflineConfigs() {
        return huaweiOfflineConfigs;
    }


    /**
     * Sets huawei offline configs.
     *
     * @param huaweiOfflineConfigs the huawei offline configs
     */
    @JsonProperty( "huawei_offline_configs" )
    public void setHuaweiOfflineConfigs( String huaweiOfflineConfigs ) {
        this.huaweiOfflineConfigs = huaweiOfflineConfigs;
    }


    /**
     * Gets icmp ping.
     *
     * @return the icmp ping
     */
    @JsonProperty( "icmp_ping" )
    public String getIcmpPing() {
        return icmpPing;
    }


    /**
     * Sets icmp ping.
     *
     * @param icmpPing the icmp ping
     */
    @JsonProperty( "icmp_ping" )
    public void setIcmpPing( String icmpPing ) {
        this.icmpPing = icmpPing;
    }


    /**
     * Gets icmp ping retries.
     *
     * @return the icmp ping retries
     */
    @JsonProperty( "icmp_ping_retries" )
    public String getIcmpPingRetries() {
        return icmpPingRetries;
    }


    /**
     * Sets icmp ping retries.
     *
     * @param icmpPingRetries the icmp ping retries
     */
    @JsonProperty( "icmp_ping_retries" )
    public void setIcmpPingRetries( String icmpPingRetries ) {
        this.icmpPingRetries = icmpPingRetries;
    }


    /**
     * Gets icmp unreach means host down.
     *
     * @return the icmp unreach means host down
     */
    @JsonProperty( "icmp_unreach_means_host_down" )
    public String getIcmpUnreachMeansHostDown() {
        return icmpUnreachMeansHostDown;
    }


    /**
     * Sets icmp unreach means host down.
     *
     * @param icmpUnreachMeansHostDown the icmp unreach means host down
     */
    @JsonProperty( "icmp_unreach_means_host_down" )
    public void setIcmpUnreachMeansHostDown( String icmpUnreachMeansHostDown ) {
        this.icmpUnreachMeansHostDown = icmpUnreachMeansHostDown;
    }


    /**
     * Gets junos offline configs.
     *
     * @return the junos offline configs
     */
    @JsonProperty( "junos_offline_configs" )
    public String getJunosOfflineConfigs() {
        return junosOfflineConfigs;
    }


    /**
     * Sets junos offline configs.
     *
     * @param junosOfflineConfigs the junos offline configs
     */
    @JsonProperty( "junos_offline_configs" )
    public void setJunosOfflineConfigs( String junosOfflineConfigs ) {
        this.junosOfflineConfigs = junosOfflineConfigs;
    }


    /**
     * Gets log live hosts.
     *
     * @return the log live hosts
     */
    @JsonProperty( "log_live_hosts" )
    public String getLogLiveHosts() {
        return logLiveHosts;
    }


    /**
     * Sets log live hosts.
     *
     * @param logLiveHosts the log live hosts
     */
    @JsonProperty( "log_live_hosts" )
    public void setLogLiveHosts( String logLiveHosts ) {
        this.logLiveHosts = logLiveHosts;
    }


    /**
     * Gets log whole attack.
     *
     * @return the log whole attack
     */
    @JsonProperty( "log_whole_attack" )
    public String getLogWholeAttack() {
        return logWholeAttack;
    }


    /**
     * Sets log whole attack.
     *
     * @param logWholeAttack the log whole attack
     */
    @JsonProperty( "log_whole_attack" )
    public void setLogWholeAttack( String logWholeAttack ) {
        this.logWholeAttack = logWholeAttack;
    }


    /**
     * Gets max checks per host.
     *
     * @return the max checks per host
     */
    @JsonProperty( "max_checks_per_host" )
    public String getMaxChecksPerHost() {
        return maxChecksPerHost;
    }


    /**
     * Sets max checks per host.
     *
     * @param maxChecksPerHost the max checks per host
     */
    @JsonProperty( "max_checks_per_host" )
    public void setMaxChecksPerHost( String maxChecksPerHost ) {
        this.maxChecksPerHost = maxChecksPerHost;
    }


    /**
     * Gets max hosts per scan.
     *
     * @return the max hosts per scan
     */
    @JsonProperty( "max_hosts_per_scan" )
    public String getMaxHostsPerScan() {
        return maxHostsPerScan;
    }


    /**
     * Sets max hosts per scan.
     *
     * @param maxHostsPerScan the max hosts per scan
     */
    @JsonProperty( "max_hosts_per_scan" )
    public void setMaxHostsPerScan( String maxHostsPerScan ) {
        this.maxHostsPerScan = maxHostsPerScan;
    }


    /**
     * Gets max simult tcp sessions per host.
     *
     * @return the max simult tcp sessions per host
     */
    @JsonProperty( "max_simult_tcp_sessions_per_host" )
    public String getMaxSimultTcpSessionsPerHost() {
        return maxSimultTcpSessionsPerHost;
    }


    /**
     * Sets max simult tcp sessions per host.
     *
     * @param maxSimultTcpSessionsPerHost the max simult tcp sessions per host
     */
    @JsonProperty( "max_simult_tcp_sessions_per_host" )
    public void setMaxSimultTcpSessionsPerHost( String maxSimultTcpSessionsPerHost ) {
        this.maxSimultTcpSessionsPerHost = maxSimultTcpSessionsPerHost;
    }


    /**
     * Gets max simult tcp sessions per scan.
     *
     * @return the max simult tcp sessions per scan
     */
    @JsonProperty( "max_simult_tcp_sessions_per_scan" )
    public String getMaxSimultTcpSessionsPerScan() {
        return maxSimultTcpSessionsPerScan;
    }


    /**
     * Sets max simult tcp sessions per scan.
     *
     * @param maxSimultTcpSessionsPerScan the max simult tcp sessions per scan
     */
    @JsonProperty( "max_simult_tcp_sessions_per_scan" )
    public void setMaxSimultTcpSessionsPerScan( String maxSimultTcpSessionsPerScan ) {
        this.maxSimultTcpSessionsPerScan = maxSimultTcpSessionsPerScan;
    }


    /**
     * Gets modbus end reg.
     *
     * @return the modbus end reg
     */
    @JsonProperty( "modbus_end_reg" )
    public String getModbusEndReg() {
        return modbusEndReg;
    }


    /**
     * Sets modbus end reg.
     *
     * @param modbusEndReg the modbus end reg
     */
    @JsonProperty( "modbus_end_reg" )
    public void setModbusEndReg( String modbusEndReg ) {
        this.modbusEndReg = modbusEndReg;
    }


    /**
     * Gets modbus start reg.
     *
     * @return the modbus start reg
     */
    @JsonProperty( "modbus_start_reg" )
    public String getModbusStartReg() {
        return modbusStartReg;
    }


    /**
     * Sets modbus start reg.
     *
     * @param modbusStartReg the modbus start reg
     */
    @JsonProperty( "modbus_start_reg" )
    public void setModbusStartReg( String modbusStartReg ) {
        this.modbusStartReg = modbusStartReg;
    }


    /**
     * Gets name.
     *
     * @return the name
     */
    @JsonProperty( "name" )
    public String getName() {
        return name;
    }


    /**
     * Sets name.
     *
     * @param name the name
     */
    @JsonProperty( "name" )
    public void setName( String name ) {
        this.name = name;
    }


    /**
     * Gets netapp offline configs.
     *
     * @return the netapp offline configs
     */
    @JsonProperty( "netapp_offline_configs" )
    public String getNetappOfflineConfigs() {
        return netappOfflineConfigs;
    }


    /**
     * Sets netapp offline configs.
     *
     * @param netappOfflineConfigs the netapp offline configs
     */
    @JsonProperty( "netapp_offline_configs" )
    public void setNetappOfflineConfigs( String netappOfflineConfigs ) {
        this.netappOfflineConfigs = netappOfflineConfigs;
    }


    /**
     * Gets network receive timeout.
     *
     * @return the network receive timeout
     */
    @JsonProperty( "network_receive_timeout" )
    public String getNetworkReceiveTimeout() {
        return networkReceiveTimeout;
    }


    /**
     * Sets network receive timeout.
     *
     * @param networkReceiveTimeout the network receive timeout
     */
    @JsonProperty( "network_receive_timeout" )
    public void setNetworkReceiveTimeout( String networkReceiveTimeout ) {
        this.networkReceiveTimeout = networkReceiveTimeout;
    }


    /**
     * Gets network type.
     *
     * @return the network type
     */
    @JsonProperty( "network_type" )
    public String getNetworkType() {
        return networkType;
    }


    /**
     * Sets network type.
     *
     * @param networkType the network type
     */
    @JsonProperty( "network_type" )
    public void setNetworkType( String networkType ) {
        this.networkType = networkType;
    }


    /**
     * Gets never send win creds in the clear.
     *
     * @return the never send win creds in the clear
     */
    @JsonProperty( "never_send_win_creds_in_the_clear" )
    public String getNeverSendWinCredsInTheClear() {
        return neverSendWinCredsInTheClear;
    }


    /**
     * Sets never send win creds in the clear.
     *
     * @param neverSendWinCredsInTheClear the never send win creds in the clear
     */
    @JsonProperty( "never_send_win_creds_in_the_clear" )
    public void setNeverSendWinCredsInTheClear( String neverSendWinCredsInTheClear ) {
        this.neverSendWinCredsInTheClear = neverSendWinCredsInTheClear;
    }


    /**
     * Gets only portscan if enum failed.
     *
     * @return the only portscan if enum failed
     */
    @JsonProperty( "only_portscan_if_enum_failed" )
    public String getOnlyPortscanIfEnumFailed() {
        return onlyPortscanIfEnumFailed;
    }


    /**
     * Sets only portscan if enum failed.
     *
     * @param onlyPortscanIfEnumFailed the only portscan if enum failed
     */
    @JsonProperty( "only_portscan_if_enum_failed" )
    public void setOnlyPortscanIfEnumFailed( String onlyPortscanIfEnumFailed ) {
        this.onlyPortscanIfEnumFailed = onlyPortscanIfEnumFailed;
    }


    /**
     * Gets patch audit over rexec.
     *
     * @return the patch audit over rexec
     */
    @JsonProperty( "patch_audit_over_rexec" )
    public String getPatchAuditOverRexec() {
        return patchAuditOverRexec;
    }


    /**
     * Sets patch audit over rexec.
     *
     * @param patchAuditOverRexec the patch audit over rexec
     */
    @JsonProperty( "patch_audit_over_rexec" )
    public void setPatchAuditOverRexec( String patchAuditOverRexec ) {
        this.patchAuditOverRexec = patchAuditOverRexec;
    }


    /**
     * Gets patch audit over rsh.
     *
     * @return the patch audit over rsh
     */
    @JsonProperty( "patch_audit_over_rsh" )
    public String getPatchAuditOverRsh() {
        return patchAuditOverRsh;
    }


    /**
     * Sets patch audit over rsh.
     *
     * @param patchAuditOverRsh the patch audit over rsh
     */
    @JsonProperty( "patch_audit_over_rsh" )
    public void setPatchAuditOverRsh( String patchAuditOverRsh ) {
        this.patchAuditOverRsh = patchAuditOverRsh;
    }


    /**
     * Gets patch audit over telnet.
     *
     * @return the patch audit over telnet
     */
    @JsonProperty( "patch_audit_over_telnet" )
    public String getPatchAuditOverTelnet() {
        return patchAuditOverTelnet;
    }


    /**
     * Sets patch audit over telnet.
     *
     * @param patchAuditOverTelnet the patch audit over telnet
     */
    @JsonProperty( "patch_audit_over_telnet" )
    public void setPatchAuditOverTelnet( String patchAuditOverTelnet ) {
        this.patchAuditOverTelnet = patchAuditOverTelnet;
    }


    /**
     * Gets ping the remote host.
     *
     * @return the ping the remote host
     */
    @JsonProperty( "ping_the_remote_host" )
    public String getPingTheRemoteHost() {
        return pingTheRemoteHost;
    }


    /**
     * Sets ping the remote host.
     *
     * @param pingTheRemoteHost the ping the remote host
     */
    @JsonProperty( "ping_the_remote_host" )
    public void setPingTheRemoteHost( String pingTheRemoteHost ) {
        this.pingTheRemoteHost = pingTheRemoteHost;
    }


    /**
     * Gets portscan range.
     *
     * @return the portscan range
     */
    @JsonProperty( "portscan_range" )
    public String getPortscanRange() {
        return portscanRange;
    }


    /**
     * Sets portscan range.
     *
     * @param portscanRange the portscan range
     */
    @JsonProperty( "portscan_range" )
    public void setPortscanRange( String portscanRange ) {
        this.portscanRange = portscanRange;
    }


    /**
     * Gets procurve config to audit.
     *
     * @return the procurve config to audit
     */
    @JsonProperty( "procurve_config_to_audit" )
    public String getProcurveConfigToAudit() {
        return procurveConfigToAudit;
    }


    /**
     * Sets procurve config to audit.
     *
     * @param procurveConfigToAudit the procurve config to audit
     */
    @JsonProperty( "procurve_config_to_audit" )
    public void setProcurveConfigToAudit( String procurveConfigToAudit ) {
        this.procurveConfigToAudit = procurveConfigToAudit;
    }


    /**
     * Gets procurve offline configs.
     *
     * @return the procurve offline configs
     */
    @JsonProperty( "procurve_offline_configs" )
    public String getProcurveOfflineConfigs() {
        return procurveOfflineConfigs;
    }


    /**
     * Sets procurve offline configs.
     *
     * @param procurveOfflineConfigs the procurve offline configs
     */
    @JsonProperty( "procurve_offline_configs" )
    public void setProcurveOfflineConfigs( String procurveOfflineConfigs ) {
        this.procurveOfflineConfigs = procurveOfflineConfigs;
    }


    /**
     * Gets provided creds only.
     *
     * @return the provided creds only
     */
    @JsonProperty( "provided_creds_only" )
    public String getProvidedCredsOnly() {
        return providedCredsOnly;
    }


    /**
     * Sets provided creds only.
     *
     * @param providedCredsOnly the provided creds only
     */
    @JsonProperty( "provided_creds_only" )
    public void setProvidedCredsOnly( String providedCredsOnly ) {
        this.providedCredsOnly = providedCredsOnly;
    }


    /**
     * Gets reduce connections on congestion.
     *
     * @return the reduce connections on congestion
     */
    @JsonProperty( "reduce_connections_on_congestion" )
    public String getReduceConnectionsOnCongestion() {
        return reduceConnectionsOnCongestion;
    }


    /**
     * Sets reduce connections on congestion.
     *
     * @param reduceConnectionsOnCongestion the reduce connections on congestion
     */
    @JsonProperty( "reduce_connections_on_congestion" )
    public void setReduceConnectionsOnCongestion( String reduceConnectionsOnCongestion ) {
        this.reduceConnectionsOnCongestion = reduceConnectionsOnCongestion;
    }


    /**
     * Gets report paranoia.
     *
     * @return the report paranoia
     */
    @JsonProperty( "report_paranoia" )
    public String getReportParanoia() {
        return reportParanoia;
    }


    /**
     * Sets report paranoia.
     *
     * @param reportParanoia the report paranoia
     */
    @JsonProperty( "report_paranoia" )
    public void setReportParanoia( String reportParanoia ) {
        this.reportParanoia = reportParanoia;
    }


    /**
     * Gets report superseded patches.
     *
     * @return the report superseded patches
     */
    @JsonProperty( "report_superseded_patches" )
    public String getReportSupersededPatches() {
        return reportSupersededPatches;
    }


    /**
     * Sets report superseded patches.
     *
     * @param reportSupersededPatches the report superseded patches
     */
    @JsonProperty( "report_superseded_patches" )
    public void setReportSupersededPatches( String reportSupersededPatches ) {
        this.reportSupersededPatches = reportSupersededPatches;
    }


    /**
     * Gets report verbosity.
     *
     * @return the report verbosity
     */
    @JsonProperty( "report_verbosity" )
    public String getReportVerbosity() {
        return reportVerbosity;
    }


    /**
     * Sets report verbosity.
     *
     * @param reportVerbosity the report verbosity
     */
    @JsonProperty( "report_verbosity" )
    public void setReportVerbosity( String reportVerbosity ) {
        this.reportVerbosity = reportVerbosity;
    }


    /**
     * Gets request windows domain info.
     *
     * @return the request windows domain info
     */
    @JsonProperty( "request_windows_domain_info" )
    public String getRequestWindowsDomainInfo() {
        return requestWindowsDomainInfo;
    }


    /**
     * Sets request windows domain info.
     *
     * @param requestWindowsDomainInfo the request windows domain info
     */
    @JsonProperty( "request_windows_domain_info" )
    public void setRequestWindowsDomainInfo( String requestWindowsDomainInfo ) {
        this.requestWindowsDomainInfo = requestWindowsDomainInfo;
    }


    /**
     * Gets reverse lookup.
     *
     * @return the reverse lookup
     */
    @JsonProperty( "reverse_lookup" )
    public String getReverseLookup() {
        return reverseLookup;
    }


    /**
     * Sets reverse lookup.
     *
     * @param reverseLookup the reverse lookup
     */
    @JsonProperty( "reverse_lookup" )
    public void setReverseLookup( String reverseLookup ) {
        this.reverseLookup = reverseLookup;
    }


    /**
     * Gets safe checks.
     *
     * @return the safe checks
     */
    @JsonProperty( "safe_checks" )
    public String getSafeChecks() {
        return safeChecks;
    }


    /**
     * Sets safe checks.
     *
     * @param safeChecks the safe checks
     */
    @JsonProperty( "safe_checks" )
    public void setSafeChecks( String safeChecks ) {
        this.safeChecks = safeChecks;
    }


    /**
     * Gets scan netware hosts.
     *
     * @return the scan netware hosts
     */
    @JsonProperty( "scan_netware_hosts" )
    public String getScanNetwareHosts() {
        return scanNetwareHosts;
    }


    /**
     * Sets scan netware hosts.
     *
     * @param scanNetwareHosts the scan netware hosts
     */
    @JsonProperty( "scan_netware_hosts" )
    public void setScanNetwareHosts( String scanNetwareHosts ) {
        this.scanNetwareHosts = scanNetwareHosts;
    }


    /**
     * Gets scan network printers.
     *
     * @return the scan network printers
     */
    @JsonProperty( "scan_network_printers" )
    public String getScanNetworkPrinters() {
        return scanNetworkPrinters;
    }


    /**
     * Sets scan network printers.
     *
     * @param scanNetworkPrinters the scan network printers
     */
    @JsonProperty( "scan_network_printers" )
    public void setScanNetworkPrinters( String scanNetworkPrinters ) {
        this.scanNetworkPrinters = scanNetworkPrinters;
    }


    /**
     * Gets scan webapps.
     *
     * @return the scan webapps
     */
    @JsonProperty( "scan_webapps" )
    public String getScanWebapps() {
        return scanWebapps;
    }


    /**
     * Sets scan webapps.
     *
     * @param scanWebapps the scan webapps
     */
    @JsonProperty( "scan_webapps" )
    public void setScanWebapps( String scanWebapps ) {
        this.scanWebapps = scanWebapps;
    }


    /**
     * Gets silent dependencies.
     *
     * @return the silent dependencies
     */
    @JsonProperty( "silent_dependencies" )
    public String getSilentDependencies() {
        return silentDependencies;
    }


    /**
     * Sets silent dependencies.
     *
     * @param silentDependencies the silent dependencies
     */
    @JsonProperty( "silent_dependencies" )
    public void setSilentDependencies( String silentDependencies ) {
        this.silentDependencies = silentDependencies;
    }


    /**
     * Gets slice network addresses.
     *
     * @return the slice network addresses
     */
    @JsonProperty( "slice_network_addresses" )
    public String getSliceNetworkAddresses() {
        return sliceNetworkAddresses;
    }


    /**
     * Sets slice network addresses.
     *
     * @param sliceNetworkAddresses the slice network addresses
     */
    @JsonProperty( "slice_network_addresses" )
    public void setSliceNetworkAddresses( String sliceNetworkAddresses ) {
        this.sliceNetworkAddresses = sliceNetworkAddresses;
    }


    /**
     * Gets smtp domain.
     *
     * @return the smtp domain
     */
    @JsonProperty( "smtp_domain" )
    public String getSmtpDomain() {
        return smtpDomain;
    }


    /**
     * Sets smtp domain.
     *
     * @param smtpDomain the smtp domain
     */
    @JsonProperty( "smtp_domain" )
    public void setSmtpDomain( String smtpDomain ) {
        this.smtpDomain = smtpDomain;
    }


    /**
     * Gets smtp from.
     *
     * @return the smtp from
     */
    @JsonProperty( "smtp_from" )
    public String getSmtpFrom() {
        return smtpFrom;
    }


    /**
     * Sets smtp from.
     *
     * @param smtpFrom the smtp from
     */
    @JsonProperty( "smtp_from" )
    public void setSmtpFrom( String smtpFrom ) {
        this.smtpFrom = smtpFrom;
    }


    /**
     * Gets smtp to.
     *
     * @return the smtp to
     */
    @JsonProperty( "smtp_to" )
    public String getSmtpTo() {
        return smtpTo;
    }


    /**
     * Sets smtp to.
     *
     * @param smtpTo the smtp to
     */
    @JsonProperty( "smtp_to" )
    public void setSmtpTo( String smtpTo ) {
        this.smtpTo = smtpTo;
    }


    /**
     * Gets snmp port.
     *
     * @return the snmp port
     */
    @JsonProperty( "snmp_port" )
    public String getSnmpPort() {
        return snmpPort;
    }


    /**
     * Sets snmp port.
     *
     * @param snmpPort the snmp port
     */
    @JsonProperty( "snmp_port" )
    public void setSnmpPort( String snmpPort ) {
        this.snmpPort = snmpPort;
    }


    /**
     * Gets snmp scanner.
     *
     * @return the snmp scanner
     */
    @JsonProperty( "snmp_scanner" )
    public String getSnmpScanner() {
        return snmpScanner;
    }


    /**
     * Sets snmp scanner.
     *
     * @param snmpScanner the snmp scanner
     */
    @JsonProperty( "snmp_scanner" )
    public void setSnmpScanner( String snmpScanner ) {
        this.snmpScanner = snmpScanner;
    }


    /**
     * Gets sonicos offline configs.
     *
     * @return the sonicos offline configs
     */
    @JsonProperty( "sonicos_offline_configs" )
    public String getSonicosOfflineConfigs() {
        return sonicosOfflineConfigs;
    }


    /**
     * Sets sonicos offline configs.
     *
     * @param sonicosOfflineConfigs the sonicos offline configs
     */
    @JsonProperty( "sonicos_offline_configs" )
    public void setSonicosOfflineConfigs( String sonicosOfflineConfigs ) {
        this.sonicosOfflineConfigs = sonicosOfflineConfigs;
    }


    /**
     * Gets ssh client banner.
     *
     * @return the ssh client banner
     */
    @JsonProperty( "ssh_client_banner" )
    public String getSshClientBanner() {
        return sshClientBanner;
    }


    /**
     * Sets ssh client banner.
     *
     * @param sshClientBanner the ssh client banner
     */
    @JsonProperty( "ssh_client_banner" )
    public void setSshClientBanner( String sshClientBanner ) {
        this.sshClientBanner = sshClientBanner;
    }


    /**
     * Gets ssh known hosts.
     *
     * @return the ssh known hosts
     */
    @JsonProperty( "ssh_known_hosts" )
    public String getSshKnownHosts() {
        return sshKnownHosts;
    }


    /**
     * Sets ssh known hosts.
     *
     * @param sshKnownHosts the ssh known hosts
     */
    @JsonProperty( "ssh_known_hosts" )
    public void setSshKnownHosts( String sshKnownHosts ) {
        this.sshKnownHosts = sshKnownHosts;
    }


    /**
     * Gets ssh netstat scanner.
     *
     * @return the ssh netstat scanner
     */
    @JsonProperty( "ssh_netstat_scanner" )
    public String getSshNetstatScanner() {
        return sshNetstatScanner;
    }


    /**
     * Sets ssh netstat scanner.
     *
     * @param sshNetstatScanner the ssh netstat scanner
     */
    @JsonProperty( "ssh_netstat_scanner" )
    public void setSshNetstatScanner( String sshNetstatScanner ) {
        this.sshNetstatScanner = sshNetstatScanner;
    }


    /**
     * Gets ssh port.
     *
     * @return the ssh port
     */
    @JsonProperty( "ssh_port" )
    public String getSshPort() {
        return sshPort;
    }


    /**
     * Sets ssh port.
     *
     * @param sshPort the ssh port
     */
    @JsonProperty( "ssh_port" )
    public void setSshPort( String sshPort ) {
        this.sshPort = sshPort;
    }


    /**
     * Gets ssl prob ports.
     *
     * @return the ssl prob ports
     */
    @JsonProperty( "ssl_prob_ports" )
    public String getSslProbPorts() {
        return sslProbPorts;
    }


    /**
     * Sets ssl prob ports.
     *
     * @param sslProbPorts the ssl prob ports
     */
    @JsonProperty( "ssl_prob_ports" )
    public void setSslProbPorts( String sslProbPorts ) {
        this.sslProbPorts = sslProbPorts;
    }


    /**
     * Gets start cotp tsap.
     *
     * @return the start cotp tsap
     */
    @JsonProperty( "start_cotp_tsap" )
    public String getStartCotpTsap() {
        return startCotpTsap;
    }


    /**
     * Sets start cotp tsap.
     *
     * @param startCotpTsap the start cotp tsap
     */
    @JsonProperty( "start_cotp_tsap" )
    public void setStartCotpTsap( String startCotpTsap ) {
        this.startCotpTsap = startCotpTsap;
    }


    /**
     * Gets start remote registry.
     *
     * @return the start remote registry
     */
    @JsonProperty( "start_remote_registry" )
    public String getStartRemoteRegistry() {
        return startRemoteRegistry;
    }


    /**
     * Sets start remote registry.
     *
     * @param startRemoteRegistry the start remote registry
     */
    @JsonProperty( "start_remote_registry" )
    public void setStartRemoteRegistry( String startRemoteRegistry ) {
        this.startRemoteRegistry = startRemoteRegistry;
    }


    /**
     * Gets stop cotp tsap.
     *
     * @return the stop cotp tsap
     */
    @JsonProperty( "stop_cotp_tsap" )
    public String getStopCotpTsap() {
        return stopCotpTsap;
    }


    /**
     * Sets stop cotp tsap.
     *
     * @param stopCotpTsap the stop cotp tsap
     */
    @JsonProperty( "stop_cotp_tsap" )
    public void setStopCotpTsap( String stopCotpTsap ) {
        this.stopCotpTsap = stopCotpTsap;
    }


    /**
     * Gets stop scan on disconnect.
     *
     * @return the stop scan on disconnect
     */
    @JsonProperty( "stop_scan_on_disconnect" )
    public String getStopScanOnDisconnect() {
        return stopScanOnDisconnect;
    }


    /**
     * Sets stop scan on disconnect.
     *
     * @param stopScanOnDisconnect the stop scan on disconnect
     */
    @JsonProperty( "stop_scan_on_disconnect" )
    public void setStopScanOnDisconnect( String stopScanOnDisconnect ) {
        this.stopScanOnDisconnect = stopScanOnDisconnect;
    }


    /**
     * Gets svc detection on all ports.
     *
     * @return the svc detection on all ports
     */
    @JsonProperty( "svc_detection_on_all_ports" )
    public String getSvcDetectionOnAllPorts() {
        return svcDetectionOnAllPorts;
    }


    /**
     * Sets svc detection on all ports.
     *
     * @param svcDetectionOnAllPorts the svc detection on all ports
     */
    @JsonProperty( "svc_detection_on_all_ports" )
    public void setSvcDetectionOnAllPorts( String svcDetectionOnAllPorts ) {
        this.svcDetectionOnAllPorts = svcDetectionOnAllPorts;
    }


    /**
     * Gets syn firewall detection.
     *
     * @return the syn firewall detection
     */
    @JsonProperty( "syn_firewall_detection" )
    public String getSynFirewallDetection() {
        return synFirewallDetection;
    }


    /**
     * Sets syn firewall detection.
     *
     * @param synFirewallDetection the syn firewall detection
     */
    @JsonProperty( "syn_firewall_detection" )
    public void setSynFirewallDetection( String synFirewallDetection ) {
        this.synFirewallDetection = synFirewallDetection;
    }


    /**
     * Gets syn scanner.
     *
     * @return the syn scanner
     */
    @JsonProperty( "syn_scanner" )
    public String getSynScanner() {
        return synScanner;
    }


    /**
     * Sets syn scanner.
     *
     * @param synScanner the syn scanner
     */
    @JsonProperty( "syn_scanner" )
    public void setSynScanner( String synScanner ) {
        this.synScanner = synScanner;
    }


    /**
     * Gets tcp ping.
     *
     * @return the tcp ping
     */
    @JsonProperty( "tcp_ping" )
    public String getTcpPing() {
        return tcpPing;
    }


    /**
     * Sets tcp ping.
     *
     * @param tcpPing the tcp ping
     */
    @JsonProperty( "tcp_ping" )
    public void setTcpPing( String tcpPing ) {
        this.tcpPing = tcpPing;
    }


    /**
     * Gets tcp ping dest ports.
     *
     * @return the tcp ping dest ports
     */
    @JsonProperty( "tcp_ping_dest_ports" )
    public String getTcpPingDestPorts() {
        return tcpPingDestPorts;
    }


    /**
     * Sets tcp ping dest ports.
     *
     * @param tcpPingDestPorts the tcp ping dest ports
     */
    @JsonProperty( "tcp_ping_dest_ports" )
    public void setTcpPingDestPorts( String tcpPingDestPorts ) {
        this.tcpPingDestPorts = tcpPingDestPorts;
    }


    /**
     * Gets test default oracle accounts.
     *
     * @return the test default oracle accounts
     */
    @JsonProperty( "test_default_oracle_accounts" )
    public String getTestDefaultOracleAccounts() {
        return testDefaultOracleAccounts;
    }


    /**
     * Sets test default oracle accounts.
     *
     * @param testDefaultOracleAccounts the test default oracle accounts
     */
    @JsonProperty( "test_default_oracle_accounts" )
    public void setTestDefaultOracleAccounts( String testDefaultOracleAccounts ) {
        this.testDefaultOracleAccounts = testDefaultOracleAccounts;
    }


    /**
     * Gets test local nessus host.
     *
     * @return the test local nessus host
     */
    @JsonProperty( "test_local_nessus_host" )
    public String getTestLocalNessusHost() {
        return testLocalNessusHost;
    }


    /**
     * Sets test local nessus host.
     *
     * @param testLocalNessusHost the test local nessus host
     */
    @JsonProperty( "test_local_nessus_host" )
    public void setTestLocalNessusHost( String testLocalNessusHost ) {
        this.testLocalNessusHost = testLocalNessusHost;
    }


    /**
     * Gets thorough tests.
     *
     * @return the thorough tests
     */
    @JsonProperty( "thorough_tests" )
    public String getThoroughTests() {
        return thoroughTests;
    }


    /**
     * Sets thorough tests.
     *
     * @param thoroughTests the thorough tests
     */
    @JsonProperty( "thorough_tests" )
    public void setThoroughTests( String thoroughTests ) {
        this.thoroughTests = thoroughTests;
    }


    /**
     * Gets udp ping.
     *
     * @return the udp ping
     */
    @JsonProperty( "udp_ping" )
    public String getUdpPing() {
        return udpPing;
    }


    /**
     * Sets udp ping.
     *
     * @param udpPing the udp ping
     */
    @JsonProperty( "udp_ping" )
    public void setUdpPing( String udpPing ) {
        this.udpPing = udpPing;
    }


    /**
     * Gets udp scanner.
     *
     * @return the udp scanner
     */
    @JsonProperty( "udp_scanner" )
    public String getUdpScanner() {
        return udpScanner;
    }


    /**
     * Sets udp scanner.
     *
     * @param udpScanner the udp scanner
     */
    @JsonProperty( "udp_scanner" )
    public void setUdpScanner( String udpScanner ) {
        this.udpScanner = udpScanner;
    }


    /**
     * Gets unscanned closed.
     *
     * @return the unscanned closed
     */
    @JsonProperty( "unscanned_closed" )
    public String getUnscannedClosed() {
        return unscannedClosed;
    }


    /**
     * Sets unscanned closed.
     *
     * @param unscannedClosed the unscanned closed
     */
    @JsonProperty( "unscanned_closed" )
    public void setUnscannedClosed( String unscannedClosed ) {
        this.unscannedClosed = unscannedClosed;
    }


    /**
     * Gets verify open ports.
     *
     * @return the verify open ports
     */
    @JsonProperty( "verify_open_ports" )
    public String getVerifyOpenPorts() {
        return verifyOpenPorts;
    }


    /**
     * Sets verify open ports.
     *
     * @param verifyOpenPorts the verify open ports
     */
    @JsonProperty( "verify_open_ports" )
    public void setVerifyOpenPorts( String verifyOpenPorts ) {
        this.verifyOpenPorts = verifyOpenPorts;
    }


    /**
     * Gets win known bad hashes.
     *
     * @return the win known bad hashes
     */
    @JsonProperty( "win_known_bad_hashes" )
    public String getWinKnownBadHashes() {
        return winKnownBadHashes;
    }


    /**
     * Sets win known bad hashes.
     *
     * @param winKnownBadHashes the win known bad hashes
     */
    @JsonProperty( "win_known_bad_hashes" )
    public void setWinKnownBadHashes( String winKnownBadHashes ) {
        this.winKnownBadHashes = winKnownBadHashes;
    }


    /**
     * Gets win known good hashes.
     *
     * @return the win known good hashes
     */
    @JsonProperty( "win_known_good_hashes" )
    public String getWinKnownGoodHashes() {
        return winKnownGoodHashes;
    }


    /**
     * Sets win known good hashes.
     *
     * @param winKnownGoodHashes the win known good hashes
     */
    @JsonProperty( "win_known_good_hashes" )
    public void setWinKnownGoodHashes( String winKnownGoodHashes ) {
        this.winKnownGoodHashes = winKnownGoodHashes;
    }


    /**
     * Gets wmi netstat scanner.
     *
     * @return the wmi netstat scanner
     */
    @JsonProperty( "wmi_netstat_scanner" )
    public String getWmiNetstatScanner() {
        return wmiNetstatScanner;
    }


    /**
     * Sets wmi netstat scanner.
     *
     * @param wmiNetstatScanner the wmi netstat scanner
     */
    @JsonProperty( "wmi_netstat_scanner" )
    public void setWmiNetstatScanner( String wmiNetstatScanner ) {
        this.wmiNetstatScanner = wmiNetstatScanner;
    }


    /**
     * Gets wol mac addresses.
     *
     * @return the wol mac addresses
     */
    @JsonProperty( "wol_mac_addresses" )
    public String getWolMacAddresses() {
        return wolMacAddresses;
    }


    /**
     * Sets wol mac addresses.
     *
     * @param wolMacAddresses the wol mac addresses
     */
    @JsonProperty( "wol_mac_addresses" )
    public void setWolMacAddresses( String wolMacAddresses ) {
        this.wolMacAddresses = wolMacAddresses;
    }


    /**
     * Gets wol wait time.
     *
     * @return the wol wait time
     */
    @JsonProperty( "wol_wait_time" )
    public String getWolWaitTime() {
        return wolWaitTime;
    }


    /**
     * Sets wol wait time.
     *
     * @param wolWaitTime the wol wait time
     */
    @JsonProperty( "wol_wait_time" )
    public void setWolWaitTime( String wolWaitTime ) {
        this.wolWaitTime = wolWaitTime;
    }


    /**
     * Sets acls.
     *
     * @param acls the acls
     */
    public void withAcls(Permission acls) {
        this.acls = acls;
    }


    /**
     * Sets additional snmp port 1.
     *
     * @param additionalSnmpPort1 the additional snmp port 1
     */
    public void withAdditionalSnmpPort1(String additionalSnmpPort1) {
        this.additionalSnmpPort1 = additionalSnmpPort1;
    }


    /**
     * Sets additional snmp port 2.
     *
     * @param additionalSnmpPort2 the additional snmp port 2
     */
    public void withAdditionalSnmpPort2(String additionalSnmpPort2) {
        this.additionalSnmpPort2 = additionalSnmpPort2;
    }


    /**
     * withs additional snmp port 3.
     *
     * @param additionalSnmpPort3 the additional snmp port 3
     */
    public void withAdditionalSnmpPort3( String additionalSnmpPort3 ) {
        this.additionalSnmpPort3 = additionalSnmpPort3;
    }


    /**
     * Sets adtran aos offline configs.
     *
     * @param adtranAosOfflineConfigs the adtran aos offline configs
     */
    public void withAdtranAosOfflineConfigs( String adtranAosOfflineConfigs ) {
        this.adtranAosOfflineConfigs = adtranAosOfflineConfigs;
    }


    /**
     * Sets allow post scan editing.
     *
     * @param allowPostScanEditing the allow post scan editing
     */
    public void withAllowPostScanEditing( String allowPostScanEditing ) {
        this.allowPostScanEditing = allowPostScanEditing;
    }


    /**
     * Sets apm force updates.
     *
     * @param apmForceUpdates the apm force updates
     */
    public void withApmForceUpdates( String apmForceUpdates ) {
        this.apmForceUpdates = apmForceUpdates;
    }


    /**
     * Sets apm update timeout.
     *
     * @param apmUpdateTimeout the apm update timeout
     */
    public void withApmUpdateTimeout( String apmUpdateTimeout ) {
        this.apmUpdateTimeout = apmUpdateTimeout;
    }


    /**
     * Sets arp ping.
     *
     * @param arpPing the arp ping
     */
    public void withArpPing( String arpPing ) {
        this.arpPing = arpPing;
    }


    /**
     * Sets av grace period.
     *
     * @param avGracePeriod the av grace period
     */
    public void withAvGracePeriod( String avGracePeriod ) {
        this.avGracePeriod = avGracePeriod;
    }


    /**
     * Sets aws ap northeast 1.
     *
     * @param awsApNortheast1 the aws ap northeast 1
     */
    public void withAwsApNortheast1( String awsApNortheast1 ) {
        this.awsApNortheast1 = awsApNortheast1;
    }


    /**
     * Sets aws ap southeast 1.
     *
     * @param awsApSoutheast1 the aws ap southeast 1
     */
    public void withAwsApSoutheast1( String awsApSoutheast1 ) {
        this.awsApSoutheast1 = awsApSoutheast1;
    }


    /**
     * Sets aws ap southeast 2.
     *
     * @param awsApSoutheast2 the aws ap southeast 2
     */
    public void withAwsApSoutheast2( String awsApSoutheast2 ) {
        this.awsApSoutheast2 = awsApSoutheast2;
    }


    /**
     * Sets aws eu west 1.
     *
     * @param awsEuWest1 the aws eu west 1
     */
    public void withAwsEuWest1( String awsEuWest1 ) {
        this.awsEuWest1 = awsEuWest1;
    }


    /**
     * Sets aws sa east 1.
     *
     * @param awsSaEast1 the aws sa east 1
     */
    public void withAwsSaEast1( String awsSaEast1 ) {
        this.awsSaEast1 = awsSaEast1;
    }


    /**
     * Sets aws ui region type.
     *
     * @param awsUiRegionType the aws ui region type
     */
    public void withAwsUiRegionType( String awsUiRegionType ) {
        this.awsUiRegionType = awsUiRegionType;
    }


    /**
     * Sets aws us east 1.
     *
     * @param awsUsEast1 the aws us east 1
     */
    public void withAwsUsEast1( String awsUsEast1 ) {
        this.awsUsEast1 = awsUsEast1;
    }


    /**
     * Sets aws us gov west 1.
     *
     * @param awsUsGovWest1 the aws us gov west 1
     */
    public void withAwsUsGovWest1( String awsUsGovWest1 ) {
        this.awsUsGovWest1 = awsUsGovWest1;
    }


    /**
     * Sets aws us west 1.
     *
     * @param awsUsWest1 the aws us west 1
     */
    public void withAwsUsWest1( String awsUsWest1 ) {
        this.awsUsWest1 = awsUsWest1;
    }


    /**
     * Sets aws us west 2.
     *
     * @param awsUsWest2 the aws us west 2
     */
    public void withAwsUsWest2( String awsUsWest2 ) {
        this.awsUsWest2 = awsUsWest2;
    }


    /**
     * Sets aws use https.
     *
     * @param awsUseHttps the aws use https
     */
    public void withAwsUseHttps( String awsUseHttps ) {
        this.awsUseHttps = awsUseHttps;
    }


    /**
     * Sets aws verify ssl.
     *
     * @param awsVerifySsl the aws verify ssl
     */
    public void withAwsVerifySsl( String awsVerifySsl ) {
        this.awsVerifySsl = awsVerifySsl;
    }


    /**
     * Sets brocade offline configs.
     *
     * @param brocadeOfflineConfigs the brocade offline configs
     */
    public void withBrocadeOfflineConfigs( String brocadeOfflineConfigs ) {
        this.brocadeOfflineConfigs = brocadeOfflineConfigs;
    }


    /**
     * Sets check crl.
     *
     * @param checkCrl the check crl
     */
    public void withCheckCrl( String checkCrl ) {
        this.checkCrl = checkCrl;
    }


    /**
     * Sets cisco config to audit.
     *
     * @param ciscoConfigToAudit the cisco config to audit
     */
    public void withCiscoConfigToAudit( String ciscoConfigToAudit ) {
        this.ciscoConfigToAudit = ciscoConfigToAudit;
    }


    /**
     * Sets cisco offline configs.
     *
     * @param ciscoOfflineConfigs the cisco offline configs
     */
    public void withCiscoOfflineConfigs( String ciscoOfflineConfigs ) {
        this.ciscoOfflineConfigs = ciscoOfflineConfigs;
    }


    /**
     * Sets dell f 10 offline configs.
     *
     * @param dellF10OfflineConfigs the dell f 10 offline configs
     */
    public void withDellF10OfflineConfigs( String dellF10OfflineConfigs ) {
        this.dellF10OfflineConfigs = dellF10OfflineConfigs;
    }


    /**
     * Sets description.
     *
     * @param description the description
     */
    public void withDescription( String description ) {
        this.description = description;
    }


    /**
     * Sets detect ssl.
     *
     * @param detectSsl the detect ssl
     */
    public void withDetectSsl( String detectSsl ) {
        this.detectSsl = detectSsl;
    }


    /**
     * Sets display unreachable hosts.
     *
     * @param displayUnreachableHosts the display unreachable hosts
     */
    public void withDisplayUnreachableHosts( String displayUnreachableHosts ) {
        this.displayUnreachableHosts = displayUnreachableHosts;
    }


    /**
     * Sets dont use ntlmv 1.
     *
     * @param dontUseNtlmv1 the dont use ntlmv 1
     */
    public void withDontUseNtlmv1( String dontUseNtlmv1 ) {
        this.dontUseNtlmv1 = dontUseNtlmv1;
    }


    /**
     * Sets enable admin shares.
     *
     * @param enableAdminShares the enable admin shares
     */
    public void withEnableAdminShares( String enableAdminShares ) {
        this.enableAdminShares = enableAdminShares;
    }


    /**
     * Sets enum domain users end uid.
     *
     * @param enumDomainUsersEndUid the enum domain users end uid
     */
    public void withEnumDomainUsersEndUid( String enumDomainUsersEndUid ) {
        this.enumDomainUsersEndUid = enumDomainUsersEndUid;
    }


    /**
     * Sets enum domain users start uid.
     *
     * @param enumDomainUsersStartUid the enum domain users start uid
     */
    public void withEnumDomainUsersStartUid( String enumDomainUsersStartUid ) {
        this.enumDomainUsersStartUid = enumDomainUsersStartUid;
    }


    /**
     * Sets enum local users end uid.
     *
     * @param enumLocalUsersEndUid the enum local users end uid
     */
    public void withEnumLocalUsersEndUid( String enumLocalUsersEndUid ) {
        this.enumLocalUsersEndUid = enumLocalUsersEndUid;
    }


    /**
     * Sets enum local users start uid.
     *
     * @param enumLocalUsersStartUid the enum local users start uid
     */
    public void withEnumLocalUsersStartUid( String enumLocalUsersStartUid ) {
        this.enumLocalUsersStartUid = enumLocalUsersStartUid;
    }


    /**
     * Sets enumerate all ciphers.
     *
     * @param enumerateAllCiphers the enumerate all ciphers
     */
    public void withEnumerateAllCiphers( String enumerateAllCiphers ) {
        this.enumerateAllCiphers = enumerateAllCiphers;
    }


    /**
     * Sets extremeos offline configs.
     *
     * @param extremeosOfflineConfigs the extremeos offline configs
     */
    public void withExtremeosOfflineConfigs( String extremeosOfflineConfigs ) {
        this.extremeosOfflineConfigs = extremeosOfflineConfigs;
    }


    /**
     * Sets fast network discovery.
     *
     * @param fastNetworkDiscovery the fast network discovery
     */
    public void withFastNetworkDiscovery( String fastNetworkDiscovery ) {
        this.fastNetworkDiscovery = fastNetworkDiscovery;
    }


    /**
     * Sets fireeye offline configs.
     *
     * @param fireeyeOfflineConfigs the fireeye offline configs
     */
    public void withFireeyeOfflineConfigs( String fireeyeOfflineConfigs ) {
        this.fireeyeOfflineConfigs = fireeyeOfflineConfigs;
    }


    /**
     * Sets host whitelist.
     *
     * @param hostWhitelist the host whitelist
     */
    public void withHostWhitelist( String hostWhitelist ) {
        this.hostWhitelist = hostWhitelist;
    }


    /**
     * Sets http login auth regex nocase.
     *
     * @param httpLoginAuthRegexNocase the http login auth regex nocase
     */
    public void withHttpLoginAuthRegexNocase( String httpLoginAuthRegexNocase ) {
        this.httpLoginAuthRegexNocase = httpLoginAuthRegexNocase;
    }


    /**
     * Sets http login auth regex on headers.
     *
     * @param httpLoginAuthRegexOnHeaders the http login auth regex on headers
     */
    public void withHttpLoginAuthRegexOnHeaders( String httpLoginAuthRegexOnHeaders ) {
        this.httpLoginAuthRegexOnHeaders = httpLoginAuthRegexOnHeaders;
    }


    /**
     * Sets http login invert auth regex.
     *
     * @param httpLoginInvertAuthRegex the http login invert auth regex
     */
    public void withHttpLoginInvertAuthRegex( String httpLoginInvertAuthRegex ) {
        this.httpLoginInvertAuthRegex = httpLoginInvertAuthRegex;
    }


    /**
     * Sets http login max redir.
     *
     * @param httpLoginMaxRedir the http login max redir
     */
    public void withHttpLoginMaxRedir( String httpLoginMaxRedir ) {
        this.httpLoginMaxRedir = httpLoginMaxRedir;
    }


    /**
     * Sets http login method.
     *
     * @param httpLoginMethod the http login method
     */
    public void withHttpLoginMethod( String httpLoginMethod ) {
        this.httpLoginMethod = httpLoginMethod;
    }


    /**
     * Sets huawei offline configs.
     *
     * @param huaweiOfflineConfigs the huawei offline configs
     */
    public void withHuaweiOfflineConfigs( String huaweiOfflineConfigs ) {
        this.huaweiOfflineConfigs = huaweiOfflineConfigs;
    }


    /**
     * Sets icmp ping.
     *
     * @param icmpPing the icmp ping
     */
    public void withIcmpPing( String icmpPing ) {
        this.icmpPing = icmpPing;
    }


    /**
     * Sets icmp ping retries.
     *
     * @param icmpPingRetries the icmp ping retries
     */
    public void withIcmpPingRetries( String icmpPingRetries ) {
        this.icmpPingRetries = icmpPingRetries;
    }


    /**
     * Sets icmp unreach means host down.
     *
     * @param icmpUnreachMeansHostDown the icmp unreach means host down
     */
    public void withIcmpUnreachMeansHostDown( String icmpUnreachMeansHostDown ) {
        this.icmpUnreachMeansHostDown = icmpUnreachMeansHostDown;
    }


    /**
     * Sets junos offline configs.
     *
     * @param junosOfflineConfigs the junos offline configs
     */
    public void withJunosOfflineConfigs( String junosOfflineConfigs ) {
        this.junosOfflineConfigs = junosOfflineConfigs;
    }


    /**
     * Sets log live hosts.
     *
     * @param logLiveHosts the log live hosts
     */
    public void withLogLiveHosts( String logLiveHosts ) {
        this.logLiveHosts = logLiveHosts;
    }


    /**
     * Sets log whole attack.
     *
     * @param logWholeAttack the log whole attack
     */
    public void withLogWholeAttack( String logWholeAttack ) {
        this.logWholeAttack = logWholeAttack;
    }


    /**
     * Sets max checks per host.
     *
     * @param maxChecksPerHost the max checks per host
     */
    public void withMaxChecksPerHost( String maxChecksPerHost ) {
        this.maxChecksPerHost = maxChecksPerHost;
    }


    /**
     * Sets max hosts per scan.
     *
     * @param maxHostsPerScan the max hosts per scan
     */
    public void withMaxHostsPerScan( String maxHostsPerScan ) {
        this.maxHostsPerScan = maxHostsPerScan;
    }


    /**
     * Sets max simult tcp sessions per host.
     *
     * @param maxSimultTcpSessionsPerHost the max simult tcp sessions per host
     */
    public void withMaxSimultTcpSessionsPerHost( String maxSimultTcpSessionsPerHost ) {
        this.maxSimultTcpSessionsPerHost = maxSimultTcpSessionsPerHost;
    }


    /**
     * Sets max simult tcp sessions per scan.
     *
     * @param maxSimultTcpSessionsPerScan the max simult tcp sessions per scan
     */
    public void withMaxSimultTcpSessionsPerScan( String maxSimultTcpSessionsPerScan ) {
        this.maxSimultTcpSessionsPerScan = maxSimultTcpSessionsPerScan;
    }


    /**
     * Sets modbus end reg.
     *
     * @param modbusEndReg the modbus end reg
     */
    public void withModbusEndReg( String modbusEndReg ) {
        this.modbusEndReg = modbusEndReg;
    }


    /**
     * Sets modbus start reg.
     *
     * @param modbusStartReg the modbus start reg
     */
    public void withModbusStartReg( String modbusStartReg ) {
        this.modbusStartReg = modbusStartReg;
    }


    /**
     * Sets name.
     *
     * @param name the name
     */
    public void withName( String name ) {
        this.name = name;
    }


    /**
     * Sets netapp offline configs.
     *
     * @param netappOfflineConfigs the netapp offline configs
     */
    public void withNetappOfflineConfigs( String netappOfflineConfigs ) {
        this.netappOfflineConfigs = netappOfflineConfigs;
    }


    /**
     * Sets network receive timeout.
     *
     * @param networkReceiveTimeout the network receive timeout
     */
    public void withNetworkReceiveTimeout( String networkReceiveTimeout ) {
        this.networkReceiveTimeout = networkReceiveTimeout;
    }


    /**
     * Sets network type.
     *
     * @param networkType the network type
     */
    public void withNetworkType( String networkType ) {
        this.networkType = networkType;
    }


    /**
     * Sets never send win creds in the clear.
     *
     * @param neverSendWinCredsInTheClear the never send win creds in the clear
     */
    public void withNeverSendWinCredsInTheClear( String neverSendWinCredsInTheClear ) {
        this.neverSendWinCredsInTheClear = neverSendWinCredsInTheClear;
    }


    /**
     * Sets only portscan if enum failed.
     *
     * @param onlyPortscanIfEnumFailed the only portscan if enum failed
     */
    public void withOnlyPortscanIfEnumFailed( String onlyPortscanIfEnumFailed ) {
        this.onlyPortscanIfEnumFailed = onlyPortscanIfEnumFailed;
    }


    /**
     * Sets patch audit over rexec.
     *
     * @param patchAuditOverRexec the patch audit over rexec
     */
    public void withPatchAuditOverRexec( String patchAuditOverRexec ) {
        this.patchAuditOverRexec = patchAuditOverRexec;
    }


    /**
     * Sets patch audit over rsh.
     *
     * @param patchAuditOverRsh the patch audit over rsh
     */
    public void withPatchAuditOverRsh( String patchAuditOverRsh ) {
        this.patchAuditOverRsh = patchAuditOverRsh;
    }


    /**
     * Sets patch audit over telnet.
     *
     * @param patchAuditOverTelnet the patch audit over telnet
     */
    public void withPatchAuditOverTelnet( String patchAuditOverTelnet ) {
        this.patchAuditOverTelnet = patchAuditOverTelnet;
    }


    /**
     * Sets ping the remote host.
     *
     * @param pingTheRemoteHost the ping the remote host
     */
    public void withPingTheRemoteHost( String pingTheRemoteHost ) {
        this.pingTheRemoteHost = pingTheRemoteHost;
    }


    /**
     * Sets portscan range.
     *
     * @param portscanRange the portscan range
     */
    public void withPortscanRange( String portscanRange ) {
        this.portscanRange = portscanRange;
    }


    /**
     * Sets procurve config to audit.
     *
     * @param procurveConfigToAudit the procurve config to audit
     */
    public void withProcurveConfigToAudit( String procurveConfigToAudit ) {
        this.procurveConfigToAudit = procurveConfigToAudit;
    }


    /**
     * Sets procurve offline configs.
     *
     * @param procurveOfflineConfigs the procurve offline configs
     */
    public void withProcurveOfflineConfigs( String procurveOfflineConfigs ) {
        this.procurveOfflineConfigs = procurveOfflineConfigs;
    }


    /**
     * Sets provided creds only.
     *
     * @param providedCredsOnly the provided creds only
     */
    public void withProvidedCredsOnly( String providedCredsOnly ) {
        this.providedCredsOnly = providedCredsOnly;
    }


    /**
     * Sets reduce connections on congestion.
     *
     * @param reduceConnectionsOnCongestion the reduce connections on congestion
     */
    public void withReduceConnectionsOnCongestion( String reduceConnectionsOnCongestion ) {
        this.reduceConnectionsOnCongestion = reduceConnectionsOnCongestion;
    }


    /**
     * Sets report paranoia.
     *
     * @param reportParanoia the report paranoia
     */
    public void withReportParanoia( String reportParanoia ) {
        this.reportParanoia = reportParanoia;
    }


    /**
     * Sets report superseded patches.
     *
     * @param reportSupersededPatches the report superseded patches
     */
    public void withReportSupersededPatches( String reportSupersededPatches ) {
        this.reportSupersededPatches = reportSupersededPatches;
    }


    /**
     * Sets report verbosity.
     *
     * @param reportVerbosity the report verbosity
     */
    public void withReportVerbosity( String reportVerbosity ) {
        this.reportVerbosity = reportVerbosity;
    }


    /**
     * Sets request windows domain info.
     *
     * @param requestWindowsDomainInfo the request windows domain info
     */
    public void withRequestWindowsDomainInfo( String requestWindowsDomainInfo ) {
        this.requestWindowsDomainInfo = requestWindowsDomainInfo;
    }


    /**
     * Sets reverse lookup.
     *
     * @param reverseLookup the reverse lookup
     */
    public void withReverseLookup( String reverseLookup ) {
        this.reverseLookup = reverseLookup;
    }


    /**
     * Sets safe checks.
     *
     * @param safeChecks the safe checks
     */
    public void withSafeChecks( String safeChecks ) {
        this.safeChecks = safeChecks;
    }


    /**
     * Sets scan netware hosts.
     *
     * @param scanNetwareHosts the scan netware hosts
     */
    public void withScanNetwareHosts( String scanNetwareHosts ) {
        this.scanNetwareHosts = scanNetwareHosts;
    }


    /**
     * Sets scan network printers.
     *
     * @param scanNetworkPrinters the scan network printers
     */
    public void withScanNetworkPrinters( String scanNetworkPrinters ) {
        this.scanNetworkPrinters = scanNetworkPrinters;
    }


    /**
     * Sets scan webapps.
     *
     * @param scanWebapps the scan webapps
     */
    public void withScanWebapps( String scanWebapps ) {
        this.scanWebapps = scanWebapps;
    }


    /**
     * Sets silent dependencies.
     *
     * @param silentDependencies the silent dependencies
     */
    public void withSilentDependencies( String silentDependencies ) {
        this.silentDependencies = silentDependencies;
    }


    /**
     * Sets slice network addresses.
     *
     * @param sliceNetworkAddresses the slice network addresses
     */
    public void withSliceNetworkAddresses( String sliceNetworkAddresses ) {
        this.sliceNetworkAddresses = sliceNetworkAddresses;
    }


    /**
     * Sets smtp domain.
     *
     * @param smtpDomain the smtp domain
     */
    public void withSmtpDomain( String smtpDomain ) {
        this.smtpDomain = smtpDomain;
    }


    /**
     * Sets smtp from.
     *
     * @param smtpFrom the smtp from
     */
    public void withSmtpFrom( String smtpFrom ) {
        this.smtpFrom = smtpFrom;
    }


    /**
     * Sets smtp to.
     *
     * @param smtpTo the smtp to
     */
    public void withSmtpTo( String smtpTo ) {
        this.smtpTo = smtpTo;
    }


    /**
     * Sets snmp port.
     *
     * @param snmpPort the snmp port
     */
    public void withSnmpPort( String snmpPort ) {
        this.snmpPort = snmpPort;
    }


    /**
     * Sets snmp scanner.
     *
     * @param snmpScanner the snmp scanner
     */
    public void withSnmpScanner( String snmpScanner ) {
        this.snmpScanner = snmpScanner;
    }


    /**
     * Sets sonicos offline configs.
     *
     * @param sonicosOfflineConfigs the sonicos offline configs
     */
    public void withSonicosOfflineConfigs( String sonicosOfflineConfigs ) {
        this.sonicosOfflineConfigs = sonicosOfflineConfigs;
    }


    /**
     * Sets ssh client banner.
     *
     * @param sshClientBanner the ssh client banner
     */
    public void withSshClientBanner( String sshClientBanner ) {
        this.sshClientBanner = sshClientBanner;
    }


    /**
     * Sets ssh known hosts.
     *
     * @param sshKnownHosts the ssh known hosts
     */
    public void withSshKnownHosts( String sshKnownHosts ) {
        this.sshKnownHosts = sshKnownHosts;
    }


    /**
     * Sets ssh netstat scanner.
     *
     * @param sshNetstatScanner the ssh netstat scanner
     */
    public void withSshNetstatScanner( String sshNetstatScanner ) {
        this.sshNetstatScanner = sshNetstatScanner;
    }


    /**
     * Sets ssh port.
     *
     * @param sshPort the ssh port
     */
    public void withSshPort( String sshPort ) {
        this.sshPort = sshPort;
    }


    /**
     * Sets ssl prob ports.
     *
     * @param sslProbPorts the ssl prob ports
     */
    public void withSslProbPorts( String sslProbPorts ) {
        this.sslProbPorts = sslProbPorts;
    }


    /**
     * Sets start cotp tsap.
     *
     * @param startCotpTsap the start cotp tsap
     */
    public void withStartCotpTsap( String startCotpTsap ) {
        this.startCotpTsap = startCotpTsap;
    }


    /**
     * Sets start remote registry.
     *
     * @param startRemoteRegistry the start remote registry
     */
    public void withStartRemoteRegistry( String startRemoteRegistry ) {
        this.startRemoteRegistry = startRemoteRegistry;
    }


    /**
     * Sets stop cotp tsap.
     *
     * @param stopCotpTsap the stop cotp tsap
     */
    public void withStopCotpTsap( String stopCotpTsap ) {
        this.stopCotpTsap = stopCotpTsap;
    }


    /**
     * Sets stop scan on disconnect.
     *
     * @param stopScanOnDisconnect the stop scan on disconnect
     */
    public void withStopScanOnDisconnect( String stopScanOnDisconnect ) {
        this.stopScanOnDisconnect = stopScanOnDisconnect;
    }


    /**
     * Sets svc detection on all ports.
     *
     * @param svcDetectionOnAllPorts the svc detection on all ports
     */
    public void withSvcDetectionOnAllPorts( String svcDetectionOnAllPorts ) {
        this.svcDetectionOnAllPorts = svcDetectionOnAllPorts;
    }


    /**
     * Sets syn firewall detection.
     *
     * @param synFirewallDetection the syn firewall detection
     */
    public void withSynFirewallDetection( String synFirewallDetection ) {
        this.synFirewallDetection = synFirewallDetection;
    }


    /**
     * Sets syn scanner.
     *
     * @param synScanner the syn scanner
     */
    public void withSynScanner( String synScanner ) {
        this.synScanner = synScanner;
    }


    /**
     * Sets tcp ping.
     *
     * @param tcpPing the tcp ping
     */
    public void withTcpPing( String tcpPing ) {
        this.tcpPing = tcpPing;
    }


    /**
     * Sets tcp ping dest ports.
     *
     * @param tcpPingDestPorts the tcp ping dest ports
     */
    public void withTcpPingDestPorts( String tcpPingDestPorts ) {
        this.tcpPingDestPorts = tcpPingDestPorts;
    }


    /**
     * Sets test default oracle accounts.
     *
     * @param testDefaultOracleAccounts the test default oracle accounts
     */
    public void withTestDefaultOracleAccounts( String testDefaultOracleAccounts ) {
        this.testDefaultOracleAccounts = testDefaultOracleAccounts;
    }


    /**
     * Sets test local nessus host.
     *
     * @param testLocalNessusHost the test local nessus host
     */
    public void withTestLocalNessusHost( String testLocalNessusHost ) {
        this.testLocalNessusHost = testLocalNessusHost;
    }


    /**
     * Sets thorough tests.
     *
     * @param thoroughTests the thorough tests
     */
    public void withThoroughTests( String thoroughTests ) {
        this.thoroughTests = thoroughTests;
    }


    /**
     * Sets udp ping.
     *
     * @param udpPing the udp ping
     */
    public void withUdpPing( String udpPing ) {
        this.udpPing = udpPing;
    }


    /**
     * Sets udp scanner.
     *
     * @param udpScanner the udp scanner
     */
    public void withUdpScanner( String udpScanner ) {
        this.udpScanner = udpScanner;
    }


    /**
     * Sets unscanned closed.
     *
     * @param unscannedClosed the unscanned closed
     */
    public void withUnscannedClosed( String unscannedClosed ) {
        this.unscannedClosed = unscannedClosed;
    }


    /**
     * Sets verify open ports.
     *
     * @param verifyOpenPorts the verify open ports
     */
    public void withVerifyOpenPorts( String verifyOpenPorts ) {
        this.verifyOpenPorts = verifyOpenPorts;
    }


    /**
     * Sets win known bad hashes.
     *
     * @param winKnownBadHashes the win known bad hashes
     */
    public void withWinKnownBadHashes( String winKnownBadHashes ) {
        this.winKnownBadHashes = winKnownBadHashes;
    }


    /**
     * Sets win known good hashes.
     *
     * @param winKnownGoodHashes the win known good hashes
     */
    public void withWinKnownGoodHashes( String winKnownGoodHashes ) {
        this.winKnownGoodHashes = winKnownGoodHashes;
    }


    /**
     * Sets wmi netstat scanner.
     *
     * @param wmiNetstatScanner the wmi netstat scanner
     */
    public void withWmiNetstatScanner( String wmiNetstatScanner ) {
        this.wmiNetstatScanner = wmiNetstatScanner;
    }


    /**
     * Sets wol mac addresses.
     *
     * @param wolMacAddresses the wol mac addresses
     */
    public void withWolMacAddresses( String wolMacAddresses ) {
        this.wolMacAddresses = wolMacAddresses;
    }


    /**
     * Sets wol wait time.
     *
     * @param wolWaitTime the wol wait time
     */
    public void withWolWaitTime( String wolWaitTime ) {
        this.wolWaitTime = wolWaitTime;
    }
}
