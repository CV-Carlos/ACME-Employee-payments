package Helpers;

import Helpers.DateTimeHandlers;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;

public class PaymentsInformation {

    private static LinkedHashMap<String[], Double> timeSlotsWeek = new LinkedHashMap<>();
    private static LinkedHashMap<String[], Double> timeSlotsWeekend = new LinkedHashMap<>();

    final private static int WEEK = 0;
    final private static int WEEKEND = 1;

    public static void loadTimeSlots()
    {
        // Monday to Friday
        addingSlotToMap(WEEK,"00:01","09:00",25.00);
        addingSlotToMap(WEEK,"09:01","18:00",15.00);
        addingSlotToMap(WEEK,"18:01","00:00",20.00);

        //Saturday to Sunday
        addingSlotToMap(WEEKEND,"00:01","09:00",30.00);
        addingSlotToMap(WEEKEND,"09:01","18:00",20.00);
        addingSlotToMap(WEEKEND,"18:01","00:00",25.00);
    }

    private static void addingSlotToMap(int day, String startTime, String endTime, Double payment)
    {
        String[] timeSlot = new String[]{startTime,endTime};
        if (day == WEEK)
            timeSlotsWeek.put(timeSlot,payment);
        else
            timeSlotsWeekend.put(timeSlot,payment);
    }

    public static LinkedHashMap<LocalDateTime[], Double> getTimeSlotsFor(String dayWorked)
    {
        switch (dayWorked)
        {
            case "MO","TU","WE","TH","FR":
                return createTimeSlotsMap(dayWorked, timeSlotsWeek);
            case "SA","SU":
                return createTimeSlotsMap(dayWorked, timeSlotsWeekend);
            default:
                throw new IllegalStateException("Unexpected value: " + dayWorked);
        }
    }

    private static LinkedHashMap<LocalDateTime[], Double> createTimeSlotsMap(String dayWorked,
                                                                             LinkedHashMap<String[],
                                                                                     Double> timeSlotsWeek)
    {
        LocalDateTime startTimeDate;
        LocalDateTime endTimeDate;

        LinkedHashMap<LocalDateTime[],Double> timeSlotsDateWeek = new LinkedHashMap<LocalDateTime[],Double>();

        for (String[] timeSlot: timeSlotsWeek.keySet())
        {
            startTimeDate = DateTimeHandlers.createDate(dayWorked,timeSlot[0]);
            if (timeSlot[1].equals("00:00"))
                dayWorked = DateTimeHandlers.getNextDay(dayWorked);
            endTimeDate = DateTimeHandlers.createDate(dayWorked,timeSlot[1]);
            LocalDateTime[] timeSlotsDate = new LocalDateTime[]{startTimeDate,endTimeDate};
            timeSlotsDateWeek.put(timeSlotsDate,timeSlotsWeek.get(timeSlot));
        }
        return timeSlotsDateWeek;
    }
}
