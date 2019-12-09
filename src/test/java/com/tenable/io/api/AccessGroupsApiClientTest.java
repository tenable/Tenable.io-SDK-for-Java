package com.tenable.io.api;

import com.tenable.io.api.accessGroups.models.*;
import com.tenable.io.api.editors.models.Filter;
import com.tenable.io.api.users.models.User;
import com.tenable.io.core.exceptions.TenableIoException;
import org.apache.http.NameValuePair;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Copyright (c) 2018 Tenable Network Security, Inc.
 */
public class AccessGroupsApiClientTest extends TestBase{
    @Before
    public void preChecks() throws TenableIoException {
        deleteTestAccessGroups();
    }

    @Test
    public void testAccessGroups() throws Exception{
        // create
        String testAccessGroupName = getNewTestAccessGroupName();
        AccessGroupRequest request1 = new AccessGroupRequest();

        AssetRule rule = new AssetRule();
        rule.setType( "ipv4" );
        rule.setOperator( "eq" );
        String[] terms = { "10.10.7.130" };
        rule.setTerms( terms );
        AssetRule[] rules = { rule } ;

        AssetRulePrincipal principal = new AssetRulePrincipal();
        principal.setType( AccessGroupPrincipalType.USER );
        User user = apiClient.getUsersApi().list().get( 0 );
        principal.setId( user.getUuid().toString() );
        principal.setName( user.getName() );
        principal.setPermissions( Collections.singletonList( AccessGroupPrincipalPermission.CAN_VIEW ) );
        AssetRulePrincipal[] principals = new AssetRulePrincipal[1];

        request1.withName( testAccessGroupName ).withRules( rules ).withAccessGroupType( AccessGroupType.MANAGE_ASSETS ).withPrincipals( Collections.singletonList( principal ).toArray(principals) );
        AccessGroup ag1 = apiClient.getAccessGroupsApi().createAccessGroup( request1 );
        assertNotNull ( ag1 );
        assertEquals(2, ag1.getPrincipals().length );

        // list and verify creation
        AccessGroupListResponse list = apiClient.getAccessGroupsApi().listAccessGroups();
        assertNotNull( list );
        boolean created = false;
        for( AccessGroup a : list.getAccessGroups() ){
            if( a.getName().equals( testAccessGroupName ) ){
                assertEquals(2, a.getPrincipals().length);
                assertEquals( 1, a.getPrincipals()[1].getPermissions().size() );
                assertEquals(AccessGroupType.MANAGE_ASSETS, a.getAccessGroupType());
                created = true;
            }
        }
        assertTrue( created );

        // list with optional params
        List<NameValuePair> params = new ArrayList();
        AccessGroupListResponse listWithParams = apiClient.getAccessGroupsApi().listAccessGroups( params );
        assertNotNull( listWithParams );

        // edit
        String testAccessGroupName2 = getNewTestAccessGroupName();
        AccessGroupRequest request2 = new AccessGroupRequest();
        AssetRule rule2 = new AssetRule();
        rule2.setType( "ipv4" );
        rule2.setOperator( "eq" );
        String[] terms2 = { "10.10.7.130", "10.10.10.28" };
        rule2.setTerms( terms2 );
        AssetRule[] rules2 = { rule2 } ;
        request2.withName( testAccessGroupName2 ).withRules( rules2 );
        AccessGroup ag2 = apiClient.getAccessGroupsApi().editAccessGroup( ag1.getId(), request2 );
        assertNotNull( ag2 );

        // details and verify edit
        AccessGroup details1 = apiClient.getAccessGroupsApi().accessGroupDetails( ag2.getId() );
        assertNotNull( details1 );
        assertTrue( details1.getName().equals( testAccessGroupName2 ));

        // list (filters for access groups)
        AccessGroupFilters agFilter = apiClient.getAccessGroupsApi().listFilters();
        assertNotNull( agFilter );

        // list (filters for rules)
        List<Filter> ruleFilter = apiClient.getAccessGroupsApi().listRuleFilters();
        assertNotNull( ruleFilter );

        // delete
        apiClient.getAccessGroupsApi().deleteAccessGroup( ag2.getId() );

        // verify delete
        list = apiClient.getAccessGroupsApi().listAccessGroups();
        boolean deleted = true;
        if ( list!=null ){
            for( AccessGroup items : list.getAccessGroups() ){
                if( items.getId() == ag2.getId() ) {
                    deleted = false;
                    break;
                }
            }
        }
        assertTrue( deleted );
    }
}
