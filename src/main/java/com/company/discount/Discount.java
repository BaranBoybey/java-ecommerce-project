package com.company.discount;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;
import com.company.Cart;

@Getter
@AllArgsConstructor

public abstract class Discount {

    private UUID id;
    private String name;
    private Double thresholdAmount;

    public boolean IsDiscountApplicableToCart(Cart cart) {
        return cart.calculateCartTotalAmount() >= thresholdAmount;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract Double CartAmountAfterDiscountApplied(Double amount) throws Exception;
}
