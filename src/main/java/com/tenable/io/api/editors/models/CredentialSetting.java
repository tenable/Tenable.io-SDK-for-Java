package com.tenable.io.api.editors.models;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class CredentialSetting {
    private SettingsDetail authentication;


    /**
     * Gets authentication.
     *
     * @return the authentication
     */
    public SettingsDetail getAuthentication() {
        return authentication;
    }


    /**
     * Sets authentication.
     *
     * @param authentication the authentication
     */
    public void setAuthentication( SettingsDetail authentication ) {
        this.authentication = authentication;
    }
}
