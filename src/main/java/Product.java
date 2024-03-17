import category.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.UUID;
@Getter
@AllArgsConstructor
@ToString
public class Product {
    private UUID id;
    private String name;
    private double price;
    private int remainingStock;
    private Category category;


}
