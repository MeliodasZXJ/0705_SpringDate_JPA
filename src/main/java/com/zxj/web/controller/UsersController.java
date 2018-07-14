package com.zxj.web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.zxj.bean.Users;
import com.zxj.service.UsersCrudService;
import com.zxj.service.UsersPageSortService;
@Controller
@RequestMapping("User")
public class UsersController {
	
	@Autowired
	private UsersCrudService usersCrudService;
	@Autowired
	private UsersPageSortService usersPageSortService;
	
	@RequestMapping("login")	//	User/login
	public ModelAndView login(@RequestParam("uname")String uname,@RequestParam("upss")String upass) {
		ModelAndView model = new ModelAndView("/pages/login/login.jsp");
		Users u = usersCrudService.login(uname, upass);
		if(u!=null) {
			model = new ModelAndView("/User/pList");
			return model;
		}
		model.addObject("error", "账号或密码错误");
		return model;		
	}
	
	@RequestMapping("pList")	// User/pList
	public ModelAndView pList(@RequestParam(value="pageNumber",required = false,defaultValue="1")Integer pageNumber,
							@RequestParam(value="pageSize",required = false,defaultValue="5")Integer pageSize) {
		ModelAndView model = new ModelAndView("/pages/login/plist.jsp");
		Page<Users> page = usersPageSortService.findAllByPage(pageNumber-1, pageSize);
		model.addObject("userList", page);			
		return model;		
	}
	
	@RequestMapping("findOne") 
	public ModelAndView findOne(@RequestParam("uid")Integer uid) {
		ModelAndView model = new ModelAndView("/pages/login/update.jsp");
		Users u = usersPageSortService.findById(uid);
		model.addObject("user", u);
		return model;		
	}
	
	@RequestMapping("update")	// User/update
	public ModelAndView update(Users u) {
		ModelAndView model = new ModelAndView("/User/pList");
		usersPageSortService.update(u);		
		return model;		
	}
	
	@RequestMapping("save")	// User/save
	public ModelAndView save(Users u) {
		ModelAndView model = new ModelAndView("/User/pList");
		usersPageSortService.save(u);		
		return model;		
	}
	
	@RequestMapping(value="{uid}",method=RequestMethod.DELETE)
	public String delete(@PathVariable(value="uid")Integer uid) {
		usersPageSortService.delete(uid);		
		return "redirect:pList";		
	}
	
	

}
