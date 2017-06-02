package com.tenable.io.api.policies.models;


import java.util.ArrayList;
import java.util.List;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class PolicyAuditCustomFeed {
    private List<PolicyAuditCustom> add;


    /**
     * Gets list of policy audits.
     *
     * @return the list of policy audits
     */
    public List<PolicyAuditCustom> getAdd() {
        return add;
    }


    /**
     * Sets the list of policy audits.
     *
     * @param add the list of policy audits
     */
    public void setAdd( List<PolicyAuditCustom> add ) {
        this.add = add;
    }


    /**
     * Adds a policy audits to the list.
     *
     * @param policyAuditCustom the PolicyAuditCustom object to add to the list
     */
    public void addPolicyAuditCustom( PolicyAuditCustom policyAuditCustom ) {
        if( add == null ) {
            add = new ArrayList<>();
        }

        add.add( policyAuditCustom );
    }
}
