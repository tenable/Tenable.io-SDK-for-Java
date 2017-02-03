package com.tenable.io.api.folders;


import com.tenable.io.api.TenableIoClient;
import com.tenable.io.api.folders.models.Folder;
import com.tenable.io.core.exceptions.TenableIoException;

import java.util.ArrayList;
import java.util.List;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class FolderHelper {

    public final String TYPE_CUSTOM = "custom";
    public final String TYPE_MAIN = "main";
    public final String TYPE_TRASH = "trash";

    private TenableIoClient client;


    /**
     * Instantiates a new Folder helper.
     *
     * @param client the client
     */
    public FolderHelper( TenableIoClient client ) {
        this.client = client;
    }


    /**
     * Retrieve folders.
     *
     * @return A list of FolderRef instances of all folders.
     * @throws TenableIoException the Tenable IO exception
     */
    public List<FolderRef> folders() throws TenableIoException {
        return folders( null, null, null );
    }


    /**
     * Retrieve folders by name.
     *
     * @param name the name of folders to retrieve
     * @return A list of FolderRef instances of all matching folders.
     * @throws TenableIoException the Tenable IO exception
     */
    public List<FolderRef> foldersByName( String name ) throws TenableIoException {
        return folders( name, null, null );
    }


    /**
     * Retrieve folders by name regular expression.
     *
     * @param regex Regular expression to match folder name with
     * @return A list of FolderRef instances of all matching folders.
     * @throws TenableIoException the Tenable IO exception
     */
    public List<FolderRef> foldersByRegex( String regex ) throws TenableIoException {
        return folders( null, regex, null );
    }


    /**
     * Retrieve folders by type.
     *
     * @param type The type of folders to return
     * @return A list of FolderRef instances of all matching folders.
     * @throws TenableIoException the Tenable IO exception
     */
    public List<FolderRef> foldersByType( String type ) throws TenableIoException {
        return folders( null, null, type );
    }


    /**
     * Retrieve a folder by ID.
     *
     * @param id the id of the folder to retrieve.
     * @return An instance of FolderRef for the folder. Null if not found.
     * @throws TenableIoException the Tenable IO exception
     */
    public Folder id( int id ) throws TenableIoException {
        List<Folder> folders = client.getFoldersApi().list();
        for( Folder folder : folders ) {
            if( folder.getId() == id ) {
                return folder;
            }
        }
        return null;
    }


    /**
     * Create a new folder.
     *
     * @param name The folder name.
     * @return The instance of FolderRef for the newly created folder.
     * @throws TenableIoException the Tenable IO exception
     */
    public FolderRef create( String name ) throws TenableIoException {
        int folderId = this.client.getFoldersApi().create( name );
        return new FolderRef( this.client, folderId );
    }


    /**
     * Get the trash folder
     *
     * @return An instance of FolderRef for the trash folder.
     * @throws TenableIoException the Tenable IO exception
     */
    public FolderRef trashFolder() throws TenableIoException {
        List<FolderRef> trashFolders = this.foldersByType( TYPE_TRASH );
        if( trashFolders.size() > 0 ) {
            return trashFolders.get( 0 );
        }
        return null;
    }


    /**
     * Get the main folder.
     *
     * @return An instance of FolderRef for the main folder.
     * @throws TenableIoException the Tenable IO exception
     */
    public FolderRef mainFolder() throws TenableIoException {
        List<FolderRef> mainFolders = this.foldersByType( TYPE_MAIN );
        if( mainFolders.size() > 0 ) {
            return mainFolders.get( 0 );
        }
        return null;
    }


    private List<FolderRef> folders( String name, String regex, String type ) throws TenableIoException {
        List<FolderRef> result = new ArrayList<>();
        List<Folder> folders = client.getFoldersApi().list();
        for( Folder folder : folders ) {
            if( name != null ) {
                if( folder.getName().equals( name ) ) {
                    result.add( new FolderRef( this.client, folder.getId() ) );
                }
            } else if( regex != null ) {
                if( folder.getName().matches( regex ) ) {
                    result.add( new FolderRef( this.client, folder.getId() ) );
                }
            } else if( folder != null ) {
                if( folder.getType().equals( type ) ) {
                    result.add( new FolderRef( this.client, folder.getId() ) );
                }
            } else {
                result.add( new FolderRef( this.client, folder.getId() ) );
            }
        }
        return result;
    }

}
