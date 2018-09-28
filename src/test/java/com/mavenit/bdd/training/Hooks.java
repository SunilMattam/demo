package com.mavenit.bdd.training;

import com.mavenit.bdd.training.drivers.DriverFactory;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {

    DriverFactory driverFactory = new DriverFactory();

    @Before
    public void setUp() {
        driverFactory.openBrowser();
        driverFactory.navigate("https://demo.nopcommerce.com/register");
        driverFactory.maxWindow();
        driverFactory.applyImpWait();
      //  driverFactory.closeCookies();

    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            driverFactory.embedScreenshot(scenario);
        }
        driverFactory.closeBrowser();
    }

}
