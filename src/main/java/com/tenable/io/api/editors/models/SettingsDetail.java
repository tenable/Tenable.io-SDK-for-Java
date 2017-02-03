package com.tenable.io.api.editors.models;


import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
@JsonInclude( JsonInclude.Include.NON_DEFAULT )
public class SettingsDetail {
    private String title;
    private String desc;
    private List<Mode> modes;
    private List<Section> sections;
    private List<Group> groups;
    private List<Input> inputs;


    /**
     * Gets description.
     *
     * @return the description
     */
    public String getDesc() {
        return desc;
    }


    /**
     * Sets description.
     *
     * @param desc the description
     */
    public void setDesc( String desc ) {
        this.desc = desc;
    }


    /**
     * Gets groups.
     *
     * @return the groups
     */
    public List<Group> getGroups() {
        return groups;
    }


    /**
     * Sets groups.
     *
     * @param groups the groups
     */
    public void setGroups( List<Group> groups ) {
        this.groups = groups;
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
     * Gets modes.
     *
     * @return the modes
     */
    public List<Mode> getModes() {
        return modes;
    }


    /**
     * Sets modes.
     *
     * @param modes the modes
     */
    public void setModes( List<Mode> modes ) {
        this.modes = modes;
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
