package com.itheima.ssm.dao;
import com.itheima.ssm.domain.Member;
import com.itheima.ssm.domain.Orders;
import com.itheima.ssm.domain.Product;
import com.itheima.ssm.domain.Role;
import com.itheima.ssm.domain.UserInfo;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

public interface IUserDao {

    @Select("select * from users where username=#{username}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "email", column = "email"),
            @Result(property = "password", column = "password"),
            @Result(property = "phoneNum", column = "phoneNum"),
            @Result(property = "status", column = "status"),
            @Result(property = "roles",column = "id",javaType = java.util.List.class,many = @Many(select = "com.itheima.ssm.dao.IRoleDao.findRoleByUserId"))
    })
    public UserInfo findByUsername(String username) throws Exception;
    
    @Select("select* from users")
	@Results({//property 属性，性质          column 列  将数据库中的列和domain包中的orders类的成员变量对应起来
		@Result(id=true,property="id",column="id"),
		@Result(property="username",column="username"),
		@Result(property="email",column="email"),
		@Result(property="password",column="password"),
		@Result(property="phoneNum",column="phoneNum"),
		@Result(property="status",column="status"),
		@Result(property="id",column="userId",javaType=UserInfo.class,one = @One(select="com.itheima.ssm.dao.IUserDao.findById"))               
	})
    public List<UserInfo> findAll() throws Exception;
    

    @Select("select * from users where id=#{userId}")
    @Results({
    	@Result(id=true,property="id",column="id"),
		@Result(property="username",column="username"),
		@Result(property="email",column="email"),
		@Result(property="password",column="password"),
		@Result(property="phoneNum",column="phoneNum"),
		@Result(property="status",column="status"),
                                                                                               
            @Result(property = "roles",column = "id",javaType =java.util.List.class,many =@Many(select = "com.itheima.ssm.dao.IRoleDao.findRoleByUserId"))
    })   
//     这里的参数是service层通过controller层得到的参数ordersId
    public UserInfo findById(String userId) throws Exception;
    
    
    @Insert("insert into users(email,username,password,phoneNum,status) values(#{email},#{username},#{password},#{phoneNum},#{status})")
    void save(UserInfo userInfo) throws Exception;

    
    @Select("select* from role where id not in (select roleId from users_role where userId =#{userId})")
	public List<Role> findOtherRoles(String userId);

    
    @Insert("insert into users_role (userId ,roleId )values (#{userId},#{roleId})")
	public void addRoleToUser(@Param("userId") String userId, @Param("roleId")String roleId);
    
    
    
}
