package com.zxj.service;

import org.springframework.data.domain.Page;

import com.zxj.bean.Users;

public interface UsersPageSortService {
	
	public Page<Users> findAllByPage(Integer pageNumber,Integer pageSize);
	
	public void save(Users u);
	
	public void update(Users u);
	
	public void delete(Integer uid);
	
	public Users findById(Integer uid);

}
