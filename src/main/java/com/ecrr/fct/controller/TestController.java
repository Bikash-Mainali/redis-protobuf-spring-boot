package com.ecrr.fct.controller;

import com.ecrr.fct.model.Address;
import com.ecrr.fct.protobufgenerated.People;
import com.ecrr.fct.serializer.json.Json;
import com.ecrr.fct.serializer.protobufs.ProtobufsSerializer;
import com.google.gson.Gson;
import com.google.protobuf.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.stream.Stream;

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

    @Autowired
    @Qualifier("json")
    private RedisTemplate<String, Object> jsonRedisTemplate;
    //this is specific to People message. It would be different for different message type
    //private final ProtobufSerializer<People> serializer = new ProtobufSerializer<People>(People.class);

    @GetMapping("/protobuf/{id}")
    //@Cacheable(key = "#id",value = "people")
    public ResponseEntity<?> protobuf(@PathVariable int id) throws IOException {
        //use redistemplate to check if exist and set to the redis or
        //user @Cacheable but needs to configure HttpMessageConversion
        //but keep in mind that it produces protobuf formatted response body
        //redisTemplate.setValueSerializer(serializer);

        //set messageType in singleton instance
        ProtobufsSerializer.setMessageType(People.class);
        People people = (People) redisTemplate.opsForValue().get(String.valueOf(id));

        if(people == null){
            //set proto message to redis cache
            System.out.println("fetching data from DB");
            People peopleMessage = generatePeopleClass();
            redisTemplate.opsForValue().set(String.valueOf(id), peopleMessage);
            people = peopleMessage;
        }
        //convert to json
        return new ResponseEntity<>(people, HttpStatus.OK);
    }

    @GetMapping("/json/{id}")
    public ResponseEntity<?> json(@PathVariable String id) throws IOException {
        com.ecrr.fct.model.People people = (com.ecrr.fct.model.People) jsonRedisTemplate.opsForValue().get(id);
        if(people == null){
            //set proto message to redis cache
            System.out.println("fetching data from DB");
            com.ecrr.fct.model.People people1 = Json.generatePeopleClass();
            jsonRedisTemplate.opsForValue().set(id, people1);
            people = people1;
        }
        //convert to json
        return new ResponseEntity<>(new Gson().toJson(people), HttpStatus.OK);
    }
}
