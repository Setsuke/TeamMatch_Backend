package com.teammatch.tournament.UnitTests.BBD.stepdef;

import com.teammatch.tournament.domain.model.Player;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@ExtendWith(SpringExtension.class)
public class FoundPlayersPreferenceStepDefinitionTest {

    private Player expectPlayer = new Player();
    private Player actualPlayer = new Player();


    @Given("the user wants to search based on their player")
    public void theUserWantsToSearchBasedOnTheirPlayer(Player player) {
        expectPlayer = player;
    }

    @When("someone visits the player profile on their preference")
    public void someoneVisitsThePlayerProfileOnTheirPreference() {
        actualPlayer.setId(1l).setFirstName("Omar").setLastName("Marit").setGender("Hombre").setDescription("Play Valorant");
    }

    @Then("the information about the player about her preference is successfully")
    public void theInformationAboutThePlayerAboutHerPreferenceIsSuccessfully() {
        validatePlayer();
    }
    private void validatePlayer(){
        Assertions.assertEquals(expectPlayer.getId(),actualPlayer.getId());
    }
}
