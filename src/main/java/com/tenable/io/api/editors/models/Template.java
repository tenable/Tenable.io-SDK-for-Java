package com.tenable.io.api.editors.models;


import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class Template {
    private String uuid;
    private String name;
    private String title;
    private String description;
    private boolean cloudOnly;
    private boolean subscriptionOnly;
    private boolean isAgent;
    private String moreInfo;


    /**
     * Gets uuid.
     *
     * @return the uuid
     */
    public String getUuid() {
        return uuid;
    }


    /**
     * Sets uuid.
     *
     * @param uuid the uuid
     */
    public void setUuid( String uuid ) {
        this.uuid = uuid;
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
     * Gets description.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }


    /**
     * Sets description.
     *
     * @param description the description
     */
    public void setDescription( String description ) {
        this.description = description;
    }


    /**
     * Is cloud only boolean.
     *
     * @return the boolean
     */
    @JsonProperty( "cloud_only" )
    public boolean isCloudOnly() {
        return cloudOnly;
    }


    /**
     * Sets cloud only.
     *
     * @param cloudOnly the cloud only
     */
    @JsonProperty( "cloud_only" )
    public void setCloudOnly( boolean cloudOnly ) {
        this.cloudOnly = cloudOnly;
    }


    /**
     * Is subscription only boolean.
     *
     * @return the boolean
     */
    @JsonProperty( "subscription_only" )
    public boolean isSubscriptionOnly() {
        return subscriptionOnly;
    }


    /**
     * Sets subscription only.
     *
     * @param subscriptionOnly the subscription only
     */
    @JsonProperty( "subscription_only" )
    public void setSubscriptionOnly( boolean subscriptionOnly ) {
        this.subscriptionOnly = subscriptionOnly;
    }


    /**
     * Is agent boolean.
     *
     * @return the boolean
     */
    @JsonProperty( "is_agent" )
    public boolean isAgent() {
        return isAgent;
    }


    /**
     * Sets agent.
     *
     * @param agent the agent
     */
    @JsonProperty( "is_agent" )
    public void setAgent( boolean agent ) {
        isAgent = agent;
    }


    /**
     * Gets more info.
     *
     * @return the more info
     */
    @JsonProperty( "more_info" )
    public String getMoreInfo() {
        return moreInfo;
    }


    /**
     * Sets more info.
     *
     * @param moreInfo the more info
     */
    @JsonProperty( "more_info" )
    public void setMoreInfo( String moreInfo ) {
        this.moreInfo = moreInfo;
    }
}
