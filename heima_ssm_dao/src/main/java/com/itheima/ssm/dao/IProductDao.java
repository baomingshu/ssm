package com.itheima.ssm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.itheima.ssm.domain.Product;

public interface IProductDao {
	
//	根据id查询产品
	@Select("select * from product where id =#{id}")
	public Product findById(int id)throws Exception;
	
//	查询所有的产品信息
	@Select("select * from product")
	public List<Product> findAll()throws Exception;
	
	@Insert("insert into product(productNum,productName,"
			+ "cityName,departureTime,productPrice,productDesc,"
			+ "productStatus)values(#{productNum},#{productName},#{cityName},"
			+ "#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
	void save(Product product);
}
