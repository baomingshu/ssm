package com.itheima.ssm.service;

import java.util.List;

import com.itheima.ssm.domain.Product;

public interface IProductService {
	public List<Product> findAll() throws Exception;
	
}
