package com.tenable.io.api.assetLists.models;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.tenable.io.api.permissions.models.Permission;

import java.util.List;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
@JsonInclude( JsonInclude.Include.NON_DEFAULT )
public class AssetListRequest {
    private String name;
    private String members;
    private String type;
    private List<Permission> acls;


    /**
     * The name of the list.
     *
     * @return The name of the list.
     */
    public String getName() {
        return name;
    }


    /**
     * The name of the list.
     *
     * @param name The name of the list.
     */
    public void setName( String name ) {
        this.name = name;
    }


    /**
     * The name of the list.
     *
     * @param name The name of the list.
     */
    public AssetListRequest withName( String name ) {
        this.name = name;
        return this;
    }


    /**
     * The members of the list.
     *
     * @return The members of the list.
     */
    public String getMembers() {
        return members;
    }


    /**
     * The members of the list.
     *
     * @param members The members of the list.
     */
    public void setMembers( String members ) {
        this.members = members;
    }


    /**
     * The  members of the list.
     *
     * @param members The members of the list.
     */
    public AssetListRequest withMembers( String members ) {
        this.members = members;
        return this;
    }


    /**
     * The list type (user or system).
     *
     * @return The list type (user or system).
     */
    public String getType() {
        return type;
    }


    /**
     * The list type (user or system).
     *
     * @param type The list type (user or system).
     */
    public void setType( String type ) {
        this.type = type;
    }


    /**
     * The list type (user or system).
     *
     * @param type The list type (user or system).
     */
    public AssetListRequest withType( String type ) {
        this.type = type;
        return this;
    }


    /**
     * A list containing permissions to apply to the list.
     *
     * @return A list containing permissions to apply to the list.
     */
    public List<Permission> getAcls() {
        return acls;
    }


    /**
     * A list containing permissions to apply to the list.
     *
     * @param acls A list containing permissions to apply to the list.
     */
    public void setAcls( List<Permission> acls ) {
        this.acls = acls;
    }

    /**
     * A list containing permissions to apply to the list.
     *
     * @param acls A list containing permissions to apply to the list.
     */
    public AssetListRequest withAcls( List<Permission> acls ) {
        this.acls = acls;
        return this;
    }
}
