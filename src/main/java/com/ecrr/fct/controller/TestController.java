package com.ecrr.fct.controller;

import com.ecrr.fct.protobufgenerated.People;
import com.ecrr.fct.protobufs.ProtobufSerializer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.protobuf.Message;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.util.JsonFormat;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

import static com.ecrr.fct.Protobuf.Protobuf.generatePeopleClass;
import static com.ecrr.fct.util.ProtobufUtil.toJson;

/**
 * @PROJECT IntelliJ IDEA
 * @AUTHOR Bikash Mainali
 * @DATE 1/11/24
 */

@RestController
public class TestController {

    @Autowired
    private RedisTemplate<String, Message> redisTemplate;
    private final ProtobufSerializer<People> serializer = new ProtobufSerializer<People>(People.class);

    @GetMapping("/person/{id}")
    //@Cacheable(key = "#id",value = "people")
    public ResponseEntity<?> getPerson(@PathVariable int id) throws IOException {
        //use redistemplate to check if exist and set to the redis or
        //user @Cacheable but needs to configure HttpMessageConversion
        //but keep in mind that it produces protobuf formatted response body
        redisTemplate.setValueSerializer(serializer);

        People people = (People) redisTemplate.opsForValue().get(String.valueOf(id));

        if(people == null){
            //set proto message to redis cache
            System.out.println("fetching data from DB");
            People peopleMessage = generatePeopleClass();
            redisTemplate.opsForValue().set(String.valueOf(id), peopleMessage);
            people = peopleMessage;
        }
        //convert to json
        return new ResponseEntity<>(toJson(people), HttpStatus.OK);
    }
}
