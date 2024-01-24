package com.ecrr.fct.serializer.protobufs;

import com.ecrr.fct.protobufgenerated.Address;
import com.ecrr.fct.protobufgenerated.People;
import com.ecrr.fct.protobufgenerated.Person;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

@Component
public
class ProtobufSerialization {

    public static String outputPath = "./output.file/protoOutput.txt";

    public static void main(String[] args) throws IOException {
        ProtobufSerialization ProtobufSerialization = new ProtobufSerialization();

        //from generated classes
        People people = ProtobufSerialization.generatePeopleClass();

        ProtobufSerialization.serializeAndWriteToFile(people);
        ProtobufSerialization.serializeAndPrint(people);
        ProtobufSerialization.deserializeAndPrint();
        ProtobufSerialization.getFileSize(outputPath);
    }

    public void serializeAndWriteToFile(People people) throws IOException {
        Path path = Paths.get(outputPath);

        people.writeTo(Files.newOutputStream(path));
    }

    public void serializeAndPrint(People people) {
        byte [] serializedData = people.toByteArray();

        System.out.println("Serialized Output in Decimal : ");
        System.out.println(Arrays.toString(serializedData));
    }

    public void deserializeAndPrint() throws IOException {
        Path path = Paths.get(outputPath);

        People parsedObject = People.parseFrom(Files.newInputStream(path));
        System.out.println("Deserialized Object : ");
        System.out.println(parsedObject.toString());
    }

    public void getFileSize(String filePath){
        System.out.println("File size in byte is: " + new File(filePath).length());
    }

    public static People generatePeopleClass() {
        Address firstAddress = Address.newBuilder()
                .setStreet("street1")
                .setNumber(100)
                .build();

        Address secondAddress = Address.newBuilder()
                .setStreet("street2")
                .setNumber(101)
                .build();

        Address thirdAddress = Address.newBuilder()
                .setStreet("street3")
                .setNumber(102)
                .build();

        Person firstPerson = Person.newBuilder()
                .setName("person1")
                .addAllAddress(Arrays.asList(firstAddress, secondAddress))
                .addMobile("9999999999")
                .addEmail("person1@example.com")
                .build();

        Person secondPerson = Person.newBuilder()
                .setName("person2")
                .addAddress(thirdAddress)
                .addMobile("8888888888")
                .addEmail("person2@example.com")
                .build();

        People people = People.newBuilder()
                .addPerson(firstPerson)
                .addPerson(secondPerson)
                .build();

        return people;
    }
}
