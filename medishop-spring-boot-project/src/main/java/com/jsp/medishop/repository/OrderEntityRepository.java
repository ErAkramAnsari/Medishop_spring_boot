package com.jsp.medishop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.medishop.dto.OrderEntity;

public interface OrderEntityRepository extends JpaRepository<OrderEntity, Long> {

}
