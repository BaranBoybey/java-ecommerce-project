package category;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.util.UUID;
@AllArgsConstructor
@Getter
public abstract class Category {

    private UUID id;
    private String name;

    public abstract LocalDate DeliveryDueDate();

    public String generateCategoryCode() {
        return getId().toString().substring(0,8).concat("-").concat(getName().substring(0,2));
    }

}


