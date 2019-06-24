package com.kewei.manager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.WebApplicationInitializer;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = "com.kewei.manager.dao")
public class ManagerApplication extends SpringBootServletInitializer implements WebApplicationInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application){

		return application.sources(ManagerApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(ManagerApplication.class, args);
		System.out.println("SpringBoot启动成功");
	}
}
