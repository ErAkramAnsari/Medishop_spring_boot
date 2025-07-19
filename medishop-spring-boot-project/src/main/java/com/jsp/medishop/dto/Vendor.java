package com.jsp.medishop.dto;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Data;


/**
 * @author Mo Masood Ansari
 *
 */
@Entity
@Data
public class Vendor {

	@Id
	private int id;
	private String name;
	private String email;
	private long phone;
	@Column(unique = true,nullable = true , length = 12)
	private long adhar;
	private String password;
	private String address;
	@Column(name = "vendor_status")
	private String vendorStatus="inactive";

	@ManyToMany
	private List<Customer> customers;
	
	@ManyToMany(mappedBy = "vendors")
	private List<Medicine> medicines;
	
	
	@ManyToOne
	private Admin admin;

}
