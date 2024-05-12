package com.pharmazealapi.dto;

import com.pharmazealapi.entity.*;
import org.flywaydb.core.internal.util.DateUtils;
import org.hibernate.type.descriptor.DateTimeUtils;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@Component
public class DTOFactory {
    public UserDTO createUserDTO(User user){
        return new UserDTO(user.getUserId(), user.getName(), user.getGender(),user.getContact(),user.getEmail(), user.getPassword(), user.getRole(),user.getStatus(),user.getLocation().toString());
    }
    public DrugDTO createDrugDTO(Drug drug, DrugAvailability drugAvailability){
        String expiryDate="";
        if(drugAvailability.getExpiryDate()!=null){
            expiryDate=DateFormat.getDateInstance().format(drugAvailability.getExpiryDate());
        }
        return new DrugDTO(drug.getDrugId(),drug.getName(), drug.getHealthCondition(), drug.getIdCheck(),drugAvailability.getAvailability(),drugAvailability.getQuantity(),
                drug.getPrice(),expiryDate );
    }

    public CustomerDTO createCustomerDTO(Customer customer, Address address,Location location){
        String dob=DateFormat.getDateInstance().format(customer.getDob());
        return new CustomerDTO(customer.getNhsNumber(),dob, customer.getLastName(), customer.getFirstName(),customer.getGender(),
                customer.getIsVulnerable(),address.toString(), location.getLocationName(), customer.getAllergiticDrug(),customer.getMedicalCondition());

    }

    public SalesItemDTO createSalesItemDTO(SalesItem salesItem,Drug drug){
        return new SalesItemDTO(drug.getDrugId(), drug.getName(), salesItem.getQuantity(), salesItem.getPrice());
    }

    public SalesDTO createSalesDTO(Sales sales,Location Location,Customer customer,User user, Double price, List<SalesItemDTO> itemList) {
        String drugList="";
        int count=0;
        for(SalesItemDTO dto:itemList){
            if(count==0){
                drugList=dto.getDrugName();
            }
            else{
            drugList=drugList+", "+ dto.getDrugName();}
            count+=1;
        }
        return new SalesDTO(sales.getSalesId(), Location.getLocationName(), customer.getNhsNumber(),
                customer.getFullName(),drugList, itemList, price.doubleValue(), user.getUserId(), user.getName(),
                sales.getIdVerified(), sales.getSalesDate());
    }

    public NotificationDTO createNotificationDTO(String message){
        return new NotificationDTO(message);
    }

}
