package com.itheima.ssm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.itheima.ssm.domain.Product;

public interface IProductDao {
	@Select("select* from product")
	public List<Product> findAll()throws Exception;
	
}
