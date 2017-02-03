package com.tenable.io.api.plugins.models;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class PluginDetail {
    private int id;
    private String name;
    private String familyName;
    private List<PluginAttribute> attributes;


    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }


    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId( int id ) {
        this.id = id;
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
     * Gets family name.
     *
     * @return the family name
     */
    @JsonProperty( "family_name" )
    public String getFamilyName() {
        return familyName;
    }


    /**
     * Sets family name.
     *
     * @param familyName the family name
     */
    @JsonProperty( "family_name" )
    public void setFamilyName( String familyName ) {
        this.familyName = familyName;
    }


    /**
     * Gets attributes.
     *
     * @return the attributes
     */
    public List<PluginAttribute> getAttributes() {
        return attributes;
    }


    /**
     * Sets attributes.
     *
     * @param attributes the attributes
     */
    public void setAttributes( List<PluginAttribute> attributes ) {
        this.attributes = attributes;
    }
}
