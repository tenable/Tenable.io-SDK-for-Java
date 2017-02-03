package com.tenable.io.api.editors.models;


import java.util.List;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class Audit {
    private String name;
    private List<AuditDetail> audits;


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
    public void setName( String name ) {
        this.name = name;
    }


    /**
     * Gets audits.
     *
     * @return the audits
     */
    public List<AuditDetail> getAudits() {
        return audits;
    }


    /**
     * Sets audits.
     *
     * @param audits the audits
     */
    public void setAudits( List<AuditDetail> audits ) {
        this.audits = audits;
    }
}
