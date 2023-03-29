package com.qaprosoft.carina.demo.api.swapi;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.api.annotation.Endpoint;
import com.qaprosoft.carina.core.foundation.api.annotation.SuccessfulHttpStatus;
import com.qaprosoft.carina.core.foundation.api.http.HttpMethodType;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.zebrunner.carina.utils.Configuration;

@Endpoint(url = "${base_url}/people", methodType = HttpMethodType.GET)
//@ResponseTemplatePath(path = "")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class GetPeopleMethod extends AbstractApiMethodV2 {
    public GetPeopleMethod(){
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url"));
    }
}
