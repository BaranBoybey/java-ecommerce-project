import java.util.UUID;

public class DataGenerator {

    public static void createCustomer() {
        Address address1 = new Address(State.ILLINOIS, "Springfield", "12345", "123 main st");
        Customer customer1 = new Customer(UUID.randomUUID(), "John Doe", "john@example.com", address1);

        Customer customer2 = new Customer(UUID.randomUUID(), "Jane Smith", "jane@example.com"); // Constructor without address

        StaticConstants.CUSTOMER_LIST.put(customer1.getId(), customer1);
        StaticConstants.CUSTOMER_LIST.put(customer2.getId(), customer2);
    }
}
