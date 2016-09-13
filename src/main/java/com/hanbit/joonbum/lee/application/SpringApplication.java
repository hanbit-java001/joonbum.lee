package com.hanbit.joonbum.lee.application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.Log4jConfigurer;

import com.sun.org.apache.bcel.internal.util.ClassPath;

public class SpringApplication {

	public static void main(String[] args) {
		try {
			Log4jConfigurer.initLogging("classpath:config/log4j.xml");

			ApplicationContext applicationContext = //ioc 컨테이너
					new ClassPathXmlApplicationContext("spring/applicationContext-core.xml");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
