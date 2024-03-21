package com.company.discount;

import lombok.Getter;

import java.util.UUID;

@Getter
public class AmountBasedDiscount extends Discount{

    private Double discountAmount;
    public AmountBasedDiscount(UUID id, String name, Double thresholdAmount, Double discountAmount) {

        super(id, name, thresholdAmount);
    }

    @Override
    public Double CartAmountAfterDiscountApplied(Double amount) throws Exception {
        if (amount >= getThresholdAmount()) {
            Double discountAmount = getDiscountAmount();
            if (discountAmount >= amount){
                return 0.0;
            }
            return amount - discountAmount;
        }
        throw new Exception("discount couldn't applied");
    }
}
