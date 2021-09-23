/*
*           USER FACING - CLASS
*
* This
*
* */


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner_in = new Scanner(System.in);
        boolean continue_working = true;

        boolean date_is_valid = false;

      //  parseTimeSlotsDates();

        String employee_information;

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
                    "Type ? to see an example of it\n");

            while (InputValidation.inputIsCorrect(scanner_in) == false)
            {
                // Prevents the message from appear every time user press "Enter" with empty text
                //if (!scanner_in.next().isEmpty())
                    System.out.println(InputValidation.getCurrentError());
                scanner_in.nextLine();
            }
            if (InputValidation.getLastValidInput().equals("?"))
            {
                System.out.println("Example = ASTRID=MO10:00-12:00,TH12:00-14:00,SU20:00-21:00\n");
                continue;
            }
            else
            {
                EmployeeEntry entry = CalculateSalary.calculateNewEntry(InputValidation.getLastValidInput());
            }
//            else
//            employee_information = scanner_in.next().strip().toUpperCase();
            // if (EmployeeInformationValidation.validate(employee_information))
//            scanner_in.useDelimiter("\n");
//            System.out.println("Now, please insert the date when you are expecting to \n" +
//                    "transit on the streets in the format dd MMM yyyy, example 12 Jun 2021");
//            while (!date_is_valid)
//            {
//                scanner_in.nextLine();
//                while (!scanner_in.hasNext("\\s*(0?[1-9]|[12][0-9]|3[01])\\s[a-zA-Z][a-zA-Z][a-zA-Z]" +
//                        "\\s+\\d\\d\\d\\d\\s*"))
//                {
//                    System.out.println("That date does not seems to be correct,\n" +
//                            "remember the correct format is dd MMM yyyy, example 12 Jun 2021");
//                    scanner_in.nextLine();
//                }
//                date = scanner_in.next().strip().toUpperCase();
//                date_is_valid = verifyIfDateExists(date);
//                if (!date_is_valid)
//                    System.out.println("The date is invalid, please verify the date exist");
//            }
//            date_is_valid = false;
//            System.out.println("Finally, please insert do you expect to transit the streets\n" +
//                    "with the 24h format HH:mm, example 13:23 (01:23pm)");
//            scanner_in.nextLine();
//            while (!scanner_in.hasNext("\\s*([0-9]|0[0-9]|1[0-9]|2[0-3]):[0-5][0-9]\\s*"))
//            {
//                System.out.println("That time does not seems to be correct,\n" +
//                        "remember the correct 24h format is HH:mm, example 13:23 (01:23pm)");
//                scanner_in.nextLine();
//            }
//            time = scanner_in.next().strip();
//            scanner_in.nextLine();
//            UserRequest user_request = new UserRequest(employee_information,date,time);
//            System.out.println("Your inputs are:\n" +
//                    "License plate: " + employee_information + "\n" +
//                    "Date: " + date + "\n" +
//                    "Time: " + time);
//            System.out.println("===================================================\n");
//            System.out.println(verifyTransitIsAllowed(user_request));
//            System.out.println("===================================================\n");
//            System.out.println("Do you want to submit a new request? Type Yes(Y)/No(N)");
//            while (!scanner_in.hasNext("\\s*([y|Y][e|E][s|S]|[n|N][o|O])\\s*")
//                    && !scanner_in.hasNext("\\s*([y|Y]|[n|N]\\s*)"))
//            {
//                System.out.println("Please, answer Yes(Y) if you want to make another,\n" +
//                        "request or No(N) if you do not want to");
//                scanner_in.nextLine();
//            }
//            continue_working = scanner_in.hasNext("\\s*([y|Y][e|E][s|S]|([y|Y]))\\s*");
//            scanner_in.nextLine();
        }
        while (continue_working);
        System.out.println("Thanks for using this our services, good bye!");

    }
}
