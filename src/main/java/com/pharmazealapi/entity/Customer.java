package com.pharmazealapi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="customer")
public class Customer {
    @Id
    @Column(name="nhs_number")
    private int nhsNumber;
    @Column(name="date_of_birth")
    private Date dob;
    @Column(name="last_name")
    private String lastName;
    @Column(name="first_name")
    private String firstName;
    @Column(name="gender")
    private String gender;
    @Column(name="is_vulnerable")
    private String isVulnerable;
    @Column(name="address_id")
    private int addressId;
    @Column(name="location_id")
    private int locationId;
    @Column(name="allergitic_drug")
    private String allergiticDrug;
    @Column(name="medical_condition")
    private String medicalCondition;

    public String getFullName(){
        return getFirstName()+getLastName();
    }
}
