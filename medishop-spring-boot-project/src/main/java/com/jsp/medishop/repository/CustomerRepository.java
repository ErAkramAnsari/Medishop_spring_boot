package com.jsp.medishop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.medishop.dto.Customer;

/**
 * @author Kamran
 */
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	public Customer findByEmail(String email);
	


}
