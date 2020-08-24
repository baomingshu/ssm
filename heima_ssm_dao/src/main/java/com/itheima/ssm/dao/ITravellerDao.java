package com.itheima.ssm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.itheima.ssm.domain.Traveller;

public interface ITravellerDao {
//  下面的查询使用的子查询，先使用IOrdersDao类中传递过来的ordersId值（使用where orderId=#{ordersId}语句）查
//	询出中间表order_traveller的travellerId值，使用travellerId查询traveller表的所有信息。
	@Select ("select * from traveller where id in (select travellerId from order_traveller where orderId=#{ordersId})")
	public List<Traveller> findByOrdersId(String ordersId) throws Exception;
}
