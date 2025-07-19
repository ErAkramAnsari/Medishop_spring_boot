package com.jsp.medishop.service.impl;

import java.time.LocalDate;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.jsp.medishop.dao.CustomerDao;
import com.jsp.medishop.dao.MedicineDao;
import com.jsp.medishop.dao.OrderEntityDao;

import com.jsp.medishop.dto.Customer;
import com.jsp.medishop.dto.Medicine;
import com.jsp.medishop.dto.OrderEntity;

import com.jsp.medishop.response.ResponseStructure;
import com.jsp.medishop.service.OrderEntityService;


import jakarta.servlet.http.HttpSession;
@Service
public class OrderEntityServiceImp implements OrderEntityService{
	@Autowired
	private HttpSession httpSession;
	
	@Autowired
	private OrderEntityDao entityDao;
	
	@Autowired
	private MedicineDao medicineDao;
	
	@Autowired
	private CustomerDao customerDao;
	
	@Autowired
	private ResponseStructure<OrderEntity> responseStructure;

	@Override
	public ResponseStructure<OrderEntity> saveOrderEntitiyService(OrderEntity entity,int medicineId) {
		
		String customerEmail = (String) httpSession.getAttribute("customerEmail");
		
		if(customerEmail!=null) {
			/*
			 * it will generate random 10 digits orderId
			 */
			long orderId = (long) Math.floor(Math.random() * 9000000000L) + 1000000000L;
			Medicine medicine = medicineDao.getMedicineByIdDao(medicineId);
			Customer customer = customerDao.getCustomerByEmailDao(customerEmail);
			entity.setCustomer(customer);
			entity.setMedicine(medicine);
			entity.setOderId(orderId);
			entity.setOrderDate(LocalDate.now());
			/**
			 * this line will calculate final amount
			 */
			entity.setTotalAmount(medicine.getPrice()*entity.getQuantity());
			/**
			 * date calculation
			 */
			entity.setEstimatedDeliveryDater(LocalDate.now().plusDays(4));
			if(entity.getCustomerDeliveryDate()==null) {
				entity.setCustomerDeliveryDate(entity.getEstimatedDeliveryDater());
			}
			entityDao.saveOderEntityDao(entity);
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMsg("Order Placed SuccessFully");
			responseStructure.setData(entity);
		}else {
			responseStructure.setStatus(HttpStatus.NOT_ACCEPTABLE.value());
			responseStructure.setMsg("Please login and then order");
			responseStructure.setData(null);
		}
		return responseStructure;
	}

	@Override
	public ResponseStructure<OrderEntity> getOrderEntitiyByIdService(int orderId) {
		// TODO Auto-generated method stub
		return null;
	}


}
