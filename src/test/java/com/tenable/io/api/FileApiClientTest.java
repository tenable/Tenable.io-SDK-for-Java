package com.tenable.io.api;


import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class FileApiClientTest extends TestBase {
    @Test
    public void testFileUpload() throws Exception {
        TenableIoClient apiClient = new TenableIoClient();
        String filename = apiClient.getFileApi().upload( new File( "src/test/resources/targets.txt" ) );

        assertNotNull( filename );
    }
}