package com.qaprosoft.carina.demo.gui.pages.gsmarena;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.gui.components.HeaderMenu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class TipUsPage extends AbstractPage {
    @FindBy(id="header")
    private HeaderMenu headerMenu;

    public TipUsPage(WebDriver driver) {
        super(driver);
    }
}
