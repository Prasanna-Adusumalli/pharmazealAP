package com.pharmazealapi.controller;

import com.pharmazealapi.dto.CredentialsDTO;
import com.pharmazealapi.dto.NewUserDTO;
import com.pharmazealapi.dto.UserDTO;
import com.pharmazealapi.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path="user")
@AllArgsConstructor
public class UserController {

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

    @PostMapping(path="create")
    public void createNewUser(@RequestBody NewUserDTO newUserDTO){
        userService.createNewUser(newUserDTO);
    }

    @GetMapping(path="all")
    public List<UserDTO> getAllUserDetails(){
        return userService.getAllUserDetails();
    }

    @GetMapping(path="employee")
    public List<UserDTO> getAllEmployeeDetails(){
        return userService.getAllEmployeeDetails();
    }


    @DeleteMapping(path="delete/employee/{id}")
    public boolean deleteEmployee(@PathVariable() int id){
        return userService.deleteEmployee(id);
    }

}
