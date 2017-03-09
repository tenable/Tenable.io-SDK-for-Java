package com.tenable.io.api.workbenches;


import com.tenable.io.api.models.AssetVulnerabilities;
import com.tenable.io.core.exceptions.TenableIoException;

import java.util.List;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public interface ParseWorkbenchByAsset extends AutoCloseable {
    /**
     * Parses the next page's worth of AssetVulnerabilities object and returns it.
     * Returns an empty list if the last items has been reached.
     *
     * @return the next page's worth of AssetVulnerabilities object
     * @throws TenableIoException thrown if a parameter is invalid or the nessus file cannot be found or when encountering deserialization error
     */
    List<AssetVulnerabilities> getNextAssetPage() throws TenableIoException;
}
