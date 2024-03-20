package com.company.category;

import java.time.LocalDate;
import java.util.UUID;

public class SkinCare extends Category {
    public SkinCare(UUID id, String name) {
        super(id, name);
    }

    @Override
    public LocalDate DeliveryDueDate() {
        return LocalDate.now();
    }
}
