package com.tenable.io.api.containerSecurity;

import com.fasterxml.jackson.core.type.TypeReference;
import com.tenable.io.api.ApiWrapperBase;
import com.tenable.io.api.containerSecurity.models.CsPolicyCompliance;
import com.tenable.io.core.exceptions.TenableIoException;
import com.tenable.io.core.services.AsyncHttpService;
import com.tenable.io.core.services.HttpFuture;

/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class CsPolicyApi extends ApiWrapperBase {

    /**
     * Instantiates a new Container security policy api.
     *
     * @param asyncHttpService the async http service
     * @param apiScheme the api scheme
     * @param ApiHost the api host
     */
    public CsPolicyApi( AsyncHttpService asyncHttpService, String apiScheme, String ApiHost ) {
        super( asyncHttpService, apiScheme, ApiHost );
    }

    /**
     * Gets policy compliance status by image id.
     *
     * @param imageId the image id
     * @return the report by image digest
     * @throws TenableIoException the tenable io exception
     */
    public CsPolicyCompliance getPolicyComplianceByImageId( String imageId ) throws TenableIoException {
        HttpFuture httpFuture = asyncHttpService.doGet( createBaseUriBuilder( containerSecurityBaseUrl + "/policycompliance" )
                .addParameter( "image_id", imageId ).build() );
        return httpFuture.getAsType( new TypeReference<CsPolicyCompliance>() {} );
    }

}
