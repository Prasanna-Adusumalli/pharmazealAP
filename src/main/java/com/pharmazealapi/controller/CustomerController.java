package com.pharmazealapi.controller;

import com.pharmazealapi.dto.CustomerDTO;
import com.pharmazealapi.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path="customer")
@AllArgsConstructor
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @CrossOrigin(origins = "*")
    @GetMapping(path = "location/{location}")
    public List<CustomerDTO> getCustomersByLocation(@PathVariable("location") String location) {
        List<CustomerDTO> customerDTOList = customerService.getCustomersByLocation(location);
        return customerDTOList;
    }
}
