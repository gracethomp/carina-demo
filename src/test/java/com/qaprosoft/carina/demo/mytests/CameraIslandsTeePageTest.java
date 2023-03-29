package com.qaprosoft.carina.demo.mytests;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.gui.components.ProductInfo;
import com.qaprosoft.carina.demo.gui.pages.gsmarena.CameraIslandsTeePage;
import com.qaprosoft.carina.demo.gui.pages.HomePage;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CameraIslandsTeePageTest implements IAbstractTest {

    @Test
    @MethodOwner(owner = "Khadzhynov Michael")
    public void testProductInfo() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();

        CameraIslandsTeePage cameraIslandsTeePage = homePage.getHeaderMenu()
                .openMerchMainPage()
                .clickCameraIslandsTee();

        ProductInfo productInfo = cameraIslandsTeePage.getProductInfo();
        Assert.assertTrue(productInfo.isUIObjectPresent(), "UI object wasn't present");

        Assert.assertEquals(productInfo.getProductInfoTitle().getText(), "CAMERA ISLANDS TEE (ON DARK)");
        Assert.assertTrue(productInfo.getProductInfoPrice().isVisible(), "Product price is not visible");
        Assert.assertTrue(productInfo.getProductDescription().isVisible(), "Product price is not visible");

        productInfo.getProductOptionColorButtons().forEach(e -> {
            e.click();
            Assert.assertTrue(e.isClickable(), "Button wasn't clickable");
        });
        productInfo.getProductOptionSizeButtons().forEach(e-> {
            e.click();
            Assert.assertTrue(e.isClickable(), "Button wasn't clickable");
        });
        productInfo.getProductOptionSizeButtons().get(3).click();
        productInfo.openSelectQuantityMenu().getOptions().forEach(e->{
            e.click();
            Assert.assertTrue(e.isSelected(), "Element wasn't selected");
        });

        Assert.assertTrue(productInfo.getAddToCartButton().isVisible(), "Add to cart button wasn't visible");
        Assert.assertTrue(productInfo.getAddToCartButton().isClickable(),"Add to cart button wasn't clickable");

        productInfo.getAdditionalInfoButtons().forEach(e->{
            e.click();
            Assert.assertFalse(e.getText().isEmpty());
        });
    }
}
