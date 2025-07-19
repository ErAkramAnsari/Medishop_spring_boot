package com.jsp.medishop.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.medishop.dto.Customer;
import com.jsp.medishop.response.ResponseStructure;
import com.jsp.medishop.service.CustomerService;


/**
 * @author Mo Masood Ansari
 *
 */
@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService service;

	@PostMapping(value = "/saveCustomer")
	public ResponseStructure<Customer> saveCustomerController(@RequestBody Customer customer) throws IOException{
		return service.saveCustomerService(customer);
	}
	@GetMapping(value="/logingCustomer/{email}/{password}")
	public ResponseStructure<Customer> loginCustomerByEmailController(@PathVariable String email,@PathVariable String password)throws IOException{
		return service.loginCustomerByEmailService(email, password);
	}

}
