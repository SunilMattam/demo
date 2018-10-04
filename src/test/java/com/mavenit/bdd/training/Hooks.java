package com.mavenit.bdd.training;

import com.mavenit.bdd.training.drivers.DriverFactory;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

import java.net.MalformedURLException;

public class Hooks {

    DriverFactory driverFactory = new DriverFactory();

    @Before
    public void setUp() throws MalformedURLException {
        driverFactory.openBrowser();
        driverFactory.navigate("https://www.made.com/");
        driverFactory.maxWindow();
        driverFactory.applyImpWait();
        driverFactory.closeCookies();

    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            driverFactory.embedScreenshot(scenario);
        }
        driverFactory.closeBrowser();
    }

}
