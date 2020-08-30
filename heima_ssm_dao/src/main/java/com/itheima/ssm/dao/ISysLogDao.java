package com.itheima.ssm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.itheima.ssm.domain.SysLog;

public interface ISysLogDao {

	@Insert("insert into syslog (visitTime,username,ip,url,executionTime,method)values(#{visitTime},#{username},#{ip},#{url},#{executionTime},#{method})")    
	public void save (SysLog log )throws Exception;

	@Select("select * from syslog")
	public List<SysLog> findAll();
}
