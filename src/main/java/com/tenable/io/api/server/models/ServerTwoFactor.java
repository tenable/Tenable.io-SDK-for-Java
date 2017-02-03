package com.tenable.io.api.server.models;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class ServerTwoFactor {
    private boolean smtp;
    private boolean twilio;


    /**
     * Is smtp boolean.
     *
     * @return the boolean
     */
    public boolean isSmtp() {
        return smtp;
    }


    /**
     * Sets smtp.
     *
     * @param smtp the smtp
     */
    public void setSmtp( boolean smtp ) {
        this.smtp = smtp;
    }


    /**
     * Is twilio boolean.
     *
     * @return the boolean
     */
    public boolean isTwilio() {
        return twilio;
    }


    /**
     * Sets twilio.
     *
     * @param twilio the twilio
     */
    public void setTwilio( boolean twilio ) {
        this.twilio = twilio;
    }
}
