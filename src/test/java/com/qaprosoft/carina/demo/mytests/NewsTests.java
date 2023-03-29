package com.qaprosoft.carina.demo.mytests;

import java.util.stream.Collectors;

import org.testng.annotations.Test;
import org.testng.Assert;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.qaprosoft.carina.demo.gui.pages.gsmarena.ArticlePage;
import com.qaprosoft.carina.demo.gui.pages.HomePage;
import com.qaprosoft.carina.demo.gui.pages.gsmarena.NewsPage;

public class NewsTests implements IAbstractTest {
    @Test()
    @MethodOwner(owner = "Olena Babii")
    public void testArticleComments(){
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not open!");
        NewsPage newsPage = homePage.getHeaderMenu().openNewsPage();

        Assert.assertTrue(newsPage.isOpen(), "News page is not open!");
        ArticlePage articlePage = newsPage.openArticle(0);
        Assert.assertTrue(articlePage.isOpen(), "Article page is not open!");
        Assert.assertEquals(articlePage.getDatesList(),
                articlePage.getDatesList().stream().sorted().collect(Collectors.toList()),
                "Order of comments is incorrect!");
    }
}
