package com.dawnwar.dao.redis;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Repository;

import com.dawnwar.entity.UserModel;


@Repository
public class UserRedisDao extends BaseRedisConfig<UserModel> {
	
	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	@Autowired
	private RedisTemplate<String, UserModel> redisTemplate;

	@Test
	public void test() throws Exception {

		// 保存字符串
		stringRedisTemplate.opsForValue().set("aaa", "111");
		Assert.assertEquals("111", stringRedisTemplate.opsForValue().get("aaa"));

		// 保存对象
		UserModel user = new UserModel("超人", 20);
		redisTemplate.opsForValue().set(user.getName(), user);

		user = new UserModel("蝙蝠侠", 30);
		redisTemplate.opsForValue().set(user.getName(), user);

		user = new UserModel("蜘蛛侠", 40);
		redisTemplate.opsForValue().set(user.getName(), user);

		Assert.assertEquals(20, redisTemplate.opsForValue().get("超人").getAge().longValue());
		Assert.assertEquals(30, redisTemplate.opsForValue().get("蝙蝠侠").getAge().longValue());
		Assert.assertEquals(40, redisTemplate.opsForValue().get("蜘蛛侠").getAge().longValue());

	}

	
    
   
}
