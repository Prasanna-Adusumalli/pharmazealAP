package com.pharmazealapi.service;

import com.pharmazealapi.dto.DTOFactory;
import com.pharmazealapi.dto.DrugDTO;
import com.pharmazealapi.dto.PrescriptionDTO;
import com.pharmazealapi.entity.*;
import com.pharmazealapi.repository.CustomerRepository;
import com.pharmazealapi.repository.DrugRepository;
import com.pharmazealapi.repository.ExistingPrescriptionRepository;
import com.pharmazealapi.repository.LocationRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class PrescriptionService {
    @Autowired
    ExistingPrescriptionRepository existingPrescriptionRepository;
    LocationRepository locationRepository;
    DrugRepository drugRepository;
    CustomerRepository customerRepository;
    @Autowired
    DTOFactory dtoFactory;

    public List<PrescriptionDTO> getPrescriptionsByLocation(String locationName){
        List<PrescriptionDTO> prescriptionDTOList=new ArrayList<>();
        Location location=locationRepository.findByLocationNameEqualsIgnoreCase(locationName).orElse(null);
        List<ExistingPrescription> prescriptionList=existingPrescriptionRepository.findAllByLocationId(location.getLocationId());
        for(ExistingPrescription prescription:prescriptionList){
            Drug drug=drugRepository.findById(prescription.getDrugId()).get();
            Customer customer=customerRepository.findById(prescription.getCustomerNHS()).get();
            prescriptionDTOList.add(dtoFactory.createPrescriptionDTO(prescription,location.getLocationName(),
                    drug,customer));
        }
        return prescriptionDTOList;
    }
}
