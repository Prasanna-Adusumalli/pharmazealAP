package com.pharmazealapi.controller;

import com.pharmazealapi.dto.CredentialsDTO;
import com.pharmazealapi.dto.UserDTO;
import com.pharmazealapi.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path="user")
@AllArgsConstructor
public class UserRestController {
    @Autowired
    private UserService userService;
    @PostMapping(path="login")
    public boolean loginAccount(@RequestBody CredentialsDTO credentialsDTO){
        return userService.login(credentialsDTO);
    }

    @PostMapping(path="details")
    public UserDTO getUserDetails(@RequestBody CredentialsDTO credentialsDTO){
        return userService.getUserDetails(credentialsDTO);
    }

}
