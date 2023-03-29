package com.qaprosoft.carina.demo.mytests;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.gui.components.rozetka.SignUpMenu;
import com.qaprosoft.carina.demo.gui.pages.rozetka.RozetkaHomePage;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class RozetkaSignUpTests implements IAbstractTest {
    @Test()
    @MethodOwner(owner = "Olena Babii")
    public void testSignUpValidation(){
        RozetkaHomePage homePage = new RozetkaHomePage(getDriver());
        homePage.open();
        SignUpMenu signUpMenu = homePage.getRozetkaHeaderMenu().openLoginMenu().openSignUpMenu();
        SoftAssert softAssert = new SoftAssert();
        signUpMenu.fillNameField("Olena");
        softAssert.assertTrue(signUpMenu.getValidationMessages().get(0).isElementPresent(), "No error message!");
        signUpMenu.fillSurnameField("Babii");
        softAssert.assertTrue(signUpMenu.getValidationMessages().get(1).isElementPresent(), "No error message!");
        signUpMenu.fillPhoneField("9");
        softAssert.assertTrue(signUpMenu.getValidationMessages().get(2).isElementPresent(), "No error message!");
        signUpMenu.fillEmailField("es");
        softAssert.assertTrue(signUpMenu.getValidationMessages().get(3).isElementPresent(), "No error message!");
        signUpMenu.fillPasswordField("es");
        softAssert.assertEquals(signUpMenu.getErrorListIconsColors().get(0), "rgb(248, 65, 71)");
        softAssert.assertEquals(signUpMenu.getErrorListIconsColors().get(1), "rgb(0, 160, 70)");
        softAssert.assertEquals(signUpMenu.getErrorListIconsColors().get(2), "rgb(248, 65, 71)");
        softAssert.assertEquals(signUpMenu.getErrorListIconsColors().get(3), "rgb(248, 65, 71)");
        softAssert.assertEquals(signUpMenu.getErrorListIconsColors().get(4), "rgb(248, 65, 71)");
        softAssert.assertAll();
    }

    @Test()
    @MethodOwner(owner = "Olena Babii")
    public void test(){
        RozetkaHomePage homePage = new RozetkaHomePage(getDriver());
        homePage.open();
        getDriver().close();
    }
}
