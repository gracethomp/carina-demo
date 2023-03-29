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

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.qaprosoft.carina.demo.gui.enums.FooterButton;
import com.qaprosoft.carina.demo.gui.pages.*;
import com.qaprosoft.carina.demo.gui.pages.gsmarena.CompareModelsPage;
import com.qaprosoft.carina.demo.gui.pages.gsmarena.GlossaryPage;
import com.qaprosoft.carina.demo.gui.pages.gsmarena.NetworkCoveragePage;
import com.qaprosoft.carina.demo.gui.pages.gsmarena.NewsPage;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class FooterMenu extends AbstractUIObject {
    @FindBy(linkText = "Home")
    private ExtendedWebElement homeLink;

    @FindBy(xpath = "//div[@id='footer']//a[contains(text(),'Compare')]")
    private ExtendedWebElement compareLink;
    
    @FindBy(linkText = "News")
    private ExtendedWebElement newsLink;

    @FindBy(linkText = "Reviews")
    private ExtendedWebElement reviewLink;

    @FindBy(linkText = "Glossary")
    private ExtendedWebElement glossaryLink;

    @FindBy(xpath = "//div[@id='footer']//div[@id='footmenu']//a[@href]")
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

    public NetworkCoveragePage openCoveragePage(){
        compareLink.click();
        return new NetworkCoveragePage(driver);
    }

    public GlossaryPage openGlossaryPage(){
        glossaryLink.click();
        return new GlossaryPage(driver);
    }

    public boolean isAllButtonsPresent() {
        ExtendedWebElement[] webElements = brandLinks.toArray(new ExtendedWebElement[0]);
        return allElementsPresent(webElements);
    }

    /*public boolean clickEachButton() {
        NewsPage newsPage = openNewsPage();
        if(!newsLink.getAttribute("href").equals(newsPage.getCurrentUrl()))
            return false;
        CompareModelsPage compareModelsPage = openComparePage();
        if(!compareLink.getAttribute("href").equals(compareModelsPage.getCurrentUrl()))
            return false;
        NetworkCoveragePage coveragePage = openCoveragePage();
        if(!compareLink.getAttribute("href").equals(compareModelsPage.getCurrentUrl()))
            return false;
        GlossaryPage glossaryPage = openGlossaryPage();
        return (glossaryLink.getAttribute("href").equals(glossaryPage.getCurrentUrl()));
    }*/

    public void clickMenuButton(FooterButton footerButton) {
        brandLinks.get(footerButton.getValue()).click();
    }
}
