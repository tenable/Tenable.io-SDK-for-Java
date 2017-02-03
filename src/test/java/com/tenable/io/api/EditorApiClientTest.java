package com.tenable.io.api;


import com.tenable.io.api.editors.models.Template;
import com.tenable.io.api.editors.models.TemplateType;
import com.tenable.io.api.plugins.models.PluginDescription;
import com.tenable.io.api.policies.models.Policy;
import com.tenable.io.api.policies.models.PolicyDetail;

import com.tenable.io.api.editors.models.EditorDetail;
import org.junit.Test;

import java.util.List;
import java.util.Random;

import static org.junit.Assert.*;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class EditorApiClientTest extends TestBase {

    @Test
    public void testList() throws Exception {
        TenableIoClient apiClient = new TenableIoClient();
        List<Template> policyTemplates = apiClient.getEditorApi().list( TemplateType.POLICY );
        assertNotNull( policyTemplates );
        assertTrue( policyTemplates.size() > 0 );

        List<Template> scanTemplates = apiClient.getEditorApi().list( TemplateType.SCAN );
        assertNotNull( scanTemplates );
        assertTrue( scanTemplates.size() > 0 );
    }


    @Test
    public void testDetails() throws Exception {
        TenableIoClient apiClient = new TenableIoClient();
        List<Template> policyTemplates = apiClient.getEditorApi().list( TemplateType.POLICY );
        assertNotNull( policyTemplates );
        assertTrue( policyTemplates.size() > 0 );

        Random rand = new Random();
        int randomPolicyIndex = rand.nextInt( policyTemplates.size() );

        EditorDetail detail = apiClient.getEditorApi().details( TemplateType.POLICY, policyTemplates.get( randomPolicyIndex ).getUuid() );
        assertNotNull( detail );
        assertNotNull( detail.getSettings() );
    }


    @Test
    public void testAgent() throws Exception {
        TenableIoClient apiClient = new TenableIoClient();
        List<Template> policyTemplates = apiClient.getEditorApi().list( TemplateType.POLICY );
        assertNotNull( policyTemplates );
        assertTrue( policyTemplates.size() > 0 );

        Template agentTemplate = null;
        for( Template template : policyTemplates ) {
            if( template.isAgent() ) {
                agentTemplate = template;
                break;
            }
        }

        assertNotNull( agentTemplate );
        EditorDetail detail = apiClient.getEditorApi().details( TemplateType.POLICY, agentTemplate.getUuid() );
        assertNotNull( detail );

    }


    @Test
    public void testPluginDescription() throws Exception {
        TenableIoClient apiClient = new TenableIoClient();
        List<Policy> policies = apiClient.getPoliciesApi().list();
        assertNotNull( policies );
        Random random = new Random();
        int policyIndex = random.nextInt( policies.size() );
        PolicyDetail detail = apiClient.getPoliciesApi().details( policies.get( policyIndex ).getId() );
        assertNotNull( detail );
        PluginDescription description = apiClient.getEditorApi().pluginDescription( policies.get( policyIndex ).getId(), 12, 22372 );
        assertNotNull( description );
    }

}
