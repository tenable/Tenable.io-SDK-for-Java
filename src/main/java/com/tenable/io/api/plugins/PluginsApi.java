package com.tenable.io.api.plugins;


import com.fasterxml.jackson.core.type.TypeReference;
import com.tenable.io.api.ApiWrapperBase;
import com.tenable.io.api.plugins.models.PluginDetail;
import com.tenable.io.api.plugins.models.PluginFamily;
import com.tenable.io.api.plugins.models.PluginFamilyDetail;
import com.tenable.io.core.exceptions.TenableIoException;
import com.tenable.io.core.services.AsyncHttpService;
import com.tenable.io.core.services.HttpFuture;

import java.util.List;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class PluginsApi extends ApiWrapperBase {

    /**
     * Instantiates a new Plugins api.
     *
     * @param asyncHttpService the async http service
     * @param apiScheme        the api scheme
     * @param ApiHost          the api host
     */
    public PluginsApi( AsyncHttpService asyncHttpService, String apiScheme, String ApiHost ) {
        super( asyncHttpService, apiScheme, ApiHost );
    }


    /**
     * Returns the list of plugin families.
     *
     * @return the list of plugin families.
     * @throws TenableIoException the tenable IO exception
     */
    public List<PluginFamily> families() throws TenableIoException {
        HttpFuture httpFuture = asyncHttpService.doGet( createBaseUriBuilder( "/plugins/families" ).build() );
        return httpFuture.getAsType( new TypeReference<List<PluginFamily>>() {
        }, "families" );
    }


    /**
     * Returns the list of plugins in a family
     *
     * @param familyId The id of the family to lookup.
     * @return the plugin family detail
     * @throws TenableIoException the tenable IO exception
     */
    public PluginFamilyDetail familyDetails( int familyId ) throws TenableIoException {
        HttpFuture httpFuture = asyncHttpService.doGet( createBaseUriBuilder( "/plugins/families/" + familyId ).build() );
        return httpFuture.getAsType( PluginFamilyDetail.class );
    }


    /**
     * Returns details for a given plugin.
     *
     * @param pluginId the plugin id
     * @return the plugin detail
     * @throws TenableIoException the tenable IO exception
     */
    public PluginDetail pluginDetails( int pluginId ) throws TenableIoException {
        HttpFuture httpFuture = asyncHttpService.doGet( createBaseUriBuilder( "/plugins/plugin/" + pluginId ).build() );
        return httpFuture.getAsType( PluginDetail.class );
    }

}
