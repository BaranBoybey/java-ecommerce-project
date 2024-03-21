package com.company;

import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@ToString

public class Customer {
    private UUID id;
    private UUID referenceCode;
    private String username, email;
    private List<Address> address;

    public Customer(UUID id, UUID referenceCode,String username, String email, Address address) {
        this.id = id;
        this.referenceCode = referenceCode;
        this.username = username;
        this.email = email;
        this.address = new ArrayList<>();
        this.address.add(address);
    }

    public Customer(UUID id, UUID referenceCode,String username, String email) {
        this.id = id;
        this.referenceCode = referenceCode;
        this.username = username;
        this.email = email;
        this.address = new ArrayList<>();
    }

    public void addAddress(Address address) {
        this.address.add(address);
    }
}
