package com.tenable.io.api.tags;

import com.fasterxml.jackson.core.type.TypeReference;
import com.tenable.io.api.ApiWrapperBase;
import com.tenable.io.api.tags.models.*;
import com.tenable.io.core.exceptions.TenableIoException;
import com.tenable.io.core.services.AsyncHttpService;
import com.tenable.io.core.services.HttpFuture;

import java.util.List;


/**
 * Copyright (c) 2018 Tenable Network Security, Inc.
 */
public class TagsApi extends ApiWrapperBase {

    /**
     * Instantiates a new Tags api.
     *
     * @param asyncHttpService the async http service
     * @param apiScheme        the api scheme
     * @param ApiHost          the api host
     */
    public TagsApi( AsyncHttpService asyncHttpService, String apiScheme, String ApiHost ) {
        super( asyncHttpService, apiScheme, ApiHost );
    }


    /**
     * Returns the list of current tag values
     *
     * @return the list of tag values
     * @throws TenableIoException the tenable IO exception
     */
    public ValueListResponse listTagValues() throws TenableIoException {
        HttpFuture httpFuture = asyncHttpService.doGet( createBaseUriBuilder( "/tags/values" ).build() );
        return httpFuture.getAsType( ValueListResponse.class );
    }


    /**
     * Creates a new tag value.
     *
     * @param request the TagValueRequest to create value
     * @return the newly created tag with value
     * @throws TenableIoException the tenable IO exception
     */
    public TagValue createValue( TagValueRequest request ) throws TenableIoException {
        HttpFuture httpFuture = asyncHttpService.doPost( createBaseUriBuilder( "/tags/values" ).build(), request );
        return httpFuture.getAsType( TagValue.class );
    }


    /**
     * Returns details for the given tag value
     *
     * @return the list of tag values
     * @param valueUuid the id of the value
     * @throws TenableIoException the tenable IO exception
     */
    public TagValue valueDetails( String valueUuid ) throws TenableIoException {
        HttpFuture httpFuture = asyncHttpService.doGet( createBaseUriBuilder( "/tags/values/" + valueUuid ).build() );
        return httpFuture.getAsType( TagValue.class );
    }


    /**
     * Update an existing value category.
     *
     * @param valueUuid the uuid of the value
     * @param request the TagValueRequest to edit value category
     * @throws TenableIoException the tenable IO exception
     */
    public TagValue editTagValue( String valueUuid, TagValueRequest request ) throws TenableIoException {
        HttpFuture httpFuture = asyncHttpService.doPut( createBaseUriBuilder( "/tags/values/" + valueUuid ).build(), request );
        return httpFuture.getAsType( TagValue.class );
    }


    /**
     * Delete an existing category given value uuid
     *
     * @param valueUuid the uuid of the tag
     * @throws TenableIoException the tenable IO exception
     */
    public void deleteTagValue( String valueUuid ) throws TenableIoException {
        HttpFuture httpFuture = asyncHttpService.doDelete( createBaseUriBuilder( "/tags/values/" + valueUuid ).build() );
        httpFuture.get();
    }


    /**
     * Returns number of assets for the given tag value
     *
     * @return the count of assets for given tag value
     * @param valueUuid the id of the value
     * @throws TenableIoException the tenable IO exception
     */
    public AssignmentCounts countValueAssets( String valueUuid ) throws TenableIoException {
        HttpFuture httpFuture = asyncHttpService.doGet( createBaseUriBuilder( "/tags/values/" + valueUuid + "/counts" ).build() );
        return httpFuture.getAsType( AssignmentCounts.class );
    }


    /**
     * Bulk delete of tag Values.
     *
     * @param uuidList list of value uuids to be deleted
     * @throws TenableIoException the tenable IO exception
     */
    public void deleteRequest( String[] uuidList ) throws TenableIoException {
        ValueBulkRequest request = new ValueBulkRequest().withValues( uuidList );
        HttpFuture httpFuture = asyncHttpService.doPost( createBaseUriBuilder( "/tags/values/delete-requests" ).build(), request );
        httpFuture.get();
    }


    /**
     * Returns the list of tag categories.
     *
     * @return the list of tag categories
     * @throws TenableIoException the tenable IO exception
     */
    public CategoryListResponse listTagCategories() throws TenableIoException {
        HttpFuture httpFuture = asyncHttpService.doGet( createBaseUriBuilder( "/tags/categories/" ).build() );
        return httpFuture.getAsType( CategoryListResponse.class );
    }


