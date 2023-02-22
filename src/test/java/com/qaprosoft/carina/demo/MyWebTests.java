package com.qaprosoft.carina.demo;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.gui.components.FooterMenu;
import com.qaprosoft.carina.demo.gui.pages.HomePage;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.core.registrar.tag.Priority;
import com.zebrunner.carina.core.registrar.tag.TestPriority;
import org.testng.Assert;
import org.testng.annotations.Test;

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
        Assert.assertTrue(footerMenu.clickEachButton(), "Buttons work incorrectly");
    }

    @Test()
    @MethodOwner(owner = "Olena Babii")
    @TestPriority(Priority.P1)
    public void testHeaderMenu() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
    }
    @Test()
    @MethodOwner(owner = "Olena Babii")
    @TestPriority(Priority.P3)
    public void testSignUpMenu() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
    }
    @Test()
    @MethodOwner(owner = "Olena Babii")
    @TestPriority(Priority.P4)
    public void testLogInMenu() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
    }

}
