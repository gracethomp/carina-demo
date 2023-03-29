package com.qaprosoft.carina.demo.mytests;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.api.swapi.GetPeopleMethod;
import com.qaprosoft.carina.demo.api.swapi.models.ResultsItem;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class SWApiTests implements IAbstractTest {
    @Test()
    @MethodOwner(owner = "Olena Babii")
    public void testNameValidation() {
        GetPeopleMethod getPeopleMethod = new GetPeopleMethod();
        List<ResultsItem> resultsItems = getPeopleMethod.callAPIExpectSuccess()
                .then()
                .extract()
                .body()
                .jsonPath()
                .getList("results", ResultsItem.class);
        resultsItems.forEach(e->{
            Assert.assertNotEquals(e.getName(), "", "Name field is empty");
            Assert.assertNotEquals(e.getName(), null, "Name field is empty");
        });
    }
}
