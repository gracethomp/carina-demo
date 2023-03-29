package com.qaprosoft.carina.demo.gui.components.dou;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DouChart extends AbstractUIObject {
    @FindBy(xpath = ".//div[@class='cep-total']")
    private ExtendedWebElement cepTotal;
    @FindBy(xpath = ".//div[@class='cep-x-axis']")
    private ExtendedWebElement cepXAxis;
    @FindBy(xpath = ".//div[@class='cep-item']")
    private List<ExtendedWebElement> cepItems;
    @FindBy(xpath = ".//div[@class='cep-chart-legend']//div[@class='legend-item']")
    private List<ExtendedWebElement> legendItems;
    @FindBy(xpath = ".//div[contains(@class, 'cep-ctrl-item')]")
    private List<ExtendedWebElement> cepControlsButtons;
    public DouChart(WebDriver driver) {
        super(driver);
    }
    public DouChart(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public List<ExtendedWebElement> getCepControlsButtons() {
        return cepControlsButtons;
    }

    public String readElementClass(ExtendedWebElement element) {
        return element.getAttribute("class");
    }

    public ExtendedWebElement getCepTotal() {
        return cepTotal;
    }

    public ExtendedWebElement getCepXAxis() {
        return cepXAxis;
    }

    public List<ExtendedWebElement> getLegendItems() {
        return legendItems;
    }

    public DouChart clickCepControlButton(int index){
        cepControlsButtons.get(index).click();
        return this;
    }
}
