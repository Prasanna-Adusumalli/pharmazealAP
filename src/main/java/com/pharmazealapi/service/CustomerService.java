package com.pharmazealapi.service;

import com.pharmazealapi.dto.CustomerDTO;
import com.pharmazealapi.dto.DTOFactory;
import com.pharmazealapi.entity.Address;
import com.pharmazealapi.entity.Customer;
import com.pharmazealapi.entity.Location;
import com.pharmazealapi.repository.AddressRepository;
import com.pharmazealapi.repository.CustomerRepository;
import com.pharmazealapi.repository.LocationRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final AddressRepository addressRepository;
    private final LocationRepository locationRepository;
    @Autowired
    private DTOFactory dtoFactory;
   //To get list of all the customers based on location
    public List<CustomerDTO> getCustomersByLocation(String locationName){
        List<CustomerDTO> customerDTOList=new ArrayList<>();
        Location location =locationRepository.findByLocationNameEqualsIgnoreCase(locationName).orElse(null);
        List<Customer> customerList=customerRepository.findAll();
        for(Customer customer:customerList){
            if(location.getLocationId()==customer.getLocationId()&& (customer.getNhsNumber()!=1)) {
                Address address = addressRepository.findById(customer.getAddressId()).get();
                customerDTOList.add(dtoFactory.createCustomerDTO(customer, address, location));
            }
        }
        return customerDTOList;
    }
}
