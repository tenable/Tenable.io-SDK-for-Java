package com.tenable.io.api;


import com.tenable.io.api.agents.models.Agent;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class AgentsApiClientTest extends TestBase {
    @Test
    public void testAgents() throws Exception {
        TenableIoClient apiClient = new TenableIoClient();

        List<Agent> agents = apiClient.getAgentsApi().list();
        assertNotNull( agents );
        assertTrue( agents.size() > 0 );

        //works. don't want to delete agent since adding a new agent requires manual steps
        //apiClient.getAgentsApi().delete(1, 6100);
    }
}
