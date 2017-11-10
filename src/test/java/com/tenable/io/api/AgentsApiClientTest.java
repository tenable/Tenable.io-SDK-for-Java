package com.tenable.io.api;


import com.tenable.io.api.agents.models.Agent;
import com.tenable.io.core.exceptions.TenableIoException;
import com.tenable.io.core.exceptions.TenableIoErrorCode;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class AgentsApiClientTest extends TestBase {
    @Test
    public void testAgents() throws Exception {
        TenableIoClient apiClient = new TenableIoClient();

        // No agents expected to be returned on a new container
        List<Agent> agents = apiClient.getAgentsApi().list();
        assertNull( agents );

        //Since no agents should exist on testing containers a 404 is expected
        try {
            apiClient.getAgentsApi().delete(9999);
        }
        catch (TenableIoException e){
            assertTrue(e.getErrorCode() == TenableIoErrorCode.NotFound);
        }
    }
}
