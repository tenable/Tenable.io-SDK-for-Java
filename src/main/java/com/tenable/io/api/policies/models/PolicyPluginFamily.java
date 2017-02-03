package com.tenable.io.api.policies.models;


import java.util.Map;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class PolicyPluginFamily {
    private String status;
    private Map<String, String> individual;


    /**
     * Gets status.
     *
     * @return the status
     */
    public String getStatus() {
        return status;
    }


    /**
     * Sets status.
     *
     * @param status the status
     */
    public void setStatus( String status ) {
        this.status = status;
    }


    /**
     * Gets individual plugins.
     *
     * @return the individual plugins
     */
    public Map<String, String> getIndividual() {
        return individual;
    }


    /**
     * Sets individual plugins.
     *
     * @param individual the individual plugins
     */
    public void setIndividual( Map<String, String> individual ) {
        this.individual = individual;
    }
}
