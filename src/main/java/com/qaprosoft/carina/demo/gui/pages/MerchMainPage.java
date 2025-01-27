package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.gui.components.ProductTile;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MerchMainPage extends AbstractPage {
    @FindBy(xpath = "//div[@class='grid__column grid__column--6 grid__column--3@md'][2]")
    private ProductTile cameraIslandsTeeTShirt;

    @FindBy(xpath = "//div[@class='grid__column grid__column--6 grid__column--3@md']")
    private List<ProductTile> productTiles;

    public MerchMainPage(WebDriver driver) {
        super(driver);
    }

    public List<ProductTile> getProductTiles() {
        return productTiles;
    }
}
