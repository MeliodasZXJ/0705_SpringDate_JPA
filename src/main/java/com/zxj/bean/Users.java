package com.zxj.bean;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table
public class Users {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer uid;
	private String uname;
	private String upass;
	private String name;
	private String sex;
	private Integer age;
	private String remark;
	@OneToOne(mappedBy="users",fetch=FetchType.LAZY)
	public Identity identity;
	@Override
	public String toString() {
		return "Users [uid=" + uid + ", uname=" + uname + ", upass=" + upass + ", name=" + name + ", sex=" + sex
				+ ", age=" + age + ", remark=" + remark + "]";
	}
	

}
