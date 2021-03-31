package com.example.accessingdatamysql.model;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

//@Getter
//@Setter
@Entity(name = "EOrders")
@Table(name = "eorders")
public class EOrders {

    @Id
    @SequenceGenerator(
            name="eorder_seq",
            sequenceName = "eorder_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "eorder_seq"
    )
    private Integer id;
    @Column(
            name = "customer_id",
            nullable = false,
            columnDefinition = "TEXT",
            updatable = false

    )
    private String customerId;
    private String status;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "paymentId")
    public PaymentOrderDetails paymentDetails;

    private Date orderDate;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "addressId")
    public AddressDetails shippingAddressDetails;

    private Double total;
    private Double shippingTotal;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "orderId")
    public List<EOrderDetails> orderDetails;

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

//    public Integer getPaymentId() {
//        return paymentId;
//    }
//
//    public void setPaymentId(Integer paymentId) {
//        this.paymentId = paymentId;
//    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public PaymentOrderDetails getPaymentDetails() {
        return paymentDetails;
    }

    public void setPaymentDetails(PaymentOrderDetails paymentDetails) {
        this.paymentDetails = paymentDetails;
    }

    public AddressDetails getShippingAddressDetails() {
        return shippingAddressDetails;
    }

    public void setShippingAddressDetails(AddressDetails shippingAddressDetails) {
        this.shippingAddressDetails = shippingAddressDetails;
    }

    public List<EOrderDetails> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<EOrderDetails> orderDetails) {
        this.orderDetails = orderDetails;
    }



}
