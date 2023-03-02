package com.qaprosoft.carina.demo;

import com.qaprosoft.apitools.validation.JsonCompareKeywords;
import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.api.my_requests.GetAllToolsMethod;
import com.qaprosoft.carina.demo.api.my_requests.GetStatusMethod;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.testng.annotations.Test;


public class MyAPITests implements IAbstractTest {
    @Test()
    @MethodOwner(owner = "Olena Babii")
    public void testGetStatus() {
        GetStatusMethod getStatusMethod = new GetStatusMethod();
        getStatusMethod.callAPI();
        getStatusMethod.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
    }

    @Test()
    @MethodOwner(owner = "Olena Babii")
    public void testGetAllTools() {
        GetAllToolsMethod getAllToolsMethod = new GetAllToolsMethod();
        getAllToolsMethod.callAPI();
        getAllToolsMethod.validateResponse();
    }
}
