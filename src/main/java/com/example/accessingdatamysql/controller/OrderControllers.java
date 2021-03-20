package com.example.accessingdatamysql.controller;


import com.example.accessingdatamysql.model.AddressDetails;
import com.example.accessingdatamysql.repository.AddressDetailsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/v1")
public class OrderControllers {

    @Autowired
    AddressDetailsRepository repository;

    @GetMapping("/getOrder")
    public ResponseEntity<String> getOrders() {
        List<String> list = new ArrayList<>();
        list.add("Manish");
        System.out.println("loggind from order controler");
        return new ResponseEntity<>(list.toString(), HttpStatus.OK);
    }

    @GetMapping("/address")
    public List<AddressDetails> getAddresses() {
        List<String> list = new ArrayList<>();
        List<AddressDetails> ad = repository.findAll();
        return ad;
    }
}
