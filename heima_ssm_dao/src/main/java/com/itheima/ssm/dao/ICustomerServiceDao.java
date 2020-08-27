package com.itheima.ssm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.itheima.ssm.domain.CustomerService;
import com.itheima.ssm.domain.Product;

public interface ICustomerServiceDao {

	@Select("select * from customer_service")
public List<CustomerService> findAll()throws Exception;
	
	@Insert("insert into customer_service(customerName,customerNum,phoneNum,status)values(#{customerName},#{customerNum},#{phoneNum},#{status}")
	void save(CustomerService customer_service);
}
