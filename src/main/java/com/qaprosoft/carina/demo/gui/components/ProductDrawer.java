package com.qaprosoft.carina.demo.gui.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ProductDrawer extends AbstractUIObject {
    @FindBy(xpath = "//a[@class='product-drawer__close']")
    private ExtendedWebElement closeProductDrawerButton;

    public ProductDrawer(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public ExtendedWebElement getCloseProductDrawerButton() {
        return closeProductDrawerButton;
    }
}
