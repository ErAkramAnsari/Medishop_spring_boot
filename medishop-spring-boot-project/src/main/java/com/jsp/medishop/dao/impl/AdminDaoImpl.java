package com.jsp.medishop.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.medishop.dao.AdminDao;
import com.jsp.medishop.dto.Admin;
import com.jsp.medishop.repository.AdminRepository;

@Repository
public class AdminDaoImpl implements AdminDao {
	@Autowired
	private AdminRepository adminRepository;
	
	@Override
	public Admin loginAdminByEmailAndPasswordDao(Admin admin) {
		return adminRepository.findByEmail(admin.getEmail());
	}

}
