package com.itheima.ssm.service.impl;

import com.itheima.ssm.dao.IRoleDao;
import com.itheima.ssm.domain.Permission;
import com.itheima.ssm.domain.Role;
import com.itheima.ssm.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional

public class RoleServiceImpl implements IRoleService {

	@Autowired
	private IRoleDao roleDao;

	@Override
	public Role findById(String roleId) {

		  return roleDao.findById(roleId);
	}

	@Override
	public List<Permission> findOtherPermssion(String roleId) {

		return roleDao.findOtherPermssion(roleId);
	}

	@Override
	public void addPermissionToRole(String roleId, String[] permissionIds) {
		
		 for(String permissionsd:permissionIds){
	            roleDao.addPermissionToRole(roleId,permissionsd);
	           
	        }
	}

	@Override
	public void save(Role role) {
		roleDao.save(role);
	}

	@Override
	public List<Role> findAll() throws Exception {
		return roleDao.findAll();
	}
}
