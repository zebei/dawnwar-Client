package com.dawnwar;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ClientServiceApplication {

	public static void main(String[] args) {
		long starTime = System.currentTimeMillis();
		new SpringApplicationBuilder(ClientServiceApplication.class).web(true).run(args);
		long endTime = System.currentTimeMillis();
		long time = endTime - starTime;
		System.out.println("\nStart Time: " + time / 1000 + " s");
		System.out.println("...............................................................");
		System.out.println("..........Client Service starts successfully............");
		System.out.println("...............................................................");
	}

}
