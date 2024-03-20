package com.company;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;
import java.util.UUID;

@AllArgsConstructor
@Setter
@Getter

public class Cart {

    private Customer customer;
    private UUID discountId;
    private int quantity;
    private Map<Product, Integer> productMap;

    public Cart(Customer customer) {
        this.customer = customer;
    }

    public double calculateCartTotalAmount() {
        double totalAmount = 0;
        for (Product product: productMap.keySet()) {
            totalAmount += product.getPrice() * productMap.get(product);
        }
        return totalAmount;
    }

}