    /**
     * Creates a new tag with category.
     *
     * @param  request the TagCategory to create category with.
     * @return the newly created tag with category
     * @throws TenableIoException the tenable IO exception
     */
    public TagCategory createCategory( TagCategory request ) throws TenableIoException {
        HttpFuture httpFuture = asyncHttpService.doPost( createBaseUriBuilder( "/tags/categories" ).build(), request );
        return httpFuture.getAsType( TagCategory.class );
    }


    /**
     * Returns the details for the given tag category.
     *
     * @return the tag category
     * @param categoryId the category id
     * @throws TenableIoException the tenable IO exception
     */
    public TagCategory categoryDetails( String categoryId ) throws TenableIoException {
        HttpFuture httpFuture = asyncHttpService.doGet( createBaseUriBuilder( "/tags/categories/" + categoryId ).build() );
        return httpFuture.getAsType( TagCategory.class );
    }


    /**
     * Modify the details for the given tag category.
     *
     * @param categoryId the id of the category to edit
     * @param request the TagCategory to edit the category with
     * @throws TenableIoException the tenable IO exception
     */
    public TagCategory editCategory( String categoryId, TagCategory request ) throws TenableIoException {
        HttpFuture httpFuture = asyncHttpService.doPut( createBaseUriBuilder( "/tags/categories/" + categoryId ).build(), request );
        return httpFuture.getAsType( TagCategory.class );
    }


    /**
     * Delete the given category
     *
     * @param categoryId the category id
     * @throws TenableIoException the tenable IO exception
     */
    public void deleteCategory( String categoryId ) throws TenableIoException {
        HttpFuture httpFuture = asyncHttpService.doDelete( createBaseUriBuilder( "/tags/categories/" + categoryId ).build() );
        httpFuture.get();
    }


    /**
     * Returns the list of values given category.
     *
     * @return the list of values given category
     * @param categoryId the category id
     * @throws TenableIoException the tenable IO exception
     */
    public ValueListResponse listCategoryValues( String categoryId ) throws TenableIoException {
        HttpFuture httpFuture = asyncHttpService.doGet( createBaseUriBuilder( "/tags/categories/" + categoryId + "/values" ).build() );
        return httpFuture.getAsType( ValueListResponse.class );
    }


    /**
     * Returns the details of value given category and value.
     *
     * @return the details of the value given category and value
     * @param categoryId the category id
     * @param valueId the valueId
     * @throws TenableIoException the tenable IO exception
     */
    public TagValue detailsByUuids( String categoryId, String valueId ) throws TenableIoException {
        HttpFuture httpFuture = asyncHttpService.doGet( createBaseUriBuilder( "/tags/categories/" + categoryId + "/values/" + valueId ).build() );
        return httpFuture.getAsType( TagValue.class );
    }


    /**
     * Returns number of assets for the given category
     *
     * @return the count of assets for given category
     * @param categoryUuid the id of the category
     * @throws TenableIoException the tenable IO exception
     */
    public AssignmentCounts countCategoryAssets( String categoryUuid ) throws TenableIoException {
        HttpFuture httpFuture = asyncHttpService.doGet( createBaseUriBuilder( "/tags/categories/" + categoryUuid + "/counts" ).build() );
        return httpFuture.getAsType( AssignmentCounts.class );
    }


    /**
     * Update or remove asset-tag assignments.
     *
     * @param request the AssetAssignmentUpdate request to update or remove assignments
     * @throws TenableIoException the tenable IO exception
     */
    public void createAssignment( AssetAssignmentUpdate request ) throws TenableIoException {
        HttpFuture httpFuture = asyncHttpService.doPost( createBaseUriBuilder( "/tags/assets/assignments" ).build(), request );
        httpFuture.get();
    }


    /**
     * Returns a list of the given asset's tags assignments.
     *
     * @param assetUuid the uuid of asset
     * @return list of the given asset's tags assignments
     * @throws TenableIoException the tenable IO exception
     */
    public List<AssetAssignment> assetTagAssignments( String assetUuid ) throws TenableIoException {
        HttpFuture httpFuture = asyncHttpService.doGet( createBaseUriBuilder( "/tags/assets/" + assetUuid + "/assignments" ).build() );
        return httpFuture.getAsType( new TypeReference<List<AssetAssignment>>() {}, "tags" );
    }


}

