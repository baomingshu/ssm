package com.itheima.ssm.service;

import java.util.List;

import com.itheima.ssm.domain.CustomerService;
import com.itheima.ssm.domain.Product;

public interface ICustomerServiceService {
	public List<CustomerService> findAll() throws Exception;
	void save(CustomerService customer_service)throws Exception;
}
