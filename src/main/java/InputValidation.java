import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class InputValidation {

    private static String wrong_format = "\nThe format of the input is incorrect, please type ? " +
                                        "to see a well formatted example\n";

    private static String failure_parsing = "\n Failure when parsing start/end time, please check time inputs\n";

    private static String wrong_times = "\nStart time should be before end time, please check time inputs on ";

    private static String currentError;

    private static String lastValidInput;

    public static boolean inputIsCorrect(Scanner scanner)
    {
        String[] employeeInformationNameHours;
        String employeeInformationName;
        String[] employeeInformationHours;

        if (scanner.hasNext("\\s*[a-zA-Z]+=((MO|TU|WE|TH|FR|SA|SU)+" +
                "(2[0-3]|[01]?[0-9]):([0-5]?[0-9])-" +
                "(2[0-3]|[01]?[0-9]):([0-5]?[0-9]),?)*\\s*") ||
               scanner.hasNext("\\s*\\?\\s*"))
        {
            if (!scanner.hasNext("\\s*\\?\\s*"))
            {
                employeeInformationNameHours = scanner.next().toUpperCase(Locale.ROOT).strip().split("=",2);
                employeeInformationName = employeeInformationNameHours[0];
                employeeInformationHours = employeeInformationNameHours[1].split(",",0);

                for (String employeeInformationHour : employeeInformationHours)
                {
                    String[] timeSlots = (employeeInformationHour.split("(?<=\\D)(?=\\d)", 2)[1]).split("-");
                    String startTime = timeSlots[0];
                    String endTime = timeSlots[1];
                    LocalTime startTimeDate;
                    LocalTime endTimeDate;
                    try
                    {
                        startTimeDate = LocalTime.parse(startTime, DateTimeFormatter.ofPattern("H:m"));
                        endTimeDate = LocalTime.parse(endTime, DateTimeFormatter.ofPattern("H:m"));
                    } catch (DateTimeException e) {
                        e.printStackTrace();
                        setCurrentError(failure_parsing);
                        return false;
                    }
                    if (startTimeDate.isAfter(endTimeDate))
                    {
                        setCurrentError(wrong_times + employeeInformationHour + "\n");
                        return false;
                    }
                }
            }
            setLastValidInput(scanner.next());
            return true;
        }
        else
        {
            setCurrentError(scanner.next().isEmpty() ? "" : wrong_format);
            return false;
        }
    }

    private static void setLastValidInput(String input) {
        lastValidInput = input;
    }

    private static void setCurrentError(String error) {
        currentError = error;
    }

    public static String getCurrentError() {
        return currentError;
    }

    public static String  getLastValidInput() {
        return lastValidInput;
    }
}
