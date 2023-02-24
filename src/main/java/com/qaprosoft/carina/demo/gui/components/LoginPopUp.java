package com.qaprosoft.carina.demo.gui.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LoginPopUp extends AbstractUIObject {
    @FindBy(xpath = "//span[@id='login-popup2']//input[@id='email']")
    private ExtendedWebElement emailField;
    @FindBy(xpath = "//span[@id='login-popup2']//input[@id='upass']")
    private ExtendedWebElement passwordField;
    @FindBy(xpath = "//span[@id='login-popup2']//input[@id='nick-submit']")
    private ExtendedWebElement logInButton;

    public LoginPopUp(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public LoginPopUp fillEmailField(String email){
        emailField.type(email);
        return this;
    }
    public LoginPopUp fillPasswordField(String password){
        passwordField.type(password);
        return this;
    }
    public LoginPopUp clickLogInButton(){
        logInButton.click();
        return this;
    }
    public void fillLoginForm(String email, String password) {
        fillEmailField(email);
        fillPasswordField(password);
        clickLogInButton();
    }
}
