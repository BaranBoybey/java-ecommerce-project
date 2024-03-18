package balance;

import java.util.UUID;

public class CustomerBalance extends Balance{
    public CustomerBalance(UUID customerId, Double balance) {
        super(customerId, balance);
    }

    @Override
    public void addBalance(Double additionalBalance) {
        setBalance(getBalance() + additionalBalance);
    }


}
