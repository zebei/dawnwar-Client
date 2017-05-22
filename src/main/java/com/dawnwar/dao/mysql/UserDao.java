package com.dawnwar.dao.mysql;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.dawnwar.entity.User;

@Repository
public class UserDao extends BaseDao<User>{
	public List<User> findInUserIds(List<Long> UserIds) {
		return getSqlSession().selectList(sqlId("findInUserIds"), UserIds);
	}   
}
