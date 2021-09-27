package JUnitTests;

import Helpers.DateTimeHandlers;
import Helpers.InputValidation;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;

public class TestDateTimeHandlers {

    final private static LocalDateTime monday_date = LocalDateTime.parse("2021-09-06 09:00",
                                                    DateTimeFormatter.ofPattern("yyyy-MM-dd H:m"));
    final private static LocalDateTime tuesday_date = LocalDateTime.parse("2021-09-07 09:00",
                                                     DateTimeFormatter.ofPattern("yyyy-MM-dd H:m"));
    final private static LocalDateTime wednesday_date = LocalDateTime.parse("2021-09-08 09:00",
                                                       DateTimeFormatter.ofPattern("yyyy-MM-dd H:m")); 
    final private static LocalDateTime thursday_date = LocalDateTime.parse("2021-09-09 09:00",
                                                      DateTimeFormatter.ofPattern("yyyy-MM-dd H:m")); 
    final private static LocalDateTime friday_date = LocalDateTime.parse("2021-09-10 09:00",
                                                    DateTimeFormatter.ofPattern("yyyy-MM-dd H:m")); 
    final private static LocalDateTime saturday_date = LocalDateTime.parse("2021-09-11 09:00",
                                                      DateTimeFormatter.ofPattern("yyyy-MM-dd H:m")); 
    final private static LocalDateTime sunday_date = LocalDateTime.parse("2021-09-12 09:00",
                                                    DateTimeFormatter.ofPattern("yyyy-MM-dd H:m")); 
    final private static LocalDateTime monday_e_date = LocalDateTime.parse("2021-09-13 09:00",
                                                      DateTimeFormatter.ofPattern("yyyy-MM-dd H:m")); 
    @Test
    void tesCreateDateMonday()
    {
        assertEquals(DateTimeHandlers.createDate("MO","09:00"),monday_date);
    }

    @Test
    void tesCreateDateTuesday()
    {
        assertEquals(DateTimeHandlers.createDate("TU","09:00"),tuesday_date);
    }

    @Test
    void tesCreateDateWednesday()
    {
        assertEquals(DateTimeHandlers.createDate("WE","09:00"),wednesday_date);
    }

    @Test
    void tesCreateDateThursday()
    {
        assertEquals(DateTimeHandlers.createDate("TH","09:00"),thursday_date);
    }

    @Test
    void tesCreateDateFriday()
    {
        assertEquals(DateTimeHandlers.createDate("FR","09:00"),friday_date);
    }

    @Test
    void tesCreateDateSaturday()
    {
        assertEquals(DateTimeHandlers.createDate("SA","09:00"),saturday_date);
    }

    @Test
    void tesCreateDateSunday()
    {
        assertEquals(DateTimeHandlers.createDate("SU","09:00"),sunday_date);
    }

    @Test
    void tesCreateDateMondayE()
    {
        assertEquals(DateTimeHandlers.createDate("MO-E","09:00"),monday_e_date);
    }


    @Test
    void testIsMidnight()
    {
        assertTrue(DateTimeHandlers.isMidnight("00:00"));
        assertFalse(DateTimeHandlers.isMidnight("00:01"));
    }

    @Test
    void testGetNextDay()
    {
        assertEquals(DateTimeHandlers.getNextDay("MO"),"TU");
        assertEquals(DateTimeHandlers.getNextDay("TU"),"WE");
        assertEquals(DateTimeHandlers.getNextDay("WE"),"TH");
        assertEquals(DateTimeHandlers.getNextDay("TH"),"FR");
        assertEquals(DateTimeHandlers.getNextDay("FR"),"SA");
        assertEquals(DateTimeHandlers.getNextDay("SA"),"SU");
        assertEquals(DateTimeHandlers.getNextDay("SU"),"MO-E");
    }

}
