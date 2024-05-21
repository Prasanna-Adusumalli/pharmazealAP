package com.pharmazealapi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class PrescriptionDTO {
    private final int id;
    private final int customerNHS;
    private final String customerName;
    private final String drugId;
    private final String drugName;
    private final int quantity;
    private final String location;
}
