package com.mavenit.bdd.training.page_objects;

import com.mavenit.bdd.training.drivers.DriverFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends DriverFactory {


    @FindBy(id = "gender-male")
    private WebElement genderRadioBtn;

    @FindBy(id = "FirstName")
    private WebElement firstNameTxt;

    @FindBy(id = "LastName")
    private WebElement lastNameTxt;

    @FindBy(id = "Email")
    private WebElement emailTxt;

    @FindBy(id = "Password")
    private WebElement password_txt;

    @FindBy(id = "ConfirmPasswordss")
    private WebElement confirmPasswordTxt;


    public void doRegister(String gender, String fn, String ln, String email, String password, String cpassword) {
        genderRadioBtn.click();
        firstNameTxt.sendKeys(fn);
        lastNameTxt.sendKeys(ln);
        emailTxt.sendKeys("rk@gmail.com");
        password_txt.sendKeys(password);
        confirmPasswordTxt.sendKeys(cpassword);
    }


}
