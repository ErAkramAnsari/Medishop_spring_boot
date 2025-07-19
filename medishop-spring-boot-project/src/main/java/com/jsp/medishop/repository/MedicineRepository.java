package com.jsp.medishop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.medishop.dto.Medicine;

public interface MedicineRepository extends JpaRepository<Medicine, Integer> {

	public Medicine findById(int medicineId);
	public List<Medicine> findByName(String name);
}
