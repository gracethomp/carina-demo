package com.qaprosoft.carina.demo.gui.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.qaprosoft.carina.demo.gui.enums.HeaderButton;
import com.qaprosoft.carina.demo.gui.pages.*;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
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

    @FindBy(xpath = "//div[@id='social-connect']//a[contains(@href, 'merch')]")
    private ExtendedWebElement merchPageLink;

    @FindBy(xpath = "//ul[@id='menu']//a")
    private List<ExtendedWebElement> buttons;

    public HeaderMenu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public boolean isAllButtonsPresent() {
        headerMenuButton.click();
        ExtendedWebElement[] webElements = buttons.toArray(new ExtendedWebElement[0]);
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
        youtubeLink.click();
        List<String> openTabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(openTabs.get(openTabs.size() - 1));
        //driver.get(youtubeLink.getAttribute("href"));
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

    public MerchMainPage openMerchPage(){
        merchPageLink.click();
        List<String> openTabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(openTabs.get(openTabs.size() - 1));
        return new MerchMainPage(driver);
    }

    public ExtendedWebElement getLogOutLink() {
        return logOutLink;
    }

    public void clickMenuButton(HeaderButton headerButton) {
        buttons.get(headerButton.getValue()).click();
    }

    public HeaderMenu switchToMerchPage(){
        List<String> windowsHandlers = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windowsHandlers.get(1));
        return this;
    }

    public MerchMainPage openMerchMainPage(){
        openHeaderMenu();
        buttons.get(7).click();
        switchToMerchPage();
        return new MerchMainPage(driver);
    }
}
