package com.qaprosoft.carina.demo.mytests;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.gui.pages.dou.SalariesPage;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class DouHistogramTests implements IAbstractTest {
    @Test()
    @MethodOwner(owner = "Olena Babii")
    public void test(){
        SalariesPage salariesPage = new SalariesPage(getDriver());
        salariesPage.open();
        List<ExtendedWebElement> barsList = salariesPage.getBarsList();
        for (ExtendedWebElement element : barsList) {
            element.hover();
            Assert.assertTrue(salariesPage.readClassAttributeText(element).contains("highlighted"));
        }
    }
    @Test()
    @MethodOwner(owner = "Olena Babii")
    public void test1(){
        SalariesPage salariesPage = new SalariesPage(getDriver());
        salariesPage.open();
        System.out.println(salariesPage.readSalaryData(0));
        System.out.println(salariesPage.readSalaryData(0));
        System.out.println(salariesPage.readSalaryData(0));
        System.out.println(salariesPage.readSalaryData(0));
    }
}
