package com.example.pharmazealapi;

import com.pharmazealapi.PharmazealapiApplication;
import com.pharmazealapi.controller.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(classes = PharmazealapiApplication.class)
public class PharmazealapiApplicationTests {

	@Autowired
	CustomerController customerController;
	@Autowired
	UserController userController;
	@Autowired
	DrugController drugController;
	@Autowired
	SalesController salesController;
	@Autowired
	PrescriptionController prescriptionController;

	@Test
	void contextLoads() {
		assertNotNull(customerController);
		assertNotNull(userController);
		assertNotNull(drugController);
		assertNotNull(salesController);
		assertNotNull(prescriptionController);
	}

}
