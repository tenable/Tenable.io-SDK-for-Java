package com.tenable.io.api;

import com.tenable.io.api.assetImport.models.Asset;
import com.tenable.io.api.tags.models.*;
import com.tenable.io.core.exceptions.TenableIoException;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;


/**
 * Copyright (c) 2018 Tenable Network Security, Inc.
 */
public class TagsApiClientTest extends TestBase{
    @Before
    public void preChecks() throws TenableIoException {
        deleteTestTags();
        importTestAsset();
    }

    @Test
    public void testTags() throws Exception{
        // create
        String testTagName = getNewTestTagName();
        TagValueRequest request1 = new TagValueRequest();
        request1.withValue( "5" ).withCategoryName( testTagName ).withCategoryDescription( "Test case category" ).withDescription( "testing with name" );
        TagValue value1 = apiClient.getTagsApi().createValue( request1 );
        TagValueRequest request2 = new TagValueRequest();
        request2.withValue( "7" ).withCategoryUuid( value1.getCategoryUuid() ).withDescription( "testing with uuid" );
        TagValue value2 = apiClient.getTagsApi().createValue( request2 );
        assertNotNull( value1 );
        assertNotNull( value2 );
        assertNotNull( value1.getDescription() );
        assertNotNull( value2.getDescription() );

        // list
        ValueListResponse list = apiClient.getTagsApi().listTagValues();
        assertNotNull( list );

        // list tag values
        TagValue[] result = apiClient.getTagsApi().listTagValues().getValues();
        assertNotNull( result );
        assertTrue( list.getPagination().getTotal() == result.length);

        // details
        TagValue details1 = apiClient.getTagsApi().valueDetails( value1.getUuid() );
        TagValue details2 = apiClient.getTagsApi().valueDetails( value2.getUuid() );
        assertNotNull( details1 );
        assertNotNull( details2 );
        assertTrue( details1.getValue().equals( value1.getValue() ) );
        assertTrue( details2.getValue().equals( value2.getValue() ) );

        // modify value
        TagValueRequest valueUpdate = new TagValueRequest();
        valueUpdate.withValue( "13" ).withDescription( "changed value to 13" );
        apiClient.getTagsApi().editTagValue( value1.getUuid(), valueUpdate );
        details1 = apiClient.getTagsApi().valueDetails( value1.getUuid() );
        assertNotNull( details1 );
        assertTrue( details1.getCategoryName().equals( value1.getCategoryName() ) );

        // details by uuid of category and value
        TagValue details5 = apiClient.getTagsApi().detailsByUuids( value1.getCategoryUuid(), value1.getUuid() );
        assertNotNull( details5 );
        assertTrue( details5.getValue().equals( valueUpdate.getValue() ) );

        // assign tag to asset
        List<Asset> assets = apiClient.getAssetImportApi().getAssets();
        System.out.println( assets );
        String[] asset = { assets.get(0).getId() };
        String[] valueUuids = { value1.getUuid() };
        AssetAssignmentUpdate update = new AssetAssignmentUpdate();
        update.setAction( "add" );
        update.setAssets( asset );
        update.setValueUuids( valueUuids );
        apiClient.getTagsApi().createAssignment( update );

        // counts (should be true and 1)
        AssignmentCounts count = apiClient.getTagsApi().countValueAssets( value1.getUuid() );
        assertNotNull( count );
        assertTrue( count.isHasAssignments() );
        assertTrue( count.getCounts().size() == 1 );

        // remove tag from asset
        update.setAction( "remove" );
        apiClient.getTagsApi().createAssignment( update );

        // counts (should be false and 0)
        count = apiClient.getTagsApi().countValueAssets( value1.getUuid() );
        assertNotNull( count );
        assertFalse( count.isHasAssignments() );
        assertTrue( count.getCounts().size() == 0 );


        // delete
        apiClient.getTagsApi().deleteTagValue( value1.getUuid() );

        // verify delete
        result = apiClient.getTagsApi().listTagValues().getValues();
        boolean deleted = true;
        if ( result!=null ){
            for( TagValue items : result ){
                if( items.getUuid() == value1.getUuid() ) {
                    deleted = false;
                    break;
                }
            }
        }
        assertTrue( deleted );

        // create the deleted value to test bulk delete
        value1 = apiClient.getTagsApi().createValue( request1 );

        // bulk delete
        String[] valueIds = { value1.getUuid(),value2.getUuid() };
        apiClient.getTagsApi().deleteRequest( valueIds );

        // verify bulk delete
        result = apiClient.getTagsApi().listTagValues().getValues();
        deleted = true;
        if ( result!=null ){
            for( TagValue items : result ){
                if( items.getUuid() == value1.getUuid() || items.getUuid() == value2.getUuid() ) {
                    deleted = false;
                    break;
                }
            }
        }
        assertTrue( deleted );

    }

    @Test
    public void testCategories() throws Exception {
        // list
        CategoryListResponse list = apiClient.getTagsApi().listTagCategories();
        assertNotNull( list );

        // list categories
        TagCategory[] result = apiClient.getTagsApi().listTagCategories().getCategories();
        assertNotNull( result );
        assertTrue( list.getPagination().getTotal() == result.length );

        // create
        String testTagName = getNewTestTagName();
        TagCategory category1 = new TagCategory();
        category1.setName( testTagName );
        category1.setDescription( "Testing Categories" );
        category1 = apiClient.getTagsApi().createCategory( category1 );
        assertNotNull( category1 );
        assertNotNull( category1.getDescription() );

        // details
        TagCategory details3 = apiClient.getTagsApi().categoryDetails( category1.getUuid() );
        assertNotNull( details3 );
        assertTrue( details3.getName().equals( category1.getName() ) );

        // edit category
        String testTagName2 = getNewTestTagName();
        TagCategory category2 = new TagCategory();
        category2.setName( testTagName2 );
        category2.setDescription( "Testing Categories More" );
        category2 = apiClient.getTagsApi().editCategory( category1.getUuid(), category2 );
        details3 = apiClient.getTagsApi().categoryDetails( category1.getUuid() );
        assertNotNull( details3 );
        assertTrue( details3.getName().equals( category2.getName() ) );

        // list values given category
        TagValueRequest request3  = new TagValueRequest();
        request3.withValue( "13" ).withCategoryUuid( category1.getUuid() );
        TagValue a = apiClient.getTagsApi().createValue( request3 );
        request3.withValue( "11" );
        TagValue b = apiClient.getTagsApi().createValue( request3 );
        request3.withValue( "12" );
        TagValue c = apiClient.getTagsApi().createValue( request3 );
        List<TagValue> listValues = apiClient.getTagsApi().listCategoryValues( category1.getUuid() );
        assertNotNull( listValues );
        assertTrue( listValues.size() == 3 );

        // counts
        AssignmentCounts count = apiClient.getTagsApi().countCategoryAssets( category1.getUuid() );
        assertNotNull( count );

        // delete
        apiClient.getTagsApi().deleteCategory( category1.getUuid() );
        result = apiClient.getTagsApi().listTagCategories().getCategories();
        boolean deleted = true;
        if ( result != null ) {
            for ( TagCategory items : result ) {
                if ( items.getUuid() == category1.getUuid() ) {
                    deleted = false;
                    break;
                }
            }
        }
        assertTrue( deleted );
    }

    @Test
    public void testAssets() throws Exception{

        // Asset tags given asset Id
        List<AssetAssignment> details = apiClient.getTagsApi().assetTagAssignments( apiClient.getAssetImportApi().getAssets().get(0).getId() );
        assertNotNull( details );
    }
}
