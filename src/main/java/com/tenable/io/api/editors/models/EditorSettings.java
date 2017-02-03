package com.tenable.io.api.editors.models;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class EditorSettings {
    private SettingsDetail basic;
    private SettingsDetail discovery;
    private SettingsDetail assessment;
    private ReportSettingsDetail report;
    private SettingsDetail advanced;


    /**
     * Gets basic settings.
     *
     * @return the basic settings
     */
    public SettingsDetail getBasic() {
        return basic;
    }


    /**
     * Sets basic settings.
     *
     * @param basic the basic
     */
    public void setBasic( SettingsDetail basic ) {
        this.basic = basic;
    }


    /**
     * Gets discovery settings.
     *
     * @return the discovery settings
     */
    public SettingsDetail getDiscovery() {
        return discovery;
    }


    /**
     * Sets discovery settings.
     *
     * @param discovery the discovery settings
     */
    public void setDiscovery( SettingsDetail discovery ) {
        this.discovery = discovery;
    }


    /**
     * Gets assessment settings.
     *
     * @return the assessment settings
     */
    public SettingsDetail getAssessment() {
        return assessment;
    }


    /**
     * Sets assessment settings.
     *
     * @param assessment the assessment settings
     */
    public void setAssessment( SettingsDetail assessment ) {
        this.assessment = assessment;
    }


    /**
     * Gets report settings.
     *
     * @return the report settings
     */
    public ReportSettingsDetail getReport() {
        return report;
    }


    /**
     * Sets report settings.
     *
     * @param report the report settings
     */
    public void setReport( ReportSettingsDetail report ) {
        this.report = report;
    }


    /**
     * Gets advanced settings.
     *
     * @return the advanced settings
     */
    public SettingsDetail getAdvanced() {
        return advanced;
    }


    /**
     * Sets advanced settings.
     *
     * @param advanced the advanced settings
     */
    public void setAdvanced( SettingsDetail advanced ) {
        this.advanced = advanced;
    }
}
