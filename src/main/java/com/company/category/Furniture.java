package com.company.category;

import com.company.order.Order;

import java.time.LocalDate;
import java.util.UUID;

public class Furniture extends Category {
    public Furniture(UUID id, String name) {
        super(id, name);
    }

    @Override
    public LocalDate DeliveryDueDate() {
        return LocalDate.now().plusDays(1);
    }
}
