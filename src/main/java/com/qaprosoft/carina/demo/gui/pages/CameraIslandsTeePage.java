package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.gui.components.ProductInfo;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CameraIslandsTeePage extends AbstractPage {

    @FindBy(xpath = "//div[@class=\"grid__column grid__column--12 grid__column--5@sm\"]")
    private ProductInfo productInfo;

    public CameraIslandsTeePage(WebDriver driver) {
        super(driver);
    }

    public ProductInfo getProductInfo() {
        return productInfo;
    }
}
