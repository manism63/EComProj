package com.example.accessingdatamysql.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

//@Getter
//@Setter
@Entity(name = "PaymentOrderDetails")
public class PaymentOrderDetails {
    @Id
    private Integer paymentId;
    private String customerId;
    private String methodType;
    private String date;
    private String confirmationNumber;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "addressId")
    public AddressDetails billingAddressDetails;
//
//    @OneToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "addressId", referencedColumnName = "billAddressId")
//    public AddressDetails billingAddressDetail;

    public Integer getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Integer paymentId) {
        this.paymentId = paymentId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getMethodType() {
        return methodType;
    }

    public void setMethodType(String methodType) {
        this.methodType = methodType;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getConfirmationNumber() {
        return confirmationNumber;
    }

    public void setConfirmationNumber(String confirmationNumber) {
        this.confirmationNumber = confirmationNumber;
    }

//    public Integer getBillAddressId() {
//        return billAddressId;
//    }
//
//    public void setBillAddressId(Integer billAddressId) {
//        this.billAddressId = billAddressId;
//    }
}
