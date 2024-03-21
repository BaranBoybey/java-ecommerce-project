package com.company.discount;

import com.company.Cart;
import com.company.Customer;
import com.company.StaticConstants;
import lombok.Getter;

import java.util.UUID;
@Getter

public class ReferenceCodeDiscount extends Discount{

    private Double rateAmount;
    public ReferenceCodeDiscount(UUID id, String name, Double thresholdAmount, Double rateAmount) {
        super(id, name, thresholdAmount);
        this.rateAmount = rateAmount;
    }

    public boolean IsDiscountApplicableToCart(Customer customer, Cart cart) {
        if (customer.getReferenceCode() != null && cart.calculateCartTotalAmount() >= 25) {
            for (Customer eachCustomer : StaticConstants.CUSTOMER_LIST) {
                if (eachCustomer.getId().toString().equals(customer.getReferenceCode().toString())) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public Double CartAmountAfterDiscountApplied(Double amount) throws Exception {
        Double discountAmount = (25/100) * amount;
        return amount - discountAmount;
    }
}
