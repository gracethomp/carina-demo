package com.qaprosoft.carina.demo.gui.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ProductTile extends AbstractUIObject {

    @FindBy(xpath = "//div[@class='grid grid--gapless']//a")
    private ExtendedWebElement seeMoreButton;

    public ProductTile(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public ExtendedWebElement getSeeMoreButton() {
        return seeMoreButton;
    }
}
