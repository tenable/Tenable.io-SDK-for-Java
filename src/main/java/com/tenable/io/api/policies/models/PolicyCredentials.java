package com.tenable.io.api.policies.models;


import java.util.*;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class PolicyCredentials {
    private Map<String, Map<String, List<Map<String, String>>>> add;

    private Map<String, Map<String, String>> edit;

    private List<String> del;


    /**
     * Gets the list of credentials to delete.
     *
     * @return the list of credentials to delete
     */
    public List<String> getDel() {
        return del;
    }


    /**
     * Sets the list of credentials to delete.
     *
     * @param del the list of credentials to delete
     */
    public void setDel( List<String> del ) {
        this.del = del;
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
