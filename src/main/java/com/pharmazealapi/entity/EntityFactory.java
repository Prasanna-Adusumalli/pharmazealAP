package com.pharmazealapi.entity;

import com.pharmazealapi.dto.NewSaleDTO;
import com.pharmazealapi.dto.NewSaleItemDTO;
import com.pharmazealapi.dto.NewUserDTO;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class EntityFactory {
    public Sales createSalesEntity(Location location,User user,NewSaleDTO newSaleDTO){
        return new Sales(0,location.getLocationId(), newSaleDTO.getCustomerNHS(), newSaleDTO.getCustomerName(),
                user.getUserId(), newSaleDTO.getIdVerified(),new Date());

    }

    public SalesItem createSalesItemEntity(Sales sales, Drug drug,NewSaleItemDTO newSaleItemDTO){
        return new SalesItem(0,sales.getSalesId(), drug.getDrugId(),newSaleItemDTO.getQuantity(),newSaleItemDTO.getPrice());
    }

    public User createNewUser(Location location, NewUserDTO newUserDTO){
        return new User(0,newUserDTO.getName(),newUserDTO.getGender()
                ,newUserDTO.getContact(),newUserDTO.getEmail(),
                newUserDTO.getPassword(),newUserDTO.getRole(),"ACTIVE",location);

    }
}
