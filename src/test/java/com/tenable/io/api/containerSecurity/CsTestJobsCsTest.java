package com.tenable.io.api.containerSecurity;

import com.tenable.io.api.containerSecurity.models.CsTestJob;
import com.tenable.io.api.containerSecurity.models.CsTestJobImage;
import com.tenable.io.core.utilities.DockerImageUploadTest;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class CsTestJobsCsTest extends DockerImageUploadTest {
    @Test
    public void testStatusByJobId() throws Exception {
        CsTestJobImage currentImageTestJob = getUploadedImageTestJob();

        CsTestJob csTestJobById = apiClient.getCsTestJobsApi().getStatusByJobId( currentImageTestJob.getJobId() );

        assertNotNull( csTestJobById );
        assertTrue( csTestJobById instanceof CsTestJob );
        assertNotNull( csTestJobById.getContainerId() );
        assertNotNull( csTestJobById.getJobId() );
    }

    @Test
    public void testStatusByDockerImageId() throws Exception {
        CsTestJobImage testJob = apiClient.getCsTestJobsApi().getStatusByDockerImageId( dockerImageData.getId() );

        assertNotNull( testJob );
        assertTrue( testJob instanceof CsTestJobImage );
        assertNotNull( testJob.getContainerId() );
        assertNotNull( testJob.getJobId() );
    }

    @Test
    public void testStatusByDockerImageDigest() throws Exception {
        CsTestJobImage testJob = getUploadedImageTestJob();

        assertTrue( testJob instanceof CsTestJobImage );
        assertNotNull( testJob.getContainerId() );
        assertNotNull( testJob.getJobId() );
    }

    @Test
    public void testList() throws Exception {
        List<CsTestJob> csTestJobs = apiClient.getCsTestJobsApi().list();

        assertNotNull( csTestJobs );
        assertTrue( csTestJobs.size() > 0 );
        assertTrue( csTestJobs.get(0) instanceof CsTestJob );
        assertNotNull( csTestJobs.get(0).getContainerId() );
        assertNotNull( csTestJobs.get(0).getJobId() );
    }

    protected CsTestJobImage getUploadedImageTestJob() throws Exception {
        CsTestJobImage testJob = super.getUploadedImageTestJob( dockerImageData.getDigest() );

        assertNotNull( testJob );

        return testJob;
    }
}
