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

    public ExtendedWebElement fillEmailField(String email){
        emailField.type(email);
        return emailField;
    }
    public ExtendedWebElement fillPasswordField(String password){
        passwordField.type(password);
        return passwordField;
    }
    public ExtendedWebElement clickLogInButton(){
        logInButton.click();
        return logInButton;
    }
    public void enterLogInHref(){
        System.out.println(logInButton.getAttribute("href"));
    }
}
