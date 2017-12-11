package com.tenable.io.api;


import com.tenable.io.api.agents.models.Agent;
import com.tenable.io.api.agents.models.AgentFilterOptions;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class AgentsApiClientTest extends TestBase {
    private final String limit = "50";
    private TenableIoClient apiClient = new TenableIoClient();
    private AgentFilterOptions filterOptions;
    private List<Agent> agents;

    @Test
    public void getAgents() throws Exception {
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add( new BasicNameValuePair("limit", limit ) );

        // get agents
        agents = apiClient.getAgentsApi().list( params );
        assertNotNull( agents );
        assertTrue(agents.size() <= Integer.parseInt( limit ) );

        Agent agent = apiClient.getAgentsApi().get( agents.get( 0 ).getId() );

        assertNotNull( agent );
        assertNotNull( agent.getName() );
        assertNotNull( agent.getDistro() );
        assertNotNull( agent.getId() );
        assertNotNull( agent.getIp() );
        assertNotNull( agent.getLinkedOn() );
        assertNotNull( agent.getPlatform() );
        assertNotNull( agent.getStatus() );
        assertNotNull( agent.getUuid() );
    }

    @Test
    public void testFilters() throws Exception {
        List<Agent> filteredAgents;

        // this function can be ran independently
        if (agents == null) {
            getAgents();
        }

        // Filter by platform equality
        String platform = agents.get(0).getPlatform();
        List<Agent> platformFilteredAgents = filteredRequest( "platform", "eq", platform );
        for ( Agent ag : platformFilteredAgents ) {
            assertEquals( platform, ag.getPlatform() );
        }

        // Filter by platform inequality
        filteredAgents = filteredRequest( "platform", "neq", platform );
        assertEquals( filteredAgents.size(), ( agents.size() - platformFilteredAgents.size() ) );
        for ( Agent ag : filteredAgents ) {
            assertNotEquals( platform, ag.getPlatform() );
        }

        // Filter by ip match
        String substr = agents.get(0).getIp().substring( 1, 3 );
        filteredAgents = filteredRequest( "ip", "match", substr );
        for ( Agent ag : filteredAgents ) {
            assertTrue( ag.getIp().contains( substr ) );
        }


        // Filter by status equality
        String status = "offline";
        filteredAgents = filteredRequest( "status", "eq", status );
        for ( Agent ag : filteredAgents ) {
            assertTrue( status.contains( ag.getStatus() ) );
        }

        // Filter by status inequality
        filteredAgents = filteredRequest( "status", "neq", status );
        for ( Agent ag : filteredAgents ) {
            assertFalse( status.contains( ag.getStatus() ) );
        }
    }

    @Test
    public void testSort() throws Exception {
        // Sort by name in asc order
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        List<Agent> sortedAgents;
        params.add( new BasicNameValuePair( "limit", limit ) );
        params.add( new BasicNameValuePair( "sort", "name:asc" ) );

        sortedAgents = apiClient.getAgentsApi().list( params );

        boolean isSorted = true;
        for ( int i = 0; i < sortedAgents.size(); i++ ) {
            if ( ( i + 1 ) < sortedAgents.size() ) {
                isSorted = sortedAgents.get( i ).getName().compareTo( sortedAgents.get( i + 1 ).getName() ) < 0;
            }
            if ( !isSorted ) { i = sortedAgents.size(); }
        }

        assertTrue( isSorted );
    }

    private List<Agent> filteredRequest( String field, String op, String value ) throws Exception {
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add( new BasicNameValuePair("limit", limit ) );
        params.add( new BasicNameValuePair("f", field + ":" + op + ":" + value ) );

        return apiClient.getAgentsApi().list( params );
    }

}
