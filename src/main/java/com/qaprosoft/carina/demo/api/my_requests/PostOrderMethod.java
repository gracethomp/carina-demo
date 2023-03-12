package com.qaprosoft.carina.demo.api.my_requests;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.api.annotation.Endpoint;
import com.qaprosoft.carina.core.foundation.api.annotation.RequestTemplatePath;
import com.qaprosoft.carina.core.foundation.api.annotation.SuccessfulHttpStatus;
import com.qaprosoft.carina.core.foundation.api.http.HttpMethodType;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.zebrunner.carina.utils.Configuration;

@Endpoint(url = "${base_url}/orders", methodType = HttpMethodType.POST)
@RequestTemplatePath(path = "api/first_api_test/orders/_post/rq_create-order.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.CREATED_201)
public class PostOrderMethod extends AbstractApiMethodV2 {
    public PostOrderMethod() {
        //super("api/users/_post/rq.json", "api/users/_post/rs.json", "api/users/user.properties");
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url"));
    }
}