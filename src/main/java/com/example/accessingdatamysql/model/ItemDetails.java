package com.example.accessingdatamysql.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "ItemDetails")
@Data
public class ItemDetails {
    @Id
    private String itemId;
    private String name;
    private Integer price;
}
