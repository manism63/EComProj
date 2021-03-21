package com.example.accessingdatamysql.controller;

import com.example.accessingdatamysql.model.AddressDetails;
import com.example.accessingdatamysql.model.EOrders;
import com.example.accessingdatamysql.repository.AddressDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/v1")
public class AddressController {

    private AddressDetailsRepository addressDetailsRepository;

    @Autowired
    public AddressController(AddressDetailsRepository repo) {
        this.addressDetailsRepository = repo;
    }

    @GetMapping("/getAddress/{id}")
    public ResponseEntity<AddressDetails> getAddress(@PathVariable Integer id) {
        Optional<AddressDetails> addressDetailsOptional = this.addressDetailsRepository.findById(id);
        if(addressDetailsOptional.isPresent()) {
            return new ResponseEntity<>(addressDetailsOptional.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
