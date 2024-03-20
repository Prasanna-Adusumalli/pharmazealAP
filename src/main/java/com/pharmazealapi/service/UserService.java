package com.pharmazealapi.service;

import com.pharmazealapi.dto.CredentialsDTO;
import com.pharmazealapi.dto.DTOFactory;
import com.pharmazealapi.dto.UserDTO;
import com.pharmazealapi.entity.User;
import com.pharmazealapi.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    @Autowired
    private final DTOFactory dtoFactory;
    public UserDTO getUserDetails(CredentialsDTO credentialsDTO){
        return dtoFactory.createUserDTO(userRepository.findByEmail(credentialsDTO.getEmail()).get());
    }
    public boolean login(CredentialsDTO credentialsDTO){
        User user=userRepository.findByEmail(credentialsDTO.getEmail()).orElse(null);
        if(user!=null&&credentialsDTO.getEmail()!=null&&credentialsDTO.getPassword()!=null){
            return credentialsDTO.getEmail().equals(user.getEmail())&&credentialsDTO.getPassword().equals(user.getPassword());
        }
        return false;
    }
}
