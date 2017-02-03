package com.tenable.io.api.editors.models;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class FilterControl {
    private String type;
    private String readableRegex;
    private String regex;
    private List<String> options;
    private List<FilterControlListItem> list;


    /**
     * Gets readable regex.
     *
     * @return the readable regex
     */
    @JsonProperty( "readable_regex" )
    public String getReadableRegex() {
        return readableRegex;
    }


    /**
     * Sets readable regex.
     *
     * @param readableRegex the readable regex
     */
    @JsonProperty( "readable_regex" )
    public void setReadableRegex( String readableRegex ) {
        this.readableRegex = readableRegex;
    }


    /**
     * Gets list.
     *
     * @return the list
     */
    public List<FilterControlListItem> getList() {
        return list;
    }


    /**
     * Sets list.
     *
     * @param list the list
     */
    public void setList( List<FilterControlListItem> list ) {
        this.list = list;
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
     * Gets regex.
     *
     * @return the regex
     */
    public String getRegex() {
        return regex;
    }


    /**
     * Sets regex.
     *
     * @param regex the regex
     */
    public void setRegex( String regex ) {
        this.regex = regex;
    }


    /**
     * Gets options.
     *
     * @return the options
     */
    public List<String> getOptions() {
        return options;
    }


    /**
     * Sets options.
     *
     * @param options the options
     */
    public void setOptions( List<String> options ) {
        this.options = options;
    }
}
