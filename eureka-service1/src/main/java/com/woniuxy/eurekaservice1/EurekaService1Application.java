package com.woniuxy.eurekaservice1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaService1Application {

    public static void main(String[] args) {
        SpringApplication.run(EurekaService1Application.class, args);
    }

}
