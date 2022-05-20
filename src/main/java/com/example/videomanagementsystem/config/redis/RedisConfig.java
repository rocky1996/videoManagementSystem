package com.example.videomanagementsystem.config.redis;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import redis.clients.jedis.JedisPoolConfig;

@Configuration
@EnableAutoConfiguration
public class RedisConfig {

    @Bean
    @ConfigurationProperties(prefix = "spring.redis.pool")
    public JedisPoolConfig getRedisConfig() {
        return new JedisPoolConfig();
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.redis")
    public JedisConnectionFactory getJedisConnectionFactory() {
        JedisConnectionFactory factory = new JedisConnectionFactory();
        factory.setUsePool(true);
        JedisPoolConfig jedisPoolConfig = getRedisConfig();
        factory.setPoolConfig(jedisPoolConfig);
        return factory;
    }

    @Bean
    public RedisTemplate<?,?> getRedisTemplate() {
        JedisConnectionFactory factory = getJedisConnectionFactory();
        RedisTemplate<?,?> redisTemplate = new StringRedisTemplate(factory);
        return redisTemplate;
    }
}
