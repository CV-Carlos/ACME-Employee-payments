package stepdefinitions;

import Controller.CalculateSalary;
import Helpers.InputValidation;
import Model.EmployeeEntry;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CalculatePaymentStepDefinitions {

    private EmployeeEntry entry;
    private String lastValidInput;
    private boolean inputValidationResult;

    @Given("{actor} worked on {employeeShift}")
    public void creatingEmployeeEntry(Actor actor, String employeeShift) {
        actor.entersTheScene();
        String input = new String(actor + "=" + employeeShift);
        this.inputValidationResult = InputValidation.inputIsCorrect(input);
        this.lastValidInput = InputValidation.getLastValidInput();
        assertTrue(this.inputValidationResult);
    }

    @When("{actor} checks what the payment is")
    public void companyChecksWhatThePaymentIs(Actor actor) {
        actor.entersTheScene();
        this.entry = CalculateSalary.calculateNewEntry(this.lastValidInput);
    }

    @Then("{actor} should see payment ${double}")
    public void companyShouldSeePayment$(Actor actor, double payment) {
        assertTrue(this.entry.getPayment() == payment);
    }

}