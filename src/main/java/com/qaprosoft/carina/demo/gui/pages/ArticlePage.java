package com.qaprosoft.carina.demo.gui.pages;

import java.util.ArrayList;
import java.time.format.DateTimeFormatter;
import java.lang.invoke.MethodHandles;
import java.util.List;
import java.time.LocalDateTime;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.gui.components.ArticleComment;

public class ArticlePage extends AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    @FindBy(xpath = "//div[@class='user-thread']")
    private List<ArticleComment> comments;

    @FindBy(xpath = "//div[@class='article-info']")
    private ExtendedWebElement articleInfo;
    public ArticlePage(WebDriver driver) {
        super(driver);
    }

    public List<LocalDateTime> getDatesList() {
        List<LocalDateTime> localDateTimes = new ArrayList<>();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        for (ArticleComment articleComment : comments) {
            LocalDateTime dateTime = LocalDateTime.parse(articleComment.getCommentDate().
                    getAttribute("data-time"), dateTimeFormatter);
            localDateTimes.add(dateTime);
            LOGGER.info(dateTime + " was added to date list");
        }
        LOGGER.info("Dates were gotten from html attributes");
        return localDateTimes;
    }

    public boolean isOpen(){
        return articleInfo.isElementPresent();
    }
}
