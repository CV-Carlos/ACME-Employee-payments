package stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.ParameterType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.ensure.Ensure;

import java.sql.Time;

public class CalculatePaymentStepDefinitions {


    @Given("{actor} worked on {employeeShift}")
    public void creatingEmployeeEntry(Actor actor, String employeeShift) {
        throw new io.cucumber.java.PendingException();
    }

    @When("{actor} checks what the payment is")
    public void companyChecksWhatThePaymentIs(Actor actor) {
        throw new io.cucumber.java.PendingException();
    }

    @Then("{actor} should see payment ${double}")
    public void companyShouldSeePayment$(Actor actor, double payment) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

}