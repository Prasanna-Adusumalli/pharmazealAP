package com.pharmazealapi.controller;

import com.pharmazealapi.dto.DrugDTO;
import com.pharmazealapi.service.DrugService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path="drugs")
@AllArgsConstructor
public class DrugRestController {
    @Autowired
    private DrugService drugService;
    @CrossOrigin(origins = "*")
    @PostMapping(path="all")
    public List<DrugDTO> getSummaryOfAllDrugs(){
        return drugService.getSummaryOfAllDrugs();
    }
}
