package com.tenable.io.api.bulkOperations.models;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The type Task.
 */
public class Task {
    private String taskId;
    private String containerUuid;
    private String status;
    private String message;
    private long startTime;
    private long endTime;
    private long lastUpdateTime;
    private int totalWorkUnits;
    private int totalWorkUnitsCompleted;
    private int completionPercentage;

    /**
     * Gets task id.
     *
     * @return the task id
     */
    @JsonProperty ( "task_id" )
    public String getTaskId() {
        return taskId;
    }

    /**
     * Sets task id.
     *
     * @param taskId the task id
     */
    @JsonProperty( "task_id" )
    public void setTaskId( String taskId ) {
        this.taskId = taskId;
    }

    /**
     * Gets container uuid.
     *
     * @return the container uuid
     */
    @JsonProperty( "container_uuid" )
    public String getContainerUuid() {
        return containerUuid;
    }

    /**
     * Sets container uuid.
     *
     * @param containerUuid the container uuid
     */
    @JsonProperty( "container_uuid" )
    public void setContainerUuid( String containerUuid ) {
        this.containerUuid = containerUuid;
    }

    /**
     * Gets status.
     *
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets status.
     *
     * @param status the status
     */
    public void setStatus( String status ) {
        this.status = status;
    }

    /**
     * Gets message.
     *
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets message.
     *
     * @param message the message
     */
    public void setMessage( String message ) {
        this.message = message;
    }

    /**
     * Gets start time.
     *
     * @return the start time
     */
    @JsonProperty( "start_time" )
    public long getStartTime() {
        return startTime;
    }

    /**
     * Sets start time.
     *
     * @param startTime the start time
     */
    @JsonProperty( "start_time" )
    public void setStartTime( long startTime ) {
        this.startTime = startTime;
    }

    /**
     * Gets end time.
     *
     * @return the end time
     */
    @JsonProperty( "end_time" )
    public long getEndTime() {
        return endTime;
    }

    /**
     * Sets end time.
     *
     * @param endTime the end time
     */
    @JsonProperty( "end_time" )
    public void setEndTime( long endTime ) {
        this.endTime = endTime;
    }

    /**
     * Gets last update time.
     *
     * @return the last update time
     */
    @JsonProperty( "last_update_time" )
    public long getLastUpdateTime() {
        return lastUpdateTime;
    }

    /**
     * Sets last update time.
     *
     * @param lastUpdateTime the last update time
     */
    @JsonProperty( "last_update_time" )
    public void setLastUpdateTime( long lastUpdateTime ) {
        this.lastUpdateTime = lastUpdateTime;
    }

    /**
     * Gets total work units.
     *
     * @return the total work units
     */
    @JsonProperty( "total_work_units" )
    public int getTotalWorkUnits() {
        return totalWorkUnits;
    }

    /**
     * Sets total work units.
     *
     * @param totalWorkUnits the total work units
     */
    @JsonProperty( "total_work_units" )
    public void setTotalWorkUnits( int totalWorkUnits ) {
        this.totalWorkUnits = totalWorkUnits;
    }

    /**
     * Gets total work units completed.
     *
     * @return the total work units completed
     */
    @JsonProperty( "total_work_units_completed" )
    public int getTotalWorkUnitsCompleted() {
        return totalWorkUnitsCompleted;
    }

    /**
     * Sets total work units completed.
     *
     * @param totalWorkUnitsCompleted the total work units completed
     */
    @JsonProperty( "total_work_units_completed" )
    public void setTotalWorkUnitsCompleted( int totalWorkUnitsCompleted ) {
        this.totalWorkUnitsCompleted = totalWorkUnitsCompleted;
    }

    /**
     * Gets completion percentage.
     *
     * @return the completion percentage
     */
    @JsonProperty( "completion_percentage" )
    public int getCompletionPercentage() {
        return completionPercentage;
    }

    /**
     * Sets completion percentage.
     *
     * @param completionPercentage the completion percentage
     */
    @JsonProperty( "completion_percentage" )
    public void setCompletionPercentage( int completionPercentage ) {
        this.completionPercentage = completionPercentage;
    }
}
