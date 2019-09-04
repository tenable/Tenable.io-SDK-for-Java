package com.tenable.io.api.workbenches.models;

import java.util.List;

/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class ReferenceValue {
    private List<String> value;

    /**
     * Gets value.
     *
     * @return the values
     */
    public List<String> getValue() {
        return value;
    }


    /**
     * Sets value.
     *
     * @param value the value
     */
    public void setValues( List<String> value ) {
        this.value = value;
    }

}
