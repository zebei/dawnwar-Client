package com.dawnwar.entity;

import java.io.Serializable;

import lombok.Data;

@Data
public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6567456337436457038L;
	private long id;
	private String name;
	private Integer age;

}
