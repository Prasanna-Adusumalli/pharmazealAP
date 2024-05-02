package com.pharmazealapi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class SalesDTO {
    private final int salesId;
    private final String location;
    private final int customerNHS;
    private final String customerName;
    private final List<SalesItemDTO> salesItemDTOList;
    private final Double price;
    private final int employeeId;
    private final String employeeName;
    private final String idVerified;
    private final Date sellingDate;
}
