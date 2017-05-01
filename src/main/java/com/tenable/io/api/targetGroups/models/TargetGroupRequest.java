package com.tenable.io.api.targetGroups.models;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.tenable.io.api.permissions.models.Permission;

import java.util.List;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
@JsonInclude( JsonInclude.Include.NON_DEFAULT )
public class TargetGroupRequest {
    private String name;
    private String members;
    private String type;
    private List<Permission> acls;


    /**
     * The name of the TargetGroup.
     *
     * @return The name of the TargetGroup.
     */
    public String getName() {
        return name;
    }


    /**
     * The name of the TargetGroup.
     *
     * @param name The name of the TargetGroup.
     */
    public void setName( String name ) {
        this.name = name;
    }


    /**
     * The name of the TargetGroup.
     *
     * @param name The name of the TargetGroup.
     */
    public TargetGroupRequest withName( String name ) {
        this.name = name;
        return this;
    }


    /**
     * The members of the TargetGroup.
     *
     * @return The members of the TargetGroup.
     */
    public String getMembers() {
        return members;
    }


    /**
     * The members of the TargetGroup.
     *
     * @param members The members of the TargetGroup.
     */
    public void setMembers( String members ) {
        this.members = members;
    }


    /**
     * The  members of the TargetGroup.
     *
     * @param members The members of the TargetGroup.
     */
    public TargetGroupRequest withMembers( String members ) {
        this.members = members;
        return this;
    }


    /**
     * The TargetGroup type (user or system).
     *
     * @return The TargetGroup type (user or system).
     */
    public String getType() {
        return type;
    }


    /**
     * The TargetGroup type (user or system).
     *
     * @param type The TargetGroup type (user or system).
     */
    public void setType( String type ) {
        this.type = type;
    }


    /**
     * The TargetGroup type (user or system).
     *
     * @param type The TargetGroup type (user or system).
     */
    public TargetGroupRequest withType( String type ) {
        this.type = type;
        return this;
    }


    /**
     * A list containing permissions to apply to the TargetGroup.
     *
     * @return A list containing permissions to apply to the TargetGroup.
     */
    public List<Permission> getAcls() {
        return acls;
    }


    /**
     * A list containing permissions to apply to the TargetGroup.
     *
     * @param acls A list containing permissions to apply to the TargetGroup.
     */
    public void setAcls( List<Permission> acls ) {
        this.acls = acls;
    }

    /**
     * A list containing permissions to apply to the TargetGroup.
     *
     * @param acls A list containing permissions to apply to the TargetGroup.
     */
    public TargetGroupRequest withAcls( List<Permission> acls ) {
        this.acls = acls;
        return this;
    }
}
