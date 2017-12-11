package com.tenable.io.api.agents.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class AgentFilter {
    private List<String> operators;
    private InputControl control;
    private String name;
    private String readableName;

    /**
     * Gets operators.
     *
     * @return the operators
     */
    public List<String> getOperators() { return operators; };

    /**
     * Sets operators.
     *
     * @param operators the operators
     */
    public void setOperators( List<String> operators ) { this.operators = operators; }

    /**
     * Gets control.
     *
     * @return the control
     */
    public InputControl getControl() { return control; }

    /**
     * Sets control.
     *
     * @param control the control
     */
    public void setControl( InputControl control ) { this.control = control; }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() { return name; }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName( String name ) { this.name = name; }

    /**
     * Gets readable name.
     *
     * @return the readable name
     */
    @JsonProperty( "readable_name" )
    public String getReadableName() { return readableName; }

    /**
     * Sets readable name.
     *
     * @param readableName the readable name
     */
    @JsonProperty( "readable_name" )
    public void setReadableName( String readableName ) { this.readableName = readableName; }

}
