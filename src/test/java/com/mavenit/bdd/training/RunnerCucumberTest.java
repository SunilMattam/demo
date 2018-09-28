package com.mavenit.bdd.training;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources",plugin = {"json:target/rakesh.json","html:target/cucumber.html"},dryRun = false,tags = "@register")
public class RunnerCucumberTest {
}
