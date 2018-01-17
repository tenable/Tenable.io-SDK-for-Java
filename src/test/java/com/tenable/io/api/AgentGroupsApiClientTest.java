package com.tenable.io.api;


import com.tenable.io.api.agentGroups.models.AgentGroup;
import com.tenable.io.api.agents.models.Agent;
import com.tenable.io.core.exceptions.TenableIoException;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class AgentGroupsApiClientTest extends TestBase {

    @Test
    public void testAgentGroups() throws Exception {
        String testName = getNewTestAgentGroupName();
        String testName2 = getNewTestAgentGroupName();
        String limit = "50";

        // create new agent group
        AgentGroup createdGroup = apiClient.getAgentGroupsApi().create( testName );
        assertNotNull( createdGroup );

        //list and verify group is created
        List<AgentGroup> groups = apiClient.getAgentGroupsApi().list();
        boolean created = false;
        for ( AgentGroup item : groups ) {
            if ( item.getName().equals(testName ) ) {
                created = true;
            }
        }

        assertTrue( created );

        //test configure
        apiClient.getAgentGroupsApi().configure( createdGroup.getId(), testName2 );

        //test details, verify name changed
        AgentGroup detail = apiClient.getAgentGroupsApi().details( createdGroup.getId() );
        assertNotNull(detail);
        assertTrue(detail.getName().equals(testName2));

        // Setup filtering parameters and get agents
        List<NameValuePair> params = new ArrayList<>();
        params.add(new BasicNameValuePair("limit", limit));
        List<Agent> agents = apiClient.getAgentsApi().list(params);
        assertNotNull(agents);

        // Add agents to createdGroup
        for ( Agent ag : agents ) {
            apiClient.getAgentGroupsApi().addAgent( createdGroup.getId(), ag.getId() );
        }
        createdGroup = apiClient.getAgentGroupsApi().details( createdGroup.getId() );
        assertEquals( createdGroup.getAgentsCount(), agents.size() );

        // Test agent group details pagination
        for ( int i = 0; i < createdGroup.getAgentsCount(); i += 10 ) {
            AgentGroup filteredGroup = getPaginatedAgents( createdGroup.getId(), Integer.toString( i ), "10" );
            assertTrue(filteredGroup.getPagination().getOffset() == i );
        }

        // Delete agents from createdGroup
        for ( Agent ag : agents ) {
            apiClient.getAgentGroupsApi().deleteAgent( createdGroup.getId(), ag.getId() );
        }

        createdGroup = apiClient.getAgentGroupsApi().details( createdGroup.getId() );
        assertTrue(createdGroup.getAgentsCount() == 0 );

        //delete agent group
        apiClient.getAgentGroupsApi().delete( createdGroup.getId() );
    }


    private AgentGroup getPaginatedAgents( int groupId, String offset, String limit ) throws Exception {
        List<NameValuePair> params = new ArrayList<>();
        params.add( new BasicNameValuePair("limit", limit ) );
        params.add( new BasicNameValuePair("offset", offset ) );

        return apiClient.getAgentGroupsApi().details( groupId, params );
    }


    @Before
    @After
    public void cleanup() throws TenableIoException {
        deleteTestAgentGroups(apiClient);
    }
}
