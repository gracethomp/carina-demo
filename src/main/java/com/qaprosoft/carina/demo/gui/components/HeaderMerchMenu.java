package com.qaprosoft.carina.demo.gui.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.qaprosoft.carina.demo.gui.pages.CartPage;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HeaderMerchMenu extends AbstractUIObject {
    @FindBy(xpath = "//a[contains(@class, 'icon--cart')]")
    private ExtendedWebElement cartIcon;

    public HeaderMerchMenu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public CartPage openCartPage(){
        cartIcon.click();
        return new CartPage(driver);
    }
}
