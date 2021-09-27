package Helpers;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValidation {

    private static String wrong_format = "\nThe format of the input is incorrect, please type ? " +
                                        "to see a well formatted example\n";

    private static String failure_parsing = "\n Failure when parsing start/end time, please check time inputs\n";

    private static String wrong_times = "\nStart time should be before end time, please check time inputs on ";

    private static String currentError;

    private static String lastValidInput;

    private static String example = "ASTRID=MO10:00-12:00,TH12:00-14:00,SU20:00-21:00";

    public static boolean inputIsCorrect(String input)
    {
        String[] employeeInformationNameHours;
        String employeeInformationName;
        String[] employeeInformationHours;
        String userInput = "empty";

        final Pattern employeeInputPatter = Pattern.compile("^\\s*[a-zA-Z]+=((MO|TU|WE|TH|FR|SA|SU)" +
                //This part of the regex covers {START-TIME}-{END-TIME}
                "(2[0-3]|[01]?[0-9]):([0-5]?[0-9])-(2[0-3]|[01]?[0-9]):([0-5]?[0-9]))" +
                //This part covers the repetition of multiple shifts {DA}{TIME}{TIME}
                "(,(MO|TU|WE|TH|FR|SA|SU)(2[0-3]|[01]?[0-9]):([0-5]?[0-9])" +
                "-(2[0-3]|[01]?[0-9]):([0-5]?[0-9]))*\\s*$", Pattern.CASE_INSENSITIVE);


        final Pattern helpPattern = Pattern.compile("^\\s*\\?\\s*$");
        final Pattern exitPattern = Pattern.compile("^\\s*exit\\s*$", Pattern.CASE_INSENSITIVE);
        final Pattern filePattern = Pattern.compile("^\\s*file\\s\\s*[a-zA-Z]+\\s*$",Pattern.CASE_INSENSITIVE);

        Matcher inputMatcher;

        // First part of the regex covers {NAME}={DAY}
        if (employeeInputPatter.matcher(input).find())
        {
            userInput = input.strip();
            employeeInformationNameHours = userInput.split("=", 2);
            employeeInformationName = employeeInformationNameHours[0];
            employeeInformationHours = employeeInformationNameHours[1].split(",", 0);

            for (String employeeInformationHour : employeeInformationHours) {
                String shiftInformation[] = employeeInformationHour.split("(?<=\\D)(?=\\d)", 2);
                String dayWorked = shiftInformation[0];
                String[] timeSlots = (shiftInformation[1]).split("-");
                String startTime = timeSlots[0];
                String endTime = timeSlots[1];
                LocalDateTime startTimeDate;
                LocalDateTime endTimeDate;
                try {
                    startTimeDate = DateTimeHandlers.createDate(dayWorked, startTime);
                    if (DateTimeHandlers.isMidnight(endTime))
                        dayWorked = DateTimeHandlers.getNextDay(dayWorked);
                    endTimeDate = DateTimeHandlers.createDate(dayWorked, endTime);
                } catch (DateTimeException e) {
                    e.printStackTrace();
                    setCurrentError(failure_parsing);
                    return false;
                }
                if (startTimeDate.isAfter(endTimeDate)) {
                    setCurrentError(wrong_times + employeeInformationHour + "\n");
                    return false;
                }
            }
            setLastValidInput(userInput);
            return true;
        }
        else if (helpPattern.matcher(input).find() || exitPattern.matcher(input).find() ||
                filePattern.matcher(input).find())
        {
            userInput = input.strip();
            if (filePattern.matcher(input).find())
            {
                String wordFile = userInput.split("\\s+",2)[0];
                String nameFile = userInput.split("\\s+",2)[1];
                userInput = wordFile.toUpperCase(Locale.ROOT) + " " + nameFile;
            }
            else
                userInput = userInput.toUpperCase(Locale.ROOT);
            setLastValidInput(userInput);
            return true;
        }
        else
        {
            setCurrentError(input.isEmpty() ? "" : wrong_format);
            return false;
        }
    }



    private static void setLastValidInput(String input)
    {
        lastValidInput = input;
    }

    private static void setCurrentError(String error)
    {
        currentError = error;
    }

    public static String getCurrentError()
    {
        return currentError;
    }

    public static String  getLastValidInput()
    {
        return lastValidInput;
    }

    public static  String getExample()
    {
        return example;
    }
}
