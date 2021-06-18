package com.teammatch.tournament.BBD.stepdef;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreateRoomStepDefinitionTest {
    private long room;
    private long newRoom;


    @Given("the organizer wants to create {long} professional")
    public void theOrganizerWantsToCreateRoomProfessional(long room) {
        this.room= room;
    }

    @And("the system added {long} to the room")
    public void theSystemAddedIdToTheRoom(long Id) {
        this.newRoom=this.room + Id;
    }

    @When("when the organizer needs to recruit professional players")
    public void whenTheOrganizerNeedsToRecruitProfessionalPlayers() {
    }

    @Then("He creates {long} successfully")
    public void heCreatesRoomCreateSuccessfully(long newRoom) {
        assertEquals(this.newRoom, newRoom);
    }


}
