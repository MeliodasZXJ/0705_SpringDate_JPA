package com.zxj.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zxj.bean.Users;
import com.zxj.dao.UsersCrudDao;
import com.zxj.service.UsersCrudService;
@Service
public class UsersCrudServiceImpl implements UsersCrudService {
	
	@Autowired
	private UsersCrudDao usersCrudDao;	

	@Override	//登陆信息确认
	public Users login(String uname, String upass) {
		// TODO Auto-generated method stub
		return usersCrudDao.login(uname, upass);
	}

}
