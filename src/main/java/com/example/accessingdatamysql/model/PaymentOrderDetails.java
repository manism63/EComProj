package com.example.accessingdatamysql.model;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "PaymentOrderDetails")
@Data
public class PaymentOrderDetails {
    @Id
    private Integer paymentId;
    private String customerId;
    private String methodType;
    private String date;
    private String confirmationNumber;
    private Integer billAddressId;
}
