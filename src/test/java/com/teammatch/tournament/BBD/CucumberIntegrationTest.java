package com.teammatch.tournament.BBD;

import com.teammatch.tournament.TournamentApplication;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.spring.CucumberContextConfiguration;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Scope;

import static io.cucumber.spring.CucumberTestContext.SCOPE_CUCUMBER_GLUE;


@RunWith(Cucumber.class)
@CucumberContextConfiguration
@SpringBootTest(classes = { TournamentApplication.class,
        CucumberIntegrationTest.class},
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@CucumberOptions(plugin = {"pretty"}, tags = "", features = "src/test/resources/features", strict = true)
@Scope(SCOPE_CUCUMBER_GLUE)
public class CucumberIntegrationTest {
}
