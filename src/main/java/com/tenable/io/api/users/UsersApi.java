package com.tenable.io.api.users;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import com.tenable.io.api.ApiWrapperBase;
import com.tenable.io.api.users.models.ApiKey;
import com.tenable.io.api.users.models.User;
import com.tenable.io.api.users.models.UserRole;
import com.tenable.io.core.exceptions.TenableIoException;
import com.tenable.io.core.services.AsyncHttpService;
import com.tenable.io.core.services.HttpFuture;


import java.util.List;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class UsersApi extends ApiWrapperBase {
    /**
     * Instantiates a new Users api.
     *
     * @param asyncHttpService the async http service
     * @param apiScheme        the api scheme
     * @param ApiHost          the api host
     */
    public UsersApi( AsyncHttpService asyncHttpService, String apiScheme, String ApiHost ) {
        super( asyncHttpService, apiScheme, ApiHost );
    }


    /**
     * Create a new user
     *
     * @param username    the username for the new user
     * @param password    the password for the new user
     * @param permissions the permissions for the new user
     * @param name        the name for the new user
     * @param email       the email for the new user
     * @param type        the type for the new user
     * @return the user
     * @throws TenableIoException the tenable IO exception
     */
    public User create( String username, String password, UserRole permissions, String name, String email, String type ) throws TenableIoException {
        CreateUserRequest request = new CreateUserRequest().withUsername( username).withPassword( password )
                .withPermissions( permissions).withName( name ).withEmail( email ).withType( type );
        HttpFuture httpFuture = asyncHttpService.doPost( createBaseUriBuilder( "/users" ).build(), request );
        return httpFuture.getAsType( User.class );
    }


    /**
     * Deletes a user given its user ID
     *
     * @param userId the user id
     * @throws TenableIoException the tenable IO exception
     */
    public void delete( int userId ) throws TenableIoException {
        HttpFuture httpFuture = asyncHttpService.doDelete( createBaseUriBuilder( "/users/" + userId ).build() );
        httpFuture.get();
    }


    /**
     * Edits the user details.
     *
     * @param userId      the user ID of the user to edit
     * @param permissions the new permission for the user
     * @param name        the new name for the user
     * @param email       the new email for the user
     * @param enabled     Boolean indicating whether the user's account is enabled.
     * @return the user
     * @throws TenableIoException the tenable IO exception
     */
    public User edit( int userId, UserRole permissions, String name, String email, Boolean enabled )
            throws TenableIoException {
        EditUserRequest request = new EditUserRequest().withPermissions( permissions ).withName( name )
                .withEmail( email).withEnabled( enabled );
        HttpFuture httpFuture = asyncHttpService.doPut( createBaseUriBuilder( "/users/" + userId ).build(), request );
        return httpFuture.getAsType( User.class );
    }


    /**
     * Gets the user corresponding to the given userId.
     *
     * @param userId the user ID of the user to fetch
     * @return the user corresponding to the given userID
     * @throws TenableIoException the tenable IO exception
     */
    public User details( int userId ) throws TenableIoException {
        HttpFuture httpFuture = asyncHttpService.doGet( createBaseUriBuilder( "/users/" + userId ).build() );
        return httpFuture.getAsType( User.class );
    }


    /**
     * Impersonates the user corresponding to the given userId
     *
     * @param userId the user id to impersonate
     * @throws TenableIoException the tenable IO exception
     */
    public void impersonate( int userId ) throws TenableIoException {
        HttpFuture httpFuture = asyncHttpService.doPost( createBaseUriBuilder( "/users/" + userId + "/impersonate" ).build(), null );
        httpFuture.get();
    }


    /**
     * Returns the user list
     *
     * @return the user list
     * @throws TenableIoException the tenable IO exception
     */
    public List<User> list() throws TenableIoException {
        HttpFuture httpFuture = asyncHttpService.doGet( createBaseUriBuilder( "/users" ).build() );
        return httpFuture.getAsType( new TypeReference<List<User>>() {}, "users" );
    }


    /**
     * Changes the password for the given user.
     *
     * @param userId          The unique id of the user
     * @param currentPassword Current password for the user.
     * @param password        New password for the user.
     * @throws TenableIoException the tenable IO exception
     */
    public void password( int userId, String currentPassword, String password ) throws TenableIoException {
        ChangePasswordRequest request = new ChangePasswordRequest().withPassword( password ).withCurrentPassword( currentPassword );
        HttpFuture httpFuture = asyncHttpService.doPut( createBaseUriBuilder( "/users/" + userId + "/chpasswd" ).build(), request );
        httpFuture.get();
    }


    /**
     * Gets the api access key and secret key for the user.
     *
     * @param userId the user id
     * @return the api key object containing the access key and secret key
     * @throws TenableIoException the tenable IO exception
     */
    public ApiKey keys( int userId ) throws TenableIoException {
        HttpFuture httpFuture = asyncHttpService.doPut( createBaseUriBuilder( "/users/" + userId +
                "/keys" ).build(), null );
        return httpFuture.getAsType( ApiKey.class );
    }


    /**
     * Enables or disables an existing user account.
     *
     * @param userId  The unique id of the user
     * @param enabled The user's enabled or disabled status to be set; when true the user will be enabled, and when
     *                false the user will be disabled
     * @return the updated user object
     * @throws TenableIoException the tenable IO exception
     */
    public User enabled( int userId, boolean enabled ) throws TenableIoException {
        EnableUserRequest request = new EnableUserRequest().withEnabled( enabled );
        HttpFuture httpFuture = asyncHttpService.doPut( createBaseUriBuilder( "/users/" + userId +
                "/enabled" ).build(), request );
        return httpFuture.getAsType( User.class );
    }


    /**
     * Enable or disable a user's two-factor authentication settings.
     *
     * @param userId       The unique id of the user.
     * @param emailEnabled Whether the two-factor authentication verification code should be additionally
     *                     sent as an e-mail.
     * @param smsEnabled   Whether two-factor authentication is enabled (and if enabled, it will be sent via SMS).
     *                     This effectively disables two-factor authentication for this user.
     * @throws TenableIoException the tenable IO exception
     */
    public void twoFactor( int userId, boolean emailEnabled, boolean smsEnabled ) throws TenableIoException {
        TwoFactorRequest request = new TwoFactorRequest().withEmailEnabled( emailEnabled ).withSmsEnabled( smsEnabled);
        HttpFuture httpFuture = asyncHttpService.doPut( createBaseUriBuilder( "/users/" + userId +
                "/two-factor" ).build(), request );
        httpFuture.get();

    }


    /**
     * Start the process of enabling two-factor authentication by sending a one-time verification code to the provided
     * phone number.
     *
     * @param userId The unique id of the user
     * @param phone  The phone number to use for two-factor authentication
     * @throws TenableIoException the tenable IO exception
     */
    public void twoFactorEnable( int userId, String phone ) throws TenableIoException {
        TwoFactorRequest request = new TwoFactorRequest().withSmsPhone( phone );
        HttpFuture httpFuture = asyncHttpService.doPost( createBaseUriBuilder( "/users/" + userId +
                "/two-factor/send-verification" ).build(), request );
        httpFuture.get();
    }


    /**
     * Validate the verification code sent to a phone number and enable two-factor authentication for the specified
     * user.
     *
     * @param userId           The unique id of the user
     * @param verificationCode The verification code that was sent
     * @throws TenableIoException the tenable IO exception
     */
    public void twoFactorEnableVerify( int userId, String verificationCode ) throws TenableIoException {
        TwoFactorRequest request = new TwoFactorRequest().withVerificationCode( verificationCode );
        HttpFuture httpFuture = asyncHttpService.doPost( createBaseUriBuilder( "/users/" + userId +
                "/two-factor/verify-code" ).build(), request );
        httpFuture.get();
    }


    @JsonInclude( JsonInclude.Include.NON_DEFAULT )
    private class TwoFactorRequest {
        private boolean emailEnabled;
        private boolean smsEnabled;
        private String smsPhone;
        private String verificationCode;


        @JsonProperty( "sms_phone" )
        public String getSmsPhone() {
            return smsPhone;
        }


        @JsonProperty( "sms_phone" )
        public void setSmsPhone( String smsPhone ) {
            this.smsPhone = smsPhone;
        }


        @JsonProperty( "verification_code" )
        public String getVerificationCode() {
            return verificationCode;
        }


        @JsonProperty( "verification_code" )
        public void setVerificationCode( String verificationCode ) {
            this.verificationCode = verificationCode;
        }


        @JsonProperty( "email_enabled" )
        public boolean isEmailEnabled() {
            return emailEnabled;
        }


        @JsonProperty( "email_enabled" )
        public void setEmailEnabled( boolean emailEnabled ) {
            this.emailEnabled = emailEnabled;
        }


        @JsonProperty( "sms_enabled" )
        public boolean isSmsEnabled() {
            return smsEnabled;
        }


        @JsonProperty( "sms_enabled" )
        public void setSmsEnabled( boolean smsEnabled ) {
            this.smsEnabled = smsEnabled;
        }

        public TwoFactorRequest withEmailEnabled( boolean emailEnabled ) {
            this.emailEnabled = emailEnabled;
            return this;
        }

        public TwoFactorRequest withSmsEnabled( boolean smsEnabled ) {
            this.smsEnabled = smsEnabled;
            return this;
        }

        public TwoFactorRequest withSmsPhone( String smsPhone ) {
            this.smsPhone = smsPhone;
            return this;
        }

        public TwoFactorRequest withVerificationCode( String verificationCode ) {
            this.verificationCode = verificationCode;
            return this;
        }
    }

    private class EnableUserRequest {
        private boolean enabled;


        public boolean isEnabled() {
            return enabled;
        }


        public void setEnabled( boolean enabled ) {
            this.enabled = enabled;
        }

        public EnableUserRequest withEnabled( boolean enabled ) {
            this.enabled = enabled;
            return this;
        }
    }

    private class CreateUserRequest {
        private String username;
        private String name;
        private String email;
        private String password;
        private UserRole permissions;
        private String type;


        public String getUsername() {
            return username;
        }


        public void setUsername( String username ) {
            this.username = username;
        }


        public String getName() {
            return name;
        }


        public void setName( String name ) {
            this.name = name;
        }


        public String getEmail() {
            return email;
        }


        public void setEmail( String email ) {
            this.email = email;
        }


        public String getPassword() {
            return password;
        }


        public void setPassword( String password ) {
            this.password = password;
        }


        public UserRole getPermissions() {
            return permissions;
        }


        public void setPermissions( UserRole permissions ) {
            this.permissions = permissions;
        }


        public String getType() {
            return type;
        }


        public void setType( String type ) {
            this.type = type;
        }


        public CreateUserRequest withUsername( String username ) {
            this.username = username;
            return this;
        }

        public CreateUserRequest withName( String name ) {
            this.name = name;
            return this;
        }

        public CreateUserRequest withEmail( String email ) {
            this.email = email;
            return this;
        }

        public CreateUserRequest withPassword( String password ) {
            this.password = password;
            return this;
        }

        public CreateUserRequest withPermissions( UserRole permissions ) {
            this.permissions = permissions;
            return this;
        }

        public CreateUserRequest withType( String type ) {
            this.type = type;
            return this;
        }


    }

    @JsonInclude( JsonInclude.Include.NON_NULL )
    private class EditUserRequest {
        private UserRole permissions;
        private String name;
        private String email;
        private Boolean enabled;


        public Boolean getEnabled() {
            return enabled;
        }


        public void setEnabled( Boolean enabled ) {
            this.enabled = enabled;
        }


        public UserRole getPermissions() {
            return permissions;
        }


        public void setPermissions( UserRole permissions ) {
            this.permissions = permissions;
        }


        public String getName() {
            return name;
        }


        public void setName( String name ) {
            this.name = name;
        }


        public String getEmail() {
            return email;
        }


        public void setEmail( String email ) {
            this.email = email;
        }

        public EditUserRequest withEnabled( Boolean enabled ) {
            this.enabled = enabled;
            return this;
        }

        public EditUserRequest withPermissions( UserRole permissions ) {
            this.permissions = permissions;
            return this;
        }

        public EditUserRequest withName( String name ) {
            this.name = name;
            return this;
        }

        public EditUserRequest withEmail( String email ) {
            this.email = email;
            return this;
        }
    }

    private class ChangePasswordRequest {
        private String password;
        private String currentPassword;


        @JsonProperty( "current_password" )
        public String getCurrentPassword() {
            return currentPassword;
        }


        @JsonProperty( "current_password" )
        public void setCurrentPassword( String currentPassword ) {
            this.currentPassword = currentPassword;
        }


        public String getPassword() {
            return password;
        }


        public void setPassword( String password ) {
            this.password = password;
        }


        public ChangePasswordRequest withPassword( String password ) {
            this.password = password;
            return this;
        }

        public ChangePasswordRequest withCurrentPassword( String currentPassword ) {
            this.currentPassword = currentPassword;
            return this;
        }
    }

}
