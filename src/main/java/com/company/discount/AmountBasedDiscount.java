package com.company.discount;

import lombok.Getter;

import java.util.UUID;

@Getter
public class AmountBasedDiscount extends Discount{
    public AmountBasedDiscount(UUID id, String name, Double thresholdAmount) {
        super(id, name, thresholdAmount);
    }

    @Override
    public Double CartAmountAfterDiscountApplied(Double amount) {
        return null;
    }
}
