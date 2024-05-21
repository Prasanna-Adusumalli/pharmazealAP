package com.pharmazealapi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class NewSaleDTO {
    //private final int salesId;
    private final String location;
    private final int customerNHS;
    private final String customerName;
    //private final String drugNameList;
    private final List<NewSaleItemDTO> salesItemDTOList;
   // private final Double price;
    private final String employeeEmail;
    //private final String employeeName;
    private final String idVerified;
    private final Date sellingDate;
}
