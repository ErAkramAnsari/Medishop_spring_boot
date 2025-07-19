package com.jsp.medishop.service;

import org.springframework.http.ResponseEntity;

import com.jsp.medishop.dto.Admin;
import com.jsp.medishop.response.ResponseStructure;

public interface AdminService {

	public ResponseStructure<Admin> loginAdminByEmailAndPasswordService(Admin admin);
	
	public ResponseEntity<String> logoutAdminService();
}
