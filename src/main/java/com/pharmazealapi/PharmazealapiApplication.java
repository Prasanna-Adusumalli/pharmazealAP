package com.pharmazealapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class PharmazealapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PharmazealapiApplication.class, args);
	}

}
