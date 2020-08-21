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
	
	@RequestMapping("/findAll.do")
	public ModelAndView findAll() throws Exception{
		ModelAndView mv = new ModelAndView();
		List<Product> ps = productService.findAll();
		mv.addObject("productList",ps);
		mv.setViewName("product-list");
		
		return mv;
	}
	

}























