package com.example.accessingdatamysql.repository;

import com.example.accessingdatamysql.model.AddressDetails;
import com.example.accessingdatamysql.model.EOrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EOrderDetailsRepository  extends JpaRepository<EOrderDetails, Integer> {
    public List<EOrderDetails> findAllByOrderId(Integer id);
}
