package com.example.accessingdatamysql.controller;


import com.example.accessingdatamysql.model.EOrders;
import com.example.accessingdatamysql.model.OrderCreateRequest;
import com.example.accessingdatamysql.model.OrderResponse;
import com.example.accessingdatamysql.service.OrderService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/v1")
public class OrderControllers {

    private final OrderService orderService;

    @Autowired
    public OrderControllers(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/getEOrder/{id}")
    public ResponseEntity<OrderResponse> getOrders(@PathVariable Integer id) {
        OrderResponse response = orderService.getEOrder(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/createEOrder")
    public ResponseEntity<OrderResponse> createOrder(@RequestBody OrderCreateRequest orderCreateRequest) throws JsonProcessingException {
        System.out.println("Came here");
        OrderResponse orderResponse = orderService.createOrder(orderCreateRequest);
        return new ResponseEntity<>(orderResponse, HttpStatus.OK);
    }

    @PutMapping("/updateEOrder/{id}")
    public ResponseEntity<OrderResponse> updateOrder(
            @PathVariable Integer id,
            @RequestBody OrderCreateRequest orderCreateRequest) {
        boolean status = orderService.updateOrder(id, orderCreateRequest);
        return new ResponseEntity<>(status ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

}
