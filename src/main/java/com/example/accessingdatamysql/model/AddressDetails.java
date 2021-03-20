package com.example.accessingdatamysql.model;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "AddressDetails")
@Data
public class AddressDetails {
    @Id
    private int addressId;
    private String addressType;
    private String city;
    private String line1;
    private String line2;
    private String state;
    private String zip;

    public AddressDetails(int id, String addressType, String city, String line1, String line2, String state, String zip) {
        this.addressId = id;
        this.addressType = addressType;
        this.city = city;
        this.line1 = line1;
        this.line2 = line2;
        this.state = state;
        this.zip = zip;
    }

    public AddressDetails() {
    }


}
