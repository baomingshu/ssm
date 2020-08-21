package com.itheima.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itheima.ssm.dao.IProductDao;
import com.itheima.ssm.domain.Product;
import com.itheima.ssm.service.IProductService;

@Service
@Transactional
public class ProductSerciceImpl implements IProductService{
	@Autowired
	private IProductDao productDao;
	@Override
	public List<Product> findAll() throws Exception {
		
		return productDao.findAll();
	}

}
