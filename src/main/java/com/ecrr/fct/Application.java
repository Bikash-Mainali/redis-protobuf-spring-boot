package com.ecrr.fct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;
import com.ecrr.fct.protobufgenerated.Address;
import com.ecrr.fct.protobufgenerated.People;
import com.ecrr.fct.protobufgenerated.Person;

import java.util.Arrays;

@SpringBootApplication
@EnableCaching
public class Application{

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
