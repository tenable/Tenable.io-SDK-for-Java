package com.tenable.io.api.editors.models;


import java.util.List;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class Credentials {
    private List<CredentialData> data;


    /**
     * Gets credential data.
     *
     * @return the data
     */
    public List<CredentialData> getData() {
        return data;
    }


    /**
     * Sets credential data.
     *
     * @param data the data
     */
    public void setData( List<CredentialData> data ) {
        this.data = data;
    }
}
