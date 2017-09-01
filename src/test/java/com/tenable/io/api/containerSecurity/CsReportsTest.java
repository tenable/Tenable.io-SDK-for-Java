package com.tenable.io.api.containerSecurity;

import com.tenable.io.api.containerSecurity.models.CsContainerImage;
import com.tenable.io.api.containerSecurity.models.CsReport;
import com.tenable.io.core.utilities.DockerImageUploadTest;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class CsReportsTest extends DockerImageUploadTest {
    @Test
    public void testReportByContainerId() throws Exception {
        CsContainerImage containerImage = getUploadedDockerImage();

        assertNotNull( containerImage );

        CsReport report = apiClient.getCsReportsApi().getReportByContainerId( containerImage.getId() );

        assertNotNull( report );
        assertTrue( report instanceof CsReport );
        assertNotNull( report.getId() );
        assertNotNull( report.getDockerImageId() );
    }

    @Test
    public void testReportByImageId() throws Exception {
        CsReport reportByImageId = apiClient.getCsReportsApi().getReportByImageId( dockerImageData.getId() );

        assertNotNull( reportByImageId );
        assertTrue( reportByImageId instanceof CsReport );
        assertNotNull( reportByImageId.getId() );
        assertNotNull( reportByImageId.getDockerImageId() );
    }

    @Test
    public void testReportByImageDigest() throws Exception {
        CsReport report = apiClient.getCsReportsApi().getReportByImageDigest( dockerImageData.getDigest() );

        assertNotNull( report );
        assertTrue( report instanceof CsReport );
        assertNotNull( report.getId() );
        assertNotNull( report.getDockerImageId() );
    }

    @Test
    public void testReportNessus() throws Exception {
        CsContainerImage containerImage = getUploadedDockerImage();

        String reportXml = apiClient.getCsReportsApi().getReportNessus( containerImage.getId() );

        assertNotNull( reportXml );
    }
}
