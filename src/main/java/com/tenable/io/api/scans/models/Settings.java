package com.tenable.io.api.scans.models;


import com.fasterxml.jackson.annotation.*;
import com.tenable.io.api.permissions.models.Permission;

import java.util.List;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
@JsonInclude( JsonInclude.Include.NON_DEFAULT )
public class Settings {
    private String name;
    private String description;
    private int policyId;
    private int folderId;
    private int scannerId;
    private Boolean enabled;
    private LaunchFrequency launch;
    private String startTime;
    private RRules rRules;
    private String timezone;
    private String textTargets;
    private String fileTargets;
    private String emails;
    private List<Permission> acls;


    /**
     * Gets the name of the scan.
     *
     * @return the name of the scan.
     */
    public String getName() {
        return name;
    }


    /**
     * Sets the name of the scan.
     *
     * @param name the name of the scan.
     */
    public void setName( String name ) {
        this.name = name;
    }


    /**
     * Gets the description of the scan.
     *
     * @return the description of the scan.
     */
    public String getDescription() {
        return description;
    }


    /**
     * Sets the description of the scan.
     *
     * @param description the description of the scan.
     */
    public void setDescription( String description ) {
        this.description = description;
    }


    /**
     * Gets the unique id of the policy to use.
     *
     * @return the unique id of the policy to use.
     */
    @JsonProperty( "policy_id" )
    public int getPolicyId() {
        return policyId;
    }


    /**
     * Sets the unique id of the policy to use.
     *
     * @param policyId the unique id of the policy to use.
     */
    @JsonProperty( "policy_id" )
    public void setPolicyId( int policyId ) {
        this.policyId = policyId;
    }


    /**
     * Gets the unique id of the destination folder for the scan.
     *
     * @return the unique id of the destination folder for the scan.
     */
    @JsonProperty( "folder_id" )
    public int getFolderId() {
        return folderId;
    }


    /**
     * Sets the unique id of the destination folder for the scan.
     *
     * @param folderId the unique id of the destination folder for the scan.
     */
    @JsonProperty( "folder_id" )
    public void setFolderId( int folderId ) {
        this.folderId = folderId;
    }


    /**
     * Gets the unique id of the scanner to use.
     *
     * @return the unique id of the scanner to use.
     */
    @JsonProperty( "scanner_id" )
    public int getScannerId() {
        return scannerId;
    }


    /**
     * Sets the unique id of the scanner to use.
     *
     * @param scannerId the unique id of the scanner to use.
     */
    @JsonProperty( "scanner_id" )
    public void setScannerId( int scannerId ) {
        this.scannerId = scannerId;
    }


    /**
     * If true, the schedule for the scan is enabled.
     *
     * @return boolean whether the schedule for the scan is enabled.
     */
    public Boolean isEnabled() {
        return enabled;
    }


    /**
     * Sets the schedule for the scan to be enabled.
     *
     * @param enabled boolean whether the schedule for the scan is enabled.
     */
    public void setEnabled( Boolean enabled ) {
        this.enabled = enabled;
    }


    /**
     * Gets when to launch the scan. (i.e. DAILY, WEEKLY, MONTHLY, YEARLY)
     *
     * @return when to launch the scan. (i.e. DAILY, WEEKLY, MONTHLY, YEARLY)
     */
    public LaunchFrequency getLaunch() {
        return launch;
    }


    /**
     * Sets when to launch the scan. (i.e. DAILY, WEEKLY, MONTHLY, YEARLY)
     *
     * @param launch when to launch the scan. (i.e. DAILY, WEEKLY, MONTHLY, YEARLY)
     */
    public void setLaunch( LaunchFrequency launch ) {
        this.launch = launch;
    }


    /**
     * Gets the starting time and date for the scan (i.e. YYYYMMDDTHHMMSS).
     *
     * @return the starting time and date for the scan (i.e. YYYYMMDDTHHMMSS).
     */
    @JsonProperty( "starttime" )
    public String getStartTime() {
        return startTime;
    }


    /**
     * Sets the starting time and date for the scan (i.e. YYYYMMDDTHHMMSS).
     *
     * @param startTime the starting time and date for the scan (i.e. YYYYMMDDTHHMMSS).
     */
    @JsonProperty( "starttime" )
    public void setStartTime( String startTime ) {
        this.startTime = startTime;
    }


