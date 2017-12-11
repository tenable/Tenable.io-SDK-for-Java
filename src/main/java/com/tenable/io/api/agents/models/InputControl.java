package com.tenable.io.api.agents.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.omg.CORBA.Any;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class InputControl {
    private String readableRegex;
    private String type;
    private String regex;
    private List<?> list;
    private List<String> options;

    /**
     * Sets readable regex.
     *
     * @param readableRegex the readable regex
     */
    @JsonProperty( "readable_regex" )
    public void setReadableRegex( String readableRegex ) { this.readableRegex = readableRegex; }

    /**
     * Gets readable regex.
     *
     * @return the readable regex
     */
    @JsonProperty( "readable_regex" )
    public String getReadableRegex() { return readableRegex; }

    /**
     * Sets regex.
     *
     * @param regex the regex
     */
    public void setRegex( String regex ) { this.regex = regex; }

    /**
     * Gets regex.
     *
     * @return the regex
     */
    public String getRegex() { return regex; }

    /**
     * Sets type.
     *
     * @param type the type
     */
    public void setType( String type ) { this.type = type; }

    /**
     * Gets type.
     *
     * @return the type
     */
    public String getType() { return type; }

    /**
     * Sets list.
     *
     * @param list the list
     */
    public void setList( List<?> list ) {
        ObjectMapper mapper = new ObjectMapper();

        try {
            this.list = mapper.readValue(list.toString(), new TypeReference<List<Dropdown>>() {} );
        } catch( Exception e) {
            this.list = new ArrayList<String>();
            this.list = list;
        }
    }

    /**
     * Gets list.
     *
     * @return the list
     */
    public List<?> getList() { return list; }

    private static class Dropdown {
        private String name;
        private String id;

        /**
         * Sets name.
         *
         * @param name the name
         */
        public void setName( String name ) { this.name = name; }

        /**
         * Gets name.
         *
         * @return the name
         */
        public String getName() { return name; }

        /**
         * Sets id.
         *
         * @param id the id
         */
        public void setId( String id ) { this.id = id; }

        /**
         * Gets id.
         *
         * @return the id
         */
        private String getId() { return id; }
    }
}
