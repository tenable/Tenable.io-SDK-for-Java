package com.tenable.io.core.utilities.models;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class DefaultXmlObject {
    private Map<String, String> attributes;
    private List<Object> children;
    private String name;
    private String value;


    /**
     * Gets the element name.
     *
     * @return the element name
     */
    public String getName() {
        return name;
    }


    /**
     * Sets the element name.
     *
     * @param name the element name
     */
    public void setName( String name ) {
        this.name = name;
    }


    /**
     * Gets the element value.
     *
     * @return the element value
     */
    public String getValue() {
        return value;
    }


    /**
     * Sets the element value.
     *
     * @param value the element value
     */
    public void setValue( String value ) {
        this.value = value;
    }


    /**
     * Gets attributes.
     * Note: the returned collection can be null
     *
     * @return the attributes
     */
    public Map<String, String> getAttributes() {
        return attributes;
    }


    /**
     * Sets attributes.
     *
     * @param attributes the attributes
     */
    public void setAttributes( Map<String, String> attributes ) {
        this.attributes = attributes;
    }


    /**
     * Adds an attribute to the collection.
     *
     * @param name  the attribute name
     * @param value the attribute value
     */
    public void addAttribute( String name, String value ) {
        if( attributes == null )
            attributes = new HashMap<>();

        attributes.put( name, value );
    }


    /**
     * Gets children.
     * Note: the returned collection can be null
     *
     * @return the children
     */
    public List<Object> getChildren() {
        return children;
    }


    /**
     * Sets children.
     *
     * @param children the children
     */
    public void setChildren( List<Object> children ) {
        this.children = children;
    }


    /**
     * Adds a DefaultXmlObject child to the collection.
     *
     * @param child the child to add
     */
    public void addChild( Object child ) {
        if( children == null )
            children = new ArrayList<>();

        children.add( child );
    }


    /**
     * With attributes default xml object.
     *
     * @param attributes the attributes
     * @return the default xml object
     */
    public DefaultXmlObject withAttributes( Map<String, String> attributes ) {
        this.attributes = attributes;
        return this;
    }


    /**
     * With children default xml object.
     *
     * @param children the children
     * @return the default xml object
     */
    public DefaultXmlObject withChildren( List<Object> children ) {
        this.children = children;
        return this;
    }


    /**
     * With name default xml object.
     *
     * @param name the name
     * @return the default xml object
     */
    public DefaultXmlObject withName( String name ) {
        this.name = name;
        return this;
    }


    /**
     * With value default xml object.
     *
     * @param value the value
     * @return the default xml object
     */
    public DefaultXmlObject withValue( String value ) {
        this.value = value;
        return this;
    }
}
