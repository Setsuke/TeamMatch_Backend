package com.teammatch.tournament.UnitTests.BBD.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PaymentTournamentCostStepDefinitionTest {

    private int initial;
    private int final_cost;

    @Given("the player wants to know the {int} of the tournament")
    public void thePlayerWantsToKnowTheEnrollmentCostOfTheTournament(int initial) {
        this.initial = initial;
    }

    @And("the system added {int} to make the payment")
    public void theSystemAddedTaxesToMakeThePayment(int added) {
        this.final_cost = this.initial + added;
    }

    @When("the player wants to pay the enrollment payment of the tournament")
    public void thePlayerWantsToPayTheEnrollmentPaymentOfTheTournament() {
    }

    @Then("he should have paid {int} successfully")
    public void heShouldHavePaidTotalEnrollmentPaymentSuccessfully(int final_cost) {
        assertEquals(this.final_cost,final_cost);
    }


}
