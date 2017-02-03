package com.tenable.io.api.editors.models;


import java.util.List;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class Compliance {
    private List<Audit> data;


    /**
     * Gets data.
     *
     * @return the data
     */
    public List<Audit> getData() {
        return data;
    }


    /**
     * Sets data.
     *
     * @param data the data
     */
    public void setData( List<Audit> data ) {
        this.data = data;
    }
}
