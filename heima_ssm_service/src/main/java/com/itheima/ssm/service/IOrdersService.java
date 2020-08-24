package com.itheima.ssm.service;

import java.util.List;

import com.itheima.ssm.domain.Orders;

public interface IOrdersService {

	List<Orders> findAll(int page,int size) throws Exception;
	
	 Orders findById(String ordersId) throws Exception;
}
