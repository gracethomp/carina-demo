package com.qaprosoft.carina.demo.gui.pages.gsmarena;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ReviewPage extends AbstractPage {
    @FindBy(xpath = "//h1[contains(text(), 'Reviews')]")
    private ExtendedWebElement titleMarker;

    public ReviewPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOpen(){
        return titleMarker.isElementPresent();
    }
}