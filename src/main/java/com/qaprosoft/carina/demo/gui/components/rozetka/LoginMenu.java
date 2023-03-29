package com.qaprosoft.carina.demo.gui.components.rozetka;

import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LoginMenu extends AbstractUIObject {
    @FindBy(xpath = "//button[contains(@class, 'register')]")
    private SignUpMenu signUpMenu;

    public LoginMenu(WebDriver driver) {
        super(driver);
    }

    public LoginMenu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public SignUpMenu openSignUpMenu(){
        signUpMenu.getRootExtendedElement().click();
        return new SignUpMenu(driver);
    }
}
