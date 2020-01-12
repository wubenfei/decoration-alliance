package com.ours.userappservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.session.FlushMode;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@SpringBootApplication
@EnableEurekaClient
@EnableRedisHttpSession(flushMode = FlushMode.IMMEDIATE)
@EnableCaching
@MapperScan("com.ours.userappservice.mapper")
public class UserappServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserappServiceApplication.class, args);
    }

}
