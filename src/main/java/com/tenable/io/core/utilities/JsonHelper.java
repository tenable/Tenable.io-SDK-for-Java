package com.tenable.io.core.utilities;


import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.StringWriter;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class JsonHelper {
    private ObjectMapper objectMapper;


    /**
     * Instantiates a new Json helper.
     */
    public JsonHelper() {
        objectMapper = new ObjectMapper();
        objectMapper.configure( DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false );
        objectMapper.configure( DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true );
    }


    /**
     * Convert an object to JsonNode.
     *
     * @param data Value to convert in Json.
     * @return the serialize object into a JsonNode
     */
    public JsonNode toJson( final Object data ) {
        try {
            return objectMapper.valueToTree( data );
        } catch( Exception e ) {
            throw new RuntimeException( e );
        }
    }


    /**
     * Convert a JSON tree to string.
     *
     * @param json JsonNode to serialize to String.
     * @return the serialized JSON string
     */
    public String serialize( final JsonNode json ) {
        try {
            StringWriter writer = new StringWriter();
            final JsonGenerator jsonGenerator = objectMapper.getFactory().createGenerator( writer );
            objectMapper.writeTree( jsonGenerator, json );
            return writer.toString();
        } catch( Exception e ) {
            throw new RuntimeException( e );
        }
    }


    /**
     * Convert a JsonNode to a Java value
     *
     * @param <A>   the type parameter
     * @param json  Json value to convert.
     * @param clazz Expected Java value type.
     * @return the deserialized Java model
     */
    public <A> A fromJson( JsonNode json, Class<A> clazz ) {
        try {
            return objectMapper.treeToValue( json, clazz );
        } catch( Exception e ) {
            throw new RuntimeException( e );
        }
    }


    /**
     * Convert a JsonNode to a Java value
     * Example:   fromJson( jsonNode, new TypeReference&lt;ListModel&lt;MyModel&gt;&gt;() {} )
     *
     * @param <A>          the type parameter
     * @param json         Json value to convert.
     * @param valueTypeRef Expected Java value type.
     * @return the deserialized Java model
     */
    public <A> A fromJson( JsonNode json, TypeReference valueTypeRef ) {
        try {
            return objectMapper.readValue( json.traverse(), valueTypeRef );
        } catch( Exception e ) {
            throw new RuntimeException( e );
        }
    }


    /**
     * Convert a Json string to a Java value
     *
     * @param <A>   the type parameter
     * @param json  Json string to convert.
     * @param clazz Expected Java value type.
     * @return the deserialized Java model
     */
    public <A> A fromJson( String json, Class<A> clazz ) {
        try {
            return objectMapper.readValue( json, clazz );
        } catch( Exception e ) {
            throw new RuntimeException( e );
        }
    }


    /**
     * Convert a JsonNode to a Java value. Use this to deserialize into a generic type
     * Example:   fromJson( json, new TypeReference&lt;ListModel&lt;MyModel&gt;&gt;() {} )
     *
     * @param <A>          the type parameter
     * @param json         Json value to convert.
     * @param valueTypeRef Expected Java value type.
     * @return the deserialized Java model
     */
    public <A> A fromJson( String json, TypeReference valueTypeRef ) {
        try {
            return objectMapper.readValue( json, valueTypeRef );
        } catch( Exception e ) {
            throw new RuntimeException( e );
        }
    }


    /**
     * Creates a new empty ObjectNode.
     *
     * @return the ObjectNode
     */
    public ObjectNode newObject() {
        return objectMapper.createObjectNode();
    }


    /**
     * Creates a new empty ArrayNode.
     *
     * @return the ArrayNode
     */
    public ArrayNode newArrayNode() {
        return objectMapper.createArrayNode();
    }


    /**
     * Convert a JsonNode to its string representation.
     *
     * @param json the json
     * @return  the serialized JSON string
     */
    public String stringify( JsonNode json ) {
        return json.toString();
    }


    /**
     * Parse a String representing a json, and return it as a JsonNode.
     *
     * @param src the src
     * @return the deserialized src string into a JsonNode
     */
    public JsonNode parse( String src ) {
        try {
            return objectMapper.readValue( src, JsonNode.class );
        } catch( Throwable t ) {
            throw new RuntimeException( t );
        }
    }


    /**
     * Parse a InputStream representing a json, and return it as a JsonNode.
     *
     * @param src the src
     * @return the deserialized src stream into a JsonNode
     */
    public JsonNode parse( java.io.InputStream src ) {
        try {
            return objectMapper.readValue( src, JsonNode.class );
        } catch( Throwable t ) {
            throw new RuntimeException( t );
        }
    }
}
