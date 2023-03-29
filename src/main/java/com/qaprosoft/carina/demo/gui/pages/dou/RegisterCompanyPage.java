package com.qaprosoft.carina.demo.gui.pages.dou;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.gui.components.dou.LoginDialog;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class RegisterCompanyPage extends AbstractPage {
    @FindBy(xpath = "//div[@id='_loginDialog']")
    private LoginDialog loginDialog;
    @FindBy(xpath = "//input[@type='file']")
    private ExtendedWebElement inputLogoButton;
    @FindBy(xpath = "//select[@id='id_employees']")
    private ExtendedWebElement selectEmployeeCount;
    @FindBy(xpath = "//input[@type='submit']")
    private ExtendedWebElement submitButton;
    public RegisterCompanyPage(WebDriver driver) {
        super(driver);
    }

    public ExtendedWebElement getInputLogoButton() {
        return inputLogoButton;
    }

    public RegisterCompanyPage uploadLogo(String pathToImage){
        inputLogoButton.attachFile(pathToImage);
        return this;
    }

    public RegisterCompanyPage selectEmployeeCount(int index){
        Select select = new Select(selectEmployeeCount.getElement());
        select.selectByIndex(index);
        return this;
    }

    public LoginDialog clickSubmitButton(){
        submitButton.click();
        return loginDialog;
    }
}
