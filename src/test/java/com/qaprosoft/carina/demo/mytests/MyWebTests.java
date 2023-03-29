package com.qaprosoft.carina.demo.mytests;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.gui.components.FooterMenu;
import com.qaprosoft.carina.demo.gui.components.HeaderMenu;
import com.qaprosoft.carina.demo.gui.components.LoginPopUp;
import com.qaprosoft.carina.demo.gui.components.ProductDrawer;
import com.qaprosoft.carina.demo.gui.enums.FooterButton;
import com.qaprosoft.carina.demo.gui.enums.HeaderButton;
import com.qaprosoft.carina.demo.gui.pages.*;
import com.qaprosoft.carina.demo.gui.pages.gsmarena.*;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.core.registrar.tag.Priority;
import com.zebrunner.carina.core.registrar.tag.TestPriority;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Random;

public class MyWebTests implements IAbstractTest  {

    @Test()
    @MethodOwner(owner = "Olena Babii")
    @TestPriority(Priority.P1)
    public void testFooterMenu() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
        FooterMenu footerMenu = homePage.getFooterMenu();
        Assert.assertTrue(footerMenu.isUIObjectPresent(2), "Footer menu wasn't found!");
        Assert.assertTrue(footerMenu.isAllButtonsPresent(), "Some button aren't present");
        footerMenu.clickMenuButton(FooterButton.HOME);
        homePage.scrollDownToFooter();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
        footerMenu.clickMenuButton(FooterButton.NEWS);
        NewsPage newsPage = new NewsPage(getDriver());
        Assert.assertTrue(newsPage.isOpen(), "News page is not open");
        footerMenu.clickMenuButton(FooterButton.REVIEWS);
        ReviewPage reviewPage = new ReviewPage(getDriver());
        Assert.assertTrue(reviewPage.isOpen(), "Review page is not open");
        footerMenu.clickMenuButton(FooterButton.COMPARE);
        CompareModelsPage compareModelsPage = new CompareModelsPage(getDriver());
        Assert.assertTrue(compareModelsPage.isOpen(), "Review page is not open");
    }

    @Test()
    @MethodOwner(owner = "Olena Babii")
    @TestPriority(Priority.P1)
    public void testHeaderMenu() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
        HeaderMenu headerMenu = homePage.getHeaderMenu();
        Assert.assertTrue(headerMenu.isUIObjectPresent(2), "Header menu wasn't found!");
        Assert.assertTrue(headerMenu.isAllButtonsPresent(), "Some button aren't present");
        headerMenu.clickMenuButton(HeaderButton.HOME);
        headerMenu.openHomePage().isPageOpened();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
        headerMenu.clickMenuButton(HeaderButton.NEWS);
        NewsPage newsPage = new NewsPage(getDriver());
        Assert.assertTrue(newsPage.isOpen(), "News page is not open");
        headerMenu.clickMenuButton(HeaderButton.REVIEWS);
        ReviewPage reviewPage = new ReviewPage(getDriver());
        Assert.assertTrue(reviewPage.isOpen(), "Review page is not open");
        headerMenu.clickMenuButton(HeaderButton.VIDEOS);
        VideoPage videoPage = new VideoPage(getDriver());
        Assert.assertTrue(videoPage.isOpen(), "Video page is not open");
    }

    @Test()
    @MethodOwner(owner = "Olena Babii")
    @TestPriority(Priority.P3)
    public void testSignUpMenu() {
        Random random = new Random();
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
        HeaderMenu header = homePage.getHeaderMenu();
        Assert.assertTrue(header.isUIObjectPresent(2), "Header menu wasn't found!");
        RegisterPage registerPage = header.openRegisterPage();
        registerPage.getUserFormLink().scrollTo();
        registerPage.fillSignUpForm("gracetom" + random.nextInt(10000),
                "gracetom" + random.nextInt(10000) +"@mail.com", "qwe123");
        Assert.assertTrue(registerPage.getSuccessSighUpMessage().isElementPresent(), "Registration is failed");
    }

    @Test()
    @MethodOwner(owner = "Olena Babii")
    @TestPriority(Priority.P4)
    public void testLogInMenu() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
        HeaderMenu headerMenu = homePage.getHeaderMenu();
        LoginPopUp loginPopUp = headerMenu.openLoginPopUp();
        loginPopUp.fillLoginForm("gracetomlinson26@gmail.com", "qwe123");
        Assert.assertEquals(getDriver().getCurrentUrl(), "https://www.gsmarena.com/login.php3",
                "Next page isn't open");
    }

    @Test()
    @MethodOwner(owner = "Olena Babii")
    public void testIncreasingImage() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        homePage.getHonorImage().hover();
        Assert.assertTrue(homePage.isImageIncrease(), "No increasing!");
    }

    @Test()
    @MethodOwner(owner = "Olena Babii")
    public void testYoutubePage(){
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        HeaderMenu headerMenu = homePage.getHeaderMenu();
        String str = getDriver().getWindowHandle();
        YoutubePage youtubePage = headerMenu.openYouTubeLink();
        Assert.assertTrue(youtubePage.isSubscribeWindowPresent(), "No subscribe message!");
        youtubePage.getDriver().close();
        getDriver().switchTo().window(str);
        Assert.assertEquals(getDriver().getCurrentUrl(), "https://www.gsmarena.com/", "Wrong URL!");
    }

    @Test()
    @MethodOwner(owner = "Olena Babii")
    public void testBrandLinks(){
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        homePage.getBrandLinks().forEach(link -> {
            link.hover();
            Assert.assertEquals(link.getElement().getCssValue("background-color"),
                    "rgba(213, 0, 0, 1)", "Wrong color!");
        });
    }

    @Test()
    @MethodOwner(owner = "Olena Babii")
    public void testMargin(){
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        ModelReviewPage modelReviewPage = homePage.openMotorolaPage();
        Assert.assertEquals(modelReviewPage.getMarginValue(),
                "0px 30px 15px", "Text format is incorrect");
    }

    @Test
    @MethodOwner(owner = "Olena Babii")
    public void testSmoke(){
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        MerchMainPage merchMainPage = homePage.getHeaderMenu().openMerchPage();
        Assert.assertEquals(getDriver().getCurrentUrl(),
                "https://merch.gsmarena.com/", "Merch page wasn't open!");
        CameraIslandsTeePage tShirtPage = merchMainPage.clickCameraIslandsTee();
        Assert.assertTrue(tShirtPage.isPageOpened(), ":(");
//        Assert.assertEquals(getDriver().getCurrentUrl(),
//                "https://merch.gsmarena.com/products/camera-islands-tee-on-dark",
//                "T-Shirt Page was not open!");
        tShirtPage.getAddToCartButton().scrollTo();
        tShirtPage.chooseColorBlack().chooseXS().chooseCustomCount("12");
        tShirtPage.getAddToCartButton().click();
        ProductDrawer productDrawer = tShirtPage.getProductDrawer();
        Assert.assertTrue(productDrawer.isUIObjectPresent(), "Product drawer is not present!");
        productDrawer.getCloseProductDrawerButton().click();
        CartPage cartPage = tShirtPage.getHeaderMerchMenu().openCartPage();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(cartPage.getCartItemsTitles().get(0).getTitleItem().getText(),
                "CAMERA ISLANDS TEE (ON DARK)", "No required item in cart!");
        softAssert.assertEquals(cartPage.getCartItemsTitles().get(0).getQuantityField().getAttribute("value"),
                "12", "Wrong quantity!");
        softAssert.assertEquals(cartPage.getCartItemsTitles().get(0).getChoicesInfo().getText(),
                "BLACK, XS", "Wrong parameters!");
        softAssert.assertAll();
    }
}
