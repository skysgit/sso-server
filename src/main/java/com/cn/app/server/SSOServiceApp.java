package com.cn.app.server;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @EnableEurekaClient或者使用@EnableDiscoveryClient
 */
@EnableEurekaClient
@SpringBootApplication
@RestController
public class SSOServiceApp {
	  public static void main(String[] args) {
	        SpringApplication.run(SSOServiceApp.class, args);
	    }
	  
	  @Value("${test}")
	  public String test;
	  
	  @Value("${test1}")
	  public String test1;
	  
	  @RequestMapping("/test")
	  public String test() {
		  return test+","+test1;
	  }
}
