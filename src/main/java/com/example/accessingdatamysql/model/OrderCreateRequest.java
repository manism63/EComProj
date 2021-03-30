package com.example.accessingdatamysql.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

// @JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderCreateRequest {

    private List<EOrderDetails> eOrderDetailsList;
    private EOrders eOrder;

    public List<EOrderDetails> getEOrderDetailsList() {
        return eOrderDetailsList;
    }

    public void setEOrderDetailsList(List<EOrderDetails> eOrderDetailsList) {
        this.eOrderDetailsList = eOrderDetailsList;
    }

    public EOrders getEOrder() {
        return eOrder;
    }

    public void setEOrders(EOrders eOrder) {
        this.eOrder = eOrder;
    }


}
