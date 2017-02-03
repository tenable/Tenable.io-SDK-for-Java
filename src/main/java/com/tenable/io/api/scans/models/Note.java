package com.tenable.io.api.scans.models;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class Note {
    private String title;
    private String message;
    private int severity;


    /**
     * Gets the title of the note.
     *
     * @return the title of the note.
     */
    public String getTitle() {
        return title;
    }


    /**
     * Sets the title of the note.
     *
     * @param title the title of the note.
     */
    public void setTitle( String title ) {
        this.title = title;
    }


    /**
     * Gets the specific message of the note.
     *
     * @return the specific message of the note.
     */
    public String getMessage() {
        return message;
    }


    /**
     * Sets the specific message of the note.
     *
     * @param message the specific message of the note.
     */
    public void setMessage( String message ) {
        this.message = message;
    }


    /**
     * Gets the severity of the note.
     *
     * @return The severity of the note.
     */
    public int getSeverity() {
        return severity;
    }


    /**
     * Sets the severity of the note.
     *
     * @param severity the severity of the note.
     */
    public void setSeverity( int severity ) {
        this.severity = severity;
    }
}
