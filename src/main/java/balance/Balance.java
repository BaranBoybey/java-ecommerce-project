package balance;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;
@AllArgsConstructor
@Getter
@Setter

public abstract class Balance {

    private UUID customerId;
    private Double balance;

    public abstract void addBalance(Double additionalBalance);

}
