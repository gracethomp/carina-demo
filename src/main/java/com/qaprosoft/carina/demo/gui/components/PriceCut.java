package com.qaprosoft.carina.demo.gui.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class PriceCut extends AbstractUIObject {
    @FindBy(xpath = ".//div[@class='deal']//a[@class='store' and @href]")
    private ExtendedWebElement storeLink;
    public PriceCut(WebDriver driver) {
        super(driver);
    }

    public PriceCut(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public ExtendedWebElement getStoreLink() {
        return storeLink;
    }
}
