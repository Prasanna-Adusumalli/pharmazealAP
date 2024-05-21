package com.pharmazealapi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class NewSaleItemDTO {
    private final String drugName;
    private final String condition;
    private final int quantity;
    private final Double price;
}
