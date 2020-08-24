package com.itheima.ssm.dao;

import org.apache.ibatis.annotations.Select;

import com.itheima.ssm.domain.Member;
import com.itheima.ssm.domain.Product;

public interface IMemberDao {
	@Select("select * from member where id =#{id}")
	public Member findById(int id)throws Exception;
}
