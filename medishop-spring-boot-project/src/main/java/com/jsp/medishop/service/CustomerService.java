package com.jsp.medishop.service;

/**
 * @author Atul
 */

import java.util.List;

import com.jsp.medishop.dto.Customer;
import com.jsp.medishop.response.ResponseStructure;

public interface CustomerService {

	public ResponseStructure<Customer> saveCustomerService(Customer customer);

	public ResponseStructure<Customer> getCustomerByIdService(int id);

	public ResponseStructure<Customer> getCustomerByEmailService(String email);

	public List<Customer> getCustomersService();

	public ResponseStructure<List<Customer>> updateCustomerByEmailService(Customer customer);

	public ResponseStructure<Customer> deleteCustomerByEmailService(String email);
	
    

	ResponseStructure<Customer> loginCustomerByEmailService(String email, String password);
	
//	public ResponseEntity<String> logoutCustomer();
}
