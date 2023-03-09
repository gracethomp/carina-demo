package com.qaprosoft.carina.demo.mobile.gui.pages.ios.gsmarena.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.components.LoginMenuBase;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LoginMenu extends LoginMenuBase {
    @FindBy(id = "email")
    private ExtendedWebElement loginField;

    public LoginMenu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public ExtendedWebElement getLoginField() {
        return loginField;
    }
}
