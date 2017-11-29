package com.tenable.io.api;

import com.tenable.io.api.agentExclusions.models.Exclusion;
import com.tenable.io.api.scanners.models.Scanner;
import com.tenable.io.api.scans.models.RRules;
import com.tenable.io.api.scans.models.Schedule;
import com.tenable.io.core.utilities.SessionIdentifierGenerator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class AgentExclusionsApiClientTest extends TestBase {
    private TenableIoClient apiClient;
    private Scanner scanner;
    private Exclusion createdExclusion;

    @Before
    public void setUp() throws Exception {
        apiClient = new TenableIoClient();
        List<Scanner> scanners = apiClient.getScannersApi().list();
        assertNotNull( scanners );

        if ( scanners.size() == 0 ) {
            throw new Exception( "Container does not have any scanners." );
        } else {
            scanner = scanners.get( 0 );
        }

        //create and test agent exclusion
        SessionIdentifierGenerator hashGen = new SessionIdentifierGenerator();
        String name = "test_exclusion_" + hashGen.nextSessionId();
        createdExclusion = apiClient.getAgentExclusionsApi().create( scanner.getId(), name, "the test exclusion" );
        exclusionAsserts( createdExclusion );
    }
    @After
    public void tearDown() throws Exception {
        //delete and test created agent exclusion
        apiClient.getAgentExclusionsApi().delete( scanner.getId(), createdExclusion.getId() );

        List<Exclusion> exclusions = getExclusionList();

        for ( int i = 0; i < exclusions.size(); i++ ) {
            Exclusion exclusion = exclusions.get( i );
            exclusionAsserts( exclusion );
            assertNotEquals( exclusion.getId(), createdExclusion.getId() );
        }
    }

    @Test
    public void testList() throws Exception {
        boolean createdExclusionFound = false;
        List<Exclusion> exclusions = getExclusionList();
        assertNotEquals( exclusions.size(), 0 );

        for ( int i = 0; i < exclusions.size(); i++ ) {
            exclusionAsserts( exclusions.get( i ) );
            createdExclusionFound = exclusions.get( i ).getId() == createdExclusion.getId();
        }

        assertTrue( createdExclusionFound );
    }

    @Test
    public void testDetails() throws Exception {
        Exclusion exclusion = apiClient.getAgentExclusionsApi().details( scanner.getId(), createdExclusion.getId() );
        exclusionAsserts( exclusion );
        assertEquals( exclusion.getId(), createdExclusion.getId() );
        assertEquals( exclusion.getName(), createdExclusion.getName() );
    }

    @Test
    public void testEdit() throws Exception {
        SessionIdentifierGenerator hashGen = new SessionIdentifierGenerator();
        String newName = "test_exclusion_edited_" + hashGen.nextSessionId();

        String newDescription = "test exclusion edited description";

        RRules rules = new RRules();
        rules.setFreq( "WEEKLY" );
        rules.setInterval( 1 );
        rules.setByWeekDay( "SU,MO" );

        DateFormat dateFormat = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );
        Date todaysDate = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime( todaysDate );
        c.add( Calendar.DATE, 1 );
        Date tomorrowsDate = c.getTime();

        Schedule schedule = new Schedule();
        schedule.setEnabled( true );
        schedule.setTimezone( "+03:00" );
        schedule.setStartTime( dateFormat.format( todaysDate ) );
        schedule.setEndTime( dateFormat.format( tomorrowsDate ) );
        schedule.setrRules( rules );

        Exclusion editedExclusion = apiClient.getAgentExclusionsApi()
                .edit( scanner.getId(), createdExclusion.getId(), newName, newDescription, schedule );

        exclusionAsserts( editedExclusion );

        assertEquals( editedExclusion.getName(), newName );
        assertEquals( editedExclusion.getDescription(), newDescription );

        Schedule editedSchedule = editedExclusion.getSchedule();
        assertTrue( editedSchedule.isEnabled() );
        assertEquals( editedSchedule.getTimezone(), schedule.getTimezone() );
        assertEquals( editedSchedule.getStartTime(), schedule.getStartTime() );
        assertEquals( editedSchedule.getEndTime(), schedule.getEndTime() );

        RRules editedRules = editedSchedule.getrRules();
        assertNotNull( editedRules );
        assertEquals( editedRules.getFreq(), rules.getFreq() );
        assertEquals( editedRules.getInterval(), rules.getInterval() );
        assertEquals( editedRules.getByWeekDay(), rules.getByWeekDay() );

        createdExclusion = editedExclusion;
    }

    private List<Exclusion> getExclusionList() throws Exception {
        return apiClient.getAgentExclusionsApi().list( scanner.getId() );
    }

    private void exclusionAsserts( Exclusion exclusion ) {
        assertNotNull( exclusion );
        assertNotNull( exclusion.getId() );
        assertNotNull( exclusion.getName() );
        assertNotNull( exclusion.getSchedule() );
    }
}
