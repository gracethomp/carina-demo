package com.qaprosoft.carina.demo.gui.components.dou;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LoginDialog extends AbstractUIObject {
    @FindBy(xpath = "//input[@id='agree-checkbox']")
    private ExtendedWebElement agreeCheckbox;
    public LoginDialog(WebDriver driver) {
        super(driver);
    }

    public LoginDialog(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public ExtendedWebElement getAgreeCheckbox() {
        return agreeCheckbox;
    }
}
