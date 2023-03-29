package com.qaprosoft.carina.demo.gui.pages.gsmarena;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class NetworkCoveragePage extends AbstractPage {
    @FindBy(xpath = "//h1[contains(text(), 'Network')]")
    private ExtendedWebElement titleMarker;

    public NetworkCoveragePage(WebDriver driver) {
        super(driver);
    }

    public boolean isOpen(){
        return titleMarker.isElementPresent();
    }
}
