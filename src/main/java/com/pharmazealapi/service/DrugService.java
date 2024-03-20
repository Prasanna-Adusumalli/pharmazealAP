package com.pharmazealapi.service;

import com.pharmazealapi.dto.DTOFactory;
import com.pharmazealapi.dto.DrugDTO;
import com.pharmazealapi.entity.Drug;
import com.pharmazealapi.repository.DrugRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class DrugService {
    private final DrugRepository drugRepository;
    @Autowired
    private DTOFactory dtoFactory;
    public List<DrugDTO> getSummaryOfAllDrugs(){
        List<DrugDTO> drugDTOList=new ArrayList<>();
        List<Drug> drugList=drugRepository.findAll();
        for(Drug d:drugList){
            drugDTOList.add(dtoFactory.createDrugDTO(d));
        }
        return drugDTOList;
    }
}
