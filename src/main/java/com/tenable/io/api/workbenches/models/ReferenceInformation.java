package com.tenable.io.api.workbenches.models;


import java.util.List;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class ReferenceInformation {
    /**
     * The list of references
     */
    List<Reference> ref;


    /**
     * Gets list of references
     *
     * @return list of references
     */
    public List<Reference> getRef() {
        return ref;
    }


    /**
     * Sets the list of references.
     *
     * @param ref list of references
     */
    public void setRef( List<Reference> ref ) {
        this.ref = ref;
    }
}
