package com.company.discount;

import lombok.Getter;

import java.util.UUID;

@Getter
public class RateBasedDiscount extends Discount{

    private Double rateAmount;
    public RateBasedDiscount(UUID id, String name, Double thresholdAmount, Double rateAmount) {
        super(id, name, thresholdAmount);
        this.rateAmount = rateAmount;
    }

    @Override
    public Double CartAmountAfterDiscountApplied(Double amount) throws Exception {
        if (amount >= getThresholdAmount()) {
            Double discountAmount = (rateAmount / 100) * amount;
            return amount - discountAmount;
        }
        throw new Exception("discount couldn't applied");
    }
}
