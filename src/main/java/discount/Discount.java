package discount;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor

public abstract class Discount {

    private UUID id;
    private String name;
    private Double thresholdAmount;

    public abstract Double CartAmountAfterDiscountApplied(Double amount);
}
