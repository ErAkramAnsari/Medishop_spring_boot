package com.jsp.medishop.dao;

import java.util.List;

import com.jsp.medishop.dto.Medicine;

public interface MedicineDao {

	public Medicine saveMedicineDao(Medicine medicine);
	
	public List<Medicine> getAllMedicineDao();
	
	public boolean verifyMedicineStatusByAdminDao(Medicine medicine);
	
public List<Medicine> getAllMedicineByNameDao(String name);
	
	
	public Medicine getMedicineByIdDao(int medicineId);
}
