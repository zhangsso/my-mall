package com.zhangs.zullservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class ZullServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZullServiceApplication.class, args);
	}

}
