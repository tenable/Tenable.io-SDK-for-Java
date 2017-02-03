package com.tenable.io.api.plugins.models;


import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class PluginAttribute {
    private String attributeName;
    private String attributeValue;


    /**
     * Gets attribute name.
     *
     * @return the attribute name
     */
    @JsonProperty( "attribute_name" )
    public String getAttributeName() {
        return attributeName;
    }


    /**
     * Sets attribute name.
     *
     * @param attributeName the attribute name
     */
    @JsonProperty( "attribute_name" )
    public void setAttributeName( String attributeName ) {
        this.attributeName = attributeName;
    }


    /**
     * Gets attribute value.
     *
     * @return the attribute value
     */
    @JsonProperty( "attribute_value" )
    public String getAttributeValue() {
        return attributeValue;
    }


    /**
     * Sets attribute value.
     *
     * @param attributeValue the attribute value
     */
    @JsonProperty( "attribute_value" )
    public void setAttributeValue( String attributeValue ) {
        this.attributeValue = attributeValue;
    }
}
