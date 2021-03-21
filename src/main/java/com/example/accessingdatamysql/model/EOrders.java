package com.example.accessingdatamysql.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

//@Getter
//@Setter
@Entity(name = "EOrders")
public class EOrders {

    @Id
    private Integer id;
    @Column(
            name = "customer_id",
            nullable = false,
            columnDefinition = "TEXT"

    )
    private String customerId;
    private String status;
    private Integer paymentId;
    private Date orderDate;
    private Integer shippingAddressId;
    private Double total;
    private Double shippingTotal;

    public Double getShippingTotal() {
        return shippingTotal;
    }

    public void setShippingTotal(Double shippingTotal) {
        this.shippingTotal = shippingTotal;
    }



    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Integer paymentId) {
        this.paymentId = paymentId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Integer getShippingAddressId() {
        return shippingAddressId;
    }

    public void setShippingAddressId(Integer shippingAddressId) {
        this.shippingAddressId = shippingAddressId;
    }
}
