package View;

import java.io.*;
import java.util.Scanner;

import Controller.CalculateSalary;
import Helpers.InputValidation;
import Model.EmployeeEntry;
import Helpers.PaymentsInformation;

/*
    Notice that this class make use of InputValidation for input sanitization
    and CalculateSalary to determine the employee payment
 */
public class Main {

    public static void main(String[] args) {

        Scanner scanner_in = new Scanner(System.in);
        scanner_in.useDelimiter("\n");
        boolean continue_working = true;

        PaymentsInformation.loadTimeSlots();

        System.out.println("===================================================\n");
        System.out.println("""
                Welcome this program will let you determine\s
                the exact salary an employee should be paid\s
                based on the hours she/he has worked\s
                """);
        System.out.println("===================================================");
        do
        {
            System.out.println("\nPlease insert the hours worked by the employee\n" +
                    "with the format {NAME}={DAY}{START-TIME}{END-TIME},{DAY}...\n" +
                    "Program uses first two day initials for {DAY} and\n" +
                    "24H format for {START-TIME} and {END-TIME}\n" +
                    "If you have a file, please input file {file-name}\n"  +
                    "Type ? to see an example of it\n" +
                    "Type exit to finish the program\n");

            if (scanner_in.hasNext())
            {
                if (!InputValidation.inputIsCorrect(scanner_in.next()))
                {
                    System.out.println(InputValidation.getCurrentError());
                    scanner_in.nextLine();
                }
                else
                {
                    if (InputValidation.getLastValidInput().equals("?"))
                    {
                        System.out.println("Example: " + InputValidation.getExample() + "\n");
                        continue;
                    }
                    else if (InputValidation.getLastValidInput().equals("EXIT"))
                        continue_working = false;
                    else if (InputValidation.getLastValidInput().startsWith("FILE"))
                    {
                        String filePath = InputValidation.getLastValidInput().split("\\s+", 2)[1];
                        try
                        {
                            File inputFile = new File(filePath);
                            FileReader inputFileReader = new FileReader(inputFile);
                            BufferedReader inputFileBuffer = new BufferedReader(inputFileReader);
                            String inputFileLine;
                            while ((inputFileLine = inputFileBuffer.readLine()) != null)
                            {
                                if(InputValidation.inputIsCorrect(inputFileLine))
                                {
                                    EmployeeEntry entry =
                                            CalculateSalary.calculateNewEntry(InputValidation.getLastValidInput());
                                    System.out.println("The amount to pay to " + entry.getName() + " is: "
                                            + entry.getPayment() + " USD");
                                }
                                else
                                {
                                    System.out.println(InputValidation.getCurrentError());
                                }

                            }
                        }
                        catch (FileNotFoundException exception)
                        {
                            System.out.println("File not found, please verify name");
                        }
                        catch (IOException exception)
                        {
                            System.out.println("Failure to read content on document, verify file contents");
                        }
                    }
                    else
                    {
                        EmployeeEntry entry = CalculateSalary.calculateNewEntry(InputValidation.getLastValidInput());
                        System.out.println("The amount to pay to " + entry.getName() + " is: "
                                                                                        + entry.getPayment() + " USD");
                    }
                }
            }
        }
        while (continue_working);
        System.out.println("Thanks for using this service, good bye!");
    }
}
