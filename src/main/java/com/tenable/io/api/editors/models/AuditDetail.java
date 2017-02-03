package com.tenable.io.api.editors.models;


import java.util.List;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class AuditDetail {
    private int free;
    private String id;
    private String name;
    private String type;
    private List<Input> inputs;


    /**
     * Gets free.
     *
     * @return the free
     */
    public int getFree() {
        return free;
    }


    /**
     * Sets free.
     *
     * @param free the free
     */
    public void setFree( int free ) {
        this.free = free;
    }


    /**
     * Gets id.
     *
     * @return the id
     */
    public String getId() {
        return id;
    }


    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId( String id ) {
        this.id = id;
    }


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
}
