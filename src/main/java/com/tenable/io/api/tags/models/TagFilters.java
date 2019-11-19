package com.tenable.io.api.tags.models;

import java.util.HashMap;
import java.util.List;

/**
 * Copyright (c) 2019 Tenable Network Security, Inc.
 */
public class TagFilters extends HashMap<TagFilterOperator, List<TagFilter>> {

    private TagFilterOperator operator;
    private List<TagFilter> filters;


    /**
     * Gets the operator for the tag filters.
     *
     * @return the operator for the tag filters, `TagFilterOperator`.
     */
    public TagFilterOperator getOperator() {
        return this.keySet().iterator().next();
    }


    /**
     * Sets the operator for the tag filters.
     *
     * @param operator the operator for the tag filters.
     */
    public void setOperator(final TagFilterOperator operator) {
        this.put(operator, this.remove(this.getOperator()));
        this.operator = this.keySet().iterator().next();
    }


    /**
     * Gets the filter conditions for the tag filters.
     *
     * @return the filter conditions for the tag filters.
     */
    public List<TagFilter> getFilters() {
        return this.get(this.getOperator());
    }


    /**
     * Sets the filter conditions for the tag filters.
     *
     * @param filters the filter conditions for the tag filters.
     */
    public void setFilters(final List<TagFilter> filters) {
        this.get(this.getOperator()).clear();
        this.get(this.getOperator()).addAll(filters);
        this.filters = this.get(this.getOperator());
    }
}
