package com.zxj.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.zxj.bean.Users;

public interface UsersPageSortDao extends PagingAndSortingRepository<Users, Integer> {
	

}
