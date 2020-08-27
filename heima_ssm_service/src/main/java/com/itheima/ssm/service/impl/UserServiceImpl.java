package com.itheima.ssm.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.itheima.ssm.dao.IUserDao;
import com.itheima.ssm.domain.Role;
import com.itheima.ssm.domain.UserInfo;
import com.itheima.ssm.service.IUserService;

//   给这个bean指定一个名字，在spring-security.xml文件的第43行就可以找到了， <security:authentication-provider user-service-ref="userService">
@Service("userService")
@Transactional
public class UserServiceImpl implements IUserService{

	@Autowired
	private IUserDao userDao;
	
	private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
	
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
        User user = new User(userInfo.getUsername(),userInfo.getPassword(), userInfo.getStatus() == 0 ? false : true, true, true, true, getAuthority(userInfo.getRoles()));
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

		PageHelper.startPage(page,size);//分页条件语句必须写在查询语句的前面一行
		return userDao.findAll();
    
}

	@Override
	public UserInfo findById(String userId) throws Exception {
		
		  return userDao.findById(userId);
	   
	}
	
	
	  @Override
	    public void save(UserInfo userInfo) throws Exception {
	        //对密码进行加密
	        userInfo.setPassword(bCryptPasswordEncoder.encode(userInfo.getPassword()));
	        userDao.save(userInfo);
	    }



}
