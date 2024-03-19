import category.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;
@Getter
@AllArgsConstructor
@ToString
public class Product {
    private UUID id;
    private String name;
    private double price;
    private int remainingStock;
    private UUID categoryId;

    public LocalDate getDeliveryDueDate() {
        for (Category category : StaticConstants.CATEGORY_MAP) {
            if (categoryId.toString().equals(category.getId().toString())) {
                return category.DeliveryDueDate();
            }
        }
        return null;
    }

    static Product findProductById(String productId) {

        for (Product product : StaticConstants.PRODUCT_LIST) {
            if (product.getId().toString().equals(productId)) {
                return product;
            }
        }
        return null;
    }


}
