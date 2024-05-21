package com.pharmazealapi.controller;

import com.pharmazealapi.entity.Location;
import com.pharmazealapi.entity.User;
import com.pharmazealapi.repository.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class UserControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    UserRepository userRepository;

    @Autowired
    LocationRepository locationRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    SalesRepository salesRepository;

    @Autowired
    SalesItemRepository salesItemRepository;

    @Autowired
    ExistingPrescriptionRepository existingPrescriptionRepository;

    @Autowired
    DrugAvailabilityRepository availabilityRepository;

    @Test
    void whenValidUserLogins() throws Exception {
        availabilityRepository.deleteAll();
        existingPrescriptionRepository.deleteAll();
        salesItemRepository.deleteAll();
        salesRepository.deleteAll();
        userRepository.deleteAll();
        customerRepository.deleteAll();
        locationRepository.deleteAll();
        Location newLocation=new Location(1,"Stoke","ST4");
        Location location=locationRepository.save(newLocation);
        User newUser=new User(0,"Nick","Male","",
                "njonas1@gmail.com","njonas123","employee","ACTIVE",location);
        userRepository.save(newUser);
        String json_credentials =
                "{\"email\": \"njonas1@gmail.com\"," +
                        "\"password\": \"njonas123\"}";

        mockMvc.perform(MockMvcRequestBuilders.post("/user/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json_credentials))
                .andExpect(status().isOk())
                .andExpect(content().string("true"));
    }

    @Test
    void whenInactiveUserLogins() throws Exception {
        availabilityRepository.deleteAll();
        existingPrescriptionRepository.deleteAll();
        salesItemRepository.deleteAll();
        salesRepository.deleteAll();
        userRepository.deleteAll();
        customerRepository.deleteAll();
        locationRepository.deleteAll();
        Location newLocation=new Location(1,"Stoke","ST4");
        Location location=locationRepository.save(newLocation);
        User newUser=new User(0,"Nick","Male","",
                "njonas1@gmail.com","njonas123","employee","INACTIVE",location);
        userRepository.save(newUser);
        String json_credentials =
                "{\"email\": \"njonas1@gmail.com\"," +
                        "\"password\": \"njonas123\"}";

        mockMvc.perform(MockMvcRequestBuilders.post("/user/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json_credentials))
                .andExpect(status().isOk())
                .andExpect(content().string("false"));
    }

    @Test
    void whenInvalidUserLogins() throws Exception {
        availabilityRepository.deleteAll();
        existingPrescriptionRepository.deleteAll();
        salesItemRepository.deleteAll();
        salesRepository.deleteAll();
        userRepository.deleteAll();
        customerRepository.deleteAll();
        locationRepository.deleteAll();
        Location newLocation=new Location(1,"Stoke","ST4");
        Location location=locationRepository.save(newLocation);
        User newUser=new User(0,"Nick","Male","",
                "njonas1@gmail.com","njonas123","employee","ACTIVE",location);
        userRepository.save(newUser);
        String json_credentials =
                "{\"email\": \"njonas1@gmail.com\"," +
                        "\"password\": \"njonas\"}";

        mockMvc.perform(MockMvcRequestBuilders.post("/user/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json_credentials))
                .andExpect(status().isOk())
                .andExpect(content().string("false"));
    }

    @Test
    void getUserDetails() {
        availabilityRepository.deleteAll();
        existingPrescriptionRepository.deleteAll();
        salesItemRepository.deleteAll();
        salesRepository.deleteAll();
        userRepository.deleteAll();
        customerRepository.deleteAll();
        locationRepository.deleteAll();
    }

    @Test
    void getAllUserDetails() {
    }

    @Test
    void getAllEmployeeDetails() {
    }

    @Test
    void deleteEmployee() {
    }
}