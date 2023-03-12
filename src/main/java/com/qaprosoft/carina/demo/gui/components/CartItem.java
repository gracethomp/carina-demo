package com.qaprosoft.carina.demo.gui.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CartItem extends AbstractUIObject {
    @FindBy(xpath = ".//input[@class='input-field__input']")
    private ExtendedWebElement quantityField;

    @FindBy(xpath = ".//p[@class='cart-item__variant-title']")
    private ExtendedWebElement choicesInfo;

    @FindBy(xpath = ".//a[@class='cart-item__title']")
    private ExtendedWebElement titleItem;

    public CartItem(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public ExtendedWebElement getChoicesInfo() {
        return choicesInfo;
    }

    public ExtendedWebElement getQuantityField() {
        return quantityField;
    }

    public ExtendedWebElement getTitleItem() {
        return titleItem;
    }
}
