package com.pharmazealapi.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@Getter
@Setter
public class CustomerDTO {
    private int nhsNumber;
    private String dob;
    private String lastName;
    private String firstName;
    private String gender;
    private String isVulnerable;
    private String address;
    private String location;
    private String allergiticDrug;
    private String medicalCondition;
}
