package com.tenable.io.api.tags.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AssetAssignmentUpdate {
    private String action;
    private String[] assets;
    private String[] valueUuids;

    /**
     * Gets the action to take ("add" or "remove").
     *
     * @return the action to take ("add" or "remove").
     */
    public String getAction() {
        return action;
    }


    /**
     * Sets the action to take ("add" or "remove").
     *
     * @param action the action to take ("add" or "remove").
     */
    public void setAction( String action ) {
        this.action = action;
    }


    /**
     * Sets the action to take ("add" or "remove").
     *
     * @param action the action to take ("add" or "remove").
     */
    public AssetAssignmentUpdate withAction( String action ) {
        this.action = action;
        return this;
    }


    /**
     * Gets the assets uuids to take action on.
     *
     * @return the assets uuids to take action on.
     */
    public String[] getAssets() {
        return assets;
    }


    /**
     * Sets the assets uuids to take action on.
     *
     * @param assets the assets uuids to take action on.
     */
    public void setAssets( String[] assets ) {
        this.assets = assets;
    }


    /**
     * Sets the assets uuids to take action on.
     *
     * @param assets the assets uuids to take action on.
     */
    public AssetAssignmentUpdate withAssets( String[] assets ) {
        this.assets = assets;
        return this;
    }


    /**
     * Gets the TagValues to take action on.
     *
     * @return the TagValues to take action on.
     */
    @JsonProperty( "tags" )
    public String[] getValueUuids() {
        return valueUuids;
    }


    /**
     * Sets the TagValues to take action on.
     *
     * @param valueUuids the TagValues to take action on.
     */
    @JsonProperty( "tags" )
    public void setValueUuids( String[] valueUuids ) {
        this.valueUuids = valueUuids;
    }


    /**
     * Sets the TagValues to take action on.
     *
     * @param valueUuids the Tagvalues to take action on.
     */
    public AssetAssignmentUpdate withValueUuids( String[] valueUuids ) {
        this.valueUuids = valueUuids;
        return this;
    }
}
