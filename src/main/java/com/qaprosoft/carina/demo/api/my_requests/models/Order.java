package com.qaprosoft.carina.demo.api.my_requests.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public final class Order {
    private final String orderId;
    private final String created;

    @JsonCreator
    public Order(@JsonProperty("orderId") String id,@JsonProperty("created") String created){
        this.orderId = id;
        this.created = created;
    }

    public String getCreated() {
        return created;
    }

    public String getOrderId() {
        return orderId;
    }
}
