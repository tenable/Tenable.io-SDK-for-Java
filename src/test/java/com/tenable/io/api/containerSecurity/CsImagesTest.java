package com.tenable.io.api.containerSecurity;

import com.tenable.io.core.utilities.DockerImageUploadTest;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class CsImagesTest extends DockerImageUploadTest {
    @Override
    public void tearDown() throws Exception {
        super.tearDown();
        assertNull( getUploadedDockerImage() );
    }

    @Test
    public void testList() throws Exception {
        assertNotNull( getUploadedDockerImage() );
    }
}
