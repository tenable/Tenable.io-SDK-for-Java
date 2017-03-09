package com.tenable.io.api.workbenches.models;


import com.fasterxml.jackson.annotation.JsonValue;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public enum FilterOperator {
    /**
     * Equal filter operator.
     */
    EQUAL( "eq" ),
    /**
     * Not equal filter operator.
     */
    NOT_EQUAL( "neq" ),
    /**
     * Greater than filter operator.
     */
    GREATER_THAN( "gt" ),
    /**
     * Lower than filter operator.
     */
    LOWER_THAN( "lt" ),
    /**
     * Later than filter operator. Applies to dates
     */
    LATER_THAN( "date-gt" ),
    /**
     * Ealier than filter operator. Applies to dates.
     */
    EARLIER_THAN( "date-lt" ),
    /**
     * On filter operator. Applies to dates.
     */
    ON( "date-eq" ),
    /**
     * Not On filter operator. Applies to dates.
     */
    NOT_ON( "date-neq" ),
    /**
     * Asset Match filter operator.
     */
    IS_MEMBER_OF( "match-asset" ),
    /**
     * Asset Not Match filter operator.
     */
    IS_NOT_MEMBER_OF( "nmatch-asset" ),
    /**
     * Contains/matches filter operator.
     */
    CONTAINS( "match" ),
    /**
     * Does not Contain/does not match filter operator.
     */
    DOES_NOT_CONTAIN( "nmatch" );


    private final String value;


    FilterOperator( String value ) {
        this.value = value;
    }


    /**
     * Gets value.
     *
     * @return the value
     */
    @JsonValue
    public String getValue() {
        return value;
    }
}
