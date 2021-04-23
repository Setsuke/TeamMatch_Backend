package com.teammatch.tournament.UnitTests.stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;

public class RetreieveGameStepDefinition {
    @Given("the user wants to get the information about a game with id {int}")
    public void theUserWantsToGetTheInformationAboutAGameWithId(int arg0) {
        Assertions.assertEquals(1,1);
    }

    @Then("the information about the Game will be retrieved successfully")
    public void theInformationAboutTheGameWillBeRetrievedSuccessfully() {
        Assertions.assertEquals(1,1);
    }

    @Then("the information about the Games will be retrieved successfully")
    public void theInformationAboutTheGamesWillBeRetrievedSuccessfully() {

        Assertions.assertEquals(1,1);
    }
}
