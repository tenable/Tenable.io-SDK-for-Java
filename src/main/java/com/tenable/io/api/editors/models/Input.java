package com.tenable.io.api.editors.models;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class Input {
    private String id;
    private String type;
    private String label;
    private String hint;
    private String name;
    private boolean required;
    private String defaultValue;
    private List<Option> options;


    /**
     * Gets input name.
     *
     * @return the name of the input
     */
    public String getName() {
        return name;
    }


    /**
     * Sets the name of the input.
     *
     * @param name the name of the input
     */
    public void setName( String name ) {
        this.name = name;
    }


    /**
     * Is required boolean.
     *
     * @return the boolean
     */
    public boolean isRequired() {
        return required;
    }


    /**
     * Sets required.
     *
     * @param required the required
     */
    public void setRequired( boolean required ) {
        this.required = required;
    }


    /**
     * Gets hint.
     *
     * @return the hint
     */
    public String getHint() {
        return hint;
    }


    /**
     * Sets hint.
     *
     * @param hint the hint
     */
    public void setHint( String hint ) {
        this.hint = hint;
    }


    /**
     * The unique id name for the group.
     *
     * @return The unique id name for the group.
     */
    public String getId() {
        return id;
    }


    /**
     * The unique id name for the group.
     *
     * @param id The unique id name for the group.
     */
    public void setId( String id ) {
        this.id = id;
    }


    /**
     * The type of input (entry, checkbox, file, radio).
     *
     * @return The type of input (entry, checkbox, file, radio).
     */
    public String getType() {
        return type;
    }


    /**
     * The type of input (entry, checkbox, file, radio).
     *
     * @param type The type of input (entry, checkbox, file, radio).
     */
    public void setType( String type ) {
        this.type = type;
    }


    /**
     * Gets the label for the input.
     *
     * @return The label for the input.
     */
    public String getLabel() {
        return label;
    }


    /**
     * Sets the label for the input.
     *
     * @param label The label for the input.
     */
    public void setLabel( String label ) {
        this.label = label;
    }


    /**
     * Gets the default value for the input.
     *
     * @return the default value for the input.
     */
    @JsonProperty( "default" )
    public String getDefaultValue() {
        return defaultValue;
    }


    /**
     * Sets the default value for the input.
     *
     * @param defaultValue the default value for the input.
     */
    @JsonProperty( "default" )
    public void setDefaultValue( String defaultValue ) {
        this.defaultValue = defaultValue;
    }


    /**
     * Gets the options for radio input.
     *
     * @return the options for radio input.
     */
    public List<Option> getOptions() {
        return options;
    }


    /**
     * Sets the options for radio input.
     *
     * @param options the options for radio input.
     */
    public void setOptions( List<Option> options ) {
        this.options = options;
    }
}
