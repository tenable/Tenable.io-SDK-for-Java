package com.tenable.io.core.utilities;


import com.tenable.io.api.workbenches.models.nessus.Report;

import java.util.Map;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public abstract class NessusObject<T> {
    /**
     * Creates and returns an object based on the given info (provided from a START_ELEMENT node.
     *
     * @param nodeName   the node name
     * @param attributes the node attributes
     * @return an object based on the given info (provided from a START_ELEMENT node
     */
    public abstract T create( String nodeName, Map<String, String> attributes );


    /**
     * Passes a child object of the currentObject.
     *
     * @param currentObject the current object
     * @param child         the child object
     */
    public void gotChild( T currentObject, Object child ) {};


    /**
     * Passes a text value to the current objecct
     *
     * @param currentObject the current object
     * @param text          the text value
     */
    public void gotTextValue( T currentObject, String text ) {}
}
