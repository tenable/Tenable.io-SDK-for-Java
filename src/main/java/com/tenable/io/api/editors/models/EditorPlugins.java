package com.tenable.io.api.editors.models;


import java.util.Map;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class EditorPlugins {
    private Map<String, Family> families;


    /**
     * Gets families.
     *
     * @return the families
     */
    public Map<String, Family> getFamilies() {
        return families;
    }


    /**
     * Sets families.
     *
     * @param families the families
     */
    public void setFamilies( Map<String, Family> families ) {
        this.families = families;
    }
}
