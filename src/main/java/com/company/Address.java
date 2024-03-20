package com.company;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString

public class Address {

    private State state;
    private String zipCode, city,streetAddress, AdditionalAddressLine;

    public Address(State state, String city,String zipCode, String streetAddress) {
        this.state = state;
        this.zipCode = zipCode;
        this.city = city;
        this.streetAddress = streetAddress;
    }

}
