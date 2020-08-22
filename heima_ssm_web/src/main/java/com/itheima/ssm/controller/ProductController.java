package com.itheima.ssm.controller;

import java.util.List;

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
	public ModelAndView findAll() throws Exception{
		// ModelAndView是一个类，他的对象可以调用mv.addObject();，mv.setViewName();两个方法。
		//mv.addObject用来把存放list集合的这个ps对象返回给前台
		//让前台product-list.jsp中的247行的<c:forEach items="${productList}" var="product">方法使用
		//mv.setViewName(),指定了前台文件为product-list
		 ModelAndView mv = new ModelAndView() ;
		List<Product> ps = productService.findAll();
		mv.addObject("productList",ps);
		mv.setViewName("product-list");
		
		return mv;
	}
	

}























