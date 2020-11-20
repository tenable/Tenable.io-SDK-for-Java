package com.tenable.io.api.accessGroups.models;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Copyright (c) 2019 Tenable Network Security, Inc.
 */
public enum AccessGroupPrincipalType {
    /**
     * user - Principal is a single users.
     */
    USER("user"),
    /**
     * group - Principal is a predetermined group of users.
     */
    GROUP("group"),
    /**
     * all_users - Principal defaults to all users in the account.
     */
    ALL_USERS("all_users");

    private final String value;


    AccessGroupPrincipalType( String value ) {
        this.value = value;
    }

    /**
     * Gets AccessGroupPrincipalType value
     *
     * @return the value
     */
    @JsonValue
    public String getValue() {
        return value;
    }
}
