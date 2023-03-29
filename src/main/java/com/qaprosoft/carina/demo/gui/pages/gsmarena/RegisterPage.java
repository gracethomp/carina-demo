package com.qaprosoft.carina.demo.gui.pages.gsmarena;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends AbstractPage {
    @FindBy(id = "user-submit")
    private ExtendedWebElement userFormLink;

    @FindBy(id = "uname")
    private ExtendedWebElement nicknameField;

    @FindBy(xpath = "//div[@id='user-submit']//input[@id='email']")
    private ExtendedWebElement emailField;

    @FindBy(xpath = "//div[@id='user-submit']//input[@id='upass']")
    private ExtendedWebElement passwordField;

    @FindBy(xpath = "//label[@for='iagree1']")
    private ExtendedWebElement agreementCheckbox;

    @FindBy(xpath = "//label[@for='iagree2']")
    private ExtendedWebElement ageCheckbox;

    @FindBy(xpath = "//div[@class='normal-text res-success']")
    private ExtendedWebElement successSighUpMessage;

    @FindBy(xpath = "//div[@id='user-submit']//input[@id='nick-submit']")
    private ExtendedWebElement submitButton;

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    public ExtendedWebElement getUserFormLink() {
        return userFormLink;
    }

    public ExtendedWebElement getSuccessSighUpMessage() {
        return successSighUpMessage;
    }

    public RegisterPage fillNicknameField(String nickname) {
        nicknameField.type(nickname);
        return this;
    }
    public RegisterPage fillEmailField(String email) {
        emailField.type(email);
        return this;
    }
    public RegisterPage fillPasswordField(String password) {
        passwordField.type(password);
        return this;
    }
    public RegisterPage agreeStoringData(){
        agreementCheckbox.click();
        return this;
    }
    public RegisterPage agreeAge(){
        ageCheckbox.click();
        return this;
    }
    public RegisterPage clickSubmitButton(){
        submitButton.click();
        return this;
    }

    public RegisterPage fillSignUpForm(String nickname, String email, String password){
        fillNicknameField(nickname);
        fillEmailField(email);
        fillPasswordField(password);
        agreeStoringData();
        agreeAge();
        clickSubmitButton();
        return this;
    }
}
