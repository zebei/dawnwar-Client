package com.dawnwar.entity;

import java.io.Serializable;

import lombok.Data;

@Data
public class UserModel implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6567456337436457038L;
	private Long id;
	private String name;
	private Integer age;

	public UserModel(String name, Integer age) {
		this.name = name;
		this.age = age;
	}

}
