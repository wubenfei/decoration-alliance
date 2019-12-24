package com.ours.friendlyCompany;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

//@EnableHystrix
//@EnableRedisHttpSession(flushMode = FlushMode.IMMEDIATE, maxInactiveIntervalInSeconds = 1800)
@SpringBootApplication
@MapperScan("com.ours.friendlyCompany.dao")
@EnableDiscoveryClient
@EnableCaching
public class FriendlyCompanyApplication {

    public static void main(String[] args) {
        SpringApplication.run(FriendlyCompanyApplication.class, args);
    }

}
