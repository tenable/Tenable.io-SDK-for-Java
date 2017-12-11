package com.tenable.io.api;

import com.tenable.io.api.agentConfig.models.AgentConfigResponse;
import com.tenable.io.api.agentConfig.models.AutoUnlink;
import com.tenable.io.api.scanners.models.Scanner;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class AgentConfigApiClientTest extends TestBase {
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
    public void testAgentConfigEdit() throws Exception {
        AutoUnlink autoUnlink = new AutoUnlink( 1000, true );
        AgentConfigResponse response = apiClient.getAgentConfigApi().edit( scanner.getId(), false, autoUnlink );
        responseAssertions( response );
    }

    @Test
    public void testAgentConfigDetails() throws Exception {
        AgentConfigResponse response = apiClient.getAgentConfigApi().details( scanner.getId() );
        responseAssertions( response );
    }

    private void responseAssertions( AgentConfigResponse response ) {
        assertNotNull( response );
        assertTrue( response instanceof AgentConfigResponse );
        assertNotNull( response.getSoftwareUpdate() );
        assertNotNull( response.getAutoUnlink() );
    }
}
