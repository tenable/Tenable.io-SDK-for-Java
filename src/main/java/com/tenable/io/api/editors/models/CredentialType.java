package com.tenable.io.api.editors.models;


import java.util.List;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class CredentialType {
    private String name;
    private int max;
    private List<Input> inputs;
    private List<CredentialInstance> instances;
    private CredentialSetting settings;


    /**
     * Gets credential name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }


    /**
     * Sets credential name.
     *
     * @param name the name
     */
    public void setName( String name ) {
        this.name = name;
    }


    /**
     * Gets max.
     *
     * @return the max
     */
    public int getMax() {
        return max;
    }


    /**
     * Sets max.
     *
     * @param max the max
     */
    public void setMax( int max ) {
        this.max = max;
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
     * Gets instances.
     *
     * @return the instances
     */
    public List<CredentialInstance> getInstances() {
        return instances;
    }


    /**
     * Sets instances.
     *
     * @param instances the instances
     */
    public void setInstances( List<CredentialInstance> instances ) {
        this.instances = instances;
    }


    /**
     * Gets settings.
     *
     * @return the settings
     */
    public CredentialSetting getSettings() {
        return settings;
    }


    /**
     * Sets settings.
     *
     * @param settings the settings
     */
    public void setSettings( CredentialSetting settings ) {
        this.settings = settings;
    }
}
