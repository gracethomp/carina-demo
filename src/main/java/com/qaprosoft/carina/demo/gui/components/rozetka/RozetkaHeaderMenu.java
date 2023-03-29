package com.qaprosoft.carina.demo.gui.components.rozetka;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class RozetkaHeaderMenu extends AbstractUIObject {
    @FindBy(xpath = "//li[contains(@class, 'user')]//button")
    private ExtendedWebElement loginButton;

    public RozetkaHeaderMenu(WebDriver driver) {
        super(driver);
    }

    public RozetkaHeaderMenu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public LoginMenu openLoginMenu(){
        loginButton.click();
        return new LoginMenu(driver);
    }
}
