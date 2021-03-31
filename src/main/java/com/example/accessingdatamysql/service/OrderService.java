
package com.example.accessingdatamysql.service;

import com.example.accessingdatamysql.model.*;
import com.example.accessingdatamysql.repository.*;
import com.example.accessingdatamysql.service.validation.EOrderDetailsValidation;
import com.example.accessingdatamysql.service.validation.EOrderValidation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Slf4j
@Service
public class OrderService {

    public final EOrdersRepository eOrdersRepository;
    public final AddressDetailsRepository addressDetailsRepository;
    public final EOrderDetailsRepository eOrderDetailsRepository;
    public final PaymentOrderDetailsRepository paymentOrderDetailsRepository;
    public final ItemDetailsRepository itemDetailsRepository;

    public OrderService(EOrdersRepository eOrdersRepository, AddressDetailsRepository addressDetailsRepository, EOrderDetailsRepository eOrderDetailsRepository, PaymentOrderDetailsRepository paymentOrderDetailsRepository, ItemDetailsRepository itemDetailsRepository) {
        this.eOrdersRepository = eOrdersRepository;
        this.addressDetailsRepository = addressDetailsRepository;
        this.eOrderDetailsRepository = eOrderDetailsRepository;
        this.paymentOrderDetailsRepository = paymentOrderDetailsRepository;
        this.itemDetailsRepository = itemDetailsRepository;
    }

    public OrderResponse getEOrder(int id) {
        OrderResponse orderResponse = new OrderResponse();
        Map<String, String> errorMap = new HashMap<>();
        Optional<EOrders> optionalEOrders = eOrdersRepository.findById(id);
        if(optionalEOrders.isPresent()) {
            orderResponse.setEOrders(optionalEOrders.get());
        } else {
            errorMap.put("Error", String.format("Error while fetching order for OrderId: %d", id));
            orderResponse.setErrorDesc(errorMap);
        }
        return orderResponse;
    }

    public OrderResponse createOrder(OrderCreateRequest orderCreateRequest) {
        EOrders eOrders = orderCreateRequest.getEOrders();
        List<EOrderDetails> eOrderDetailsList = eOrders.orderDetails;
        Integer orderId = eOrders.getId();
        OrderResponse orderResponse = new OrderResponse();
        Map<String, String> errorDesc = new HashMap<>();


        if(!EOrderDetailsValidation.eOrderDetailsListValidation(itemDetailsRepository, eOrderDetailsList, errorDesc) ||
                !EOrderValidation.eOrderValidation(eOrdersRepository,eOrders, errorDesc)
        ) {
            orderResponse.setErrorDesc(errorDesc);
            return orderResponse;
        }

        Double totalAmount = 0.0;
        Double shippingTotal = 0.0;
        for(EOrderDetails e: eOrderDetailsList) {
            System.out.println("Item subtotal:" + e.getItemSubTotal());
            System.out.println("Item Shipping total:" + e.getItemSubTotal());
            totalAmount += (e.getItemSubTotal() == null ? 0 : e.getItemSubTotal());
            shippingTotal += (e.getShippingCharge() == null ? 0 : e.getShippingCharge());
        }

        totalAmount = (totalAmount + shippingTotal) * 1.1;

        eOrders.setTotal(totalAmount);
        eOrders.setShippingTotal(shippingTotal);

        EOrders newOrder = new EOrders();
        newOrder.setOrderDate(eOrders.getOrderDate());
        newOrder.setTotal(eOrders.getTotal());
        newOrder.setShippingTotal(eOrders.getShippingTotal());
        newOrder.setCustomerId(eOrders.getCustomerId());
        newOrder.setId(eOrders.getId());
        newOrder.setStatus(eOrders.getStatus());
        newOrder.setPaymentDetails(eOrders.getPaymentDetails());
        newOrder.setShippingAddressDetails(eOrders.getShippingAddressDetails());

        // Saving Orders
        EOrders order = eOrdersRepository.save(newOrder);
        orderResponse.setEOrders(order);
        for(EOrderDetails e: eOrderDetailsList) {
            e.setOrderId(order.getId());
        }

        // Saving Order Details
        List<EOrderDetails> details = eOrderDetailsRepository.saveAll(eOrderDetailsList);
        order.setOrderDetails(details);

        return orderResponse;
    }

    @Transactional
    public boolean updateOrder(Integer orderId, OrderCreateRequest orderCreateRequest) {
        if(orderId != orderCreateRequest.getEOrders().getId()) {
            return false;
        }
        Optional<EOrders> order = eOrdersRepository.findById(orderId);
        if(order.isPresent()) {
            EOrders o = order.get();
            EOrders updateOrder = orderCreateRequest.getEOrders();
            o.setStatus(updateOrder.getStatus());
            return true;
        }
        return false;
    }
}
