package com.jsp.medishop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.medishop.dto.OrderEntity;
import com.jsp.medishop.response.ResponseStructure;
import com.jsp.medishop.service.OrderEntityService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class OrderEntityController {
	@Autowired
	private OrderEntityService entityService;

	@PostMapping(value = "/saveOrder/{medicineId}")
	public ResponseStructure<OrderEntity> saveOrderEntitiyController(@RequestBody OrderEntity entitiy,@PathVariable int medicineId) {
		
		return entityService.saveOrderEntitiyService(entitiy, medicineId);
	}
}
