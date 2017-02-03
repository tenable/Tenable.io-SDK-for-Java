package com.tenable.io.api.policies.models;


import java.util.Map;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class PolicyAudit {
    private int id;
    private Map<String, String> variables;


    /**
     * Gets the audit id.
     *
     * @return the audit id
     */
    public int getId() {
        return id;
    }


    /**
     * Sets the audit id.
     *
     * @param id the audit id
     */
    public void setId( int id ) {
        this.id = id;
    }


    /**
     * Gets variables.
     *
     * @return the variables
     */
    public Map<String, String> getVariables() {
        return variables;
    }


    /**
     * Sets variables.
     *
     * @param variables the variables
     */
    public void setVariables( Map<String, String> variables ) {
        this.variables = variables;
    }
}
