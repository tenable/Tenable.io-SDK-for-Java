package com.tenable.io.api.server.models;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class ServerProperties {
    private ServerCapabilities capabilities;
    private boolean enterprise;
    private int expiration;
    private int expirationTime;
    private int idleTimeout;
    private ServerLicense license;
    private String loadedPluginSet;
    private boolean loginBanner;
    private String nessusType;
    private String nessusUiVersion;
    private List<ServerNotification> notifications;
    private String pluginSet;
    private int scannerBootTime;
    private String serverVersion;
    private String serverUuid;
    private ServerUpdate update;
    private String serverBuild;
    private int nessusUiBuild;
    private boolean msp;
    private boolean forceUiReload;
    private String containerDbVersion;
    private ServerAnalytics analytics;


    /**
     * Gets server build.
     *
     * @return the server build
     */
    public String getServerBuild() {
        return serverBuild;
    }


    /**
     * Sets server build.
     *
     * @param serverBuild the server build
     */
    public void setServerBuild( String serverBuild ) {
        this.serverBuild = serverBuild;
    }


    /**
     * Gets nessus ui build.
     *
     * @return the nessus ui build
     */
    public int getNessusUiBuild() {
        return nessusUiBuild;
    }


    /**
     * Sets nessus ui build.
     *
     * @param nessusUiBuild the nessus ui build
     */
    public void setNessusUiBuild( int nessusUiBuild ) {
        this.nessusUiBuild = nessusUiBuild;
    }


    /**
     * Is msp boolean.
     *
     * @return the boolean
     */
    public boolean isMsp() {
        return msp;
    }


    /**
     * Sets msp.
     *
     * @param msp the msp
     */
    public void setMsp( boolean msp ) {
        this.msp = msp;
    }


    /**
     * Is force ui reload boolean.
     *
     * @return the boolean
     */
    public boolean isForceUiReload() {
        return forceUiReload;
    }


    /**
     * Sets force ui reload.
     *
     * @param forceUiReload the force ui reload
     */
    public void setForceUiReload( boolean forceUiReload ) {
        this.forceUiReload = forceUiReload;
    }


    /**
     * Gets container db version.
     *
     * @return the container db version
     */
    public String getContainerDbVersion() {
        return containerDbVersion;
    }


    /**
     * Sets container db version.
     *
     * @param containerDbVersion the container db version
     */
    public void setContainerDbVersion( String containerDbVersion ) {
        this.containerDbVersion = containerDbVersion;
    }


    /**
     * Gets analytics.
     *
     * @return the analytics
     */
    public ServerAnalytics getAnalytics() {
        return analytics;
    }


    /**
     * Sets analytics.
     *
     * @param analytics the analytics
     */
    public void setAnalytics( ServerAnalytics analytics ) {
        this.analytics = analytics;
    }


    /**
     * Gets capabilities.
     *
     * @return the capabilities
     */
    public ServerCapabilities getCapabilities() {
        return capabilities;
    }


    /**
     * Sets capabilities.
     *
     * @param capabilities the capabilities
     */
    public void setCapabilities( ServerCapabilities capabilities ) {
        this.capabilities = capabilities;
    }


    /**
     * Is enterprise boolean.
     *
     * @return the boolean
     */
    public boolean isEnterprise() {
        return enterprise;
    }


    /**
     * Sets enterprise.
     *
     * @param enterprise the enterprise
     */
    public void setEnterprise( boolean enterprise ) {
        this.enterprise = enterprise;
    }


    /**
     * Gets expiration.
     *
     * @return the expiration
     */
    public int getExpiration() {
        return expiration;
    }


    /**
     * Sets expiration.
     *
     * @param expiration the expiration
     */
    public void setExpiration( int expiration ) {
        this.expiration = expiration;
    }


    /**
     * Gets expiration time.
     *
     * @return the expiration time
     */
    @JsonProperty( "expiration_time" )
    public int getExpirationTime() {
        return expirationTime;
    }


    /**
     * Sets expiration time.
     *
     * @param expirationTime the expiration time
     */
    @JsonProperty( "expiration_time" )
    public void setExpirationTime( int expirationTime ) {
        this.expirationTime = expirationTime;
    }


    /**
     * Gets idle timeout.
     *
     * @return the idle timeout
     */
    @JsonProperty( "idle_timeout" )
    public int getIdleTimeout() {
        return idleTimeout;
    }


    /**
     * Sets idle timeout.
     *
     * @param idleTimeout the idle timeout
     */
    @JsonProperty( "idle_timeout" )
    public void setIdleTimeout( int idleTimeout ) {
        this.idleTimeout = idleTimeout;
    }


    /**
     * Gets license.
     *
     * @return the license
     */
    public ServerLicense getLicense() {
        return license;
    }


    /**
     * Sets license.
     *
     * @param license the license
     */
    public void setLicense( ServerLicense license ) {
        this.license = license;
    }


    /**
     * Gets loaded plugin set.
     *
     * @return the loaded plugin set
     */
    @JsonProperty( "loaded_plugin_set" )
    public String getLoadedPluginSet() {
        return loadedPluginSet;
    }


    /**
     * Sets loaded plugin set.
     *
     * @param loadedPluginSet the loaded plugin set
     */
    @JsonProperty( "loaded_plugin_set" )
    public void setLoadedPluginSet( String loadedPluginSet ) {
        this.loadedPluginSet = loadedPluginSet;
    }


    /**
     * Is login banner boolean.
     *
     * @return the boolean
     */
    @JsonProperty( "login_banner" )
    public boolean isLoginBanner() {
        return loginBanner;
    }


    /**
     * Sets login banner.
     *
     * @param loginBanner the login banner
     */
    @JsonProperty( "login_banner" )
    public void setLoginBanner( boolean loginBanner ) {
        this.loginBanner = loginBanner;
    }


    /**
     * Gets nessus type.
     *
     * @return the nessus type
     */
    @JsonProperty( "nessus_type" )
    public String getNessusType() {
        return nessusType;
    }


    /**
     * Sets nessus type.
     *
     * @param nessusType the nessus type
     */
    @JsonProperty( "nessus_type" )
    public void setNessusType( String nessusType ) {
        this.nessusType = nessusType;
    }


    /**
     * Gets nessus ui version.
     *
     * @return the nessus ui version
     */
    @JsonProperty( "nessus_ui_version" )
    public String getNessusUiVersion() {
        return nessusUiVersion;
    }


    /**
     * Sets nessus ui version.
     *
     * @param nessusUiVersion the nessus ui version
     */
    @JsonProperty( "nessus_ui_version" )
    public void setNessusUiVersion( String nessusUiVersion ) {
        this.nessusUiVersion = nessusUiVersion;
    }


    /**
     * Gets notifications.
     *
     * @return the notifications
     */
    public List<ServerNotification> getNotifications() {
        return notifications;
    }


    /**
     * Sets notifications.
     *
     * @param notifications the notifications
     */
    public void setNotifications( List<ServerNotification> notifications ) {
        this.notifications = notifications;
    }


    /**
     * Gets plugin set.
     *
     * @return the plugin set
     */
    @JsonProperty( "plugin_set" )
    public String getPluginSet() {
        return pluginSet;
    }


    /**
     * Sets plugin set.
     *
     * @param pluginSet the plugin set
     */
    @JsonProperty( "plugin_set" )
    public void setPluginSet( String pluginSet ) {
        this.pluginSet = pluginSet;
    }


    /**
     * Gets scanner boot time.
     *
     * @return the scanner boot time
     */
    @JsonProperty( "scanner_boottime" )
    public int getScannerBootTime() {
        return scannerBootTime;
    }


    /**
     * Sets scanner boot time.
     *
     * @param scannerBootTime the scanner boot time
     */
    @JsonProperty( "scanner_boottime" )
    public void setScannerBootTime( int scannerBootTime ) {
        this.scannerBootTime = scannerBootTime;
    }


    /**
     * Gets server version.
     *
     * @return the server version
     */
    @JsonProperty( "server_version" )
    public String getServerVersion() {
        return serverVersion;
    }


    /**
     * Sets server version.
     *
     * @param serverVersion the server version
     */
    @JsonProperty( "server_version" )
    public void setServerVersion( String serverVersion ) {
        this.serverVersion = serverVersion;
    }


    /**
     * Gets server uuid.
     *
     * @return the server uuid
     */
    @JsonProperty( "server_uuid" )
    public String getServerUuid() {
        return serverUuid;
    }


    /**
     * Sets server uuid.
     *
     * @param serverUuid the server uuid
     */
    @JsonProperty( "server_uuid" )
    public void setServerUuid( String serverUuid ) {
        this.serverUuid = serverUuid;
    }


    /**
     * Gets update.
     *
     * @return the update
     */
    public ServerUpdate getUpdate() {
        return update;
    }


    /**
     * Sets update.
     *
     * @param update the update
     */
    public void setUpdate( ServerUpdate update ) {
        this.update = update;
    }
}
