package com.liu.managerial_system;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ServletComponentScan
@ComponentScan(basePackages = {"com.liu.managerial_system.controller","com.liu.managerial_system.service"})
@MapperScan("com.liu.managerial_system.mapper")
public class ManagerialSystemApplication extends SpringBootServletInitializer {

//@ComponentScan(basePackages = {"com.liu.managerial_system.controller", "com.liu.managerial_system.service"})
//@MapperScan("com.liu.managerial_system.mapper")
//@SpringBootApplication
//public class ManagerialSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(ManagerialSystemApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(ManagerialSystemApplication.class);
    }
}
