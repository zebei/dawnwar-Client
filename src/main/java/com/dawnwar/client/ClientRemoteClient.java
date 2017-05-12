package com.dawnwar.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "compute-service", fallback = ClientHystrix.class)

public interface ClientRemoteClient {
	
	
	 @RequestMapping(value = "/add" ,method = RequestMethod.GET)
	 public Integer add(@RequestParam Integer a, @RequestParam Integer b); 
	
}
