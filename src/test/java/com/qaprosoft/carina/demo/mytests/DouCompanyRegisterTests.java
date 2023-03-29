package com.qaprosoft.carina.demo.mytests;

import org.testng.annotations.Test;
import org.testng.Assert;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.qaprosoft.carina.demo.gui.components.dou.LoginDialog;
import com.qaprosoft.carina.demo.gui.pages.dou.RegisterCompanyPage;

public class DouCompanyRegisterTests implements IAbstractTest {
    @Test()
    @MethodOwner(owner = "Olena Babii")
    public void testCompanyRegistrationForm() {
        RegisterCompanyPage registerCompanyPage = new RegisterCompanyPage(getDriver());
        registerCompanyPage.open();

        Assert.assertTrue(registerCompanyPage.isPageOpened(), "Page wasn't open!");

        registerCompanyPage.uploadLogo("src/test/resources/files/ukulele.png");
        registerCompanyPage.selectEmployeeCount(2);

        LoginDialog loginDialog = registerCompanyPage.clickSubmitButton();

        Assert.assertTrue(loginDialog.isUIObjectPresent(), "Login dialog wasn't presented!");
        Assert.assertTrue(loginDialog.getAgreeCheckbox().isChecked(), "Check box wasn't checked!");
    }
}
