package com.itheima.ssm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.itheima.ssm.domain.Orders;
import com.itheima.ssm.service.IOrdersService;

@Controller
@RequestMapping("/orders")
public class OrdersController {

	@Autowired
	private IOrdersService ordersService;

	
	/*
	 * // 未分页时查询全部订单
	 * 
	 * @RequestMapping("/findAll.do") public ModelAndView findAll() throws
	 * Exception { 
	 * ModelAndView mv = new ModelAndView(); 
	 * List<Orders> ordersList= ordersService.findAll(); 
	 * mv.addObject("ordersList", ordersList);
	 * mv.setViewName("orders-list"); return mv; }
	 */
	
	
	// 分页时查询全部订单
	// 使用@RequestMapping在jsp文件中需要寻找到这个"/findAll.do"只需要使用 ${pageContext.request.contextPath}/orders/findAll.do 就可以找到这里
	//接下来使用@RequestParam，请求得到前端的参数page和size,
	// 建立ModelAndView的对象，他调用mv.addObject();，mv.setViewName();两个方法。
	@RequestMapping("/findAll.do")
	public ModelAndView findAll(@RequestParam(name = "page", required = true, defaultValue = "1") int page,
			@RequestParam(name = "size", required = true, defaultValue = "4") int size) throws Exception {
		ModelAndView mv = new ModelAndView();
//		第20行使用了autowired注解方式创建了对象，在这里调用了service的finAll方法,拿到了orders表的所有数据
		List<Orders> ordersList = ordersService.findAll(page, size);
		// PageInfo就是一个分页bean，将上面得到的orderList集合ordersList传给pageInfo类中的成员变量
		PageInfo pageInfo = new PageInfo(ordersList);
		// mv调用addObject方法将pageInfo的数据传给前台，例如orders-page-list.jsp文件第246行"pageInfo.list"     
		mv.addObject("pageInfo", pageInfo);
		//mv.setViewName(),指定了前台文件为orders-page-list,前台页面跳转到orders-page-list.jsp
		mv.setViewName("orders-page-list");
		return mv;
	}
	
	
	
//	查询订单详细数据
	// <button type="button" class="btn bg-olive btn-xs" onclick="location.href='${pageContext.request.contextPath}/orders/findById.do?id=${orders.id}'">详情</button>
    @RequestMapping("/findById.do")
//    使用@RequestParam，请求得到前端的参数page和size
    public ModelAndView findById(@RequestParam(name = "id", required = true) String ordersId) throws Exception {
        ModelAndView mv = new ModelAndView();
//        第20行使用了autowired注解方式创建了对象，在这里调用了service的findById方法，拿到了订单的详细数据
        Orders orders = ordersService.findById(ordersId);
//       mv调用addObject方法将查询到的订单的详细数据所有数据传给前台，例如orders-show.jsp文件第106行"orders.orderNum"
        mv.addObject("orders",orders);
      //mv.setViewName(),指定了前台文件为orders-show，前台页面跳转到orders-show.jsp
        mv.setViewName("orders-show");
        return mv;
    }
	
	
	
	
	
}
