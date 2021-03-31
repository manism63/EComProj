package com.example.accessingdatamysql.service.validation;

import com.example.accessingdatamysql.model.EOrderDetails;
import com.example.accessingdatamysql.model.EOrders;
import com.example.accessingdatamysql.repository.EOrdersRepository;
import com.example.accessingdatamysql.repository.ItemDetailsRepository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class EOrderValidation {

    public static boolean eOrderValidation(EOrdersRepository eOrdersRepository,
                                           EOrders eOrder,
                                           Map<String, String> errorDesc)  {
        if(eOrder.getId() == null) return true;
        Optional<EOrders> optionalEOrders = eOrdersRepository.findById(eOrder.getId());
        if(optionalEOrders.isPresent()) {
            errorDesc.put("Error", String.format("Order already present %s", eOrder.getId()));
            return false;
        }
        return true;
    }
}
