package com.qaprosoft.carina.demo.gui.pages.dou;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.gui.components.dou.DouChart;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class PortraitPage extends AbstractPage {
    @FindBy(xpath = "//div[@id='dou-portrait22-age']")
    private DouChart ageGraphic;
    public PortraitPage(WebDriver driver) {
        super(driver);
    }
    public DouChart getAgeGraphic() {
        return ageGraphic;
    }
}
