package com.tenable.io.api.policies.models;


import com.fasterxml.jackson.annotation.JsonInclude;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class PolicyAudits {
    private PolicyAuditFeed feed;
    private PolicyAuditCustomFeed custom;


    /**
     * Gets the policy audit feed.
     *
     * @return the policy audit feed
     */
    @JsonInclude( JsonInclude.Include.NON_NULL )
    public PolicyAuditFeed getFeed() {
        return feed;
    }


    /**
     * Sets the policy audit feed.
     *
     * @param feed the policy audit feed
     */
    public void setFeed( PolicyAuditFeed feed ) {
        this.feed = feed;
    }


    /**
     * Gets custom feed.
     *
     * @return the custom feed
     */
    @JsonInclude( JsonInclude.Include.NON_NULL )
    public PolicyAuditCustomFeed getCustom() {
        return custom;
    }


    /**
     * Sets custom feed.
     *
     * @param custom the custom feed
     */
    public void setCustom( PolicyAuditCustomFeed custom ) {
        this.custom = custom;
    }
}
