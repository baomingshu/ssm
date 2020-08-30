package com.itheima.ssm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.itheima.ssm.domain.Role;
import com.itheima.ssm.domain.UserInfo;
import com.itheima.ssm.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private IUserService userService;
	
	  //给用户添加角色
    @RequestMapping("/addRoleToUser.do")
    public String addRoleToUser(@RequestParam(name = "userId", required = true) String userId, @RequestParam(name = "ids", required = true) String[] roleIds) {
        userService.addRoleToUser(userId, roleIds);
 
        return "redirect:findAll.do";
    }
    
//	查询用户以及用户可以添加的角色
	@RequestMapping("/findUserByIdAndAllRole.do")
	public ModelAndView findUserByIdAndAllRole(@RequestParam(name="id",required=true)String userId) throws Exception{
		ModelAndView mv = new ModelAndView();
//		根据用户id 查询用户
		UserInfo userInfo = userService.findById(userId);
//		 根据用户id 查询可以添加的角色
		List<Role> otherRoles =userService.findOtherRoles(userId);
		mv.addObject("user",userInfo);
		mv.addObject("roleList",otherRoles);
		mv.setViewName("user-role-add");
		
		return mv;
	}
	
	
	
	//用户添加
    @RequestMapping("/save.do")
//    只有tom用户可以添加操作
    @PreAuthorize("authentication.principal.username == 'tom'")
    public String save(UserInfo userInfo) throws Exception {
        System.out.println("userInfo :" +userInfo);
        if(userInfo!=null){
        	System.out.println("userInfo.getUsername() "+userInfo.getUsername());
        	System.out.println("userInfo.getPassword() "+userInfo.getPassword());
        }
    	userService.save(userInfo);
        return "redirect:findAll.do";
    }

	
	@RequestMapping("/findAll.do")
//	括号中写表达式，只有ADMIN用户可以findAll
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ModelAndView findAll(@RequestParam(name = "page", required = true, defaultValue = "1") Integer page,
			@RequestParam(name = "size", required = true, defaultValue = "4") Integer size) throws Exception {
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
	
	
	
	@RequestMapping("/findById.do")
//	查询订单详细数据
//    使用@RequestParam，请求得到前端的参数page和size
    public ModelAndView findById(@RequestParam(name = "id", required = true) String userId) throws Exception {
        ModelAndView mv = new ModelAndView();
//        第20行使用了autowired注解方式创建了对象，在这里调用了service的findById方法，拿到了订单的详细数据
        UserInfo users = userService.findById(userId);
//       mv调用addObject方法将查询到的订单的详细数据所有数据传给前台，例如orders-show.jsp文件第106行"orders.orderNum"
        mv.addObject("user",users);
      //mv.setViewName(),指定了前台文件为orders-show，前台页面跳转到orders-show.jsp
        mv.setViewName("user-show");
        return mv;
    }
	
}
