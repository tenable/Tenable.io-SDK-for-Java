package com.tenable.io.api.tags.models;

import java.util.Map;

public class AssignmentCounts {
    private boolean hasAssignments;
    private Map counts;


    /**
     * Gets if asset has assignments.
     *
     * @return if asset has assignments.
     */
    public boolean isHasAssignments() {
        return hasAssignments;
    }


    /**
     * Sets if asset has assignments.
     *
     * @param hasAssignments boolean for if asset has assignments.
     */
    public void setHasAssignments( boolean hasAssignments ) {
        this.hasAssignments = hasAssignments;
    }


    /**
     * Gets the map of number of assignments to asset.
     *
     * @return the map of number of assignments to asset.
     */
    public Map getCounts() {
        return counts;
    }


    /**
     * Sets the number of assignments to asset.
     *
     * @param counts the map of number of assignments to assets.
     */
    public void setCounts( Map counts ) {
        this.counts = counts;
    }
}
