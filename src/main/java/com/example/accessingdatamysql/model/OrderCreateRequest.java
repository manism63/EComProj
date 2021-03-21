package com.example.accessingdatamysql.model;

import java.util.List;

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
