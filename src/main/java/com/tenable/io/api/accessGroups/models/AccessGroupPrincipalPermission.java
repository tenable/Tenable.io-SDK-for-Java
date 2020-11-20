package com.tenable.io.api.accessGroups.models;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Copyright (c) 2019 Tenable Network Security, Inc.
 */
public enum AccessGroupPrincipalPermission {
    /**
     * CAN_VIEW - Users assigned this permission can view specific assets and related vulnerabilities in aggregated scan result views.
     */
    CAN_VIEW("CAN_VIEW"),
    /**
     * CAN_SCAN - Users assigned this permission can run scans against specific targets and view individual scan results for the targets.
     */
    CAN_SCAN("CAN_SCAN");

    private final String value;


    AccessGroupPrincipalPermission( String value ) {
        this.value = value;
    }

    /**
     * Gets AccessGroupPrincipalPermission value
     *
     * @return the value
     */
    @JsonValue
    public String getValue() {
        return value;
    }
}
