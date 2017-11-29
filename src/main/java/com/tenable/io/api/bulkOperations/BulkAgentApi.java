package com.tenable.io.api.bulkOperations;

import com.tenable.io.api.ApiWrapperBase;
import com.tenable.io.api.bulkOperations.models.Task;
import com.tenable.io.core.exceptions.TenableIoException;
import com.tenable.io.core.services.AsyncHttpService;
import com.tenable.io.core.services.HttpFuture;

import java.net.URI;
import java.util.List;

/**
 * The type Bulk agent api.
 */
public class BulkAgentApi extends ApiWrapperBase {
    /**
     * Instantiates a new Bulk agent api.
     *
     * @param asyncHttpService the async http service
     * @param apiScheme        the api scheme
     * @param ApiHost          the api host
     */
    public BulkAgentApi( AsyncHttpService asyncHttpService, String apiScheme, String ApiHost ) {
        super( asyncHttpService, apiScheme, ApiHost );
    }

    /**
     * Add task.
     *
     * @param scannerId the scanner id
     * @param groupId   the group id
     * @param ids       the ids
     * @return the task
     * @throws TenableIoException the tenable io exception
     */
    public Task add( int scannerId, int groupId, List<Integer> ids ) throws TenableIoException {
        AddAgentRequest request = new AddAgentRequest().withItems( ids );
        HttpFuture httpFuture = asyncHttpService.doPost( getAgentGroupURI( scannerId, groupId, "/add" ), request );
        return httpFuture.getAsType( Task.class );
    }

    /**
     * Remove task.
     *
     * @param scannerId the scanner id
     * @param groupId   the group id
     * @param ids       the ids
     * @return the task
     * @throws TenableIoException the tenable io exception
     */
    public Task remove( int scannerId, int groupId, List<Integer> ids ) throws TenableIoException {
        AddAgentRequest request = new AddAgentRequest().withItems( ids );
        HttpFuture httpFuture = asyncHttpService.doPost( getAgentGroupURI( scannerId, groupId, "/remove" ), request );
        return httpFuture.getAsType( Task.class );
    }

    /**
     * Unlink task.
     *
     * @param scannerId the scanner id
     * @param ids       the ids
     * @return the task
     * @throws TenableIoException the tenable io exception
     */
    public Task unlink( int scannerId, List<Integer> ids ) throws TenableIoException {
        AddAgentRequest request = new AddAgentRequest().withItems( ids );
        HttpFuture httpFuture = asyncHttpService.doPost( getAgentsURI( scannerId, "/unlink" ), request );
        return httpFuture.getAsType( Task.class );
    }

    /**
     * Group status task.
     *
     * @param scannerId the scanner id
     * @param groupId   the group id
     * @param taskUuid  the task uuid
     * @return the task
     * @throws TenableIoException the tenable io exception
     */
    public Task groupStatus( int scannerId, int groupId, String taskUuid ) throws TenableIoException {
        HttpFuture httpFuture = asyncHttpService.doGet( getAgentGroupURI( scannerId, groupId, "/" + taskUuid ) );
        return httpFuture.getAsType( Task.class );
    }

    /**
     * Status task.
     *
     * @param scannerId the scanner id
     * @param taskUuid  the task uuid
     * @return the task
     * @throws TenableIoException the tenable io exception
     */
    public Task status( int scannerId, String taskUuid ) throws TenableIoException {
        HttpFuture httpFuture = asyncHttpService.doGet( getAgentsURI( scannerId, "/" + taskUuid ) );
        return httpFuture.getAsType( Task.class );
    }

    private URI getAgentGroupURI( int scannerId, int groupId, String additionalPath ) throws TenableIoException {
        return createBaseUriBuilder(getScannersPath( scannerId ) +
                "/agent-groups/" + groupId + "/agents/_bulk" + additionalPath).build();
    }

    private URI getAgentsURI( int scannerId, String additionalPath ) throws TenableIoException {
        return createBaseUriBuilder(getScannersPath( scannerId ) +
                "/agents/_bulk" + additionalPath).build();
    }

    private String getScannersPath( int scannerId ) {
        return "/scanners/" + scannerId;
    }

    private class AddAgentRequest {
        private List<Integer> items;

        /**
         * Gets items.
         *
         * @return the items
         */
        public List<Integer> getItems() {
            return items;
        }

        /**
         * Sets items.
         *
         * @param items the items
         */
        public void setItems( List<Integer> items ) {
            this.items = items;
        }

        /**
         * With items add agent request.
         *
         * @param items the items
         * @return the add agent request
         */
        public AddAgentRequest withItems( List<Integer> items ) {
            this.items = items;
            return this;
        }
    }
}
