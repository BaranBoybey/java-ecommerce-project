import category.Category;

import java.util.Scanner;

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

        while (true) {

            System.out.println("what would you like to do type id for selection");

            for (int i = 0; i < prepareMenuOptions().length; i++) {
                System.out.println(i + "-" + prepareMenuOptions()[i]);
            }

            int menuSelection = scanner.nextInt();

            switch (menuSelection) {
                case 1:
                    System.out.println("List categories selected");
                    for (Category category : StaticConstants.CATEGORY_MAP) {
                        System.out.println(category.generateCategoryCode() + "name:  " + category.getName());
                    }
                    break;
                case 2:
                    System.out.println("List products selected");
                    break;
                case 3:
                    System.out.println("List discounts selected");
                    break;
                case 4:
                    System.out.println("See balance selected");
                    break;
                case 5:
                    System.out.println("Add balance selected");
                    break;
                case 6:
                    System.out.println("Place an order selected");
                    break;
                case 7:
                    System.out.println("See cart selected");
                    break;
                case 8:
                    System.out.println("See order details selected");
                    break;
                case 9:
                    System.out.println("See your address selected");
                    break;
                case 10:
                    System.out.println("Close app selected");
                    break;
                default:
                    System.out.println("Invalid choice");
            }




        }
    }

    private static String[] prepareMenuOptions() {
        return new String[] {
                "List categories", "List products", "List discounts", "see balance", "add balance" +
                "place an order", "see cart", "see order details", "see your address", "close app"
        };
    }
}
