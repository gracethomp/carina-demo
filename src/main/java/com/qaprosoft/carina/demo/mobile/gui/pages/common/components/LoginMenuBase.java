package com.qaprosoft.carina.demo.mobile.gui.pages.common.components;

import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public abstract class LoginMenuBase extends AbstractUIObject {
    public LoginMenuBase(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }
}
