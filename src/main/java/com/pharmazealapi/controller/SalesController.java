package com.pharmazealapi.controller;

import com.pharmazealapi.dto.DrugDTO;
import com.pharmazealapi.dto.SalesDTO;
import com.pharmazealapi.service.DrugService;
import com.pharmazealapi.service.SalesService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path="sales")
@AllArgsConstructor
public class SalesController {

    @Autowired
    private SalesService salesService;

    @CrossOrigin(origins = "*")
    @GetMapping(path = "location/{location}")
    public List<SalesDTO> getSalesByLocation(@PathVariable("location") String location) {
        List<SalesDTO> salesDTOList = salesService.getSalesByLocation(location);
        return salesDTOList;
    }

}
