package com.tenable.io.api;

import com.tenable.io.api.agentGroups.models.AgentGroup;
import com.tenable.io.api.agents.models.Agent;
import com.tenable.io.api.bulkOperations.models.Task;
import com.tenable.io.api.scanners.models.Scanner;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class BulkAgentApiClientTest extends TestBase {
    private TenableIoClient apiClient;
    private Scanner scanner;

    @Before
    public void setUp() throws Exception {
        apiClient = new TenableIoClient();
        List<Scanner> scanners = apiClient.getScannersApi().list();
        assertNotNull( scanners );

        if ( scanners.size() == 0 ) {
            throw new Exception( "Container does not have any scanners." );
        } else {
            scanner = scanners.get( 0 );
        }
    }

    @Test
    public void testBulkAddAgent() throws Exception {
        bulkAddAgent();
    }

    @Test
    public void testBulkRemoveAgent() throws Exception {
        Task task = apiClient.getBulkAgentApi().remove( scanner.getId(), getAgentGroupId(), getAgentIds() );
        taskAssertions( task );
    }

    @Test
    public void testBulkUnlinkAgent() throws Exception {
        Task task = apiClient.getBulkAgentApi().unlink( scanner.getId(), getAgentIds() );
        taskAssertions( task );
    }

    @Test
    public void testBulkAgentGroupStatus() throws Exception {
        Task task = bulkAddAgent();

        Task retrievedTask = apiClient.getBulkAgentApi().groupStatus( scanner.getId(), getAgentGroupId(), task.getTaskId() );
        taskAssertions( retrievedTask );

        assertEquals( task.getTaskId(), retrievedTask.getTaskId() );
        assertEquals( task.getContainerUuid(), retrievedTask.getContainerUuid() );
    }

    @Test
    public void testBulkAgentStatus() throws Exception {
        Task task = bulkAddAgent();

        Task retrievedTask = apiClient.getBulkAgentApi().status( scanner.getId(), task.getTaskId() );
        taskAssertions( retrievedTask );

        assertEquals( task.getTaskId(), retrievedTask.getTaskId() );
        assertEquals( task.getContainerUuid(), retrievedTask.getContainerUuid() );
    }

    private Task bulkAddAgent() throws Exception {
        Task task = apiClient.getBulkAgentApi().add( scanner.getId(), getAgentGroupId(), getAgentIds() );
        taskAssertions( task );
        return task;
    }

    private int getAgentGroupId() throws Exception {
        String name = getNewTestAgentGroupName();
        AgentGroup agentGroup = apiClient.getAgentGroupsApi().create( name );
        assertNotNull( agentGroup );

        return agentGroup.getId();
    }

    private List<Integer> getAgentIds() throws Exception {
        List<Agent> agents = apiClient.getAgentsApi().list();
        assertNotNull( agents );

        List<Integer> agentIds = new ArrayList<>();

        for ( int i = 2; i < agents.size(); i++ ) {
            agentIds.add( agents.get( i ).getId() );
        }

        return agentIds;
    }

    private void taskAssertions( Task task ) {
        assertNotNull( task );
        assertTrue( task instanceof Task );
        assertNotNull( task.getTaskId() );
        assertNotNull( task.getContainerUuid() );
        assertNotNull( task.getStatus() );
    }
}
