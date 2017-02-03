package com.tenable.io.api.scanners.models;


import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class AWSTarget {
    private int scannerId;
    private String instanceId;
    private String privateIp;
    private String publicIp;
    private String state;
    private String zone;
    private String type;
    private String name;


    /**
     * Gets the id of the scanner.
     *
     * @return the id of the scanner.
     */
    @JsonProperty( "scanner_id" )
    public int getScannerId() {
        return scannerId;
    }


    /**
     * Sets the id of the scanner.
     *
     * @param scannerId the id of the scanner.
     */
    @JsonProperty( "scanner_id" )
    public void setScannerId( int scannerId ) {
        this.scannerId = scannerId;
    }


    /**
     * Gets unique instance identifier from Amazon.
     *
     * @return unique instance identifier from Amazon.
     */
    @JsonProperty( "instance_id" )
    public String getInstanceId() {
        return instanceId;
    }


    /**
     * Sets unique instance identifier from Amazon.
     *
     * @param instanceId unique instance identifier from Amazon.
     */
    @JsonProperty( "instance_id" )
    public void setInstanceId( String instanceId ) {
        this.instanceId = instanceId;
    }


    /**
     * Gets private IP address of the AWS instance.
     *
     * @return the private IP address of the AWS instance.
     */
    @JsonProperty( "private_ip" )
    public String getPrivateIp() {
        return privateIp;
    }


    /**
     * Sets private IP address of the AWS instance.
     *
     * @param privateIp the private IP address of the AWS instance.
     */
    @JsonProperty( "private_ip" )
    public void setPrivateIp( String privateIp ) {
        this.privateIp = privateIp;
    }


    /**
     * Gets the public IP address of the AWS instance.
     *
     * @return the public IP address of the AWS instance.
     */
    @JsonProperty( "public_ip" )
    public String getPublicIp() {
        return publicIp;
    }


    /**
     * Sets the public IP address of the AWS instance.
     *
     * @param publicIp the public IP address of the AWS instance.
     */
    @JsonProperty( "public_ip" )
    public void setPublicIp( String publicIp ) {
        this.publicIp = publicIp;
    }


    /**
     * Gets the state of the instance. Can be one of the following values: 'running', 'stopped', or 'terminated'.
     *
     * @return the state of the instance. Can be one of the following values: 'running', 'stopped', or 'terminated'.
     */
    public String getState() {
        return state;
    }


    /**
     * Sets the state of the instance. Can be one of the following values: 'running', 'stopped', or 'terminated'.
     *
     * @param state the state of the instance. Can be one of the following values: 'running', 'stopped', or 'terminated'.
     */
    public void setState( String state ) {
        this.state = state;
    }


    /**
     * Gets the availability zone for the instance. Example: 'us-east-1a', 'us-east-1b', etc...
     *
     * @return the availability zone for the instance. Example: 'us-east-1a', 'us-east-1b', etc...
     */
    public String getZone() {
        return zone;
    }


    /**
     * Sets the availability zone for the instance. Example: 'us-east-1a', 'us-east-1b', etc...
     *
     * @param zone the availability zone for the instance. Example: 'us-east-1a', 'us-east-1b', etc...
     */
    public void setZone( String zone ) {
        this.zone = zone;
    }


    /**
     * Gets the size of the instance. Example: 't2.small', 't2.medium', etc...
     *
     * @return the size of the instance. Example: 't2.small', 't2.medium', etc...
     */
    public String getType() {
        return type;
    }


    /**
     * Sets the size of the instance. Example: 't2.small', 't2.medium', etc...
     *
     * @param type the size of the instance. Example: 't2.small', 't2.medium', etc...
     */
    public void setType( String type ) {
        this.type = type;
    }


    /**
     * Gets the user-defined name of the instance.
     *
     * @return the user-defined name of the instance.
     */
    public String getName() {
        return name;
    }


    /**
     * Sets the user-defined name of the instance.
     *
     * @param name the user-defined name of the instance.
     */
    public void setName( String name ) {
        this.name = name;
    }
}
