package com.qaprosoft.carina.demo;

import com.qaprosoft.apitools.validation.JsonCompareKeywords;
import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.api.my_requests.GetAllToolsMethod;
import com.qaprosoft.carina.demo.api.my_requests.GetSingleToolMethod;
import com.qaprosoft.carina.demo.api.my_requests.GetStatusMethod;
import com.qaprosoft.carina.demo.api.my_requests.PostUserMethod;
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
        getSingleToolMethod.request.given().pathParam("toolID", id);
        getSingleToolMethod.callAPI();
        getSingleToolMethod.validateResponseAgainstSchema("api/first_api_test/_get/rs_single_tool.schema");
        //getSingleToolMethod.validateResponse();
    }

    @Test()
    @MethodOwner(owner = "Olena Babii")
    public void testPostUserMethod(){
        PostUserMethod postUserMethod = new PostUserMethod();
        postUserMethod.setProperties("api/first_api_test/_post/user-data.properties");
        postUserMethod.callAPI();
        postUserMethod.validateResponseAgainstSchema("api/first_api_test/_post/rs_succesful-register.schema");
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
