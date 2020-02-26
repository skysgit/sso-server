package com.cn.app.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 这里没有使用SpringBootApplication或SpringCloudApplication注解，会报错
 * 原因也很简单，我们的java源码目录下没有目录，我们手动加一个也就正常了，
 * 为了写点体会和这里没必要用到包和类，所以使用这种方式
 */
@EnableEurekaClient
@SpringBootApplication
public class SSOServiceAppTest {
	  public static void main(String[] args) {
	        SpringApplication.run(SSOServiceAppTest.class, args);
	    }
}
