package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.gui.components.PriceCut;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class DailyDealsPage extends AbstractPage {
    @FindBy(xpath = "//div[@class='pricecut']")
    private List<PriceCut> priceCuts;

    public DailyDealsPage(WebDriver driver) {
        super(driver);
    }

    public List<PriceCut> getPriceCuts() {
        return priceCuts;
    }

    public List<PriceCut> getPriceCuts(String siteDomain) {
        return priceCuts.stream().filter(e->e.getStoreLink().getAttribute("href")
                .contains(siteDomain)).collect(Collectors.toList());
    }
}
