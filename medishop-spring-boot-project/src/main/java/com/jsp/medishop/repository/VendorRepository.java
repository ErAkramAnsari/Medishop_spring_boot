package com.jsp.medishop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.medishop.dto.Vendor;

/**
 * @author Atul
 */
public interface VendorRepository extends JpaRepository<Vendor, Integer> {

	public Vendor findByEmail(String email);
}
