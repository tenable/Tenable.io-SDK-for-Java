package com.tenable.io.api.editors.models;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class CredentialData {
    private int defaultExpand;
    private String name;
    private List<CredentialType> types;


    /**
     * Gets default expand.
     *
     * @return the default expand
     */
    @JsonProperty( "default_expand" )
    public int getDefaultExpand() {
        return defaultExpand;
    }


    /**
     * Sets default expand.
     *
     * @param defaultExpand the default expand
     */
    @JsonProperty( "default_expand" )
    public void setDefaultExpand( int defaultExpand ) {
        this.defaultExpand = defaultExpand;
    }


    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }


    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName( String name ) {
        this.name = name;
    }


    /**
     * Gets types.
     *
     * @return the types
     */
    public List<CredentialType> getTypes() {
        return types;
    }


    /**
     * Sets types.
     *
     * @param types the types
     */
    public void setTypes( List<CredentialType> types ) {
        this.types = types;
    }
}
