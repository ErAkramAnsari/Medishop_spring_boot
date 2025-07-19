package com.jsp.medishop.service;

import com.jsp.medishop.dto.OrderEntity;
import com.jsp.medishop.response.ResponseStructure;

public interface OrderEntityService  {
	public ResponseStructure<OrderEntity> saveOrderEntitiyService(OrderEntity entitiy,int medicineId);

	public ResponseStructure<OrderEntity> getOrderEntitiyByIdService(int orderId);

}
