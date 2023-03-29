package com.qaprosoft.carina.demo.gui.pages.rozetka;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.gui.components.rozetka.RozetkaHeaderMenu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class RozetkaHomePage extends AbstractPage {
    @FindBy(xpath = "//header")
    private RozetkaHeaderMenu rozetkaHeaderMenu;
    public RozetkaHomePage(WebDriver driver) {
        super(driver);
    }

    public RozetkaHeaderMenu getRozetkaHeaderMenu() {
        return rozetkaHeaderMenu;
    }
}
