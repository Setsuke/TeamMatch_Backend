package com.teammatch.tournament.UnitTests.BBD.stepdef;

import com.teammatch.tournament.domain.model.Player;
import com.teammatch.tournament.domain.model.Team;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@ExtendWith(SpringExtension.class)
public class CreateTeamStepDefinitionTest {

    private Team addTeam = new Team();
    private Player expectPlayer = new Player();

    @Given("someone wants to get the information about a player")
    public void someoneWantsToGetTheInformationAboutAPlayer(Player player)
    {
        expectPlayer = player;
    }


    @When("the player create a team")
    public void thePlayerCreateATeam() {
        addTeam.setId(1L).setName("Infamous").setTeamSize(2).setLevelAverage((float) 12.20).setHoursPlayed((float)24.5);
    }


    @Then("the information about the team will be creating successfully")
    public void theInformationAboutTheTeamWillBeCreatingSuccessfully() {
        validateTeam();
    }
    private void validateTeam(){
        Assertions.assertEquals(addTeam.getId(),expectPlayer.getId());
    }
}
