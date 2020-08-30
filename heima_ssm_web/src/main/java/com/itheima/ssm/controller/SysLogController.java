package com.itheima.ssm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.itheima.ssm.domain.SysLog;
import com.itheima.ssm.service.ISysLogService;

@Controller
@RequestMapping("/sysLog")
public class SysLogController {

	@Autowired
	private ISysLogService sysLogService ;
	
	@RequestMapping("/findAll.do")
	public ModelAndView findAll()throws Exception{
		ModelAndView mv =new ModelAndView();
		List<SysLog> sysLogs=sysLogService.findAll();
		mv.addObject("sysLogs",sysLogs);
		mv.setViewName("syslog-list");
		
		return mv;
	}
	
	
}
