package com.itheima.ssm.dao;


import org.apache.ibatis.annotations.One;

import java.util.List;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.itheima.ssm.domain.Member;
import com.itheima.ssm.domain.Orders;
import com.itheima.ssm.domain.Product;

public interface IOrdersDao {

	@Select("select* from orders")
	@Results({//property 属性，性质          column 列  将数据库中的列和domain包中的orders类的成员变量对应起来
		@Result(id=true,property="id",column="id"),
		@Result(property="orderNum",column="orderNum"),
		@Result(property="orderTime",column="orderTime"),
		@Result(property="orderStatus",column="orderStatus"),
		@Result(property="peopleCount",column="peopleCount"),
		@Result(property="peopleCount",column="peopleCount"),
		@Result(property="payType",column="payType"),
		@Result(property="orderDesc",column="orderDesc"),
		@Result(property="product",column="productId",javaType=Product.class,one = @One(select="com.itheima.ssm.dao.IProductDao.findById"))               
	})
    public List<Orders> findAll() throws Exception;

    //多表操作
//	ordersId值来自下面54行的参数（前端->controller->service->dao）
    @Select("select * from orders where id=#{ordersId}")
    @Results({//property 属性，性质          column 列  将数据库中的列和domain包中的orders类的成员变量对应起来
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "orderNum", column = "orderNum"),
            @Result(property = "orderTime", column = "orderTime"),
            @Result(property = "orderStatus", column = "orderStatus"),
            @Result(property = "peopleCount", column = "peopleCount"),
            @Result(property = "peopleCount", column = "peopleCount"),
            @Result(property = "payType", column = "payType"),
            @Result(property = "orderDesc", column = "orderDesc"),
//            以下语句，先通过上方的"select * from orders where id=#{ordersId}"语句拿到column（列）的productId值（column = "productId"），通过productId的值在com.itheima.ssm.dao.IProductDao包中通过findById方法-->                
//              查询出product表的信息，赋值给orders表的成员变量product  （property = "product"）                                                                                                                                                                                                         <--|        
            @Result(property = "product", column = "productId", javaType = Product.class, one = @One(select = "com.itheima.ssm.dao.IProductDao.findById")),
            @Result(property = "member",column = "memberId",javaType = Member.class,one = @One(select = "com.itheima.ssm.dao.IMemberDao.findById")),
//          以下语句，先通过上方的"select * from orders where id=#{ordersId}"语句拿到column（列）的id值（column = "id"），通过id的值在com.itheima.ssm.dao.ITravellerDao包中通过findByOrdersId方法-->                
//          查询出traveller表的信息，赋值给orders表的成员变量travellers （property = "travellers"）                                                                                                                                                                                                         <--|         
            @Result(property = "travellers",column = "id",javaType =java.util.List.class,many =@Many(select = "com.itheima.ssm.dao.ITravellerDao.findByOrdersId"))
    })
//     这里的参数是service层通过controller层得到的参数ordersId
    public Orders findById(String ordersId) throws Exception;
}
