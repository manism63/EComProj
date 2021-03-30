DataBase Design
--------------------------
1. EOrders and EOrderDetails Tables (Application Table): EOrders is the main table, which contains the order-id, payment-id.
For the corresponding orderId in the EOrders table, one or more entry can be present in EOrdersDetails table. Each entry in the EOrderDetails table for the respective order-id represents the single item type in the order. So multiple entry in the EOrderDetails means, an order contains multiple item types to be delivered. 
And then similarly, EOrders contains total field, is the total sum of the order, which is equivalent to the sum of itemSubTotal of each item in the EOrderDetails plus sum of the shipping charge of each item and including the tax (Which is default 10% as of now).
2. ItemDetails: It is an static table that contains the item details 
3. PaymentOrderDetails: It contains payment options.

> Note: I haven't created a foreign key relationship because of the time constraint.

Application Design
----------------------------
- Controller: It contains the controller of the orders service
- Model: Defined all the table models
- Service: Return the OrderResponse datatype 
    1. GetOrder Service: 
    2. CreateOrder Service
 - Repository: Create JPA repository to fetch the Database 

 
 EndPoints:
 -------------------------------
 - GetOrder service: `localhost:8080/v1/getEOrder/1`
##### Response Type
 ```
{
    "eorders": {
        "id": 1,
        "customerId": "100",
        "status": "Pending",
        "paymentDetails": {
            "paymentId": 1,
            "customerId": "100",
            "methodType": "CARD",
            "date": "2020-05-01T20:32:10Z",
            "confirmationNumber": "CONF_01",
            "billingAddressDetails": {
                "addressId": 1,
                "addressType": "HOME",
                "city": "SEATTLE",
                "line1": "1314 Spring Street",
                "line2": "Apt 203",
                "state": "WA",
                "zip": "98104"
            }
        },
        "orderDate": "2020-05-01T20:32:10.000+00:00",
        "shippingAddressDetails": {
            "addressId": 1,
            "addressType": "HOME",
            "city": "SEATTLE",
            "line1": "1314 Spring Street",
            "line2": "Apt 203",
            "state": "WA",
            "zip": "98104"
        },
        "total": 110,
        "shippingTotal": 10,
        "orderDetails": [
            {
                "orderId": 1,
                "subOrderId": 1,
                "orderStatus": "Pending",
                "itemId": "item_1",
                "itemQuantity": 1,
                "itemSubTotal": 50,
                "orderDate": "2020-05-01T20:32:10Z",
                "shippingCharge": 5
            }
        ]
    }
}
```
- Create Order Endpoint: `localhost:8080/v1/createEOrder`
##### Request Type:
```
{
    "eorders": {
        "id": 1,
        "customerId": "1",
        "status": "OrderPlaced",
        "paymentId": 1212,
        "orderDate": "2021-03-20T08:07:54.748+00:00",
        "shippingAddressId": 1
    },
    "eorderDetailsList": [
        {
            "orderId": 1,
            "subOrderId": 1,
            "orderStatus": "Pending",
            "itemId": "it_00",
            "itemQuantity": 1,
            "itemSubTotal": 15.0,
            "orderDate": "2020-01-01",
            "shippingCharge": 1
        }
    ]
}
```

##### Response Type

```
{
    "eorders": {
        "id": 1,
        "customerId": "1",
        "status": "OrderPlaced",
        "paymentId": 1212,
        "orderDate": "2021-03-20T08:07:54.748+00:00",
        "shippingAddressId": 1,
        "total": 17.6,
        "shippingTotal": 1
    },
    "eorderDetailsList": [
        {
            "orderId": 1,
            "subOrderId": 1,
            "orderStatus": "Pending",
            "itemId": "it_00",
            "itemQuantity": 1,
            "itemSubTotal": 15,
            "orderDate": "2020-01-01",
            "shippingCharge": 1
        }
    ]
}
```
