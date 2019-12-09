package com.tenable.io.api.accessGroups.models;


import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Copyright (c) 2018 Tenable Network Security, Inc.
 */
public class AccessGroupRequest {
    private String name;
    private boolean allAssets = false;
    private boolean allUsers = false;
    private AssetRule[] rules;
    private AssetRulePrincipal[] principals;
    private AccessGroupType accessGroupType;


    /**
     * Gets the name of access group.
     *
     * @return the name of access group.
     */
    public String getName() {
        return name;
    }


    /**
     * Sets the name of access group.
     *
     * @param name the name of access group.
     */
    public void setName( String name ) {
        this.name = name;
    }

    /**
     * Sets the name of access group.
     *
     * @param name the name of access group.
     */
    public AccessGroupRequest withName( String name ) {
        this.name = name;
        return this;
    }


    /**
     * Gets whether access group is system-provided All Assets.
     *
     * @return whether access group is system-provided All Assets.
     */
    @JsonProperty( "all_assets" )
    public boolean isAllAssets() {
        return allAssets;
    }


    /**
     * Sets whether access group is system-provided All Assets.
     *
     * @param allAssets whether access group is system-provided All Assets.
     */
    @JsonProperty( "all_assets" )
    public void setAllAssets( boolean allAssets ) {
        this.allAssets = allAssets;
    }


    /**
     * Sets whether access group is system-provided All Assets.
     *
     * @param allAssets whether access group is system-provided All Assets.
     */
    public AccessGroupRequest withAllAssets( boolean allAssets ) {
        this.allAssets = allAssets;
        return this;
    }


    /**
     * Gets whether access group can be viewed by all.
     *
     * @return whether access group can be viewed by all.
     */
    @JsonProperty( "all_users" )
    public boolean isAllUsers() {
        return allUsers;
    }


    /**
     * Sets whether access group can be viewed by all.
     *
     * @param allUsers whether access group can be viewed by all.
     */
    @JsonProperty( "all_users" )
    public void setAllUsers( boolean allUsers ) {
        this.allUsers = allUsers;
    }


    /**
     * Sets whether access group can be viewed by all.
     *
     * @param allUsers whether access group can be viewed by all.
     */
    public AccessGroupRequest withAllUsers( boolean allUsers ) {
        this.allUsers = allUsers;
        return this;
    }


    /**
     * Gets the array of access rules.
     *
     * @return the array of access rules.
     */
    public AssetRule[] getRules() {
        return rules;
    }


    /**
     * Sets the array of access rules.
     *
     * @param rules the array of access rules.
     */
    public void setRules( AssetRule[] rules ) {
        this.rules = rules;
    }


    /**
     * Sets the array of access rules.
     *
     * @param rules the array of access rules.
     */
    public AccessGroupRequest withRules( AssetRule[] rules ) {
        this.rules = rules;
        return this;
    }


    /**
     * Gets the array of principals.
     *
     * @return the array of principals.
     */
    public AssetRulePrincipal[] getPrincipals() {
        return principals;
    }


    /**
     * Sets the array of principals.
     *
     * @param principals the array of principals.
     */
    public void setPrincipals( AssetRulePrincipal[] principals ) {
        this.principals = principals;
    }


    /**
     * Sets the array of principals.
     *
     * @param principals the array of principals.
     */
    public AccessGroupRequest withPrincipals( AssetRulePrincipal[] principals ) {
        this.principals = principals;
        return this;
    }


    /**
     * Gets the access group type.
     *
     * @return the access group type.
     */
    public AccessGroupType getAccessGroupType() {
        return accessGroupType;
    }


    /**
     * Sets the access group type.
     *
     * @param accessGroupType the access group type.
     */
    @JsonProperty( "access_group_type" )
    public void setAccessGroupType( AccessGroupType accessGroupType ) {
        this.accessGroupType = accessGroupType;
    }


    /**
     * Sets the access group type.
     *
     * @param accessGroupType the access group type.
     */
    public AccessGroupRequest withAccessGroupType( AccessGroupType accessGroupType ) {
        this.accessGroupType = accessGroupType;
        return this;
    }
}
