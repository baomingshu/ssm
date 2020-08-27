package com.itheima.ssm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import com.itheima.ssm.domain.Role;
import com.itheima.ssm.domain.UserInfo;
import com.itheima.ssm.service.IRoleService;

@Controller
@RequestMapping("/role")
public class RoleController {

	@Autowired
	private IRoleService roleService;

    @RequestMapping("/save.do")
    public String save(Role role) throws Exception {
    	roleService.save(role);
        return "redirect:findAll.do";
    }
	
	
@RequestMapping("/findAll.do")
public ModelAndView findAll() throws Exception{
	// ModelAndView是一个类，他的对象可以调用mv.addObject();，mv.setViewName();两个方法。
	
	
	//mv.setViewName(),指定了前台文件为product-list
	 ModelAndView mv = new ModelAndView() ;
//	第17行使用了autowired注解方式创建了对象，在这里调用了service层的finAll方法,拿到了product表的所有数据
	List<Role> ro = roleService.findAll();
	//mv.addObject用来把存放product表数据的list集合的ps返回给前台，让前台product-list.jsp中的247行的<c:forEach items="${productList}" var="product">方法使用
	mv.addObject("roleList",ro);
	//mv.setViewName(),指定了前台文件为product-list,前台页面跳转到product-list.jsp
	mv.setViewName("role-list");
	
	return mv;
}
}
