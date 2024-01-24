//package com.ecrr.fct.serializer.pdx;
//
//import com.ecrr.fct.model.Address;
//import com.ecrr.fct.model.People;
//import com.ecrr.fct.model.Person;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.apache.geode.cache.*;
//import org.apache.geode.pdx.PdxInstance;
//
//import java.io.*;
//import java.nio.file.Files;
//import java.util.Arrays;
//import java.util.Collections;
//
//
///**
// * @PROJECT IntelliJ IDEA
// * @AUTHOR Bikash Mainali
// * @DATE 1/22/24
// */
//public class PdxSerializer {
//
//
//    public static String outputPath = "./output.file/pdxOutput.txt";
//
//
//    public static void main(String[] args) throws IOException {
//
//        Cache gemfireCache = GemfireConfig.configGemfireCache();
//
//        People1 people1 = new People1("Bikash Mainali");
//        // Create or get a region from the GemFire Cache
//        Region<String, People1> regionMap = createRegion("test", gemfireCache);
//
//        // Put the PDX instance into the GemFire region
//        System.out.println("........writing into  cache.......");
//        regionMap.put("testKey", people1);
//
//        System.out.println("........reading from cache.......");
//        if (regionMap != null) {
//            System.out.println("size of region" + regionMap.size());
//        } else {
//            System.err.println("Region not found.");
//        }
//        People1 retrievedObject = regionMap.get("testKey");
//        System.out.println(retrievedObject);
//
//        // Your GemFire operations go here
//        gemfireCache.close();
//    }
//
//
//
//    private static <K, V> Region<K, V> createRegion(String regionName, Cache cache) {
//        RegionFactory<K, V> regionFactory = cache.createRegionFactory();
//        return regionFactory.create(regionName);
//    }
//
//    public static People generatePeopleClass() {
//        Address firstAddress = Address.builder()
//                .street("street1")
//                .number(100)
//                .build();
//
//        Address secondAddress = Address.builder()
//                .street("street2")
//                .number(101)
//                .build();
//
//        Address thirdAddress = Address.builder()
//                .street("street3")
//                .number(102)
//                .build();
//
//        Person firstPerson = Person.builder()
//                .name("person1")
//                .address(Arrays.asList(firstAddress, secondAddress))
//                .mobile(Collections.singletonList("9999999999"))
//                .email(Collections.singletonList("person1@example.com"))
//                .build();
//
//        Person secondPerson = Person.builder()
//                .name("person2")
//                .address(Collections.singletonList(thirdAddress))
//                .mobile(Collections.singletonList("8888888888"))
//                .email(Collections.singletonList("person2@example.com"))
//                .build();
//
//        People people = People.builder()
//                .person(Arrays.asList(firstPerson, secondPerson))
//                .build();
//
//        return people;
//    }
//
//}
