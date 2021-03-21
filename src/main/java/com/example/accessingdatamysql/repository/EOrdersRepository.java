package com.example.accessingdatamysql.repository;

import com.example.accessingdatamysql.model.EOrders;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EOrdersRepository extends JpaRepository<EOrders, Integer> {
    Optional<EOrders> findById(Integer id);
}
