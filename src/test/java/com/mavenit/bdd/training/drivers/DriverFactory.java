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
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class DriverFactory {

    private String browser = "chrome";
    public static WebDriver driver;

    public DriverFactory(){
        PageFactory.initElements(driver,this);
    }

    public void openBrowser() {
        switch (browser) {
            case "chrome":
                ChromeDriverManager.getInstance().setup();
                driver = new ChromeDriver();
                break;
            case "ie":
                InternetExplorerDriverManager.getInstance().setup();
                driver = new InternetExplorerDriver();
                break;
            case "opera":
                driver = new OperaDriver();
                break;
            default:
                FirefoxDriverManager.getInstance().setup();
                driver = new FirefoxDriver();
                break;
        }
    }

    public void closeCookies(){
        driver.findElement(By.linkText("GOT IT")).click();
    }

    public void closeBrowser(){
        driver.quit();
    }

    public void maxWindow(){
        driver.manage().window().maximize();
//        Dimension d = new Dimension(1280,1000);
//        //Resize the current window to the given dimension
//        driver.manage().window().setSize(d);
    }

    public void applyImpWait(){
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    public void navigate(String url){
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

    public void sleep(int ms){
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
