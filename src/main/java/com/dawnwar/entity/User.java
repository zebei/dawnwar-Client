package com.dawnwar.entity;

import java.io.Serializable;

import lombok.Data;

@Data
public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6567456337436457038L;
	private Long id;
	private String name;
	private Integer age;

	public User(String name, Integer age) {
		this.name = name;
		this.age = age;
	}
	public User(Long id,String name,Integer age){
		this.id=id;
		this.name=name;
		this.age=age;
	}

}
