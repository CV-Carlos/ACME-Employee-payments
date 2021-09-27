package Controller;

import Helpers.DateTimeHandlers;
import Model.EmployeeEntry;
import Helpers.PaymentsInformation;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.LinkedHashMap;


public class CalculateSalary
{

    public static EmployeeEntry calculateNewEntry(String lastValidInput)
    {

        EmployeeEntry entry;

        String[] employeeInformationNameHours;
        String employeeInformationName;
        String[] employeeInformationHours;
        Double employeePayment = 0.00;

        employeeInformationNameHours = lastValidInput.split("=",2);
        employeeInformationName = employeeInformationNameHours[0];
        employeeInformationHours = employeeInformationNameHours[1].split(",",0);

        entry = new EmployeeEntry(employeeInformationName,employeeInformationHours, employeePayment);

        for (String employeeInformationHour : employeeInformationHours)
        {
            String dayWorked = employeeInformationHour.split("(?<=\\D)(?=\\d)",2)[0];
            String[] timeSlots =
                    (employeeInformationHour.split("(?<=\\D)(?=\\d)",2)[1]).split("-");
            employeePayment += determinePayment(dayWorked,timeSlots);
        }
        DecimalFormat formatPayment = new DecimalFormat("####0.00");
        entry.setPayment(Double.parseDouble(formatPayment.format(employeePayment)));

        return entry;
    }

    private static double determinePayment(String dayWorked, String[] employeeTimeSlots)
    {
        double payment = 0.00;

        LinkedHashMap<LocalDateTime[], Double> timeSlotsForDayWorked = PaymentsInformation.getTimeSlotsFor(dayWorked);

        LocalDateTime employeeStartTime = DateTimeHandlers.createDate(dayWorked, employeeTimeSlots[0]);
        if (DateTimeHandlers.isMidnight(employeeTimeSlots[1]))
            dayWorked = DateTimeHandlers.getNextDay(dayWorked);
        LocalDateTime employeeEndTime = DateTimeHandlers.createDate(dayWorked, employeeTimeSlots[1]);


        for (LocalDateTime[] timeSlot : timeSlotsForDayWorked.keySet())
        {
            LocalDateTime startTimeSlot = timeSlot[0];
            LocalDateTime endTimeSlot = timeSlot[1];

            Double paymentTimeSlot = timeSlotsForDayWorked.get(timeSlot);
            // Starting time is inside the time slot
            if ((employeeStartTime.equals(startTimeSlot) || (employeeStartTime.isAfter(startTimeSlot)))
                && (employeeStartTime.equals(endTimeSlot) || (employeeStartTime.isBefore(endTimeSlot))))
            {
                double minutes;
                // The end time is inside of time slot
                if ((employeeEndTime.equals(endTimeSlot) || (employeeEndTime.isBefore(endTimeSlot))))
                {
                    minutes = ChronoUnit.MINUTES.between(employeeStartTime,employeeEndTime);
                    payment += (minutes*paymentTimeSlot)/60;
                    return payment;
                }
                // End time is not inside the time slot, so calculate the time from the start time to
                // the end of the time slot, and transform the end of time slot (+1 min) to start time
                // for next iteration
                else
                {
                    minutes = ChronoUnit.MINUTES.between(employeeStartTime,endTimeSlot);
                    payment += (minutes*paymentTimeSlot)/60;
                    employeeStartTime = endTimeSlot.plusMinutes(1);
                }
            }
        }
        return payment;
    }
}
