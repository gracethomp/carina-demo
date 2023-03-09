package com.qaprosoft.carina.demo.mobile.gui.pages.ios.gsmarena.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.HomePageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HomePage extends HomePageBase {
    @FindBy(xpath = "//XCUIElementTypeOther[@name=\"content information\"]")
    private ExtendedWebElement footer;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public ExtendedWebElement getFooter() {
        return footer;
    }
}
