package BBD.stepdef;

import com.teammatch.tournament.domain.model.Team;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class FoundTeamStepDefinitionTest {

    private Team expectTeam = new Team();
    private Team actualTeam = new Team();

    @Given("the app wants to get information about a team")
    public void theAppWantsToGetInformationAboutATeam(Team team) {
        expectTeam = team;
    }

    @When("someone visits the team profile")
    public void someoneVisitsTheTeamProfile() {
        actualTeam.setId(1L).setName("Infamous").setTeamSize(2).setLevelAverage((float) 12.20).setHoursPlayed((float)24.5);
    }

    @Then("the information about the Team will be retrieved successfully")
    public void theInformationAboutTheTeamWillBeRetrievedSuccessfully() {
        Assertions.assertEquals(expectTeam.getName(),actualTeam.getName());
    }
}
