package com.tenable.io.api.editors.models;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class Mode {
    private String id;
    private String name;
    private String desc;
    private String defaultValue;
    private String type;
    private List<Option> options;


    /**
     * Gets options.
     *
     * @return the options
     */
    public List<Option> getOptions() {
        return options;
    }


    /**
     * Sets options.
     *
     * @param options the options
     */
    public void setOptions( List<Option> options ) {
        this.options = options;
    }


    /**
     * Gets default value.
     *
     * @return the default value
     */
    @JsonProperty( "default" )
    public String getDefaultValue() {
        return defaultValue;
    }


    /**
     * Sets default value.
     *
     * @param defaultValue the default value
     */
    @JsonProperty( "default" )
    public void setDefaultValue( String defaultValue ) {
        this.defaultValue = defaultValue;
    }


    /**
     * Gets type.
     *
     * @return the type
     */
    public String getType() {
        return type;
    }


    /**
     * Sets type.
     *
     * @param type the type
     */
    public void setType( String type ) {
        this.type = type;
    }


    /**
     * Gets id.
     *
     * @return the id
     */
    public String getId() {
        return id;
    }


    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId( String id ) {
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
     * Gets desc.
     *
     * @return the desc
     */
    public String getDesc() {
        return desc;
    }


    /**
     * Sets desc.
     *
     * @param desc the desc
     */
    public void setDesc( String desc ) {
        this.desc = desc;
    }
}
