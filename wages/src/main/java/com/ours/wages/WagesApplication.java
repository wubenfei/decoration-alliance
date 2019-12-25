package com.ours.wages;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@MapperScan("com.ours.wages.mapper")
@EnableDiscoveryClient
@ServletComponentScan(basePackages = {"com.ours.wages.filter"})
public class WagesApplication {

    public static void main(String[] args) {
        SpringApplication.run(WagesApplication.class, args);
    }

}
