package com.tenable.io.api.policies.models;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class PolicyAuditCustom {
    private String category;
    private String file;


    /**
     * Instantiates a new Policy audit custom.
     */
    public PolicyAuditCustom() {
    }


    /**
     * Instantiates a new Policy audit custom.
     *
     * @param category the category
     * @param file     the file
     */
    public PolicyAuditCustom( String category, String file ) {
        this.category = category;
        this.file = file;
    }


    /**
     * Gets category.
     *
     * @return the category
     */
    public String getCategory() {
        return category;
    }


    /**
     * Sets category. For instance "Unix"
     *
     * @param category the category
     */
    public void setCategory( String category ) {
        this.category = category;
    }


    /**
     * Gets the associated uploaded file name.
     *
     * @return the associated uploaded file name
     */
    public String getFile() {
        return file;
    }


    /**
     * Sets an uploaded file name.
     *
     * @param file an uploaded file name
     */
    public void setFile( String file ) {
        this.file = file;
    }
}
