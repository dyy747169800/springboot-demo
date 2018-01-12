package com.dyy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * 程序入口
 * @author 段杨宇
 * @SpringBootApplication 等同于@EnableAutoConfiguration @ComponentScan("com.dyy")  @Configuration
 * spring通常建议我们将main方法所在的类放到一个root包下
 */
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
