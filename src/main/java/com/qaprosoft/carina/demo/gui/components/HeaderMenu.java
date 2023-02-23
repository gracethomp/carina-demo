package com.qaprosoft.carina.demo.gui.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.qaprosoft.carina.demo.gui.pages.*;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HeaderMenu extends AbstractUIObject {
    @FindBy(xpath = "//header//a[not(contains(@class, 'more-news-link more-news-link-small'))]" +
            "[not(contains(@class, 'forgot'))][not(contains(@class, 'go'))][not(contains(@class, 'advanced'))]")
    private List<ExtendedWebElement> brandLinks;

    @FindBy(xpath = "//span[@class='lines']")
    private ExtendedWebElement headerMenuButton;

    @FindBy(xpath = "//div[@id='logo']")
    private ExtendedWebElement homeLink;

    @FindBy(xpath = "//div[@id='logo']//a")
    private ExtendedWebElement home;

    @FindBy(id="topsearch-text")
    private ExtendedWebElement searchButton;

    @FindBy(xpath = "//a[@id='login-active']//i")
    private ExtendedWebElement logInButton;

    @FindBy(xpath = "//a[contains(@href, 'tipus')]")
    private ExtendedWebElement tipLink;

    @FindBy(xpath = "//div[@id='social-connect']//a[@class='yt-icon']")
    private ExtendedWebElement youtubeLink;

    @FindBy(xpath = "//div[@id='social-connect']//a[contains(@href, 'rss')]")
    private ExtendedWebElement rssFeedLink;

    @FindBy(id = "login-popup2")
    private LoginPopUp loginPopUp;

    @FindBy(xpath = "//a[contains(@href, 'register')]")
    private ExtendedWebElement registerLink;
    @FindBy(xpath = "//div[@id='social-connect']//a[contains(@href, 'logout')]")
    private ExtendedWebElement logOutLink;

    public HeaderMenu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public boolean isAllButtonsPresent() {
        headerMenuButton.click();
        ExtendedWebElement[] webElements = brandLinks.toArray(new ExtendedWebElement[0]);
        for (ExtendedWebElement w : webElements) {
            System.out.println(w.getAttribute("href"));
        }
        return allElementsPresent(webElements);
    }

    public void openHeaderMenu(){
        headerMenuButton.click();
    }
    public HomePage openHomePage() {
        homeLink.click();
        return new HomePage(driver);
    }

    public TipUsPage openTipUsPage() {
        tipLink.click();
        return new TipUsPage(driver);
    }

    public YoutubePage openYouTubeLink() {
        driver.get(youtubeLink.getAttribute("href"));
        return new YoutubePage(driver);
    }

    public RSSFeedPage openRSSFeed() {
        rssFeedLink.click();
        return new RSSFeedPage(driver);
    }

    public LoginPopUp openLoginPopUp() {
        logInButton.click();
        return loginPopUp;
    }

    public RegisterPage openRegisterPage() {
        registerLink.click();
        return new RegisterPage(driver);
    }

    public String getNeededYoutubeLink() {
        String youtubeHref = youtubeLink.getAttribute("href");
        int i = youtubeHref.indexOf('?');
        youtubeHref = youtubeHref.replace(youtubeHref.substring(i), "");
        return youtubeHref;
    }

    public ExtendedWebElement getLogOutLink() {
        return logOutLink;
    }

    public boolean checkAllButtons() {
        HomePage homePage = openHomePage();
        if(!home.getAttribute("href").equals(homePage.getCurrentUrl()))
            return false;
        TipUsPage tipUsPage = openTipUsPage();
        if(!tipLink.getAttribute("href").equals(tipUsPage.getCurrentUrl()))
            return false;
        String neededLink = getNeededYoutubeLink();
        YoutubePage youtube = openYouTubeLink();
        if(!youtube.getCurrentUrl().equals(neededLink) || !youtube.isSubscribeWindowPresent())
            return false;
        navigateBack();
        LoginPopUp loginPopUp = openLoginPopUp();
        if (!loginPopUp.isUIObjectPresent())
            return false;
        RegisterPage registerPage = openRegisterPage();
        if(!registerLink.getAttribute("href").equals(registerPage.getCurrentUrl()))
            return false;
        RSSFeedPage rssFeedPage = openRSSFeed();
        return rssFeedLink.getAttribute("href").equals(rssFeedPage.getCurrentUrl());
    }
}
