package com.tenable.io.core.utilities;


import com.tenable.io.core.exceptions.TenableIoErrorCode;
import com.tenable.io.core.exceptions.TenableIoException;
import com.tenable.io.core.utilities.models.DefaultXmlObject;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class NessusFileParser {
    private int currentCount;
    private final File nessusFile;
    private final int pagesize;
    private final String paginateObjectName;
    private NessusObject defaultObject;
    private Map<String, NessusObject> nessusObjectByName;
    private XMLStreamReader reader = null;


    /**
     * Instantiates a new Nessus file parser. Package-only visibility. Use NessusFileParserBuilder to build.
     *
     * @param nessusFile            the nessus file to parse
     * @param pagesize              the pagesize, or <= 0 to return all items
     * @param paginateObjectName    name of the node on which the pagination will occur. Must be passed if pagesize is > 0 otherwise can be null
     * @param nessusObjectByNameMap the nessus objects by name map
     * @param defaultObject         the default object. Can be null to default to the built in default object
     */
    NessusFileParser( File nessusFile, int pagesize, String paginateObjectName, Map<String, NessusObject> nessusObjectByNameMap, NessusObject defaultObject ) {
        this.currentCount = 0;
        this.nessusFile = nessusFile;
        this.pagesize = pagesize > 0 ? pagesize : 0;
        this.paginateObjectName = paginateObjectName;
        this.defaultObject = defaultObject == null ? new DefaultObject() : defaultObject;
        this.nessusObjectByName = nessusObjectByNameMap;
    }


    /**
     * Parse the whole nessus file object, regardless of the pagination parameters.
     * Note: calling this method after calling getNextPage() one or more times will lead to unpredictable results
     *
     * @return the deserialized object
     * @throws TenableIoException thrown if the nessus file cannot be found or when encountering deserialization error
     */
    public Object parseAll( String rootElementName ) throws TenableIoException {
        try {
            if( reader == null )
                reader = XMLInputFactory.newInstance().createXMLStreamReader( new FileInputStream( nessusFile ) );

            rootElementName = rootElementName.toLowerCase();
            while( reader.hasNext() && !( reader.next() == XMLStreamConstants.START_ELEMENT && reader.getLocalName().toLowerCase().equals( rootElementName ) ) );

            return reader.hasNext() ? handleStartElement( reader ) : null;
        } catch( FileNotFoundException e ) {
            throw new TenableIoException( TenableIoErrorCode.InvalidParameter, String.format( "File %s was not found.", nessusFile.getAbsolutePath() ), e );
        } catch( Exception e ) {
            throw new TenableIoException( TenableIoErrorCode.DeserializationError, String.format( "Deserialization error while parsing nessus %s.", nessusFile.getAbsolutePath() ), e );
        }
    }


    /**
     * Parses the next page's worth "paginateObjectName" object and returns it as a List of "paginateObjectName" objects.
     * Returns an empty list if the last items has been reached.
     *
     * @return the next page's worth "paginateObjectName" object and returns it as a List of "paginateObjectName" objects
     * @throws TenableIoException thrown if the nessus file cannot be found or when encountering deserialization error
     */
    public List<Object> getNextPage() throws TenableIoException {
        try {
            if( paginateObjectName == null )
                throw new TenableIoException( TenableIoErrorCode.InvalidParameter, "paginateObjectName needs to be set (during build time) to call getNextPage()" );

            if( reader == null )
                reader = XMLInputFactory.newInstance().createXMLStreamReader( new FileInputStream( nessusFile ) );

            List<Object> ret = new ArrayList( pagesize > 0 ? pagesize : 10 );
            while( true ) {
                while( reader.hasNext() && reader.next() != XMLStreamConstants.START_ELEMENT ) ;

                if( reader.hasNext() ) {
                    if( !reader.getLocalName().toLowerCase().equals( paginateObjectName ) )
                        continue;

                    ret.add( handleStartElement( reader ) );
                    currentCount++;
                    if( pagesize > 0 && currentCount % pagesize == 0 )
                        break;
                } else break;
            }
            return ret;

        } catch( FileNotFoundException e ) {
            throw new TenableIoException( TenableIoErrorCode.InvalidParameter, String.format( "File %s was not found.", nessusFile.getAbsolutePath() ), e );
        } catch( Exception e ) {
            throw new TenableIoException( TenableIoErrorCode.DeserializationError, String.format( "Deserialization error while parsing nessus %s.", nessusFile.getAbsolutePath() ), e );
        }
    }


    /**
     * Parses the current element parser element. This method must only be called when the given stream reader points to a START_ELEMENT
     *
     * @param r the stream reader
     * @return the deserialized element
     * @throws XMLStreamException
     */
    private Object handleStartElement( XMLStreamReader r ) throws XMLStreamException {
        String currentObjectName = r.getLocalName().toLowerCase();

        Map<String, String> attributes = new HashMap<>();
        for( int i = 0; i < r.getAttributeCount(); i++ )
            attributes.put( r.getAttributeLocalName( i ).toLowerCase(), r.getAttributeValue( i ) );

        NessusObject nessusObject = nessusObjectByName.containsKey( currentObjectName ) ? nessusObjectByName.get( currentObjectName ) : defaultObject;
        Object element = nessusObject.create( currentObjectName, attributes );

        while( r.hasNext() ) {
            switch( r.next() ) {
                case XMLStreamConstants.START_ELEMENT:
                    Object child = handleStartElement( r );
                    nessusObject.gotChild( element, child );
                    break;

                case XMLStreamConstants.CHARACTERS:
                    nessusObject.gotTextValue( element, r.getText() );
                    break;

                case XMLStreamConstants.END_ELEMENT:
                    return element;
            }
        }

        // should never happen the only return should be from END_ELEMENT
        return null;
    }


    /**
     * Default NessusObject implementation
     */
    private class DefaultObject extends NessusObject<DefaultXmlObject> {
        @Override
        public DefaultXmlObject create( String nodeName, Map<String, String> attributes ) {
            return new DefaultXmlObject().withName( nodeName ).withAttributes( attributes );
        }


        @Override
        public void gotChild( DefaultXmlObject currentObject, Object child ) {
            currentObject.addChild( child );
        }


        @Override
        public void gotTextValue( DefaultXmlObject currentObject, String text ) {
            currentObject.setValue( currentObject.getValue() == null ? text : currentObject.getValue() + text ); //need to do the append trick when the value had 0x0 characters -it ends up being broken in several chunk
        }
    }
}
