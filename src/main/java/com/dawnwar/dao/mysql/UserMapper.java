package com.dawnwar.dao.mysql;

import java.util.List;

import org.apache.ibatis.annotations.*;

import com.dawnwar.entity.User;

@Mapper
public interface UserMapper {
	@Select("SELECT * FROM user WHERE name = #{name}")
	User findByName(@Param("name") String name);

	@Insert("INSERT INTO user(name, age) VALUES(#{name}, #{age})")
	int insert(@Param("name") String name, @Param("age") Integer age);

	@Update("UPDATE user SET age=#{age} WHERE name=#{name}")
	void update(User user);

	@Delete("DELETE FROM user WHERE id =#{id}")
	void delete(Long id);
	
	
	
	@Results({
	    @Result(property = "name", column = "name"),
	    @Result(property = "age", column = "age")
	})
	@Select("SELECT name, age FROM user")
	List<User> findAll();
}
