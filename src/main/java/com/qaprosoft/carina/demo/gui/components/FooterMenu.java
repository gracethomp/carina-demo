/*
 * Copyright 2013-2021 QAPROSOFT (http://qaprosoft.com/).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.qaprosoft.carina.demo.gui.components;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.qaprosoft.carina.demo.gui.pages.CompareModelsPage;
import com.qaprosoft.carina.demo.gui.pages.HomePage;
import com.qaprosoft.carina.demo.gui.pages.NewsPage;

import java.util.ArrayList;
import java.util.List;

public class FooterMenu extends AbstractUIObject {
    @FindBy(linkText = "Home")
    private ExtendedWebElement homeLink;

    @FindBy(xpath = "//div[@class='footer-inner']//a[contains(text(),'Compare')]")
    private ExtendedWebElement compareLink;
    
    @FindBy(linkText = "News")
    private ExtendedWebElement newsLink;

    @FindBy(xpath = "//div[@id='footmenu']//a[@href]")
    private List<ExtendedWebElement> brandLinks;

    public FooterMenu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public HomePage openHomePage() {
        homeLink.click();
        return new HomePage(driver);
    }

    public CompareModelsPage openComparePage() {
        compareLink.click();
        return new CompareModelsPage(driver);
    }
    
    public NewsPage openNewsPage() {
        newsLink.click();
        return new NewsPage(driver);
    }

    public boolean isAllButtonsPresent() {
        ExtendedWebElement[] webElements = brandLinks.toArray(new ExtendedWebElement[0]);
        for (ExtendedWebElement b : brandLinks) {
            System.out.println(b.getAttribute("href"));
        }
        return allElementsPresent(webElements);
    }

    public boolean clickEachButton() {
        return true;
    }
}
