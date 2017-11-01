package com.tenable.io.core.utilities;

import com.tenable.io.api.TenableIoClient;
import com.tenable.io.api.TestBase;
import com.tenable.io.api.containerSecurity.models.CsContainerImage;
import com.tenable.io.api.containerSecurity.models.CsTestJob;
import com.tenable.io.api.containerSecurity.models.CsTestJobImage;
import com.tenable.io.core.exceptions.TenableIoException;
import com.tenable.io.core.utilities.models.DockerImageUploadData;
import org.junit.After;
import org.junit.Before;

import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class DockerImageUploadTest extends TestBase {
    protected TenableIoClient apiClient;
    protected DockerImageUploadData dockerImageData;

    private int SLEEP_INTERVAL = 2000;

    @Before
    public void setUp() throws Exception {
        apiClient = new TenableIoClient();
        dockerImageData = new DockerImageHelper().uploadDockerImage( "test_image", "test_tag", false );

        CsTestJobImage testJob = null;

        do {
            try {
                Thread.sleep( SLEEP_INTERVAL );
            } catch( InterruptedException e ) {
            }
            testJob = getUploadedImageTestJob( dockerImageData.getDigest() );
        } while ( testJob == null || !testJob.getJobStatus().equals( CsTestJob.STATUS_COMPLETED ) );
    }

    @After
    public void tearDown() throws Exception {
        try {
            new DockerImageHelper().deleteDockerImage( dockerImageData.getDigest() );
        } 
        catch (TenableIoException e) {}
    }

    protected CsContainerImage getUploadedDockerImage() throws TenableIoException {
        List<CsContainerImage> result = apiClient.getCsImagesApi().list();

        assertNotNull( result );
        assertTrue( result.size() > 0 );
        assertTrue( result.get(0) instanceof CsContainerImage );

        for ( int i = 0; i < result.size(); i++ ) {
            CsContainerImage image = result.get( i );

            if ( image.getDigest().split( "sha256:" )[1].equals( dockerImageData.getDigest() )
                    && image.getName().equals( dockerImageData.getName() ) ) {
                return image;
            }
        }

        return null;
    }

    protected CsTestJobImage getUploadedImageTestJob( String imageDigest ) throws Exception {
        return apiClient.getCsTestJobsApi().getStatusByDockerImageDigest( imageDigest );
    }
}
