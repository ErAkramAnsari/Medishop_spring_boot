package com.jsp.medishop.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.medishop.dao.MedicineDao;
import com.jsp.medishop.dto.Medicine;
import com.jsp.medishop.repository.MedicineRepository;

@Repository
public class MedicineDaoImpl implements MedicineDao {

	@Autowired
	private MedicineRepository medicineRepository;
	
	@Override
	public Medicine saveMedicineDao(Medicine medicine) {
		return medicineRepository.save(medicine);
	}

	@Override
	public List<Medicine> getAllMedicineDao() {
		return medicineRepository.findAll();
	}
	@Override
	public boolean verifyMedicineStatusByAdminDao(Medicine medicine) {
		return (medicineRepository.save(medicine) != null) ? true : false;
	}
	@Override
	public List<Medicine> getAllMedicineByNameDao(String name) {

		List<Medicine> medicines = medicineRepository.findByName(name);

		List<Medicine> medicines2 = new ArrayList<Medicine>();

		for (Medicine medicine : medicines) {
			if (medicine.getMedicine_status().equalsIgnoreCase("active")) {
				medicines2.add(medicine);
			}
		}
		return medicines2;
	}

	@Override
	public Medicine getMedicineByIdDao(int medicineId) {
		
		return medicineRepository.findById(medicineId);
	}


}
