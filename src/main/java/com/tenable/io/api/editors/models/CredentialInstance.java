package com.tenable.io.api.editors.models;


import java.util.List;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class CredentialInstance {
    private int id;
    private List<Input> inputs;
    private String summary;


    /**
     * Gets credential id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }


    /**
     * Sets credential id.
     *
     * @param id the id
     */
    public void setId( int id ) {
        this.id = id;
    }


    /**
     * Gets inputs.
     *
     * @return the inputs
     */
    public List<Input> getInputs() {
        return inputs;
    }


    /**
     * Sets inputs.
     *
     * @param inputs the inputs
     */
    public void setInputs( List<Input> inputs ) {
        this.inputs = inputs;
    }


    /**
     * Gets summary.
     *
     * @return the summary
     */
    public String getSummary() {
        return summary;
    }


    /**
     * Sets summary.
     *
     * @param summary the summary
     */
    public void setSummary( String summary ) {
        this.summary = summary;
    }
}
