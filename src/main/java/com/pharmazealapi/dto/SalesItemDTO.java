package com.pharmazealapi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class SalesItemDTO {
    private final String drugId;
    private final String drugName;
    private final int quantity;
    private final Double price;
}
