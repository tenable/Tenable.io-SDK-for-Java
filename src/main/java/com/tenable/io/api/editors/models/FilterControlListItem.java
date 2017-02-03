package com.tenable.io.api.editors.models;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class FilterControlListItem {
    private String name;

    /**
     * Instantiates a new Filter control list item.
     *
     */
    public FilterControlListItem() {
    }

    /**
     * Instantiates a new Filter control list item.
     *
     * @param value the value
     */
    public FilterControlListItem(String value) {
        name = value;
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
    public void setName(String name) {
        this.name = name;
    }

}
