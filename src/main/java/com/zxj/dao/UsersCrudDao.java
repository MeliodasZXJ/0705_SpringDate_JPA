package com.zxj.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.zxj.bean.Users;

public interface UsersCrudDao extends CrudRepository<Users, Integer> {
	
	@Query(value="select * from users where uname=:uname and upass=:upass",nativeQuery=true)
	public Users login(@Param("uname")String uname,@Param("upass")String upass);

}
