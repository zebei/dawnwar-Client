/*package com.dawnwar.utils;

import java.util.concurrent.TimeUnit;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class RedisLock  {

    @Autowired
    private StringRedisTemplate redisTemplate;


    // lock flag stored in redis
    private static final String LOCKED = "TRUE";

    // timeout(ms)
    private static final long TIME_OUT = 300000;

    // lock expire time(s)
    public static final int EXPIRE = 120;

    // private Jedis jedis;
    private String key;

    // state flag
    private volatile boolean locked = false;


    public void SetRedisLockKey(String source) {
        this.key = source+":OUTCATEGORY:LOCK";
    }

  

    public void lock(long timeout) {
        long nano = System.nanoTime();
        timeout *= 1000000;
        try {
            while (System.nanoTime()-nano < timeout) {
                if (redisTemplate.getConnectionFactory().getConnection().setNX(key.getBytes(), LOCKED.getBytes())) {
                    redisTemplate.expire(key, EXPIRE, TimeUnit.SECONDS);
                    locked = true;
                    log.info("add RedisLock key:{}",key);
                    break;
                }
                Thread.sleep(1000);
            }
        } catch (Exception e) {
        	log.error("start redisLock fail key:{}",key,e);
        	
        }
    }

    public void unlock() {
        if (locked) {
            log.info("release RedisLock key:{}",key);
            redisTemplate.delete(key);
        }
    }

    public void lock() {
        lock(TIME_OUT);
    }

    public void lockInterruptibly() throws InterruptedException {
    
    }


    public boolean tryLock() {
        return false;
    }

    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

}
*/