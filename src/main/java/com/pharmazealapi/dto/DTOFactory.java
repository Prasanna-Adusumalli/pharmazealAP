package com.pharmazealapi.dto;

import com.pharmazealapi.entity.Drug;
import com.pharmazealapi.entity.DrugAvailability;
import com.pharmazealapi.entity.User;
import org.flywaydb.core.internal.util.DateUtils;
import org.hibernate.type.descriptor.DateTimeUtils;
import org.springframework.stereotype.Component;

import java.text.DateFormat;

@Component
public class DTOFactory {
    public UserDTO createUserDTO(User user){
        return new UserDTO(user.getUserId(), user.getName(), user.getGender(),user.getContact(),user.getEmail(), user.getPassword(), user.getRole(),user.getLocation().toString());
    }
    public DrugDTO createDrugDTO(Drug drug, DrugAvailability drugAvailability){
        String expiryDate="";
        if(drugAvailability.getExpiryDate()!=null){
            expiryDate=DateFormat.getDateInstance().format(drugAvailability.getExpiryDate());
        }
        return new DrugDTO(drug.getDrugId(),drug.getName(), drug.getHealthCondition(), drug.getIdCheck(),drugAvailability.getAvailability(),drugAvailability.getQuantity(),
                drug.getPrice(),expiryDate );
    }

    public NotificationDTO createNotificationDTO(String message){
        return new NotificationDTO(message);
    }

}
