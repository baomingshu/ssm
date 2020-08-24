package com.itheima.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.itheima.ssm.dao.IOrdersDao;
import com.itheima.ssm.domain.Orders;
import com.itheima.ssm.service.IOrdersService;
@Service
@Transactional
public class OrdersServiceImpl implements IOrdersService {

	@Autowired
	private IOrdersDao ordersDao;
	@Override
	public List<Orders> findAll(int page,int size) throws Exception {
//		17行通过注解@Autowired创建了 IOrdersDao类的对象，ordersDao调用了findAll
//		PageHelper是在pom.xml文件中引用Jay包，在applicationContext.xml文件36行中配置后才能使用的
//		调用startPage方法,开始分页，这里的参数是cotroller层通过请求得到前端的参数page和size
		PageHelper.startPage(page,size);//分页条件语句必须写在查询语句的前面一行
		return ordersDao.findAll();
	}

    @Override
    public Orders findById(String ordersId) throws Exception{
//    	这里的参数是cotroller层通过请求得到前端的参数ordersId
        return ordersDao.findById(ordersId);
    }
}
