package Model;

public class EmployeeEntry {

    final private String name;
    final private String[] hoursWorked;
    private Double payment;

    public EmployeeEntry(String employeeInformationName, String[] employeeInformationHours, double employeePayment)
    {
        this.name = employeeInformationName;
        this.hoursWorked = employeeInformationHours;
        this.payment = employeePayment;
    }

    public Double getPayment()
    {
        return payment;
    }

    public String getName() {
        return name;
    }

    public String[] getHoursWorked() {
        return hoursWorked;
    }

    public void setPayment(Double employeePayment) {
        this.payment = employeePayment;
    }
}
