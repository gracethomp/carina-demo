package com.qaprosoft.carina.demo.mytests;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.gui.components.PriceCut;
import com.qaprosoft.carina.demo.gui.pages.gsmarena.DailyDealsPage;
import com.qaprosoft.carina.demo.gui.pages.HomePage;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.core.registrar.tag.Priority;
import com.zebrunner.carina.core.registrar.tag.TestPriority;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;
import java.util.List;

public class DailyDealsTests implements IAbstractTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    @Test()
    @MethodOwner(owner = "Olena Babii")
    @TestPriority(Priority.P1)
    public void testStoreLinks() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page wasn't open!");
        DailyDealsPage dailyDealsPage = homePage.getHeaderMenu().openHeaderMenu().openDealsPage();
        Assert.assertEquals(getDriver().getCurrentUrl(), "https://www.gsmarena.com/deals.php3",
                "Daily deals page wasn't open!");
        List<PriceCut> amazonLinks = dailyDealsPage.getPriceCuts("amazon");
        List<PriceCut> wirelessPlaceLinks = dailyDealsPage.getPriceCuts("wirelessplace");
        List<PriceCut> ebayLinks = dailyDealsPage.getPriceCuts("ebay");
        amazonLinks.forEach(e -> Assert.assertTrue(e.getStoreLink().isClickable(),
                "Button isn't clickable! (Amazon)"));
        wirelessPlaceLinks.forEach(e -> Assert.assertTrue(e.getStoreLink().isClickable(),
                "Button isn't clickable! (Wireless Place)"));
        ebayLinks.forEach(e -> {
            Assert.assertTrue(e.getStoreLink().isClickable(), "Button isn't clickable! (eBay)");
            LOGGER.info("passed");
        });
    }
}
