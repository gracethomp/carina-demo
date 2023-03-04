package com.qaprosoft.carina.demo.api.my_requests;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.api.annotation.Endpoint;
import com.qaprosoft.carina.core.foundation.api.annotation.SuccessfulHttpStatus;
import com.qaprosoft.carina.core.foundation.api.http.HttpMethodType;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.zebrunner.carina.utils.Configuration;

@Endpoint(url = "${base_url}/orders/{orderId}", methodType = HttpMethodType.DELETE)
@SuccessfulHttpStatus(status = HttpResponseStatusType.NO_CONTENT_204)
public class DeleteOrderMethod extends AbstractApiMethodV2 {
    public DeleteOrderMethod() {
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url"));
    }
}
