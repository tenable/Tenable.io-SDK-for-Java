package com.tenable.io.api.editors.models;


import java.util.List;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class Option {
    private String name;
    private String desc;
    private List<Input> inputs;
    private List<Section> sections;


    /**
     * Instantiates a new Option.
     */
    public Option() {

    }


    /**
     * Instantiates a new Option.
     *
     * @param value the value
     */
    public Option( String value ) {
        name = value;
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
     * Gets sections.
     *
     * @return the sections
     */
    public List<Section> getSections() {
        return sections;
    }


    /**
     * Sets sections.
     *
     * @param sections the sections
     */
    public void setSections( List<Section> sections ) {
        this.sections = sections;
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
     * Gets desc.
     *
     * @return the desc
     */
    public String getDesc() {
        return desc;
    }


    /**
     * Sets desc.
     *
     * @param desc the desc
     */
    public void setDesc( String desc ) {
        this.desc = desc;
    }

}
