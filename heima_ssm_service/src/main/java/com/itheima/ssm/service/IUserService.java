package com.itheima.ssm.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.itheima.ssm.domain.Orders;
import com.itheima.ssm.domain.UserInfo;



public interface IUserService extends UserDetailsService {

	List<UserInfo> findAll(int page,int size) throws Exception;
	UserInfo findById(String userId) throws Exception;
}
