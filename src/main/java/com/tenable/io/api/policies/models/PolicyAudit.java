package com.tenable.io.api.policies.models;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class PolicyAudit {
    private String id;
    private Map<String, String> variables;


    /**
     * Gets the audit id.
     *
     * @return the audit id
     */
    public String getId() {
        return id;
    }


    /**
     * Sets the audit id.
     *
     * @param id the audit id
     */
    public void setId( String id ) {
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


    /**
     * Add variable.
     *
     * @param name  the variable name
     * @param value the variable value
     */
    public void addVariable( String name, String value ) {
        if( variables == null ) {
            variables = new HashMap<>();
        }

        variables.put( name, value );
    }
}
