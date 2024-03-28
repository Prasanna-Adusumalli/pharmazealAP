package com.pharmazealapi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@Getter
@Setter
public class DrugDTO {
    private final String drugId;
    private final String name;
    private final String healthCondition;
    private final String idCheck;
    private final String availability;
    private final int quantity;
    private final int price;
    private final String expiryDate;
}