    /**
     * Gets a semi-colon delimited string comprised of three values. The frequency (FREQ=ONCE or DAILY or WEEKLY or MONTHLY or YEARLY),
     * the interval (INTERVAL=1 or 2 or 3 ... x), and the days of the week (BYDAY=SU,MO,TU,WE,TH,FR,SA).
     * To create a scan that runs every three weeks on Monday Wednesday and Friday the string would be 'FREQ=WEEKLY;INTERVAL=3;BYDAY=MO,WE,FR'
     *
     * @return a semi-colon delimited string comprised of three values. The frequency (FREQ=ONCE or DAILY or WEEKLY or MONTHLY or YEARLY),
     * the interval (INTERVAL=1 or 2 or 3 ... x), and the days of the week (BYDAY=SU,MO,TU,WE,TH,FR,SA).
     * To create a scan that runs every three weeks on Monday Wednesday and Friday the string would be 'FREQ=WEEKLY;INTERVAL=3;BYDAY=MO,WE,FR'
     */
    @JsonProperty( "rrules" )
    public String getrRules() {
        if( rRules != null ) {
            if(rRules.getStringValue() != null && !rRules.getStringValue().isEmpty()) {
                return rRules.getStringValue();
            }
            else {
                StringBuilder result = new StringBuilder();
                if(rRules.getFreq() != null && !rRules.getFreq().isEmpty()) {
                    result.append("FREQ=" + rRules.getFreq());
                    if(rRules.getInterval() != 0) {
                        result.append(";INTERVAL=" + rRules.getInterval());
                    }
                    if(rRules.getByWeekDay() != null && !rRules.getByWeekDay().isEmpty()) {
                        result.append(";BYDAY=" + rRules.getByWeekDay());
                    }
                }
                return result.toString();
            }
        } else {
            return null;
        }
    }


    /**
     * Sets a semi-colon delimited string comprised of three values. The frequency (FREQ=ONCE or DAILY or WEEKLY or MONTHLY or YEARLY),
     * the interval (INTERVAL=1 or 2 or 3 ... x), and the days of the week (BYDAY=SU,MO,TU,WE,TH,FR,SA).
     * To create a scan that runs every three weeks on Monday Wednesday and Friday the string would be 'FREQ=WEEKLY;INTERVAL=3;BYDAY=MO,WE,FR'
     *
     * @param rRules a semi-colon delimited string comprised of three values. The frequency (FREQ=ONCE or DAILY or WEEKLY or MONTHLY or YEARLY),
     *               the interval (INTERVAL=1 or 2 or 3 ... x), and the days of the week (BYDAY=SU,MO,TU,WE,TH,FR,SA).
     *               To create a scan that runs every three weeks on Monday Wednesday and Friday the string would be 'FREQ=WEEKLY;INTERVAL=3;BYDAY=MO,WE,FR'
     */
    @JsonProperty( "rrules" )
    public void setrRules( RRules rRules ) {
        this.rRules = rRules;
    }


    /**
     * Gets the timezone for the scan schedule.
     *
     * @return the timezone for the scan schedule.
     */
    public String getTimezone() {
        return timezone;
    }


    /**
     * Sets the timezone for the scan schedule.
     *
     * @param timezone the timezone for the scan schedule.
     */
    public void setTimezone( String timezone ) {
        this.timezone = timezone;
    }


    /**
     * Gets the list of targets to scan.
     *
     * @return the list of targets to scan.
     */
    @JsonProperty( "text_targets" )
    public String getTextTargets() {
        return textTargets;
    }


    /**
     * Sets the list of targets to scan.
     *
     * @param textTargets the list of targets to scan.
     */
    @JsonProperty( "text_targets" )
    public void setTextTargets( String textTargets ) {
        this.textTargets = textTargets;
    }


    /**
     * Gets the name of a file containing the list of targets to scan.
     *
     * @return the name of a file containing the list of targets to scan.
     */
    @JsonProperty( "file_targets" )
    public String getFileTargets() {
        return fileTargets;
    }


    /**
     * Sets the name of a file containing the list of targets to scan.
     *
     * @param fileTargets the name of a file containing the list of targets to scan.
     */
    @JsonProperty( "file_targets" )
    public void setFileTargets( String fileTargets ) {
        this.fileTargets = fileTargets;
    }


    /**
     * Gets a comma separated list of accounts who will recieve the email summary report.
     *
     * @return a comma separated list of accounts who will recieve the email summary report.
     */
    public String getEmails() {
        return emails;
    }


    /**
     * Sets a comma separated list of accounts who will recieve the email summary report.
     *
     * @param emails a comma separated list of accounts who will recieve the email summary report.
     */
    public void setEmails( String emails ) {
        this.emails = emails;
    }


