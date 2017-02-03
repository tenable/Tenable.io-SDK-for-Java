package com.tenable.io.api.policies.models;


import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class PolicyCreateResponse {
    private int policyId;
    private String policyName;


    /**
     * Gets policy id.
     *
     * @return the policy id
     */
    @JsonProperty( "policy_id" )
    public int getPolicyId() {
        return policyId;
    }


    /**
     * Sets policy id.
     *
     * @param policyId the policy id
     */
    @JsonProperty( "policy_id" )
    public void setPolicyId( int policyId ) {
        this.policyId = policyId;
    }


    /**
     * Gets policy name.
     *
     * @return the policy name
     */
    @JsonProperty( "policy_name" )
    public String getPolicyName() {
        return policyName;
    }


    /**
     * Sets policy name.
     *
     * @param policyName the policy name
     */
    @JsonProperty( "policy_name" )
    public void setPolicyName( String policyName ) {
        this.policyName = policyName;
    }
}
