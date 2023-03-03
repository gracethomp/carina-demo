package com.qaprosoft.carina.demo;

import com.qaprosoft.apitools.validation.JsonCompareKeywords;
import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.api.my_requests.*;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.testng.annotations.DataProvider;
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

    @Test(dataProvider = "DP1")
    @MethodOwner(owner = "Olena Babii")
    public void testGetSingleTool(String id){
        GetSingleToolMethod getSingleToolMethod = new GetSingleToolMethod();
        getSingleToolMethod.replaceUrlPlaceholder("toolID", id);
        //getSingleToolMethod.request.given().pathParam("toolID", id);
        getSingleToolMethod.callAPI();
        getSingleToolMethod.validateResponseAgainstSchema("api/first_api_test/_get/rs_single_tool.schema");
    }

    @Test()
    @MethodOwner(owner = "Olena Babii")
    public void testPostUserMethod(){
        PostUserMethod postUserMethod = new PostUserMethod();
        postUserMethod.setProperties("api/first_api_test/_post/user-data.properties");
        postUserMethod.callAPI();
        postUserMethod.validateResponseAgainstSchema("api/first_api_test/_post/rs_succesful-register.schema");
    }

    @Test()
    @MethodOwner(owner = "Olena Babii")
    public void testOrdersWorkNoAuth(){
        GetOrdersMethod getOrdersMethod = new GetOrdersMethod();
        getOrdersMethod.setResponseTemplate("api/first_api_test/_get/rs_no-auth.json");
        getOrdersMethod.callAPI();
        getOrdersMethod.validateResponse();
    }

    @Test()
    @MethodOwner(owner = "Olena Babii")
    public void testOrdersWorkWithAuth(){
        GetOrdersMethod getOrdersMethod = new GetOrdersMethod();
        getOrdersMethod.setHeader("Authorization", "c6a93751b3963900b3afa0c721d6dca80fcb124b13e2bb62db054ea61a8aa8e9");
        getOrdersMethod.callAPI();
        getOrdersMethod.validateResponseAgainstSchema("api/first_api_test/_get/rs_orders.schema");
    }

    @Test(dataProvider = "DP1")
    @MethodOwner(owner = "Olena Babii")
    public void testCreateOrder(String id){
        PostOrderMethod postOrderMethod = new PostOrderMethod();
        postOrderMethod.setProperties("api/first_api_test/_post/order-data.properties");
        postOrderMethod.setHeader("Authorization", "c6a93751b3963900b3afa0c721d6dca80fcb124b13e2bb62db054ea61a8aa8e9");
        postOrderMethod.getProperties().put("toolId", Integer.valueOf(id));
        postOrderMethod.callAPI();
        postOrderMethod.validateResponseAgainstSchema("api/first_api_test/_post/rs_created-order.schema");
    }

    @DataProvider(name = "DP1")
    public static Object[][] provider() {
        return new Object[][]{
                {"4643"},
                {"1225"},
                {"2177"},
                {"6543"},
                {"3674"},
                {"2585"},
                {"5851"},
                {"8739"},
                {"1709"},
                {"7395"},
                {"8554"},
                {"8753"},
                {"9482"},
                {"5477"},
                {"6483"},
                {"5774"},
                {"4875"},
                {"5499"},
                {"3486"}};
    }
}
