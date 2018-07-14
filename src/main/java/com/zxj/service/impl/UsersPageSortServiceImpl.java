package com.zxj.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;

import com.zxj.bean.Users;
import com.zxj.dao.UsersPageSortDao;
import com.zxj.service.UsersPageSortService;
@Service
public class UsersPageSortServiceImpl implements UsersPageSortService {
	
	@Autowired
	private UsersPageSortDao usersPageSortDao;

	@Override
	public Page<Users> findAllByPage(Integer pageNumber, Integer pageSize) {		
		Order order=new Sort.Order(Direction.ASC,"uname");
		Sort sort=new Sort(order);
		Pageable pageable=new PageRequest(pageNumber,pageSize);
		Page<Users> pages=usersPageSortDao.findAll(pageable);
		return pages;
	}

	@Override
	public void save(Users u) {
		// TODO Auto-generated method stub
		usersPageSortDao.save(u);
	}

	@Override
	public void update(Users u) {
		// TODO Auto-generated method stub
		usersPageSortDao.save(u);
	}

	@Override
	public void delete(Integer uid) {
		// TODO Auto-generated method stub
		usersPageSortDao.delete(uid);
	}

	@Override
	public Users findById(Integer uid) {
		// TODO Auto-generated method stub
		return usersPageSortDao.findOne(uid);
	}

	

}
