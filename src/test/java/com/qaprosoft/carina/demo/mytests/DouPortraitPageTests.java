package com.qaprosoft.carina.demo.mytests;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.gui.components.dou.DouChart;
import com.qaprosoft.carina.demo.gui.pages.dou.PortraitPage;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class DouPortraitPageTests implements IAbstractTest {
    @Test()
    @MethodOwner(owner = "Olena Babii")
    public void testAgeChart() {
        PortraitPage portraitPage = new PortraitPage(getDriver());
        portraitPage.open();

        Assert.assertTrue(portraitPage.isPageOpened(), "Page wasn't open!");

        DouChart ageGraphic = portraitPage.getAgeGraphic();

        List<ExtendedWebElement> extendedWebElements = ageGraphic.getCepControlsButtons();
        int index = 1;
        for (ExtendedWebElement e: extendedWebElements) {
            Assert.assertTrue(ageGraphic.readElementClass(e).contains("active"), "The button is inactive!");
            Assert.assertTrue(e.isVisible(), "Age value isn't visible");
            ageGraphic.getLegendItems().forEach(k -> Assert.assertFalse(k.getText().isEmpty(),
                    "No text in the legend item"));
            if(index < extendedWebElements.size()) {
                ageGraphic.clickCepControlButton(index);
                index++;
            }
        }

    }
}
