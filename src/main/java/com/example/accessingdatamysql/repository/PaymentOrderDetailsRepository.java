package com.example.accessingdatamysql.repository;

import com.example.accessingdatamysql.model.EOrderDetails;
import com.example.accessingdatamysql.model.PaymentOrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentOrderDetailsRepository  extends JpaRepository<PaymentOrderDetails, Integer> {

}
