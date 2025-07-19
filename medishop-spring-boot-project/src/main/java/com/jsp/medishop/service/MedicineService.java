package com.jsp.medishop.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.jsp.medishop.dto.Medicine;
import com.jsp.medishop.response.ResponseStructure;

public interface MedicineService {
	public ResponseStructure<Medicine> saveMedicineService(Medicine medicine);
	public ResponseStructure<List<Medicine>> getAllMedicineService();
	
	public ResponseEntity<String>  verifyMedicineStatusByAdminService(int medicineId,int vendorId);
}
