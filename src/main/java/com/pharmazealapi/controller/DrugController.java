package com.pharmazealapi.controller;

import com.pharmazealapi.dto.DrugDTO;
import com.pharmazealapi.dto.NotificationDTO;
import com.pharmazealapi.service.DrugService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path="drugs")
@AllArgsConstructor
public class DrugController {
    @Autowired
    private DrugService drugService;

    @CrossOrigin(origins = "*")
    @GetMapping(path = "location/{location}")
   public List<DrugDTO> getDrugsByLocation(@PathVariable("location") String location) {
        List<DrugDTO> drugDTOList = drugService.getDrugsByLocation(location);
        return drugDTOList;
    }

    @CrossOrigin(origins = "*")
    @GetMapping(path = "notifications/{location}")
    public List<NotificationDTO> generateNotifications(@PathVariable("location") String location) {
        List<NotificationDTO> notificationList = drugService.generateNotifications(location);
        return notificationList;
    }
}
