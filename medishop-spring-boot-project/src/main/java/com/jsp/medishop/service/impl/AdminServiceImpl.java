package com.jsp.medishop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.medishop.dao.AdminDao;
import com.jsp.medishop.dto.Admin;
import com.jsp.medishop.response.ResponseStructure;
import com.jsp.medishop.service.AdminService;

import jakarta.servlet.http.HttpSession;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private HttpSession httpSession;
	
	@Autowired
	private AdminDao adminDao;
	
	@Autowired
	private ResponseStructure<Admin> responseStructure;
	
	@Override
	public ResponseStructure<Admin> loginAdminByEmailAndPasswordService(Admin admin) {
		
		Admin admin2=adminDao.loginAdminByEmailAndPasswordDao(admin);
		
		if(admin2!=null) {
			
			if(admin2.getPassword().equals(admin.getPassword())) {
				httpSession.setAttribute("adminEmail", admin2.getEmail());
				responseStructure.setStatus(HttpStatus.OK.value());
				responseStructure.setMsg("admin---login----successfully");
				admin2.setPassword("**********");
				responseStructure.setData(admin2);
			}else {
				responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
				responseStructure.setMsg("Invalid----Password----Please---check");
				responseStructure.setData(admin);
			}
		}else {
			responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
			responseStructure.setMsg("Invalid----Email----Please---check");
			admin.setPassword("************");
			responseStructure.setData(admin);
		}
		return responseStructure;	
	}

	@Override
	public ResponseEntity<String> logoutAdminService() {
		
		if(httpSession.getAttribute("adminEmail")!=null) {
			httpSession.invalidate();
			return new ResponseEntity<String>("Logout---SuccessFully",HttpStatus.OK);
		}else {
			return new ResponseEntity<String>("first login then logout",HttpStatus.OK);
		}
	}

	
}
