DataBase Design
--------------------------

- Database Table Design
1. EOrders and EOrderDetails Tables (Application Table): EOrders is the main table, which contains the order-id, payment-id.
For the corresponding orderId in the EOrders table, one or more entry can be present in EOrdersDetails table. Each entry in the EOrderDetails table for the respective order-id represents the single item type in the order. So multiple entry in the EOrderDetails means, an order contains multiple item types to be delivered. 
And then similarly, EOrders contains total field, is the total sum of the order, which is equivalent to the sum of itemSubTotal of each item in the EOrderDetails plus sum of the shipping charge of each item and including the tax (Which is default 10% as of now).
2. ItemDetails: It is an static table that contains the item details 
3. PaymentOrderDetails: It contains payment options.

Note: I haven't created a foreign key relationship because of the time constraint.

Application Design
----------------------------
- Controller: It contains the controller of the orders service
- Model: Defined all the table models
- Service: Return the OrderResponse datatype 
    1. GetOrder Service: 
    2. CreateOrder Service
 - Repository: Create JPA repository to fetch the Database 

