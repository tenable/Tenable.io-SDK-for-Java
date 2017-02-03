package com.tenable.io.api.policies.models;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class PolicyAudits {
    private PolicyAuditFeed feed;


    /**
     * Gets the policy audit feed.
     *
     * @return the policy audit feed
     */
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
}
