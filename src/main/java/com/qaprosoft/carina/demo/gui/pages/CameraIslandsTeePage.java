package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.gui.components.HeaderMerchMenu;
import com.qaprosoft.carina.demo.gui.components.ProductDrawer;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CameraIslandsTeePage extends AbstractPage {
    @FindBy(xpath = "//label[@title='Black']")
    private ExtendedWebElement blackColorLabel;

    @FindBy(xpath = "//label[@for='variant-XS']")
    private ExtendedWebElement XSRadioButton;

    @FindBy(xpath = "//select[@data-product='quantity']")
    private ExtendedWebElement dropdownButton;

    @FindBy(xpath = "//input[contains(@class, 'input-field')]")
    private ExtendedWebElement itemCountField;

    @FindBy(xpath = "//button[@data-product='add']")
    private ExtendedWebElement addToCartButton;

    @FindBy(xpath = "//div[@class='product-drawer']")
    private ProductDrawer productDrawer;

    @FindBy(xpath = "//header")
    private HeaderMerchMenu headerMerchMenu;

    @FindBy(xpath = "//option")
    private List<ExtendedWebElement> options;

    public CameraIslandsTeePage(WebDriver driver) {
        super(driver);
    }

    public CameraIslandsTeePage chooseColorBlack(){
        blackColorLabel.click();
        return this;
    }

    public CameraIslandsTeePage chooseXS(){
        XSRadioButton.click();
        return this;
    }

    public ExtendedWebElement getDropdownButton() {
        return dropdownButton;
    }

    public CameraIslandsTeePage chooseCustomCount(String count){
        dropdownButton.click();
        options.get(options.size() - 1).click();
        itemCountField.type(count);
        return this;
    }

    public ExtendedWebElement getAddToCartButton() {
        return addToCartButton;
    }

    public ProductDrawer getProductDrawer() {
        return productDrawer;
    }

    public HeaderMerchMenu getHeaderMerchMenu() {
        return headerMerchMenu;
    }
}
