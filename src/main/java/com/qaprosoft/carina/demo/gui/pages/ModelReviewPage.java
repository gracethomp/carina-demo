package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ModelReviewPage extends AbstractPage {
    @FindBy(xpath = "//div[@id='review-body']//p[1]")
    private ExtendedWebElement introductionTextArea;

    public ModelReviewPage(WebDriver driver) {
        super(driver);
    }

    public String getMarginValue(){
        return introductionTextArea.getElement().getCssValue("margin");
    }
}
