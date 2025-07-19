package com.jsp.medishop.dao;

import com.jsp.medishop.dto.OrderEntity;

public interface OrderEntityDao {
	
	
	public OrderEntity saveOderEntityDao(OrderEntity entity);
	
	public OrderEntity getOderEntityByIdDao(long oderId);

}
