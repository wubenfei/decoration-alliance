package com.ours.friendlyCompany.config;

import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import static java.util.Collections.singletonMap;

@Configuration
public class RedisConfig {
    @Bean
    public CacheManager cacheManager(RedisConnectionFactory redisConnectionFactory) {
        /* 默认配置， 默认超时时间为30s ，设置序列化方式*/
        RedisCacheConfiguration defaultCacheConfig = RedisCacheConfiguration.defaultCacheConfig().serializeValuesWith(RedisSerializationContext.SerializationPair.
                fromSerializer(new GenericJackson2JsonRedisSerializer())).entryTtl(Duration
                .ofMinutes(30)).disableCachingNullValues();
        //配置student_page_的超时时间为10s
        Map<String, RedisCacheConfiguration> map = singletonMap("getFriendlyCompanyKind", RedisCacheConfiguration.defaultCacheConfig().serializeValuesWith(RedisSerializationContext.SerializationPair.
                fromSerializer(new GenericJackson2JsonRedisSerializer())).entryTtl(Duration.ofMinutes(10L))
                .disableCachingNullValues());

        RedisCacheManager cacheManager = RedisCacheManager.builder(RedisCacheWriter.lockingRedisCacheWriter
                (redisConnectionFactory)).cacheDefaults(defaultCacheConfig).withInitialCacheConfigurations(map).transactionAware().build();

        return cacheManager;
    }
}
