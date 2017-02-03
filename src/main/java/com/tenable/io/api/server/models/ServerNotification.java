package com.tenable.io.api.server.models;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class ServerNotification {
    private String type;
    private String message;


    /**
     * Gets type.
     *
     * @return the type
     */
    public String getType() {
        return type;
    }


    /**
     * Sets type.
     *
     * @param type the type
     */
    public void setType( String type ) {
        this.type = type;
    }


    /**
     * Gets message.
     *
     * @return the message
     */
    public String getMessage() {
        return message;
    }


    /**
     * Sets message.
     *
     * @param message the message
     */
    public void setMessage( String message ) {
        this.message = message;
    }
}
