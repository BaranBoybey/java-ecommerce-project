package com.company.order;

import com.company.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@AllArgsConstructor
@Getter
@Setter

public class Order {
    private UUID id;
    private LocalDateTime orderDate;
    private Double cartTotalAmount;
    private Double paidAmount;
    private Double discountAmount;
    private UUID customerId;
    private String orderStatus;
    private Set<Product> productList;

    public LocalDate orderDeliveryDate(Order order) {
        LocalDate maxDeliveryDate = LocalDate.MIN;

        for (Product product : order.getProductList()) {
            LocalDate deliveryDueDate = product.getDeliveryDueDate();
            if (deliveryDueDate.isAfter(maxDeliveryDate)) {
                maxDeliveryDate = deliveryDueDate;
            }
        }

        return maxDeliveryDate;

    }
}
