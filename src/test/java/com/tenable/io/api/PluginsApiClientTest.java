package com.tenable.io.api;


import com.tenable.io.api.plugins.models.PluginDetail;
import com.tenable.io.api.plugins.models.PluginFamily;
import com.tenable.io.api.plugins.models.PluginFamilyDetail;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class PluginsApiClientTest extends TestBase {


    @Test
    public void testPlugins() throws Exception {
        List<PluginFamily> pluginFamilies = apiClient.getPluginsApi().families();

        assertNotNull( pluginFamilies );
        assertTrue( pluginFamilies.size() > 0 );

        PluginFamilyDetail familyDetails = apiClient.getPluginsApi().familyDetails( pluginFamilies.get( 0 ).getId() );
        assertNotNull( familyDetails );
        assertTrue( familyDetails.getId() > 0 );
        assertTrue( familyDetails.getPlugins().size() > 0 );

        PluginDetail pluginDetails = apiClient.getPluginsApi().pluginDetails( familyDetails.getPlugins().get( 0 ).getId() );
        assertNotNull( pluginDetails );
        assertTrue( pluginDetails.getFamilyName().equals( familyDetails.getName() ) );
    }


}
