package com.company;

import com.company.balance.Balance;
import com.company.balance.CustomerBalance;
import com.company.balance.GiftCardBalance;
import com.company.category.Category;
import com.company.category.Electronic;
import com.company.category.Furniture;
import com.company.category.SkinCare;
import com.company.discount.AmountBasedDiscount;
import com.company.discount.Discount;
import com.company.discount.RateBasedDiscount;

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
        Product product1 =
                new Product(UUID.randomUUID(),"XBOX",399.99,10, StaticConstants.CATEGORY_MAP.get(0).getId()); //Assumming I know that Electronic is at index 0.

        StaticConstants.PRODUCT_LIST.add(product1);
    }

    public static void createBalance() {
        Balance balance1 = new CustomerBalance(StaticConstants.CUSTOMER_LIST.get(1).getId(), 150.00); //Assuming I know customer ID
        Balance giftCardBalance = new GiftCardBalance(StaticConstants.CUSTOMER_LIST.get(0).getId(),100.00);

        StaticConstants.CUSTOMER_BALANCE_LIST.add(balance1);
        StaticConstants.CUSTOMER_BALANCE_LIST.add(giftCardBalance);
    }

    public static void createDiscount() {
        Discount discount = new AmountBasedDiscount(UUID.randomUUID(), "Buy 250 get 50 dollar discount", 250.00);
        StaticConstants.DISCOUNT_LIST.add(discount);

        Discount discount1 = new RateBasedDiscount(UUID.randomUUID(), "10% DISCOUNT WHEN SPENDING $100", 100.00, 10.00);
    }


}
