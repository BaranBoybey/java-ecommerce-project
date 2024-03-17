import category.Category;
import category.Electronic;
import category.Furniture;
import category.SkinCare;

import java.util.UUID;

public class DataGenerator {

    public static void createCustomer() {
        Address address1 = new Address(State.ILLINOIS, "Springfield", "12345", "123 main st");
        Customer customer1 = new Customer(UUID.randomUUID(), "John Doe", "john@example.com", address1);

        Customer customer2 = new Customer(UUID.randomUUID(), "Jane Smith", "jane@example.com"); // Constructor without address

        StaticConstants.CUSTOMER_LIST.add(customer1);
        StaticConstants.CUSTOMER_LIST.add(customer2);
    }

    public static void createCategory() {
        Category category1 = new Electronic(UUID.randomUUID(), "Electronic");
        Category category2 = new Furniture(UUID.randomUUID(), "Furniture");
        Category category3 = new SkinCare(UUID.randomUUID(), "Skin care");

        StaticConstants.CATEGORY_MAP.add(category1);
        StaticConstants.CATEGORY_MAP.add(category2);
        StaticConstants.CATEGORY_MAP.add(category3);
    }

    public static void createProduct() {
        Product product1 = new Product(UUID.randomUUID(),"XBOX",399.99,10, StaticConstants.CATEGORY_MAP.get(0).getId());
    }
}
