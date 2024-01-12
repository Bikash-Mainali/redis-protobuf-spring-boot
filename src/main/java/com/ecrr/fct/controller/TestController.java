package com.ecrr.fct.controller;

import com.ecrr.fct.protobufgenerated.People;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.ecrr.fct.Protobuf.Protobuf.generatePeopleClass;

/**
 * @PROJECT IntelliJ IDEA
 * @AUTHOR Bikash Mainali
 * @DATE 1/11/24
 */

@RestController
@RequestMapping("/people")
public class TestController {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @GetMapping("/{id}")
    @Cacheable(key = "#id",value = "peoples")
    public People cacheTest(@PathVariable int id) {
        redisTemplate.opsForValue().set("key", generatePeopleClass());
        return null;
    }



}
