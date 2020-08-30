package com.itheima.ssm.controller;

import java.util.List;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.itheima.ssm.domain.Product;
import com.itheima.ssm.service.IProductService;

@Controller
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private IProductService productService;
	
	
//	添加产品
	@RequestMapping("/save.do")
	public String save (Product product) throws Exception{
		productService.save(product);
		return "redirect:findAll.do";//跳转到findALL.do,redirect是跳转的意思
	}
//	全部产品查询
	@RequestMapping("/findAll.do")
//	spring提供的jsr250配置的注解，先在spring-security配置，在pom导入依赖，在这里使用注解，，效果：只有ADMIN角色可以访问.注意：与secured注解方式的区别：ROLE_前缀,secured不用导入
	@RolesAllowed("ADMIN")
	public ModelAndView findAll() throws Exception{
		// ModelAndView是一个类，他的对象可以调用mv.addObject();，mv.setViewName();两个方法。
		
		
		//mv.setViewName(),指定了前台文件为product-list
		 ModelAndView mv = new ModelAndView() ;
//		第17行使用了autowired注解方式创建了对象，在这里调用了service层的finAll方法,拿到了product表的所有数据
		List<Product> ps = productService.findAll();
		//mv.addObject用来把存放product表数据的list集合的ps返回给前台，让前台product-list.jsp中的247行的<c:forEach items="${productList}" var="product">方法使用
		mv.addObject("productList",ps);
		//mv.setViewName(),指定了前台文件为product-list,前台页面跳转到product-list.jsp
		mv.setViewName("product-list");
		
		return mv;
	}
	

}























