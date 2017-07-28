package com.tenable.io.api.scans.models;


import java.util.List;
import java.util.Map;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class ScanCredentials {
    private Map<String, Map<String, List<Map<String, String>>>> add;

    private Map<String, Map<String, String>> edit;

    private List<String> delete;


    /**
     * Gets the list of credentials to delete.
     *
     * @return the list of credentials to delete
     */
    public List<String> getDelete() {
        return delete;
    }


    /**
     * Sets the list of credentials to delete.
     *
     * @param delete the list of credentials to delete
     */
    public void setDelete(List<String> delete) {
        this.delete = delete;
    }


    /**
     * Gets the list of credentials to edit
     *
     * @return the list of credentials to edit
     */
    public Map<String, Map<String, String>> getEdit() {
        return edit;
    }


    /**
     * Sets the list of credentials to edit
     *
     * @param edit the list of credentials to edit
     */
    public void setEdit( Map<String, Map<String, String>> edit ) {
        this.edit = edit;
    }


    /**
     * Gets the list of credentials to add
     *
     * @return the list of credentials to add
     */
    public Map<String, Map<String, List<Map<String, String>>>> getAdd() {
        return add;
    }


    /**
     * Sets the list of credentials to add
     *
     * @param add the list of credentials to add
     */
    public void setAdd( Map<String, Map<String, List<Map<String, String>>>> add ) {
        this.add = add;
    }
}
