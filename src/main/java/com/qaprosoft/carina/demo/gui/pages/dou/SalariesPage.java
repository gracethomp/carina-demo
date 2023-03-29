package com.qaprosoft.carina.demo.gui.pages.dou;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class SalariesPage extends AbstractPage {
    @FindBy(xpath = "//*[@id='dws-ch-histogramm']//*[@class='bar']")
    private List<ExtendedWebElement> barsList;
    public SalariesPage(WebDriver driver) {
        super(driver);
    }

    public List<ExtendedWebElement> getBarsList() {
        return barsList;
    }

    public void method(){
        List<ExtendedWebElement> barsList = new ArrayList<>();
        List<String> list = new ArrayList<>();
        for (ExtendedWebElement e: barsList) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            list.add(js.executeScript("", e.getElement()).toString());
        }
    }

    public String readSalaryData(int index){
        return barsList.get(index).getElement().getDomProperty("__data__");
    }

    public String readClassAttributeText(ExtendedWebElement element){
        return element.getAttribute("class");
    }
}
