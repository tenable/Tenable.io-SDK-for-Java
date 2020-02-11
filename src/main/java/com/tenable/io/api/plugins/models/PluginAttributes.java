package com.tenable.io.api.plugins.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class PluginAttributes {
    private String solution;
    private String fName;
    private String synopsis;
    private String description;
    private String rhsa;
    private String alas;
    private List<String> seeAlso;
    private String pluginName;
    private String osvdb;
    private RiskInformation riskInformation;
    private PluginInformation pluginInformation;

    /**
     * Gets solution.
     *
     * @return the solution
     */
    public String getSolution() {
        return solution;
    }


    /**
     * Sets solution.
     *
     * @param solution the solution
     */
    public void setSolution( String solution ) {
        this.solution = solution;
    }


    /**
     * Gets name.
     *
     * @return the name
     */
    @JsonProperty( "fname" )
    public String getfName() {
        return fName;
    }


    /**
     * Sets name.
     *
     * @param fName the f name
     */
    @JsonProperty( "fname" )
    public void setfName( String fName ) {
        this.fName = fName;
    }


    /**
     * Gets synopsis.
     *
     * @return the synopsis
     */
    public String getSynopsis() {
        return synopsis;
    }


    /**
     * Sets synopsis.
     *
     * @param synopsis the synopsis
     */
    public void setSynopsis( String synopsis ) {
        this.synopsis = synopsis;
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
     * Gets rhsa.
     *
     * @return the rhsa
     */
    public String getRhsa() {
        return rhsa;
    }


    /**
     * Sets rhsa.
     *
     * @param rhsa the rhsa
     */
    public void setRhsa( String rhsa ) {
        this.rhsa = rhsa;
    }


    /**
     * Gets alas.
     *
     * @return the alas
     */
    public String getAlas() {
        return alas;
    }


    /**
     * Sets alas.
     *
     * @param alas the alas
     */
    public void setAlas( String alas ) {
        this.alas = alas;
    }


    /**
     * Gets see also.
     *
     * @return the see also
     */
    @JsonProperty( "see_also" )
    public List<String> getSeeAlso() {
        return seeAlso;
    }


    /**
     * Sets see also.
     *
     * @param seeAlso the see also
     */
    @JsonProperty( "see_also" )
    public void setSeeAlso( List<String> seeAlso ) {
        this.seeAlso = seeAlso;
    }


    /**
     * Gets plugin name.
     *
     * @return the plugin name
     */
    @JsonProperty( "plugin_name" )
    public String getPluginName() {
        return pluginName;
    }


    /**
     * Sets plugin name.
     *
     * @param pluginName the plugin name
     */
    @JsonProperty( "plugin_name" )
    public void setPluginName( String pluginName ) {
        this.pluginName = pluginName;
    }


    /**
     * Gets osvdb.
     *
     * @return the osvdb
     */
    public String getOsvdb() {
        return osvdb;
    }


    /**
     * Sets osvdb.
     *
     * @param osvdb the osvdb
     */
    public void setOsvdb( String osvdb ) {
        this.osvdb = osvdb;
    }


    /**
     * Gets risk information.
     *
     * @return the risk information
     */
    @JsonProperty( "risk_information" )
    public RiskInformation getRiskInformation() {
        return riskInformation;
    }


    /**
     * Sets risk information.
     *
     * @param riskInformation the risk information
     */
    @JsonProperty( "risk_information" )
    public void setRiskInformation( RiskInformation riskInformation ) {
        this.riskInformation = riskInformation;
    }


    /**
     * Gets plugin information.
     *
     * @return the plugin information
     */
    @JsonProperty( "plugin_information" )
    public PluginInformation getPluginInformation() {
        return pluginInformation;
    }


    /**
     * Sets plugin information.
     *
     * @param pluginInformation the plugin information
     */
    @JsonProperty( "plugin_information" )
    public void setPluginInformation( PluginInformation pluginInformation ) {
        this.pluginInformation = pluginInformation;
    }

}
