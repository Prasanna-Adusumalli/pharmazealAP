package com.pharmazealapi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class DrugDTO {
    private final int drugId;
    private final String name;
    private final String healthCondition;
    private final String idCheck;
}
