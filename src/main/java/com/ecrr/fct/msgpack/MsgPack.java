package com.ecrr.fct.msgpack;

import com.ecrr.fct.model.Address;
import com.ecrr.fct.model.People;
import com.ecrr.fct.model.Person;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;

public class MsgPack {

    MessagePackSerializer msgPackSerializer = new MessagePackSerializer();
    static MsgPack msgPack = new MsgPack();
    public static String outputPath = "./output.file/msgPackOutput.txt";

    public static void main(String[] args) throws IOException {
        People people = msgPack.generatePeopleClass();
        msgPack.serializeAndWriteToFile(people); //or SerializationUtils.serialize(msgPack.generatePeopleClass());
    }

    public void serializeAndWriteToFile(People people) throws IOException {
        byte[] serializedData = msgPackSerializer.serialize(people);
        File file = new File(outputPath);
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write(serializedData);
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
