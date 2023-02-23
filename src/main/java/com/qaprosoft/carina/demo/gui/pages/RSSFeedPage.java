package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.gui.components.HeaderMenu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class RSSFeedPage extends AbstractPage {
    @FindBy(id="header")
    private HeaderMenu headerMenu;

    public RSSFeedPage(WebDriver driver) {
        super(driver);
    }
}
