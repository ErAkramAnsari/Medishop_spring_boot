package com.jsp.medishop.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

/**
 * @author Mo Masood Ansari
 *.
 */
@Entity
@Data
public class Admin {

	@Id
	private int id;
	private String email;
	private String password;
	
	@OneToMany(mappedBy="admin")
	@JsonIgnore
	private List<Vendor> vendors;

}
