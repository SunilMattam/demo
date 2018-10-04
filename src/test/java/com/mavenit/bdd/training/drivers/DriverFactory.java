package com.mavenit.bdd.training.drivers;

import cucumber.api.Scenario;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import io.github.bonigarcia.wdm.InternetExplorerDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DriverFactory {

    private String browser = "chrome";
    public static WebDriver driver;

    public DriverFactory() {
        PageFactory.initElements(driver, this);
    }

    public void openBrowser() throws MalformedURLException {
        switch (browser) {
            case "chrome":
                ChromeDriverManager.getInstance().setup();
                DesiredCapabilities capabilities1 = new DesiredCapabilities().chrome();

                driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities1);
                break;
            case "ie":
                InternetExplorerDriverManager.getInstance().setup();
                driver = new InternetExplorerDriver();
                break;
            case "opera":
                driver = new OperaDriver();
                break;
            default:
//
                DesiredCapabilities capabilities = new DesiredCapabilities().firefox();

                driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
                break;
        }
    }

    public void closeCookies() {
        driver.findElement(By.linkText("GOT IT")).click();
    }

    public void closeBrowser() {
        driver.quit();
    }

    public void maxWindow() {
        driver.manage().window().maximize();
    }

    public void applyImpWait() {
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    public void navigate(String url) {
        driver.get(url);
    }

    public void embedScreenshot(Scenario scenario) {
        try {
            byte[] screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenShot, "image/png");
        } catch (WebDriverException e) {
            System.out.println("took screen shot. ");
        }

    }

    public void sleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
