package com.itheima.ssm.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.itheima.ssm.dao.IUserDao;
import com.itheima.ssm.domain.Orders;
import com.itheima.ssm.domain.Role;
import com.itheima.ssm.domain.UserInfo;
import com.itheima.ssm.service.IUserService;

//   给这个bean指定一个名字，在spring-security.xml文件的第43行就可以找到了， <security:authentication-provider user-service-ref="userService">
@Service("userService")
@Transactional
public class UserServiceImpl implements IUserService{

	@Autowired
	private IUserDao userDao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserInfo userInfo =null;
		try {
			userInfo = userDao.findByUsername( username);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
//		这个User类是系统给的，它实现了UserDetail接口。 可以处理我们自己的用户对象封装成UserDetails
//		密码没有加密文的情况要加前缀"{noop}"
// 		 User user=new User(userInfo.getUsername(),"{noop}"+userInfo.getPassword(),getAuthority(userInfo.getRoles()));
        User user = new User(userInfo.getUsername(), "{noop}" + userInfo.getPassword(), userInfo.getStatus() == 0 ? false : true, true, true, true, getAuthority(userInfo.getRoles()));
        return user;
    }

	  //作用就是返回一个List集合，集合中装入的是角色描述
    public List<SimpleGrantedAuthority> getAuthority(List<Role> roles) {

        List<SimpleGrantedAuthority> list = new ArrayList<>();
        for (Role role : roles) {
            list.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName()));
            System.out.println(role.getRoleName());
        }
        
        return list;
    }
    
    @Override
	public List<UserInfo> findAll(int page,int size) throws Exception {
//		17行通过注解@Autowired创建了 IOrdersDao类的对象，ordersDao调用了findAll
//		PageHelper是在pom.xml文件中引用Jay包，在applicationContext.xml文件36行中配置后才能使用的
//		调用startPage方法,开始分页，这里的参数是cotroller层通过请求得到前端的参数page和size
		PageHelper.startPage(page,size);//分页条件语句必须写在查询语句的前面一行
		return userDao.findAll();
    
}

	@Override
	public UserInfo findById(String userId) throws Exception {
		
//		  return userDao.findById(userId);
		return null;
	}
}
