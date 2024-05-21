package com.pharmazealapi.service;

import com.pharmazealapi.dto.CredentialsDTO;
import com.pharmazealapi.dto.DTOFactory;
import com.pharmazealapi.dto.NewUserDTO;
import com.pharmazealapi.dto.UserDTO;
import com.pharmazealapi.entity.EntityFactory;
import com.pharmazealapi.entity.Location;
import com.pharmazealapi.entity.User;
import com.pharmazealapi.repository.LocationRepository;
import com.pharmazealapi.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final LocationRepository locationRepository;
    private final String active="ACTIVE";
    enum Role{admin,employee};
    @Autowired
    private final DTOFactory dtoFactory;
    @Autowired
    private final EntityFactory entityFactory;
    public UserDTO getUserDetails(CredentialsDTO credentialsDTO){
        return dtoFactory.createUserDTO(userRepository.findByEmail(credentialsDTO.getEmail()).orElse(null));
    }
    // to verify login is successful or not
    public boolean login(CredentialsDTO credentialsDTO){
        if(credentialsDTO.getEmail()!=null && credentialsDTO.getPassword()!=null) {
            User user = userRepository.findByEmail(credentialsDTO.getEmail()).orElse(null);
            if (user != null && active.equals(user.getStatus())) {
                return credentialsDTO.getEmail().equals(user.getEmail()) && credentialsDTO.getPassword().equals(user.getPassword());
            }
        }
        return false;
    }
   //To get list of all users
    public List<UserDTO> getAllUserDetails(){
        List<User> userList=userRepository.findAll();
        List<UserDTO> userDTOList=new ArrayList<>();
        for(User user:userList){
            if(active.equals(user.getStatus()))
                userDTOList.add(dtoFactory.createUserDTO(user));
        }
        return userDTOList;
    }
    //To get list of only employees
    public List<UserDTO> getAllEmployeeDetails(){
        List<User> userList=userRepository.findAllByRole(String.valueOf(Role.employee));
        List<UserDTO> userDTOList=new ArrayList<>();
        for(User user:userList){
            userDTOList.add(dtoFactory.createUserDTO(user));
        }
        return userDTOList;
    }
    //To delete a employee
    public boolean deleteEmployee(int id){
        int recordDeleted= userRepository.deleteByUserId(id);
        if(recordDeleted==1)
            return true;
        return false;
    }

    public void createNewUser(NewUserDTO newUserDTO){
        Location location=locationRepository.findByLocationNameEqualsIgnoreCase(newUserDTO.getLocation()).get();
        userRepository.save(entityFactory.createNewUser(location,newUserDTO));
    }
}
