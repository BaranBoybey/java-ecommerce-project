import balance.Balance;
import balance.CustomerBalance;
import balance.GiftCardBalance;
import category.Category;
import discount.Discount;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {

        DataGenerator.createCustomer();
        DataGenerator.createCategory();
        DataGenerator.createProduct();
        DataGenerator.createBalance();
        DataGenerator.createDiscount();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Select customer");

        for (int i = 0; i < StaticConstants.CUSTOMER_LIST.size(); i++) {
            System.out.println("type " + i + " for customer: " + StaticConstants.CUSTOMER_LIST.get(i).getUsername());
        }

        System.out.println("===>");

        Customer customer = StaticConstants.CUSTOMER_LIST.get(scanner.nextInt());

        Cart cart = new Cart(customer);

        while (true) {

            System.out.println("what would you like to do type id for selection");

            for (int i = 0; i < prepareMenuOptions().length; i++) {
                System.out.println(i + "-" + prepareMenuOptions()[i]);
            }

            int menuSelection = scanner.nextInt();

            switch (menuSelection) {
                case 0:
                    System.out.println("List categories selected");
                    for (Category category : StaticConstants.CATEGORY_MAP) {
                        System.out.println(category.getName() + " : " + category.generateCategoryCode());
                    }
                    break;
                case 1:
                    System.out.println("List products selected");
                    for (Product product : StaticConstants.PRODUCT_LIST) {
                        System.out.println(product);
                        System.out.println(product.getName());
                        System.out.println(product.getCategoryId());
                    }
                    break;
                case 2:
                    System.out.println("List discounts selected");
                    for (Discount discount : StaticConstants.DISCOUNT_LIST) {
                        System.out.println(discount.getName());
                    }
                    break;
                case 3:
                    System.out.println("See balance selected");
                    CustomerBalance customerBalance = findCustomerBalance(customer.getId());
                    GiftCardBalance giftCardBalance = findGiftCardBalance(customer.getId());
                    double totalBalance = customerBalance.getBalance() + giftCardBalance.getBalance();
                    System.out.println("customer balance: " + customerBalance.getBalance());
                    System.out.println("giftCardBalance: " + giftCardBalance.getBalance());
                    break;
                case 4:
                    System.out.println("Add balance selected");
                    System.out.println("which account would you like to add");
                    CustomerBalance customerBalanceAccount = findCustomerBalance(customer.getId());
                    GiftCardBalance giftCardBalanceAccount = findGiftCardBalance(customer.getId());
                    System.out.println("type 1 for customer balance: " + customerBalanceAccount.getBalance());
                    System.out.println("type 2 for gift card balance: " + giftCardBalanceAccount.getBalance());
                    int accountSelection = scanner.nextInt();
                    System.out.println("how much would you like to add?");
                    double additionalAmount = scanner.nextInt();
                    switch (accountSelection){
                        case 1:
                            customerBalanceAccount.addBalance(additionalAmount);
                            System.out.println("new customer balance: $" + customerBalanceAccount.getBalance());
                            break;
                        case 2:
                            giftCardBalanceAccount.addBalance(additionalAmount);
                            System.out.println("new giftcard balance: $" + giftCardBalanceAccount.getBalance());
                            break;
                    }


                    break;
                case 5:
                    System.out.println("Place an order selected");
                    Map<Product, Integer> map = new HashMap<>();
                    cart.setProductMap(map);
                    while (true) {
                        System.out.println("which product would you like to add to your card. to leave type exit");
                        for (Product product : StaticConstants.PRODUCT_LIST) {
                            System.out.println(product.getName() + " $" + product.getPrice() + " stock: " + product.getRemainingStock() +"\n " +
                                   "delivery due date: " + product.getDeliveryDueDate());
                        }
                        String productId = scanner.next();
                        Product product = Product.findProductById(productId);
                        if (!putItemToCartIfStockAvailable(cart, product)){
                            System.out.println("stuck is insufficient");

                        }

                        System.out.println("do you want to add more products y/n");
                        String decision = scanner.next();
                        if (!decision.equals("y")) {
                            break;
                        }
                    }
                    break;
                case 6:
                    System.out.println("See cart selected");
                    break;
                case 7:
                    System.out.println("See order details selected");
                    break;
                case 8:
                    System.out.println("See your address selected");
                    break;
                case 9:
                    System.out.println("Close app selected");
                    break;
                default:
                    System.out.println("Invalid choice");
            }




        }
    }

    private static boolean putItemToCartIfStockAvailable(Cart cart, Product product) {
        System.out.println("please provide product count");
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        Integer cartCount = cart.getProductMap().get(product);

        if (cartCount != null && product.getRemainingStock() > cartCount + count){
            cart.getProductMap().put(product, cartCount + count);
            return true;
        } else if (product.getRemainingStock() > count) {
            cart.getProductMap().put(product,count);
            return true;
        }
        return false;
    }





    private static String[] prepareMenuOptions() {
        return new String[] {
                "List categories", "List products", "List discounts", "see balance", "add balance",
                "place an order", "see cart", "see order details", "see your address", "close app"
        };
    }

    private static CustomerBalance findCustomerBalance(UUID uuid) {
        for (Balance balance : StaticConstants.CUSTOMER_BALANCE_LIST) {
            if (balance.getCustomerId().toString().equals(uuid.toString())){
                return (CustomerBalance) balance;
            }
        }
        CustomerBalance customerBalance = new CustomerBalance(uuid,0.0);
        StaticConstants.CUSTOMER_BALANCE_LIST.add(customerBalance);
        return customerBalance;
    }

    private static GiftCardBalance findGiftCardBalance(UUID uuid) {
        for (Balance balance : StaticConstants.GIFT_CARD_BALANCE_LIST) {
            if (balance.getCustomerId().toString().equals(uuid.toString())) {
                return (GiftCardBalance) balance;
            }
        }
        GiftCardBalance giftCardBalance = new GiftCardBalance(uuid, 0.0);
        StaticConstants.GIFT_CARD_BALANCE_LIST.add(giftCardBalance);
        return giftCardBalance;
    }
}
