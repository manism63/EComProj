package com.example.accessingdatamysql.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

//@Getter
//@Setter
//@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderResponse {

    private EOrders eOrders;
    private List<EOrderDetails> eOrderDetailsList;
    private AddressDetails billingAddress;
    private AddressDetails shippingAddress;
    private PaymentOrderDetails paymentOrderDetails;
    private Map<String, String> errorDesc;

    public PaymentOrderDetails getPaymentOrderDetails() {
        return paymentOrderDetails;
    }

    public void setPaymentOrderDetails(PaymentOrderDetails paymentOrderDetails) {
        this.paymentOrderDetails = paymentOrderDetails;
    }



    public OrderResponse() {
    }

    public EOrders getEOrders() {
        return eOrders;
    }

    public List<EOrderDetails> getEOrderDetailsList() {
        return eOrderDetailsList;
    }

    public AddressDetails getBillingAddress() {
        return billingAddress;
    }

    public AddressDetails getShippingAddress() {
        return shippingAddress;
    }

    public Map<String, String> getErrorDesc() {
        return errorDesc;
    }

    public void setEOrders(EOrders eOrders) {
        this.eOrders = eOrders;
    }

    public void setEOrderDetailsList(List<EOrderDetails> eOrderDetailsList) {
        this.eOrderDetailsList = eOrderDetailsList;
    }

    public void setBillingAddress(AddressDetails billingAddress) {
        this.billingAddress = billingAddress;
    }

    public void setShippingAddress(AddressDetails shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public void setErrorDesc(Map<String, String> errorDesc) {
        this.errorDesc = errorDesc;
    }
}
