package com.pharmazealapi.service;

import com.pharmazealapi.dto.DTOFactory;
import com.pharmazealapi.dto.DrugDTO;
import com.pharmazealapi.dto.NotificationDTO;
import com.pharmazealapi.entity.Drug;
import com.pharmazealapi.entity.DrugAvailability;
import com.pharmazealapi.entity.Location;
import com.pharmazealapi.repository.DrugAvailabilityRepository;
import com.pharmazealapi.repository.DrugRepository;
import com.pharmazealapi.repository.LocationRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class DrugService {
    private final DrugRepository drugRepository;
    private final LocationRepository locationRepository;
    private final DrugAvailabilityRepository availabilityRepository;
    @Autowired
    private DTOFactory dtoFactory;
    // To get drug list by location
    public List<DrugDTO> getDrugsByLocation(String locationName){
        List<DrugDTO> drugDTOList=new ArrayList<>();
        Location location=locationRepository.findByLocationNameEqualsIgnoreCase(locationName).orElse(null);
        List<Drug> drugList=drugRepository.findAll();
        for(Drug drug:drugList){
            DrugAvailability drugAvailability=availabilityRepository.findByDrugIdAndLocationId
                    (drug.getDrugId(),location.getLocationId()).orElse(getDummyObject());
            drugDTOList.add(dtoFactory.createDrugDTO(drug,drugAvailability));
        }
        return drugDTOList;
    }

    public Drug getDrugsByNameAndCondition(String name, String condition, String locationName){
        Drug drug=drugRepository.findByNameAndAndHealthCondition(name,condition).get();
        return drug;
    }

    //To generate notifications in case the quantity is less than 10 or stock is expired
    public List<NotificationDTO> generateNotifications(String locationName){
        List<NotificationDTO> notificationDTOList=new ArrayList<>();
        Location location=locationRepository.findByLocationNameEqualsIgnoreCase(locationName).orElse(null);
        List<DrugAvailability> drugAvailabilities=availabilityRepository.findAllByLocationId(location.getLocationId());
        Date currentDate=new Date();
        for(DrugAvailability availability:drugAvailabilities){
            if(availability.getExpiryDate()!=null&&currentDate.compareTo(availability.getExpiryDate())>0){
                Drug drug=drugRepository.findById(availability.getDrugId()).orElse(null);
                String message="Stock of "+drug.getName() +" is expired";
                notificationDTOList.add(dtoFactory.createNotificationDTO(message));
            }
            if("Y".equals(availability.getAvailability())&&availability.getQuantity()<=10){
                Drug drug=drugRepository.findById(availability.getDrugId()).orElse(null);
                String message="Quantity of "+drug.getName() +" is less than 10";
                notificationDTOList.add(dtoFactory.createNotificationDTO(message));
            }
        }
        return notificationDTOList;
    }

    private DrugAvailability getDummyObject(){
        DrugAvailability availability=new DrugAvailability();
        availability.setAvailability("N");
        availability.setQuantity(0);
        availability.setExpiryDate(new Date());
        return availability;
    }
}
