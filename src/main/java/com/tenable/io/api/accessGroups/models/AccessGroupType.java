package com.tenable.io.api.accessGroups.models;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Copyright (c) 2019 Tenable Network Security, Inc.
 */
public enum AccessGroupType {
    /**
     * MANAGE_ASSETS - The access group applies only to existing assets.
     */
    MANAGE_ASSETS("MANAGE_ASSETS"),
    /**
     * SCAN_TARGETS - The access group restricts which targets can be specified in a scan and is not limited to existing assets.
     */
    SCAN_TARGETS("SCAN_TARGETS"),
    /**
     * ALL - All assets (only applies to the default group).
     */
    ALL("ALL");

    private final String value;


    AccessGroupType( String value ) {
        this.value = value;
    }

    /**
     * Gets AccessGroupType value
     *
     * @return the value
     */
    @JsonValue
    public String getValue() {
        return value;
    }
}
