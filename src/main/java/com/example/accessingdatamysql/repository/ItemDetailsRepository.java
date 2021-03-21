package com.example.accessingdatamysql.repository;

import com.example.accessingdatamysql.model.ItemDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemDetailsRepository extends JpaRepository<ItemDetails, String> {

}
