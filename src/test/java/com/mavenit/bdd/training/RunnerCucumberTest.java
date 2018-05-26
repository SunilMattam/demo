package com.mavenit.bdd.training;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources",plugin = "json:target/rakesh.json")
public class RunnerCucumberTest {
}
