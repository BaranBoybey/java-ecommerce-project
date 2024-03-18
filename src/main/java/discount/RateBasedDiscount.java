package discount;

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
    public Double CartAmountAfterDiscountApplied(Double amount) {
        return null;
    }
}
