package com.dawnwar.web;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dawnwar.dao.mysql.UserDao;
import com.dawnwar.entity.User;


@Slf4j
@RefreshScope
@RestController
public class ClientController {


    @Autowired
    private DiscoveryClient client;
    @Autowired
    private UserDao userDao;

    @RequestMapping(value = "/add" ,method = RequestMethod.GET)
    public Integer add(@RequestParam Integer a, @RequestParam Integer b) {
        ServiceInstance instance = client.getLocalServiceInstance();
        Integer r = a + b;
        log.info("/add, host:" + instance.getHost() + ", service_id:" + instance.getServiceId() + ", result:" + r);
        return r;
    }
    
    @Value("${from}")
    private String from;

    @RequestMapping("/from")
    public String from() {
    	log.info("FROM");
        return this.from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getFrom() {
        return from;
    }
    @RequestMapping("/user")
    public User user() {
    	log.info("USER");
    	return userDao.load(1);
        
    }
   

}