package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class YoutubePage extends AbstractPage {
    @FindBy(xpath = "//div[@id='main']")
    private ExtendedWebElement webElement;

    public YoutubePage(WebDriver driver) {
        super(driver);
    }

    public boolean isSubscribeWindowPresent() {
        return webElement.isElementPresent();
    }

}
