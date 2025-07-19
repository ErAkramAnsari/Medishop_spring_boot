package com.jsp.medishop.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.medishop.dao.MedicineDao;
import com.jsp.medishop.dao.VendorDao;
import com.jsp.medishop.dto.Medicine;
import com.jsp.medishop.dto.Vendor;
import com.jsp.medishop.response.ResponseStructure;
import com.jsp.medishop.service.MedicineService;
import com.jsp.medishop.service.VendorService;

import jakarta.servlet.http.HttpSession;

@Service
public class MedicineServiceImpl implements MedicineService{

	
	@Autowired
	private VendorDao vendorDao;
	
	@Autowired
	private HttpSession httpSession;
	
	@Autowired
	private MedicineDao medicinedao;
	
	@Autowired
	private ResponseStructure<Medicine> responseStructure;
	
	@Autowired
	private ResponseStructure<List<Medicine>> responseStructure2;
	
	@Override
	public ResponseStructure<Medicine> saveMedicineService(Medicine medicine) {
		
		String email =(String) httpSession.getAttribute("vendorEmail");
		
		if(email!=null) {
			 Vendor vendor=vendorDao.getVendorByEmailDao(email);
			 System.out.println(vendor.getEmail());
			 medicine.setVendors(new ArrayList<Vendor>(Arrays.asList(vendor)));
			 Medicine medicine2=medicinedao.saveMedicineDao(medicine);
			 if(medicine2!=null) {
				 responseStructure.setStatus(HttpStatus.ACCEPTED.value());
				 responseStructure.setMsg("medicine addedd");
				 responseStructure.setData(medicine2);
			 }else {
				 responseStructure.setStatus(HttpStatus.NOT_ACCEPTABLE.value());
				 responseStructure.setMsg("Data is not stored check your code");
				 responseStructure.setData(null);
			 }
		}else {
			 responseStructure.setStatus(HttpStatus.NOT_ACCEPTABLE.value());
			 responseStructure.setMsg("please login with vendor and then add medicine....");
			 responseStructure.setData(null);
		}
		 return responseStructure;
	}

	@Override
	public ResponseStructure<List<Medicine>> getAllMedicineService() {
		     List<Medicine> medicines=medicinedao.getAllMedicineDao();
		     if(!medicines.isEmpty()) {
				 responseStructure2.setStatus(HttpStatus.OK.value());
				 responseStructure2.setMsg("Data----Found----");
				 responseStructure2.setData(medicines);
			 }else {
				 responseStructure2.setStatus(HttpStatus.NOT_FOUND.value());
				 responseStructure2.setMsg("Data is not found might be table is empty or check your code");
				 responseStructure2.setData(medicines);
			 }
			 return responseStructure2;
	}
	@Override
	public ResponseEntity<String> verifyMedicineStatusByAdminService(int medicineId,int vendorId) {
		
		String adminEmail = (String) httpSession.getAttribute("adminEmail");
		
		if(adminEmail!=null) {
			
			Vendor vendor = vendorDao.getVendorByIdDao(vendorId);
			
			if(vendor!=null) {
				List<Medicine> medicines= vendor.getMedicines();
				
				if(!medicines.isEmpty()) {
					for (Medicine medicine : medicines) {
						if(medicine.getId()==medicineId) {
							medicine.setMedicine_status("active");
							boolean b=medicinedao.verifyMedicineStatusByAdminDao(medicine);
							
							return (b)?new ResponseEntity<String>("medicine---verified",HttpStatusCode.valueOf(200)):new ResponseEntity<String>("not---verified",HttpStatusCode.valueOf(404));
						}
					}
				}
			}
			
		}
		return new ResponseEntity<String>("please login as admin then verified",HttpStatusCode.valueOf(200));
	}

}
