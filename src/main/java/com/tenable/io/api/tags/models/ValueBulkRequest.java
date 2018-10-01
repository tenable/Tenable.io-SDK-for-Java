package com.tenable.io.api.tags.models;

public class ValueBulkRequest {
    private String[] values;

    /**
     * Gets the list of values uuids.
     *
     * @return the list of values uuids.
     */
    public String[] getValues() {
        return values;
    }


    /**
     * Sets the list of values uuids.
     *
     * @param values the list of values uuids.
     */
    public void setValues( String[] values ) {
        this.values = values;
    }


    /**
     * Sets the list of values uuids.
     *
     * @param values the list of values uuids.
     */
    public ValueBulkRequest withValues( String[] values ) {
        this.values = values;
        return this;
    }
}
