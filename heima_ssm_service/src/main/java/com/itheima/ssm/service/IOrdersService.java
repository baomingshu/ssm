package com.itheima.ssm.service;

import java.util.List;

import com.itheima.ssm.domain.Orders;

public interface IOrdersService {

	
	
	 Orders findById(String ordersId) throws Exception;

	List<Orders> findAll(Integer page, Integer size) throws Exception;
}
