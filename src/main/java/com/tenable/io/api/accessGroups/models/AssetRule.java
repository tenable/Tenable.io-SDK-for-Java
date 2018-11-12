package com.tenable.io.api.accessGroups.models;


/**
 * Copyright (c) 2018 Tenable Network Security, Inc.
 */
public class AssetRule {
    private String type;
    private String operator;
    private String[] terms;


    /**
     * Gets the type of asset rule.
     *
     * @return the type of asset rule.
     */
    public String getType() {
        return type;
    }


    /**
     * Sets the type of asset rule.
     *
     * @param type the type of asset rule.
     */
    public void setType( String type ) {
        this.type = type;
    }


    /**
     * Gets the operator.
     *
     * @return the operator.
     */
    public String getOperator() {
        return operator;
    }


    /**
     * Sets the operator.
     *
     * @param operator  the operator.
     */
    public void setOperator( String operator ) {
        this.operator = operator;
    }


    /**
     * Gets the array of values to match asset to rule with.
     *
     * @return the array of values to match asset to rule with.
     */
    public String[] getTerms() {
        return terms;
    }


    /**
     * Sets the array of values to match asset to rule with.
     *
     * @param terms the array of values to match asset to rule with.
     */
    public void setTerms( String[] terms ) {
        this.terms = terms;
    }
}
