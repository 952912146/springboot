package com.mj.s.springboot.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import java.lang.reflect.Method;  

import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;  
import org.springframework.data.redis.serializer.StringRedisSerializer;

import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mj.s.springboot.entity.Student;  
   

@Configuration  
@EnableCaching//启用缓存，这个注解很重要；  
public class RedisConfig extends CachingConfigurerSupport {  
     
    /** 
     * 缓存管理器. 
     * @param redisTemplate 
     * @return 
     */  
    @Bean  
    public CacheManager cacheManager(RedisConnectionFactory factory) {  
    	RedisCacheManager redisCacheManager = RedisCacheManager.create(factory);
        return redisCacheManager;
    }  
     
    @Bean
    public RedisTemplate<String,Object> redisTemplate(RedisConnectionFactory factory) {
        RedisTemplate<String,Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(factory);
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
        redisTemplate.setHashValueSerializer(new JdkSerializationRedisSerializer());
        return redisTemplate; 
    }  
     
    /** 
     * 自定义key. 
     * 此方法将会根据类名+方法名+所有参数的值生成唯一的一个key,即使@Cacheable中的value属性一样，key也会不一样。 
     */  
    @Override  
    public KeyGenerator keyGenerator() {  
       System.out.println("RedisCacheConfig.keyGenerator()");  
       return new KeyGenerator() {  
           @Override  
           public Object generate(Object o, Method method, Object... objects) {  
              // This will generate a unique key of the class name, the method name  
              //and all method parameters appended.  
              StringBuilder sb = new StringBuilder();  
              sb.append(o.getClass().getName());  
              sb.append(method.getName());  
              for (Object obj : objects) {  
                  sb.append(obj.toString());  
              }  
              System.out.println("keyGenerator=" + sb.toString());  
              return sb.toString();  
           }  
       };  
    } 
   
}
