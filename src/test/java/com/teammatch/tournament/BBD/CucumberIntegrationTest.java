package com.teammatch.tournament.BBD;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.spring.CucumberContextConfiguration;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberContextConfiguration
@CucumberOptions(plugin = {"pretty"}, tags = "", features = "src/test/resources/features", strict = false,glue = "com.teammatch.tournament")
public class CucumberIntegrationTest {
}
