package com.tenable.io.api.scans;


import org.junit.Test;

import java.util.Date;

/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class ScanActivityTest {
    @Test
    public void testCompareTo() {
        long currentTimeMillis = System.currentTimeMillis();
        ScanActivity scanActivity1 = new ScanActivity( null, null, null, null, null, null );
        ScanActivity scanActivity2 = new ScanActivity( null, new Date( currentTimeMillis ), null, null,
                null, null );
        ScanActivity scanActivity3 = new ScanActivity( null, new Date( currentTimeMillis - (long)1000 ), null, null,
                null, null );

        // null timestamps belong to running scans and placed at the front
        assert( scanActivity1.compareTo( scanActivity2 ) == -1 );
        assert( scanActivity2.compareTo( scanActivity3 ) == -1 );
        assert( scanActivity2.compareTo( scanActivity2 ) == 0 );
        assert( scanActivity3.compareTo( scanActivity1 ) == 1 );
        assert( scanActivity3.compareTo( scanActivity2 ) == 1);
    }
}
