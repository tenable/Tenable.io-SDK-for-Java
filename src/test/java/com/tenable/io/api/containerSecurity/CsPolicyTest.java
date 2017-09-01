package com.tenable.io.api.containerSecurity;

import com.tenable.io.api.containerSecurity.models.CsPolicyCompliance;
import com.tenable.io.core.utilities.DockerImageUploadTest;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class CsPolicyTest extends DockerImageUploadTest {
    @Test
    public void testPolicyComplianceByImageId() throws Exception {
        CsPolicyCompliance csPolicyCompliance = apiClient.getCsPolicyApi().getPolicyComplianceByImageId( dockerImageData.getId() );

        assertNotNull( csPolicyCompliance );
        assertTrue( csPolicyCompliance instanceof CsPolicyCompliance );
        assertNotNull( csPolicyCompliance.getStatus() );
    }
}
