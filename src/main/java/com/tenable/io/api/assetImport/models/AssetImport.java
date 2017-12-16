package com.tenable.io.api.assetImport.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashSet;
import java.util.List;

/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class AssetImport {
    private List<String> ipv4;
    private List<String> ipv6;
    private List<String> fqdn;
    private String netbiosName;
    private List<String> operatingSystem;
    private String sshFingerprint;
    private List<String> macAddress;
    private String systemType;
    private String awsOwnerId;
    private String awsEc2InstanceType;
    private HashSet awsEc2InstanceGroupName;
    private String awsRegion;
    private String awsEc2Name;
    private String awsEc2InstanceStateName;
    private String awsSubnetId;
    private String awsEc2InstanceId;
    private String awsAvailabilityZone;
    private String awsEc2InstanceAmiId;
    private HashSet awsEc2ProductCode;
    private String awsVpcId;


    /**
     * Gets ssh fingerprint.
     *
     * @return the ssh fingerprint
     */
    @JsonProperty("ssh_fingerprint")
    public String getSshFingerprint() { return sshFingerprint; }


    /**
     * Sets ssh fingerprint.
     *
     * @param sshFingerprint the ssh fingerprint
     */
    @JsonProperty("ssh_fingerprint")
    public void setSshFingerprint( String sshFingerprint ) { this.sshFingerprint = sshFingerprint; }


    /**
     * Gets mac address.
     *
     * @return the mac address
     */
    @JsonProperty("mac_address")
    public List<String> getMacAddress() { return macAddress; }


    /**
     * Sets mac address.
     *
     * @param macAddress the mac address
     */
    @JsonProperty("mac_address")
    public void setMacAddress( List<String> macAddress ) { this.macAddress = macAddress; }


    /**
     * Gets netbios name.
     *
     * @return the netbios name
     */
    @JsonProperty("netbios_name")
    public String getNetbiosName() { return netbiosName; }


    /**
     * Sets netbios name.
     *
     * @param netbiosName the netbios name
     */
    @JsonProperty("netbios_name")
    public void setNetbiosName( String netbiosName ) { this.netbiosName = netbiosName; }


    /**
     * Gets system type.
     *
     * @return the system type
     */
    @JsonProperty("system_type")
    public String getSystemType() { return systemType; }


    /**
     * Sets system type.
     *
     * @param systemType the system type
     */
    @JsonProperty("system_type")
    public void setSystemType( String systemType ) { this.systemType = systemType; }


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
    public void setFqdn(List<String> fqdn) {
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
    public void setIpv4(List<String> ipv4) {
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
    public void setIpv6(List<String> ipv6) {
        this.ipv6 = ipv6;
    }


    /**
     * Gets operating system.
     *
     * @return the operating system
     */
    @JsonProperty("operating_system")
    public List<String> getOperatingSystem() {
        return operatingSystem;
    }


    /**
     * Sets operating system.
     *
     * @param operatingSystem the operating system
     */
    @JsonProperty("operating_system")
    public void setOperatingSystem(List<String> operatingSystem) {
        this.operatingSystem = operatingSystem;
    }


    /**
     * Gets aws owner id.
     *
     * @return the aws owner id
     */
    @JsonProperty("aws_owner_id")
    public String getAwsOwnerId() { return awsOwnerId; }


    /**
     * Sets aws owner id.
     *
     * @param awsOwnerId the aws owner id
     */
    @JsonProperty("aws_owner_id")
    public void setAwsOwnerId( String awsOwnerId ) { this.awsOwnerId = awsOwnerId; }


    /**
     * Gets aws ec 2 instance type.
     *
     * @return the aws ec 2 instance type
     */
    @JsonProperty("aws_ec2_instance_type")
    public String getAwsEc2InstanceType() { return awsEc2InstanceType; }


    /**
     * Sets aws ec 2 instance type.
     *
     * @param awsEc2InstanceType the aws ec 2 instance type
     */
    @JsonProperty("aws_ec2_instance_type")
    public void setAwsEc2InstanceType( String awsEc2InstanceType ) { this.awsEc2InstanceType = awsEc2InstanceType; }


    /**
     * Gets aws ec 2 instance group name.
     *
     * @return the aws ec 2 instance group name
     */
    @JsonProperty("aws_ec2_instance_group_name")
    public HashSet getAwsEc2InstanceGroupName() { return awsEc2InstanceGroupName; }


    /**
     * Sets aws ec 2 instance group name.
     *
     * @param awsEc2InstanceGroupName the aws ec 2 instance group name
     */
    @JsonProperty("aws_ec2_instance_group_name")
    public void setAwsEc2InstanceGroupName( HashSet awsEc2InstanceGroupName ) { this.awsEc2InstanceGroupName = awsEc2InstanceGroupName; }


    /**
     * Gets aws region.
     *
     * @return the aws region
     */
    @JsonProperty("aws_region")
    public String getAwsRegion() { return awsRegion; }


    /**
     * Sets aws region.
     *
     * @param awsRegion the aws region
     */
    @JsonProperty("aws_region")
    public void setAwsRegion( String awsRegion ) { this.awsRegion = awsRegion; }


    /**
     * Gets aws ec 2 name.
     *
     * @return the aws ec 2 name
     */
    @JsonProperty("aws_ec2_name")
    public String getAwsEc2Name() { return awsEc2Name; }


    /**
     * Sets aws ec 2 name.
     *
     * @param awsEc2Name the aws ec 2 name
     */
    @JsonProperty("aws_ec2_name")
    public void setAwsEc2Name( String awsEc2Name ) { this.awsEc2Name = awsEc2Name; }


    /**
     * Gets aws ec 2 instance state name.
     *
     * @return the aws ec 2 instance state name
     */
    @JsonProperty("aws_ec2_instance_state_name")
    public String getAwsEc2InstanceStateName() { return awsEc2InstanceStateName; }


    /**
     * Sets aws ec 2 instance state name.
     *
     * @param awsEc2InstanceStateName the aws ec 2 instance state name
     */
    @JsonProperty("aws_ec2_instance_state_name")
    public void setAwsEc2InstanceStateName( String awsEc2InstanceStateName ) { this.awsEc2InstanceStateName = awsEc2InstanceStateName; }


    /**
     * Gets aws subnet id.
     *
     * @return the aws subnet id
     */
    @JsonProperty("aws_subnet_id")
    public String getAwsSubnetId() { return awsSubnetId; }


    /**
     * Sets aws subnet id.
     *
     * @param awsSubnetId the aws subnet id
     */
    @JsonProperty("aws_subnet_id")
    public void setAwsSubnetId( String awsSubnetId ) { this.awsSubnetId = awsSubnetId; }


    /**
     * Gets aws ec 2 instance id.
     *
     * @return the aws ec 2 instance id
     */
    @JsonProperty("aws_ec2_instance_id")
    public String getAwsEc2InstanceId() { return awsEc2InstanceId; }


    /**
     * Sets aws ec 2 instance id.
     *
     * @param awsEc2InstanceId the aws ec 2 instance id
     */
    @JsonProperty("aws_ec2_instance_id")
    public void setAwsEc2InstanceId( String awsEc2InstanceId ) { this.awsEc2InstanceId = awsEc2InstanceId; }


    /**
     * Gets aws availability zone.
     *
     * @return the aws availability zone
     */
    @JsonProperty("aws_availability_zone")
    public String getAwsAvailabilityZone() { return awsAvailabilityZone; }


    /**
     * Sets aws availability zone.
     *
     * @param awsAvailabilityZone the aws availability zone
     */
    @JsonProperty("aws_availability_zone")
    public void setAwsAvailabilityZone( String awsAvailabilityZone ) { this.awsAvailabilityZone = awsAvailabilityZone; }


    /**
     * Gets aws ec 2 instance ami id.
     *
     * @return the aws ec 2 instance ami id
     */
    @JsonProperty("aws_ec2_instance_ami_id")
    public String getAwsEc2InstanceAmiId() { return awsEc2InstanceAmiId; }


    /**
     * Sets aws ec 2 instance ami id.
     *
     * @param awsEc2InstanceAmiId the aws ec 2 instance ami id
     */
    @JsonProperty("aws_ec2_instance_ami_id")
    public void setAwsEc2InstanceAmiId( String awsEc2InstanceAmiId ) { this.awsEc2InstanceAmiId = awsEc2InstanceAmiId; }


    /**
     * Gets aws ec 2 product code.
     *
     * @return the aws ec 2 product code
     */
    @JsonProperty("aws_ec2_product_code")
    public HashSet getAwsEc2ProductCode() { return awsEc2ProductCode; }


    /**
     * Sets aws ec 2 product code.
     *
     * @param awsEc2ProductCode the aws ec 2 product code
     */
    @JsonProperty("aws_ec2_product_code")
    public void setAwsEc2ProductCode( HashSet awsEc2ProductCode ) { this.awsEc2ProductCode = awsEc2ProductCode; }


    /**
     * Gets aws vpc id.
     *
     * @return the aws vpc id
     */
    @JsonProperty("aws_vpc_id")
    public String getAwsVpcId() { return awsVpcId; }


    /**
     * Sets aws vpc id.
     *
     * @param awsVpcId the aws vpc id
     */
    @JsonProperty("aws_vpc_id")
    public void setAwsVpcId( String awsVpcId ) { this.awsVpcId = awsVpcId; }
}
