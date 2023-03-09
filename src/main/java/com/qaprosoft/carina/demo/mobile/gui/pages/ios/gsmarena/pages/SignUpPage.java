package com.qaprosoft.carina.demo.mobile.gui.pages.ios.gsmarena.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.SignUpPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class SignUpPage extends SignUpPageBase {
    @FindBy(id="Submit")
    private ExtendedWebElement submitButton;

    @FindBy(xpath = "//XCUIElementTypeOther[@name=\"Create account - GSMArena.com\"]" +
            "/XCUIElementTypeOther[7]/XCUIElementTypeOther[1]/XCUIElementTypeTextField")
    private ExtendedWebElement nicknameField;

    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    public SignUpPage fillNicknameField(String nickname) {
        nicknameField.type(nickname);
        return this;
    }

    public ExtendedWebElement getSubmitButton() {
        return submitButton;
    }
}
