package com.qaprosoft.carina.demo.gui.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ProductInfo extends AbstractUIObject {

    @FindBy(xpath = ".//h1")
    private ExtendedWebElement productInfoTitle;

    @FindBy(xpath = ".//div[@class='product-info__price']//span")
    private ExtendedWebElement productInfoPrice;

    @FindBy(xpath = ".//div[@class='product-info__description']")
    private ExtendedWebElement productDescription;

    @FindBy(xpath = ".//div[@class='product-option product-option--COLOR']//div[@class='product-option__value product-option__value--regular']")
    private List<ExtendedWebElement> productOptionColorButtons;

    @FindBy(xpath = ".//div[@class='product-option product-option--SIZE']//div[@class='product-option__value product-option__value--size']")
    private List<ExtendedWebElement> productOptionSizeButtons;

    @FindBy(xpath = ".//select[@data-product=\"quantity\"]")
    private ExtendedWebElement productQuantitySelectMenu;

    @FindBy(xpath = ".//button[@class='button button--primary button--expand']")
    private ExtendedWebElement addToCartButton;

    @FindBy(xpath = ".//div[@class=\"product-info__additional-info\"]//div[@class='accordion']")
    private List<ExtendedWebElement> additionalInfoButtons;



    public ProductInfo(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public ExtendedWebElement getProductInfoTitle() {
        return productInfoTitle;
    }

    public ExtendedWebElement getProductInfoPrice() {
        return productInfoPrice;
    }

    public ExtendedWebElement getProductDescription() {
        return productDescription;
    }

    public List<ExtendedWebElement> getProductOptionColorButtons() {
        return productOptionColorButtons;
    }

    public List<ExtendedWebElement> getProductOptionSizeButtons() {
        return productOptionSizeButtons;
    }

    public Select openSelectQuantityMenu(){
        productQuantitySelectMenu.click();
        return new Select(productQuantitySelectMenu.getElement());
    }

    public ExtendedWebElement getAddToCartButton() {
        return addToCartButton;
    }

    public List<ExtendedWebElement> getAdditionalInfoButtons() {
        return additionalInfoButtons;
    }
}
