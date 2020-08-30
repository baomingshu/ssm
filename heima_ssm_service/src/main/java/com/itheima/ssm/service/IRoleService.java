package com.itheima.ssm.service;


import com.itheima.ssm.domain.Permission;
import com.itheima.ssm.domain.Role;

import java.util.List;

public interface IRoleService {

    public List<Role> findAll() throws Exception;

    void save(Role role) throws Exception;

	public Role findById(String roleId);

	public List<Permission> findOtherPermssion(String roleId);

	public void addPermissionToRole(String roleId, String[] permissionsId);
}
