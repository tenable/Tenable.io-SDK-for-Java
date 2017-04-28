package com.tenable.io.api;


import com.tenable.io.api.exlusions.models.Exclusion;
import com.tenable.io.api.exlusions.models.ExclusionRequest;

import com.tenable.io.core.exceptions.TenableIoException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class ExclusionsApiClientTest extends TestBase {
    @Test
    public void testExclusions() throws Exception {

        TenableIoClient apiClient = new TenableIoClient();
        //list
        List<Exclusion> result = apiClient.getExclusionsApi().list();
        assertNotNull( result );

        ExclusionRequest request = new ExclusionRequest();
        String name = getNewTestExclusionName();
        request.withName( name ).withDescription( "test Description" ).withMembers( getTestUsername( 0 ) );
        //create
        Exclusion exclusion = apiClient.getExclusionsApi().create( request );
        assertNotNull( exclusion );

        assertTrue( exclusion.getName().equals( name ) );

        //details.
        Exclusion detail = apiClient.getExclusionsApi().details( exclusion.getId() );
        assertNotNull( detail );
        assertTrue( detail.getName().equals( name ) );

        //update.
        String updatedName = getNewTestExclusionName();
        request.setName( updatedName );
        apiClient.getExclusionsApi().edit( exclusion.getId(), request );

        //verify updated
        detail = apiClient.getExclusionsApi().details( exclusion.getId() );
        assertNotNull( detail );
        assertTrue( detail.getName().equals( updatedName ) );

        //delete.
        apiClient.getExclusionsApi().delete( exclusion.getId() );

        //verify deleted
        result = apiClient.getExclusionsApi().list();
        boolean deleted = true;
        if( result != null ) {
            for( Exclusion item : result ) {
                if( item.getId() == exclusion.getId() ) {
                    deleted = false;
                    break;
                }
            }
        }
        assertTrue( deleted );

    }


    @Before
    @After
    public void cleanup() throws TenableIoException {
        TenableIoClient apiClient = new TenableIoClient();

        deleteTestExclusions( apiClient );
    }
}
