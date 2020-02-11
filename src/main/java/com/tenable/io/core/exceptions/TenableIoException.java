package com.tenable.io.core.exceptions;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class TenableIoException extends Exception {
    private final TenableIoErrorCode errorCode;
    private int extraInfo;
    private static final long serialVersionUID = 1L;

    /**
     * Instantiates a new tenable IO exception.
     *
     * @param errorCode the error code
     */
    public TenableIoException( TenableIoErrorCode errorCode ) {
        super();
        this.errorCode = errorCode;
    }


    /**
     * Instantiates a new tenable IO exception.
     *
     * @param errorCode the error code
     * @param message   the message
     */
    public TenableIoException( TenableIoErrorCode errorCode, String message ) {
        super( message );
        this.errorCode = errorCode;
    }


    /**
     * Instantiates a new tenable IO exception.
     *
     * @param errorCode      the error code
     * @param message        the message
     * @param innerException the inner exception
     */
    public TenableIoException( TenableIoErrorCode errorCode, String message, Throwable innerException ) {
        super( message, innerException );
        this.errorCode = errorCode;
    }


    /**
     * Gets error code.
     *
     * @return the error code
     */
    public TenableIoErrorCode getErrorCode() {
        return errorCode;
    }


    /**
     * Gets extra info.
     * Used internally to add to current context
     *
     * @return the extra info
     */
    public int getExtraInfo() {
        return extraInfo;
    }


    /**
     * Sets extra info.
     * Used internally to add to current context
     *
     * @param extraInfo the extra info
     */
    public void setExtraInfo( int extraInfo ) {
        this.extraInfo = extraInfo;
    }


    /**
     * With extra info tenable IO exception.
     * Used internally to add to current context
     *
     * @param extraInfo the extra info
     * @return the tenable IO exception
     */
    public TenableIoException withExtraInfo( int extraInfo ) {
        this.extraInfo = extraInfo;
        return this;
    }
}
