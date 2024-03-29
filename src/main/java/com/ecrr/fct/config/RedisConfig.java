package com.ecrr.fct.config;

import com.ecrr.fct.model.Address;
import com.ecrr.fct.model.People;
import com.ecrr.fct.serializer.CustomObjectSerializer;
import com.ecrr.fct.serializer.msgpack.MessagePackSerializer;
import com.ecrr.fct.serializer.protobufs.ProtobufsSerializer;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.protobuf.Message;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.data.redis.serializer.*;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import java.time.Duration;

@Configuration
@EnableRedisRepositories
@ComponentScan("com.ecrr.fct")
public class RedisConfig {

    //if you want to produce protobuf formatted response body to the client/consumer through rest API
//    @Bean
//    ProtobufHttpMessageConverter protobufHttpMessageConverter() {
//        return new ProtobufHttpMessageConverter();
//    }

    @Bean
    public JedisConnectionFactory connectionFactory() {
        RedisStandaloneConfiguration configuration = new RedisStandaloneConfiguration();
        //configuration.setHostName("localhost");
        //configuration.setPort(6379);
        return new JedisConnectionFactory(configuration);
    }

    @Bean
    public RedisTemplate<String, Message> template() {
        RedisTemplate<String, Message> template = new RedisTemplate<>();
        template.setConnectionFactory(connectionFactory());
        template.setKeySerializer(new GenericToStringSerializer(Object.class));
//      template.setHashKeySerializer(new Jackson2JsonRedisSerializer(Object.class));
        template.setValueSerializer(new ProtobufsSerializer<>());
//      template.setHashValueSerializer(new Jackson2JsonRedisSerializer<>(Object.class));
        template.setEnableTransactionSupport(true);
        template.afterPropertiesSet();
        return template;
    }

    @Bean("json")
    public RedisTemplate<String, Object> jsonRedisTemplate() {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(connectionFactory());

        // Use Jackson serializer with alias names
        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(new GenericJackson2JsonRedisSerializer());

        template.afterPropertiesSet();
        return template;
    }


//    @Bean
//    public RedisCacheManager cacheManager(RedisConnectionFactory redisConnectionFactory) {
//        RedisCacheConfiguration cacheConfiguration = RedisCacheConfiguration.defaultCacheConfig()
//                //.serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(template().getValueSerializer()))
//                //.serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(template().getKeySerializer()))
//                .entryTtl(Duration.ofDays(1000));
//        return RedisCacheManager.builder(redisConnectionFactory)
//                .cacheDefaults(cacheConfiguration)
//                .build();
//    }
}
