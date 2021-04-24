package com.teammatch.tournament.UnitTests.BBD.stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerLevelProgressStepDefinitionTest {
    private int initial_level;
    private int actual_level;

    @Given("the player wants to get his {int} level progress")
    public void thePlayerWantsToGetHisInitialLevelProgress(int initial_level) {
        this.initial_level = initial_level;

    }

    @When("he gains more experience {int} in game")
    public void heGainsMoreExperienceAddedInGame(int added) {
        this.actual_level = this.initial_level + added;
    }

    @Then("his {int} progress of the Game will be retrieved successfully")
    public void hisActualLevelProgressOfTheGameWillBeRetrievedSuccessfully(int actual_level) {
        assertEquals(this.actual_level, actual_level);
    }
}
