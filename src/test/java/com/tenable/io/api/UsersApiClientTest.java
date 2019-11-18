package com.tenable.io.api;


import com.tenable.io.api.users.models.ApiKey;
import com.tenable.io.api.users.models.UserRole;
import com.tenable.io.core.exceptions.TenableIoException;
import com.tenable.io.core.exceptions.TenableIoErrorCode;

import com.tenable.io.api.users.models.User;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class UsersApiClientTest extends TestBase {
    @Test
    public void testCreateAndDelete() throws Exception {
        User user = createTestUser( apiClient );

        assertNotNull( user );

        int userId = user.getId();

        apiClient.getUsersApi().delete( ( userId ) );

        try {
            User deletedUser = apiClient.getUsersApi().details( userId );
            fail( "User was not deleted" );
        } catch( TenableIoException e ) {
            assertEquals( e.getErrorCode(), TenableIoErrorCode.NotFound );
        }
    }


    @Test
    public void testUserDetails() throws Exception {
        List<User> users = apiClient.getUsersApi().list();

        assertTrue( users.size() > 0 );

        int userId = users.get( 0 ).getId();

        User user = apiClient.getUsersApi().details( userId );

        assertNotNull( user );

        assertNotNull( user.getUsername() );

    }


    @Test
    public void testEditUser() throws Exception {
        User user = createTestUser( apiClient );

        assertNotNull( user );

        int userId = user.getId();

        User updatedUser = apiClient.getUsersApi().edit( userId, UserRole.ADMINISTRATOR, "marco polo", getTestUsername( 1 ), false );

        assertEquals( updatedUser.getEmail(), getTestUsername( 1 ) );
        assertEquals( updatedUser.getName(), "marco polo" );
        assertEquals( updatedUser.getPermissions(), UserRole.ADMINISTRATOR );
        assertFalse( updatedUser.isEnabled() );

        updatedUser = apiClient.getUsersApi().edit( userId, UserRole.ADMINISTRATOR, "marco poloso", getTestUsername( 1 ), true );
        assertEquals( updatedUser.getEmail(), getTestUsername( 1 ) );
        assertEquals( updatedUser.getName(), "marco poloso" );
        assertTrue( updatedUser.isEnabled() );

        apiClient.getUsersApi().delete( ( userId ) );
    }


    @Test
    public void testImpersonateUser() throws Exception {
        List<User> users = apiClient.getUsersApi().list();

        assertTrue( users.size() > 0 );

        int userId = users.get( 0 ).getId();

        //TODO: this is currently failing 500 server error
        //apiClient.getUsersApi().impersonate(userId);

    }


    @Test
    public void testChangePassword() throws Exception {
        User user = createTestUser( apiClient );

        assertNotNull( user );

        int userId = user.getId();

        apiClient.getUsersApi().password( userId, "Password#12345", "Password#23456" );

        apiClient.getUsersApi().delete( ( userId ) );
    }


    @Test
    public void testUserKeys() throws Exception {
        User user = createTestUser( apiClient );

        assertNotNull( user );

        int userId = user.getId();

        ApiKey key = apiClient.getUsersApi().keys( userId );

        assertNotNull( key );
        assertNotNull( key.getAccessKey() );
        assertNotNull( key.getSecretKey() );

        apiClient.getUsersApi().delete( ( userId ) );
    }


    @Test
    public void testEnableDisabledUser() throws Exception {
        User user = createTestUser( apiClient );
        assertNotNull( user );
        int userId = user.getId();
        apiClient.getUsersApi().enabled( userId, false );

        User userDetail = apiClient.getUsersApi().details( userId );
        assertTrue( !userDetail.isEnabled() );

        apiClient.getUsersApi().enabled( userId, true );
        userDetail = apiClient.getUsersApi().details( userId );
        assertTrue( userDetail.isEnabled() );

        apiClient.getUsersApi().delete( ( userId ) );
    }


    @Test
    public void testTwoFactor() throws Exception {
        User user = createTestUser( apiClient );
        assertNotNull( user );
        int userId = user.getId();

        //TODO; this is not working it return error phone number not valid!!!
        //apiClient.getUsersApi().twoFactor(userId, true, true);

        User userDetail = apiClient.getUsersApi().details( userId );
        //assertTrue(!userDetail.isEnabled());

        apiClient.getUsersApi().delete( ( userId ) );
    }

    //TODO: add tests for twofactor
}
