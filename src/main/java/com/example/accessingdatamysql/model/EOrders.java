package com.example.accessingdatamysql.model;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "EOrders")
@Data
public class EOrders {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    @Column(
            name = "customer_id",
            nullable = false,
            columnDefinition = "TEXT"

    )
    private String customerId;
    private String status;
    private String paymentId;
    private Date orderDate;

    public EOrders(int id, String customerId, String status, String paymentId, Date orderDate) {
        this.id = id;
        this.customerId = customerId;
        this.status = status;
        this.paymentId = paymentId;
        this.orderDate = orderDate;

    }

    public EOrders() {
    }
}
