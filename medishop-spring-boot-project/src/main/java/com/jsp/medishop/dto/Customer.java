package com.jsp.medishop.dto;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Transient;
import lombok.Data;

/**
 * @author Atul
 */
@Entity
@Data
public class Customer {

	@Id
	private int id;
	private String name;
	@JsonFormat(pattern="dd-MM-yyyy")
	private LocalDate dob;
	@Column(unique = true, nullable = false)
	private String email;
	@Column(length = 8)
	private String password;
	private String address;
	private long phone;
	@Column(unique = true, nullable = true, length = 12)
	private long adhar;

	@Transient
	@Lob
	private byte[]image;
	
	@ManyToMany
	private List<Vendor> vendors;

}
