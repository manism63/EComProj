package com.example.accessingdatamysql.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

//@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity(name = "EOrderDetails")
// @IdClass(SubOrderId.class)
public class EOrderDetails {
    private Integer orderId;
    @Id
    @SequenceGenerator(
            name="suborder_id",
            sequenceName = "suborder_id",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "suborder_id"
    )
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
//
//@Data
//class SubOrderId implements Serializable {
//    private Integer orderId;
//    private Integer subOrderId;
//}

