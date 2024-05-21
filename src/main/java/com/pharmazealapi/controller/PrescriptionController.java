package com.pharmazealapi.controller;

import com.pharmazealapi.dto.DrugDTO;
import com.pharmazealapi.dto.PrescriptionDTO;
import com.pharmazealapi.service.PrescriptionService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path="prescription")
@AllArgsConstructor
public class PrescriptionController {
    @Autowired
    PrescriptionService prescriptionService;
    @CrossOrigin(origins = "*")
    @GetMapping(path = "location/{location}")
    public List<PrescriptionDTO> getDrugsByLocation(@PathVariable("location") String location) {
        List<PrescriptionDTO> prescriptionDTOList = prescriptionService.getPrescriptionsByLocation(location);
        return prescriptionDTOList;
    }
}
