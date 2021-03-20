package com.example.accessingdatamysql.repository;

import com.example.accessingdatamysql.model.AddressDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface AddressDetailsRepository extends JpaRepository<AddressDetails, Integer> {

}
