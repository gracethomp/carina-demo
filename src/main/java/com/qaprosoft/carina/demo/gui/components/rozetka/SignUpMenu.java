package com.qaprosoft.carina.demo.gui.components.rozetka;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class SignUpMenu extends AbstractUIObject {
    @FindBy(id = "registerUserName")
    private ExtendedWebElement nameField;

    @FindBy(id = "registerUserSurname")
    private ExtendedWebElement surnameField;

    @FindBy(id = "registerUserPhone")
    private ExtendedWebElement phoneField;

    @FindBy(id = "registerUserEmail")
    private ExtendedWebElement emailField;

    @FindBy(id = "registerUserPassword")
    private ExtendedWebElement passwordField;

    @FindBy(xpath = "//form-error[@class='validation-message']")
    private List<ExtendedWebElement> validationMessages;

    @FindBy(xpath = "//form-error//*[local-name() = 'svg']")
    private List<ExtendedWebElement> errorListIcons;

    public SignUpMenu(WebDriver driver) {
        super(driver);
    }

    public SignUpMenu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public SignUpMenu fillNameField(String name){
        nameField.type(name);
        return this;
    }
    public SignUpMenu fillSurnameField(String surname){
        surnameField.type(surname);
        return this;
    }
    public SignUpMenu fillEmailField(String email){
        emailField.type(email);
        return this;
    }
    public SignUpMenu fillPhoneField(String phone){
        phoneField.type(phone);
        return this;
    }
    public SignUpMenu fillPasswordField(String password){
        passwordField.type(password);
        return this;
    }

    public List<ExtendedWebElement> getValidationMessages() {
        return validationMessages;
    }

    public List<ExtendedWebElement> getErrorListIcons() {
        return errorListIcons;
    }

    public List<String> getErrorListIconsColors() {
        List<String> colors = new ArrayList<>();
        for(ExtendedWebElement e : errorListIcons) {
            colors.add(e.getElement().getCssValue("fill"));
        }
        return colors;
    }
}
