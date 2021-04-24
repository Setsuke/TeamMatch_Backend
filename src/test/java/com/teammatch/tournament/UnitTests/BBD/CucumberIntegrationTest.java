package com.teammatch.tournament.UnitTests.BBD;

import com.teammatch.tournament.TournamentApplication;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.spring.CucumberContextConfiguration;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Scope;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static io.cucumber.spring.CucumberTestContext.SCOPE_CUCUMBER_GLUE;


@RunWith(Cucumber.class)
@CucumberContextConfiguration
@CucumberOptions(plugin = {"pretty"}, tags = "", features = "src/test/resources/features", strict = false,glue = "com.teammatch.tournament.UnitTests")
public class CucumberIntegrationTest {
}
