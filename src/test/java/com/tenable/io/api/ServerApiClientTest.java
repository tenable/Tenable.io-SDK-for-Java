package com.tenable.io.api;


import com.tenable.io.api.server.models.ServerProperties;
import com.tenable.io.api.server.models.ServerStatus;

import org.junit.Test;

import static org.junit.Assert.*;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class ServerApiClientTest extends TestBase {
    @Test
    public void testServer() throws Exception {
        TenableIoClient apiClient = new TenableIoClient();
        ServerStatus status = apiClient.getServerApi().status();
        assertNotNull( status );

        ServerProperties properties = apiClient.getServerApi().properties();
        assertNotNull( properties );
        assertNotNull( properties.getAnalytics() );
        assertTrue( properties.getAnalytics().isEnabled() );
        assertNotNull( properties.getAnalytics().getKey() );
        assertNotNull( properties.getAnalytics().getSiteId() );
        assertNotNull( properties.getCapabilities() );
        assertTrue( properties.getCapabilities().isMultiScanner() );
        assertTrue( properties.getCapabilities().isReportEmailConfig() );
        assertNotNull( properties.getLicense() );
        assertTrue( properties.getLicense().getUsers() > 0 );
        assertTrue( properties.getIdleTimeout() > 0 );
    }
}
