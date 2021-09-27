package Helpers;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DateTimeHandlers {

    final private static String monday_date = "2021-09-06";
    final private static String tuesday_date = "2021-09-07";
    final private static String wednesday_date = "2021-09-08";
    final private static String thursday_date = "2021-09-09";
    final private static String friday_date = "2021-09-10";
    final private static String saturday_date = "2021-09-11";
    final private static String sunday_date = "2021-09-12";
    final private static String monday_e_date = "2021-09-13";

    public static LocalDateTime createDate(String dayWorked, String time)
    {
        switch (dayWorked)
        {
            case "MO":
                return LocalDateTime.parse(monday_date + " " + time, DateTimeFormatter.ofPattern("yyyy-MM-dd H:m"));
            case "TU":
                return LocalDateTime.parse(tuesday_date + " " + time, DateTimeFormatter.ofPattern("yyyy-MM-dd H:m"));
            case "WE":
                return LocalDateTime.parse(wednesday_date + " " + time, DateTimeFormatter.ofPattern("yyyy-MM-dd H:m"));
            case "TH":
                return LocalDateTime.parse(thursday_date + " " + time, DateTimeFormatter.ofPattern("yyyy-MM-dd H:m"));
            case "FR":
                return LocalDateTime.parse(friday_date + " " + time, DateTimeFormatter.ofPattern("yyyy-MM-dd H:m"));
            case "SA":
                return LocalDateTime.parse(saturday_date + " " + time, DateTimeFormatter.ofPattern("yyyy-MM-dd H:m"));
            case "SU":
                return LocalDateTime.parse(sunday_date + " " + time, DateTimeFormatter.ofPattern("yyyy-MM-dd H:m"));
            case "MO-E":
                return LocalDateTime.parse(monday_e_date + " " + time, DateTimeFormatter.ofPattern("yyyy-MM-dd H:m"));
            default:
                throw new IllegalStateException("Unexpected value: " + dayWorked);
        }
    }

    public static String getNextDay(String dayWorked) {
        switch (dayWorked)
        {
            case "MO":
                return "TU";
            case "TU":
                return "WE";
            case "WE":
                return "TH";
            case "TH":
                return "FR";
            case "FR":
                return "SA";
            case "SA":
                return "SU";
            case "SU":
                return "MO-E";
            default:
                throw new IllegalStateException("Unexpected value: " + dayWorked);
        }
    }

    public static Boolean isMidnight(String endTime) {
        final LocalTime midnight = LocalTime.parse("00:00", DateTimeFormatter.ofPattern("H:m"));
        return (LocalTime.parse(endTime, DateTimeFormatter.ofPattern("H:m")).equals(midnight));
    }
}
