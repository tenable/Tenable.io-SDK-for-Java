package com.tenable.io.core.utilities;


import com.tenable.io.core.exceptions.TenableIoErrorCode;
import com.tenable.io.core.exceptions.TenableIoException;

import java.io.File;
import java.util.Map;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 *
 * The type Nessus file parser builder.
 */
public class NessusFileParserBuilder {
    private File nessusFile;
    private int pagesize;
    private String paginateObjectName;
    private Map<String, NessusObject> nessusObjectByNameMap;
    private NessusObject defaultObject;


    /**
     * The nessus file to parse.
     *
     * @param nessusFile he nessus file to parse
     * @return the nessus file parser builder
     */
    public NessusFileParserBuilder withNessusFile( File nessusFile ) {
        this.nessusFile = nessusFile;
        return this;
    }


    /**
     * The pagesize, or <= 0 to return all items. If its value is >0 then paginateObjectName needs to be set
     *
     * @param pagesize the pagesize, or <= 0 to return all items
     * @return the nessus file parser builder
     */
    public NessusFileParserBuilder withPagesize( int pagesize ) {
        this.pagesize = pagesize;
        return this;
    }


    /**
     * Name of the node on which the pagination will occur. Must be passed if pagesize is > 0 otherwise can be null.
     *
     * @param paginateObjectName name of the node on which the pagination will occur. Must be passed if pagesize is > 0 otherwise can be null
     * @return the nessus file parser builder
     */
    public NessusFileParserBuilder withPaginateObjectName( String paginateObjectName ) {
        this.paginateObjectName = paginateObjectName.toLowerCase();
        return this;
    }


    /**
     * Map of node-name => NessusObject.
     *
     * @param nessusObjectByNameMap Map of node-name => NessusObject
     * @return the nessus file parser builder
     */
    public NessusFileParserBuilder withNessusObjectByNameMap( Map<String, NessusObject> nessusObjectByNameMap ) {
        this.nessusObjectByNameMap = nessusObjectByNameMap;
        return this;
    }


    /**
     * The default object. Can be null to default to the built in default object.
     *
     * @param defaultObject The default object. Can be null to default to the built in default object
     * @return the nessus file parser builder
     */
    public NessusFileParserBuilder withDefaultObject( NessusObject defaultObject ) {
        this.defaultObject = defaultObject;
        return this;
    }


    /**
     * Creates nessus file parser
     *
     * @return the nessus file parser
     * @throws TenableIoException the tenable io exception if some parameters are incorrect
     */
    public NessusFileParser build() throws TenableIoException {
        if( nessusFile == null || nessusObjectByNameMap == null )
            throw new TenableIoException( TenableIoErrorCode.InvalidParameter, "Parameters nessusFile and nessusObjectByNameMap are mandatory" );

        if( pagesize > 0 && paginateObjectName == null )
            throw new TenableIoException( TenableIoErrorCode.InvalidParameter, "Parameter pagesize is specified but paginateObjectName is not" );

        return new NessusFileParser( nessusFile, pagesize, paginateObjectName, nessusObjectByNameMap, defaultObject );
    }
}