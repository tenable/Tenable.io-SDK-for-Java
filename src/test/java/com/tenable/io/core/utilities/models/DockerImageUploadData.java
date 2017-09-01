package com.tenable.io.core.utilities.models;

/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class DockerImageUploadData {
    private String name;
    private String tag;
    private String id;
    private String digest;

    public DockerImageUploadData( String name, String tag, String id, String digest ) {
        this.name = name;
        this.tag = tag;
        this.id = id;
        this.digest = digest;
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
     * Gets tag.
     *
     * @return the tag
     */
    public String getTag() {
        return tag;
    }

    /**
     * Sets tag.
     *
     * @param tag the tag
     */
    public void setTag( String tag ) {
        this.tag = tag;
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
     * Gets digest.
     *
     * @return the digest
     */
    public String getDigest() {
        return digest;
    }

    /**
     * Sets digest.
     *
     * @param digest the digest
     */
    public void setDigest( String digest ) {
        this.digest = digest;
    }
}
