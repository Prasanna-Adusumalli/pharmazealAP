package com.pharmazealapi.dto;

import com.pharmazealapi.entity.Drug;
import com.pharmazealapi.entity.User;
import org.springframework.stereotype.Component;

@Component
public class DTOFactory {
    public UserDTO createUserDTO(User user){
        return new UserDTO(user.getUserId(), user.getName(), user.getGender(),user.getContact(),user.getEmail(), user.getPassword(), user.getRole(),user.getLocation().toString());
    }
    public DrugDTO createDrugDTO(Drug drug){
        return new DrugDTO(drug.getDrugId(),drug.getName(), drug.getHealthCondition(), drug.getIdCheck());
    }

}
