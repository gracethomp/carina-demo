package com.qaprosoft.carina.demo.mobile.gui.pages.ios.gsmarena.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.annotations.ClassChain;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.annotations.Predicate;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.SignUpPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class SignUpPage extends SignUpPageBase {
    @FindBy(id="Submit")
    private ExtendedWebElement submitButton;

    @FindBy(xpath = "//XCUIElementTypeOther[@name=\"Create account - GSMArena.com\"]" +
            "/XCUIElementTypeOther[7]/XCUIElementTypeOther[1]/XCUIElementTypeTextField")
    private ExtendedWebElement nicknameField;

    @FindBy(xpath = "**/XCUIElementTypeOther[`label == \"Create account - GSMArena.com\"`]" +
            "/XCUIElementTypeOther[7]/XCUIElementTypeOther[3]/XCUIElementTypeTextField")
    @ClassChain
    private ExtendedWebElement emailField;

    @FindBy(xpath = "//XCUIElementTypeOther[@name=\"Create account - GSMArena.com\"]" +
            "/XCUIElementTypeOther[8]/XCUIElementTypeSecureTextField")
    private ExtendedWebElement passwordField;

    @FindBy(xpath = "**/XCUIElementTypeSwitch[`value == \"0\"`][1]")
    @ClassChain
    private ExtendedWebElement agreementCheckbox;

    @FindBy(xpath = "//XCUIElementTypeOther[@name=\"Create account - GSMArena.com\"]" +
            "/XCUIElementTypeOther[9]/XCUIElementTypeSwitch[2]")
    private ExtendedWebElement ageCheckbox;

    @FindBy(id = "Please check your email and click on the link to finish the process. Thank you.")
    private ExtendedWebElement successMessage;

    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    public SignUpPage fillNicknameField(String nickname) {
        nicknameField.type(nickname);
        return this;
    }

    public SignUpPage fillEmailField(String email) {
        emailField.type(email);
        return this;
    }

    public SignUpPage fillPasswordField(String password){
        passwordField.type(password);
        return this;
    }

    public SignUpPage agreeTerms(){
        agreementCheckbox.click();
        return this;
    }

    public SignUpPage agreeAge(){
        ageCheckbox.click();
        return this;
    }

    public ExtendedWebElement getSubmitButton() {
        return submitButton;
    }

    public ExtendedWebElement getAgreementCheckbox() {
        return agreementCheckbox;
    }

    public ExtendedWebElement getSuccessMessage() {
        return successMessage;
    }
}