    /**
     * Get an array containing permissions to apply to the scan
     *
     * @return an array containing permissions to apply to the scan
     */
    public List<Permission> getAcls() {
        return acls;
    }


    /**
     * Sets an array containing permissions to apply to the scan
     *
     * @param acls an array containing permissions to apply to the scan
     */
    public void setAcls( List<Permission> acls ) {
        this.acls = acls;
    }


    /**
     * Sets the name of the scan.
     *
     * @param name the name of the scan.
     */
    public Settings withName(String name) {
        this.name = name;
        return this;
    }


    /**
     * Sets the description of the scan.
     *
     * @param description the description of the scan.
     */
    public Settings withDescription(String description) {
        this.description = description;
        return this;
    }


    /**
     * Sets the unique id of the policy to use.
     *
     * @param policyId the unique id of the policy to use.
     */
    public Settings withPolicyId(int policyId) {
        this.policyId = policyId;
        return this;
    }


    /**
     * Sets the unique id of the destination folder for the scan.
     *
     * @param folderId the unique id of the destination folder for the scan.
     */
    public Settings withFolderId(int folderId) {
        this.folderId = folderId;
        return this;
    }


    /**
     * Sets the unique id of the scanner to use.
     *
     * @param scannerId the unique id of the scanner to use.
     */
    public Settings withScannerId(int scannerId) {
        this.scannerId = scannerId;
        return this;
    }


    /**
     * Sets the schedule for the scan to be enabled.
     *
     * @param enabled boolean whether the schedule for the scan is enabled.
     */
    public Settings withEnabled(Boolean enabled) {
        this.enabled = enabled;
        return this;
    }


    /**
     * Sets when to launch the scan. (i.e. DAILY, WEEKLY, MONTHLY, YEARLY)
     *
     * @param launch when to launch the scan. (i.e. DAILY, WEEKLY, MONTHLY, YEARLY)
     */
    public Settings withLaunch(LaunchFrequency launch) {
        this.launch = launch;
        return this;
    }


    /**
     * Sets the starting time and date for the scan (i.e. YYYYMMDDTHHMMSS).
     *
     * @param startTime the starting time and date for the scan (i.e. YYYYMMDDTHHMMSS).
     */
    public Settings withStartTime(String startTime) {
        this.startTime = startTime;
        return this;
    }


    /**
     * Sets a semi-colon delimited string comprised of three values. The frequency (FREQ=ONCE or DAILY or WEEKLY or MONTHLY or YEARLY),
     * the interval (INTERVAL=1 or 2 or 3 ... x), and the days of the week (BYDAY=SU,MO,TU,WE,TH,FR,SA).
     * To create a scan that runs every three weeks on Monday Wednesday and Friday the string would be 'FREQ=WEEKLY;INTERVAL=3;BYDAY=MO,WE,FR'
     *
     * @param rRules a semi-colon delimited string comprised of three values. The frequency (FREQ=ONCE or DAILY or WEEKLY or MONTHLY or YEARLY),
     *               the interval (INTERVAL=1 or 2 or 3 ... x), and the days of the week (BYDAY=SU,MO,TU,WE,TH,FR,SA).
     *               To create a scan that runs every three weeks on Monday Wednesday and Friday the string would be 'FREQ=WEEKLY;INTERVAL=3;BYDAY=MO,WE,FR'
     */
    public Settings withRRules(RRules rRules) {
        this.rRules = rRules;
        return this;
    }


    /**
     * Sets the timezone for the scan schedule.
     *
     * @param timezone the timezone for the scan schedule.
     */
    public Settings withTimezone(String timezone) {
        this.timezone = timezone;
        return this;
    }


    /**
     * Sets the list of targets to scan.
     *
     * @param textTargets the list of targets to scan.
     */
    public Settings withTextTargets(String textTargets) {
        this.textTargets = textTargets;
        return this;
    }


    /**
     * Sets the name of a file containing the list of targets to scan.
     *
     * @param fileTargets the name of a file containing the list of targets to scan.
     */
    public Settings withFileTargets(String fileTargets) {
        this.fileTargets = fileTargets;
        return this;
    }


    /**
     * Sets a comma separated list of accounts who will recieve the email summary report.
     *
     * @param emails a comma separated list of accounts who will recieve the email summary report.
     */
    public Settings withEmails(String emails) {
        this.emails = emails;
        return this;
    }


    /**
     * Sets an array containing permissions to apply to the scan
     *
     * @param acls an array containing permissions to apply to the scan
     */
    public Settings withAcls(List<Permission> acls) {
        this.acls = acls;
        return this;
    }

}
