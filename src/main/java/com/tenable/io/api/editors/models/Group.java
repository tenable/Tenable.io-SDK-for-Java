package com.tenable.io.api.editors.models;


import java.util.List;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class Group {
    private String name;
    private String title;
    private List<Input> inputs;
    private List<Section> sections;


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
     * Gets title.
     *
     * @return the title
     */
    public String getTitle() {
        return title;
    }


    /**
     * Sets title.
     *
     * @param title the title
     */
    public void setTitle( String title ) {
        this.title = title;
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
}
