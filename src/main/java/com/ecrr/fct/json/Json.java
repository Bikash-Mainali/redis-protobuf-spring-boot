package com.ecrr.fct.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ecrr.fct.model.Address;
import com.ecrr.fct.model.People;
import com.ecrr.fct.model.Person;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;

public class Json {

    public static String outputPath = "./jsonOutput";

    public static void main(String[] args) throws IOException {
        Json json = new Json();

        People people = json.generatePeopleClass();
        json.serializeAndWriteToFile(people);
    }

    public void serializeAndWriteToFile(People people) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File(outputPath);
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write(objectMapper.writeValueAsBytes(people));
    }

    public People generatePeopleClass() {
        Address firstAddress = Address.builder()
                .street("street1")
                .number(100)
                .build();

        Address secondAddress = Address.builder()
                .street("street2")
                .number(101)
                .build();

        Address thirdAddress = Address.builder()
                .street("street3")
                .number(102)
                .build();

        Person firstPerson = Person.builder()
                .name("person1")
                .address(Arrays.asList(firstAddress, secondAddress))
                .mobile(Collections.singletonList("9999999999"))
                .email(Collections.singletonList("person1@example.com"))
                .build();

        Person secondPerson = Person.builder()
                .name("person2")
                .address(Collections.singletonList(thirdAddress))
                .mobile(Collections.singletonList("8888888888"))
                .email(Collections.singletonList("person2@example.com"))
                .build();

        People people = People.builder()
                .person(Arrays.asList(firstPerson, secondPerson))
                .build();

        return people;
    }
}
