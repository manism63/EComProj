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
    private Double itemSubTotal;
    private String orderDate;
    private Double shippingCharge;

    public Double getShippingCharge() {
        return shippingCharge;
    }

    public void setShippingCharge(Double shippingCharge) {
        this.shippingCharge = shippingCharge;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getSubOrderId() {
        return subOrderId;
    }

    public void setSubOrderId(Integer subOrderId) {
        this.subOrderId = subOrderId;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public Integer getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(Integer itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    public Double getItemSubTotal() {
        return itemSubTotal;
    }

    public void setItemSubTotal(Double itemSubTotal) {
        this.itemSubTotal = itemSubTotal;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }
}

@Data
class SubOrderId implements Serializable {
    private Integer orderId;
    private Integer subOrderId;
}