package com.tenable.io.api.agents.models;

import java.util.List;

/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class AgentPagination {
    private int total;
    private int offset;
    private int limit;
    private List<AgentSort> sort;

    /**
     * Gets total.
     *
     * @return the total
     */
    public int getTotal() { return total; }

    /**
     * Sets total.
     *
     * @param total the total
     */
    public void setTotal( int total ) { this.total = total; }

    /**
     * Gets offset.
     *
     * @return the offset
     */
    public int getOffset() { return offset; }

    /**
     * Sets offset.
     *
     * @param offset the offset
     */
    public void setOffset( int offset ) { this.offset = offset; }

    /**
     * Gets limit.
     *
     * @return the limit
     */
    public int getLimit() { return limit; }

    /**
     * Sets limit.
     *
     * @param limit the limit
     */
    public void setLimit( int limit ) { this.limit = limit; }

    /**
     * Gets sort.
     *
     * @return the sort
     */
    public List<AgentSort> getSort() { return sort; }

    /**
     * Sets sort.
     *
     * @param sort the sort
     */
    public void setSort( List<AgentSort> sort ) { this.sort = sort; }

}
