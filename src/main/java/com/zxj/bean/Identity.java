package com.zxj.bean;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table
public class Identity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String name;
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="uid",unique=true)
	private Users users;
	@Override
	public String toString() {
		return "Identity [id=" + id + ", name=" + name + "]";
	}	

}
