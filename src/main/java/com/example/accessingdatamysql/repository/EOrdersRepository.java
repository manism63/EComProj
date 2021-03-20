package com.example.accessingdatamysql.repository;

import com.example.accessingdatamysql.model.EOrders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface EOrdersRepository extends JpaRepository<EOrders, Integer> {
}
