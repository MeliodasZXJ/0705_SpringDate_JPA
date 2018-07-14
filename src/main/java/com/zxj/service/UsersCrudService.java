package com.zxj.service;

import com.zxj.bean.Users;

public interface UsersCrudService {
	//登陆信确认 
	public Users login(String uname,String upass);

}
