package com.example.accessingdatamysql.service.validation;

import com.example.accessingdatamysql.model.EOrderDetails;
import com.example.accessingdatamysql.model.ItemDetails;
import com.example.accessingdatamysql.repository.EOrderDetailsRepository;
import com.example.accessingdatamysql.repository.ItemDetailsRepository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class EOrderDetailsValidation {

    public static boolean eOrderDetailsListValidation(
            ItemDetailsRepository itemDetailsRepository,
            List<EOrderDetails> eOrderDetailsList,
            Map<String, String> errorDesc) {

        for(EOrderDetails orderDetails: eOrderDetailsList) {
            if(!eOrderDetailsValidation(itemDetailsRepository, orderDetails, errorDesc)) {
                return false;
            }
        }
        return true;

    }

    public static boolean eOrderDetailsValidation(
            ItemDetailsRepository itemDetailsRepository,
            EOrderDetails eOrderDetails,
            Map<String, String> errorDesc) {

        String itemId = eOrderDetails.getItemId();
        Optional<ItemDetails> item = itemDetailsRepository.findById(itemId);
        if(item.isPresent()) {
            eOrderDetails.setItemSubTotal(item.get().getPrice() * eOrderDetails.getItemQuantity());
        } else {
            errorDesc.put("Error", String.format("Item %s not present in the repository", itemId));
            return false;
        }


        return true;

    }

}
