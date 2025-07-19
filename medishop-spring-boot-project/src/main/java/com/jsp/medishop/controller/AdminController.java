package com.jsp.medishop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.medishop.dto.Admin;
import com.jsp.medishop.response.ResponseStructure;
import com.jsp.medishop.service.AdminService;
import com.jsp.medishop.service.MedicineService;
import com.jsp.medishop.service.VendorService;

@RestController
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	@Autowired
	private VendorService vendorService;
	
	@Autowired
	private MedicineService medicineService;
	
	@GetMapping("/loginAdmin")
	public ResponseStructure<Admin> loginAdminByEmailAndPasswordController(@RequestBody Admin admin) {
		return adminService.loginAdminByEmailAndPasswordService(admin);
	}
	
	@RequestMapping("/logout")
	public ResponseEntity<String> logoutAdmincontroller() {
		return adminService.logoutAdminService();
	}
	
	@PostMapping(value = "/verifyVendor/{id}")
	public ResponseEntity<String> vendorVerifyByIdService(@PathVariable int id) {
		return vendorService.vendorVerifyByIdService(id);
	}
	@PutMapping(value = "/verifyMedicine/{medicineId}/{vendorId}")
	public ResponseEntity<String> verifyMedicineStatusByAdminController(@PathVariable int medicineId,@PathVariable int vendorId) {
		return medicineService.verifyMedicineStatusByAdminService(medicineId, vendorId);
	}
}
