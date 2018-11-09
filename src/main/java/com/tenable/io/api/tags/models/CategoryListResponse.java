package com.tenable.io.api.tags.models;

import com.tenable.io.api.agents.models.AgentPagination;


/**
 * Copyright (c) 2018 Tenable Network Security, Inc.
 */
public class CategoryListResponse {
    private TagCategory[] categories;
    private AgentPagination pagination;

    /**
     * Gets the array of categories
     *
     * @return the array of categories.
     */
    public TagCategory[] getCategories() {
        return categories;
    }


    /**
     * Sets the array of categories.
     *
     * @param categories the array of categories.
     */
    public void setCategories( TagCategory[] categories ) {
        this.categories = categories;
    }


    /**
     * Gets the pagination info
     *
     * @return the pagination info.
     */
    public AgentPagination getPagination() {
        return pagination;
    }


    /**
     * Sets the pagination info.
     *
     * @param pagination the pagination info.
     */
    public void setPagination( AgentPagination pagination ) {
        this.pagination = pagination;
    }
}
