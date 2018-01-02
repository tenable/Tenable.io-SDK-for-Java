package com.tenable.io.api.assetImport.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Calendar;
import java.util.List;

/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class Asset {
    private String id;
    private boolean hasAgent;
    private Calendar lastSeen;
    private List<String> ipv4;
    private List<String> ipv6;
    private List<String> fqdn;
    private List<String> netbiosName;
    private List<String> operatingSystem;
    private List<String> biosUuid;
    private List<String> hostname;
    private List<String> sshFingerprint;
    private List<String> macAddress;
    private List<String> tenableUuid;
    private List<String> awsOwnerId;
    private List<String> awsEc2InstanceType;
    private List<String> awsEc2InstanceGroupName;
    private List<String> awsRegion;
    private List<String> awsEc2Name;
    private List<String> awsEc2InstanceStateName;
    private List<String> awsSubnetId;
    private List<String> awsEc2InstanceId;
    private List<String> awsAvailabilityZone;
    private List<String> awsEc2InstanceAmiId;
    private List<String> awsEc2ProductCode;
    private List<String> awsVpcId;
    private List<String> systemType;
    private List<Source> sources;
    private String updatedAt;
    private Calendar lastAuthenticatedScanDate;
    private Calendar firstSeen;
    private Calendar lastLicensedScanDate;
    private String createdAt;


    /**
     * Gets has agent.
     *
     * @return the has agent
     */
    @JsonProperty( "has_agent" )
    public boolean getHasAgent() { return hasAgent; }


    /**
     * Sets has agent.
     *
     * @param hasAgent the has agent
     */
    @JsonProperty( "has_agent" )
    public void setHasAgent( boolean hasAgent ) { this.hasAgent = hasAgent; }


    /**
     * Gets bios uuid.
     *
     * @return the bios uuid
     */
    @JsonProperty( "bios_uuid" )
    public List<String> getBiosUuid() { return biosUuid; }


    /**
     * Sets bios uuid.
     *
     * @param biosUuid the bios uuid
     */
    @JsonProperty( "bios_uuid" )
    public void setBiosUuid( List<String> biosUuid ) { this.biosUuid = biosUuid; }


    /**
     * Gets hostname.
     *
     * @return the hostname
     */
    public List<String> getHostname() { return hostname; }


    /**
     * Sets hostname.
     *
     * @param hostname the hostname
     */
    public void setHostname( List<String> hostname ) { this.hostname = hostname; }


    /**
     * Gets ssh fingerprint.
     *
     * @return the ssh fingerprint
     */
    @JsonProperty( "ssh_fingerprint" )
    public List<String> getSshFingerprint() { return sshFingerprint; }


    /**
     * Sets ssh fingerprint.
     *
     * @param sshFingerprint the ssh fingerprint
     */
    @JsonProperty( "ssh_fingerprint" )
    public void setSshFingerprint( List<String> sshFingerprint ) { this.sshFingerprint = sshFingerprint; }


    /**
     * Gets mac address.
     *
     * @return the mac address
     */
    @JsonProperty( "mac_address" )
    public List<String> getMacAddress() { return macAddress; }


    /**
     * Sets mac address.
     *
     * @param macAddress the mac address
     */
    @JsonProperty( "mac_address" )
    public void setMacAddress( List<String> macAddress ) { this.macAddress = macAddress; }


    /**
     * Gets netbios name.
     *
     * @return the netbios name
     */
    @JsonProperty( "netbios_name" )
    public List<String> getNetbiosName() { return netbiosName; }


    /**
     * Sets netbios name.
     *
     * @param netbiosName the netbios name
     */
    @JsonProperty( "netbios_name" )
    public void setNetbiosName( List<String> netbiosName ) { this.netbiosName = netbiosName; }


    /**
     * Gets tenable uuid.
     *
     * @return the tenable uuid
     */
    @JsonProperty( "tenable_uuid" )
    public List<String> getTenableUuid() { return tenableUuid; }


    /**
     * Sets tenable uuid.
     *
     * @param tenableUuid the tenable uuid
     */
    @JsonProperty( "tenable_uuid" )
    public void setTenableUuid( List<String> tenableUuid ) { this.tenableUuid = tenableUuid; }


    /**
     * Gets aws owner id.
     *
     * @return the aws owner id
     */
    @JsonProperty( "aws_owner_id" )
    public List<String> getAwsOwnerId() { return awsOwnerId; }


    /**
     * Sets aws owner id.
     *
     * @param awsOwnerId the aws owner id
     */
    @JsonProperty( "aws_owner_id" )
    public void setAwsOwnerId( List<String> awsOwnerId ) { this.awsOwnerId = awsOwnerId; }


    /**
     * Gets aws ec 2 instance type.
     *
     * @return the aws ec 2 instance type
     */
    @JsonProperty( "aws_ec2_instance_type" )
    public List<String> getAwsEc2InstanceType() { return awsEc2InstanceType; }


    /**
     * Sets aws ec 2 instance type.
     *
     * @param awsEc2InstanceType the aws ec 2 instance type
     */
    @JsonProperty( "aws_ec2_instance_type" )
    public void setAwsEc2InstanceType( List<String> awsEc2InstanceType ) { this.awsEc2InstanceType = awsEc2InstanceType; }


    /**
     * Gets aws ec 2 instance group name.
     *
     * @return the aws ec 2 instance group name
     */
    @JsonProperty( "aws_ec2_instance_group_name" )
    public List<String> getAwsEc2InstanceGroupName() { return awsEc2InstanceGroupName; }


    /**
     * Sets aws ec 2 instance group name.
     *
     * @param awsEc2InstanceGroupName the aws ec 2 instance group name
     */
    @JsonProperty( "aws_ec2_instance_group_name" )
    public void setAwsEc2InstanceGroupName( List<String> awsEc2InstanceGroupName ) { this.awsEc2InstanceGroupName = awsEc2InstanceGroupName; }


    /**
     * Gets aws region.
     *
     * @return the aws region
     */
    @JsonProperty( "aws_region" )
    public List<String> getAwsRegion() { return awsRegion; }


    /**
     * Sets aws region.
     *
     * @param awsRegion the aws region
     */
    @JsonProperty( "aws_region" )
    public void setAwsRegion( List<String> awsRegion ) { this.awsRegion = awsRegion; }


    /**
     * Gets aws ec 2 name.
     *
     * @return the aws ec 2 name
     */
    @JsonProperty( "aws_ec2_name" )
    public List<String> getAwsEc2Name() { return awsEc2Name; }


    /**
     * Sets aws ec 2 name.
     *
     * @param awsEc2Name the aws ec 2 name
     */
    @JsonProperty( "aws_ec2_name" )
    public void setAwsEc2Name( List<String> awsEc2Name ) { this.awsEc2Name = awsEc2Name; }


    /**
     * Gets aws ec 2 instance state name.
     *
     * @return the aws ec 2 instance state name
     */
    @JsonProperty( "aws_ec2_instance_state_name" )
    public List<String> getAwsEc2InstanceStateName() { return awsEc2InstanceStateName; }


    /**
     * Sets aws ec 2 instance state name.
     *
     * @param awsEc2InstanceStateName the aws ec 2 instance state name
     */
    @JsonProperty( "aws_ec2_instance_state_name" )
    public void setAwsEc2InstanceStateName( List<String> awsEc2InstanceStateName ) { this.awsEc2InstanceStateName = awsEc2InstanceStateName; }


    /**
     * Gets aws subnet id.
     *
     * @return the aws subnet id
     */
    @JsonProperty( "aws_subnet_id" )
    public List<String> getAwsSubnetId() { return awsSubnetId; }


    /**
     * Sets aws subnet id.
     *
     * @param awsSubnetId the aws subnet id
     */
    @JsonProperty( "aws_subnet_id" )
    public void setAwsSubnetId( List<String> awsSubnetId ) { this.awsSubnetId = awsSubnetId; }


    /**
     * Gets aws ec 2 instance id.
     *
     * @return the aws ec 2 instance id
     */
    @JsonProperty( "aws_ec2_instance_id" )
    public List<String> getAwsEc2InstanceId() { return awsEc2InstanceId; }


    /**
     * Sets aws ec 2 instance id.
     *
     * @param awsEc2InstanceId the aws ec 2 instance id
     */
    @JsonProperty( "aws_ec2_instance_id" )
    public void setAwsEc2InstanceId( List<String> awsEc2InstanceId ) { this.awsEc2InstanceId = awsEc2InstanceId; }


    /**
     * Gets aws availability zone.
     *
     * @return the aws availability zone
     */
    @JsonProperty( "aws_availability_zone" )
    public List<String> getAwsAvailabilityZone() { return awsAvailabilityZone; }


    /**
     * Sets aws availability zone.
     *
     * @param awsAvailabilityZone the aws availability zone
     */
    @JsonProperty( "aws_availability_zone" )
    public void setAwsAvailabilityZone( List<String> awsAvailabilityZone ) { this.awsAvailabilityZone = awsAvailabilityZone; }


    /**
     * Gets aws ec 2 instance ami id.
     *
     * @return the aws ec 2 instance ami id
     */
    @JsonProperty( "aws_ec2_instance_ami_id" )
    public List<String> getAwsEc2InstanceAmiId() { return awsEc2InstanceAmiId; }


    /**
     * Sets aws ec 2 instance ami id.
     *
     * @param awsEc2InstanceAmiId the aws ec 2 instance ami id
     */
    @JsonProperty( "aws_ec2_instance_ami_id" )
    public void setAwsEc2InstanceAmiId( List<String> awsEc2InstanceAmiId ) { this.awsEc2InstanceAmiId = awsEc2InstanceAmiId; }


    /**
     * Gets aws ec 2 product code.
     *
     * @return the aws ec 2 product code
     */
    @JsonProperty( "aws_ec2_product_code" )
    public List<String> getAwsEc2ProductCode() { return awsEc2ProductCode; }


    /**
     * Sets aws ec 2 product code.
     *
     * @param awsEc2ProductCode the aws ec 2 product code
     */
    @JsonProperty( "aws_ec2_product_code" )
    public void setAwsEc2ProductCode( List<String> awsEc2ProductCode ) { this.awsEc2ProductCode = awsEc2ProductCode; }


    /**
     * Gets aws vpc id.
     *
     * @return the aws vpc id
     */
    @JsonProperty( "aws_vpc_id" )
    public List<String> getAwsVpcId() { return awsVpcId; }


    /**
     * Sets aws vpc id.
     *
     * @param awsVpcId the aws vpc id
     */
    @JsonProperty( "aws_vpc_id" )
    public void setAwsVpcId( List<String> awsVpcId ) { this.awsVpcId = awsVpcId; }


    /**
     * Gets system type.
     *
     * @return the system type
     */
    @JsonProperty( "system_type" )
    public List<String> getSystemType() { return systemType; }


    /**
     * Sets system type.
     *
     * @param systemType the system type
     */
    @JsonProperty( "system_type" )
    public void setSystemType( List<String> systemType ) { this.systemType = systemType; }


    /**
     * Gets sources.
     *
     * @return the sources
     */
    public List<Source> getSources() { return sources; }


    /**
     * Sets sources.
     *
     * @param sources the sources
     */
    public void setSources( List<Source> sources ) { this.sources = sources; }


    /**
     * Gets updated at.
     *
     * @return the updated at
     */
    @JsonProperty( "updated_at" )
    public String getUpdatedAt() { return updatedAt; }


    /**
     * Sets updated at.
     *
     * @param updatedAt the updated at
     */
    @JsonProperty( "updated_at" )
    public void setUpdatedAt( String updatedAt ) { this.updatedAt = updatedAt; }


    /**
     * Gets last authenticated scan date.
     *
     * @return the last authenticated scan date
     */
    @JsonProperty( "last_authenticated_scan_date" )
    public Calendar getLastAuthenticatedScanDate() { return lastAuthenticatedScanDate; }


    /**
     * Sets last authenticated scan date.
     *
     * @param lastAuthenticatedScanDate the last authenticated scan date
     */
    @JsonProperty( "last_authenticated_scan_date" )
    public void setLastAuthenticatedScanDate( Calendar lastAuthenticatedScanDate ) { this.lastAuthenticatedScanDate = lastAuthenticatedScanDate; }


    /**
     * Gets first seen.
     *
     * @return the first seen
     */
    @JsonProperty( "first-seen" )
    public Calendar getFirstSeen() { return firstSeen; }


    /**
     * Sets first seen.
     *
     * @param firstSeen the first seen
     */
    @JsonProperty( "first-seen" )
    public void setFirstSeen( Calendar firstSeen ) { this.firstSeen = firstSeen; }


    /**
     * Gets last licensed scan date.
     *
     * @return the last licensed scan date
     */
    @JsonProperty( "last_licensed_scan_date" )
    public Calendar getLastLicensedScanDate() { return lastLicensedScanDate; }


    /**
     * Sets last licensed scan date.
     *
     * @param lastLicensedScanDate the last licensed scan date
     */
    @JsonProperty( "last_licensed_scan_date" )
    public void setLastLicensedScanDate( Calendar lastLicensedScanDate ) { this.lastLicensedScanDate = lastLicensedScanDate; }


    /**
     * Gets created at.
     *
     * @return the created at
     */
    @JsonProperty( "created_at" )
    public String getCreatedAt() { return createdAt; }


    /**
     * Sets created at.
     *
     * @param createdAt the created at
     */
    @JsonProperty( "created_at" )
    public void setCreatedAt( String createdAt ) { this.createdAt = createdAt; }


    /**
     * Gets id.
     *
     * @return the id
     */
    public String getId() {
        return id;
    }


    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId( String id ) {
        this.id = id;
    }


    /**
     * Gets fqdn.
     *
     * @return the fqdn
     */
    public List<String> getFqdn() {
        return fqdn;
    }


    /**
     * Sets fqdn.
     *
     * @param fqdn the fqdn
     */
    public void setFqdn( List<String> fqdn ) {
        this.fqdn = fqdn;
    }


    /**
     * Gets ipv 4.
     *
     * @return the ipv 4
     */
    public List<String> getIpv4() {
        return ipv4;
    }


    /**
     * Sets ipv 4.
     *
     * @param ipv4 the ipv 4
     */
    public void setIpv4( List<String> ipv4 ) {
        this.ipv4 = ipv4;
    }


    /**
     * Gets ipv 6.
     *
     * @return the ipv 6
     */
    public List<String> getIpv6() {
        return ipv6;
    }


    /**
     * Sets ipv 6.
     *
     * @param ipv6 the ipv 6
     */
    public void setIpv6( List<String> ipv6 ) {
        this.ipv6 = ipv6;
    }


    /**
     * Gets last seen.
     *
     * @return the last seen
     */
    @JsonProperty( "last_seen" )
    public Calendar getLastSeen() {
        return lastSeen;
    }


    /**
     * Sets last seen.
     *
     * @param lastSeen the last seen
     */
    @JsonProperty( "last_seen" )
    public void setLastSeen( Calendar lastSeen ) {
        this.lastSeen = lastSeen;
    }


    /**
     * Gets operating system.
     *
     * @return the operating system
     */
    @JsonProperty( "operating_system" )
    public List<String> getOperatingSystem() {
        return operatingSystem;
    }


    /**
     * Sets operating system.
     *
     * @param operatingSystem the operating system
     */
    @JsonProperty( "operating_system" )
    public void setOperatingSystem( List<String> operatingSystem ) {
        this.operatingSystem = operatingSystem;
    }


}
