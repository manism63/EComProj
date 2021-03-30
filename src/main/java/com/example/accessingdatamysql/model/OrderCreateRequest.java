package com.example.accessingdatamysql.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

//@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
public class OrderCreateRequest {
    private EOrders eOrders;
    private List<EOrderDetails> eOrderDetailsList;
}

