package com.qaprosoft.carina.demo.mytests;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.LoginPageBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.ios.WelcomePage;
import com.qaprosoft.carina.demo.mobile.gui.pages.ios.gsmarena.pages.HomePage;
import com.qaprosoft.carina.demo.mobile.gui.pages.ios.gsmarena.pages.SignUpPage;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyIOSTests implements IAbstractTest, IMobileUtils {
    @Test()
    @MethodOwner(owner = "Olena Babii")
    public void testFooter(){
        HomePage homePage = new HomePage(getDriver());
        homePage.openURL("https://www.gsmarena.com");
        swipe(homePage.getFooter());
        Assert.assertTrue(homePage.getFooter().isPresent(), "No!");
    }

    @Test()
    @MethodOwner(owner = "Olena Babii")
    public void testCarinaAppLogin(){
        WelcomePage welcomePage = new WelcomePage(getDriver());
        LoginPageBase loginPage = welcomePage.clickNextBtn();
        Assert.assertFalse(loginPage.isLoginBtnActive(), "Active button is a mistake!");
        loginPage.typeName("gracetom");
        loginPage.typePassword(RandomStringUtils.randomAlphabetic(6));
        loginPage.selectFemaleSex();
        loginPage.checkPrivacyPolicyCheckbox();
        loginPage.clickLoginBtn();
    }

    @Test()
    @MethodOwner(owner = "Olena Babii")
    public void testSignUpForm() {
        SignUpPage signUpPage = new SignUpPage(getDriver());
        signUpPage.openURL("https://m.gsmarena.com/register.php3");
        swipe(signUpPage.getSubmitButton());
        signUpPage.fillNicknameField(RandomStringUtils.randomAlphabetic(8)).fillPasswordField("qwerty123").
                fillEmailField(RandomStringUtils.randomAlphabetic(8) + "@mail.com").agreeTerms().agreeAge();
        signUpPage.getSubmitButton().click(); //to change
        Assert.assertTrue(signUpPage.getSuccessMessage().isElementPresent(), "Unsuccessful sign up!");
    }
}
