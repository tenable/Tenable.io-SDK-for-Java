package com.tenable.io.api.workbenches.models;


import java.util.List;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class Reference {
    private String ext;
    private String name;
    private String url;
    private List<ReferenceValue> values;


    /**
     * Gets ext.
     *
     * @return the ext
     */
    public String getExt() {
        return ext;
    }


    /**
     * Sets ext.
     *
     * @param ext the ext
     */
    public void setExt( String ext ) {
        this.ext = ext;
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
     * Gets url.
     *
     * @return the url
     */
    public String getUrl() {
        return url;
    }


    /**
     * Sets url.
     *
     * @param url the url
     */
    public void setUrl( String url ) {
        this.url = url;
    }


    /**
     * Gets values.
     *
     * @return the values
     */
    public List<ReferenceValue> getValues() {
        return values;
    }


    /**
     * Sets values.
     *
     * @param values the values
     */
    public void setValues( List<ReferenceValue> values ) {
        this.values = values;
    }
}
