package com.pharmazealapi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="address")
public class Address {
    @Id
    @Column(name="address_id")
    private int addressId;
    @Column(name="house_number")
    private int houseNumber;
    @Column(name="street_name")
    private String streetName;
    @Column(name="post_code")
    private String postCode;
    @Column(name="city")
    private String city;
    @Column(name="county")
    private String county;
    @Column(name="country")
    private String country;

    @Override
    public String toString() {
        return String.format
                ("%s, %s, %s, %s, %s,%s", houseNumber, streetName, postCode, city, county,country);
    }
}
