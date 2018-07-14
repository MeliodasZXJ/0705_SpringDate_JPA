package com.zxj.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import com.zxj.bean.Users;

public interface UsersDao extends Repository<Users, Integer>{
	
	public Users findByUid(Integer uid);
	
	public Users findByUnameAndUpass(String uname,String upass);
	
	public List<Users> findByAgeBetweenOrderByAge(Integer min,Integer max);
	
	public List<Users> findByAgeLessThan(Integer age);
	
	public List<Users> findByRemarkIsNull();
	
	public List<Users> findByRemarkNotNull();
	
	public List<Users> findByNameLike(String name);
	
	//StartingWith = 马%   EndingWith = %金
	public List<Users> findByNameEndingWith(String name);
	
	public List<Users> findByNameStartingWith(String name);
	
	public Users findByIdentityName(String name);
	
	//		原生的SQL文  oO0 iI1Ll
	@Query(value="select * from users where uname=:uname and upass=:upass",nativeQuery=true)
	public Users lpgin(@Param("uname")String uname,@Param("upass")String upass);

}
