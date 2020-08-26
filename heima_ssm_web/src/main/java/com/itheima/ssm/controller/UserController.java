package com.itheima.ssm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.itheima.ssm.domain.UserInfo;
import com.itheima.ssm.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private IUserService userService;
	
	
	
	@RequestMapping("/findAll.do")
	public ModelAndView findAll(@RequestParam(name = "page", required = true, defaultValue = "1") int page,
			@RequestParam(name = "size", required = true, defaultValue = "4") int size) throws Exception {
		ModelAndView mv = new ModelAndView();
//		第20行使用了autowired注解方式创建了对象，在这里调用了service的finAll方法,拿到了user表的所有数据
		List<UserInfo> userInfoList = userService.findAll(page, size);
		// PageInfo就是一个分页bean，将上面得到的orderList集合ordersList传给pageInfo类中的成员变量
		PageInfo pageInfo = new PageInfo(userInfoList);
		// mv调用addObject方法将pageInfo的数据传给前台，例如orders-page-list.jsp文件第246行"pageInfo.list"     
		mv.addObject("pageInfo", pageInfo);
		//mv.setViewName(),指定了前台文件为orders-page-list,前台页面跳转到orders-page-list.jsp
		mv.setViewName("user-page-list");
		return mv;
	}
	
}
