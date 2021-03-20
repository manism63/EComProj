package com.example.accessingdatamysql.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "EOrderDetails")
@IdClass(SubOrderId.class)
@Data
public class EOrderDetails {
    @Id
    private Integer orderId;
    @Id
    private Integer subOrderId;
    private String orderStatus;
    private String itemId;
    private Integer itemQuantity;
    private Integer itemSubTotal;
    private Integer itemShippingAddress;
    private String orderDate;
}

@Data
class SubOrderId implements Serializable {
    private Integer orderId;
    private Integer subOrderId;
}