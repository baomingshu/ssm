package com.itheima.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itheima.ssm.dao.ICustomerServiceDao;
import com.itheima.ssm.domain.CustomerService;
import com.itheima.ssm.service.ICustomerServiceService;




	@Service
	@Transactional
	public class CustomerServiceServiceImpl implements ICustomerServiceService{
		
		@Autowired
		private ICustomerServiceDao CustomerServiceDao;
		
		@Override
		public List<CustomerService> findAll() throws Exception {
			List<CustomerService> customer_serviceList = CustomerServiceDao.findAll();
			return customer_serviceList;
		}
		
		@Override
		public void save(CustomerService customer_service) throws Exception {
			CustomerServiceDao.save(customer_service);
		}

	}

