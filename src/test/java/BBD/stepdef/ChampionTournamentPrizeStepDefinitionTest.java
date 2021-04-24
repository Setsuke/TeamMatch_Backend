package BBD.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ChampionTournamentPrizeStepDefinitionTest {

    private int initial_prize;
    private int actual_prize;

    @Given("the user wants to know the {int} of the tournament")
    public void theUserWantsToKnowTheInitialPrizeOfTheTournament(int initial_prize) {
        this.initial_prize = initial_prize;
    }

    @And("the system added a new {int} to the tournament")
    public void theSystemAddedANewPlayerEnrollmentToTheTournament(int added_enrollment) {
        this.actual_prize = this.initial_prize+added_enrollment;
    }

    @When("I refresh the view")
    public void iRefreshTheView() {
    }

    @Then("the user will see the {int} of the tournament successfully")
    public void theUserWillSeeTheActualPrizeOfTheTournamentSuccessfully(int actual_prize) {
        assertEquals(this.actual_prize,actual_prize);
    }
}
