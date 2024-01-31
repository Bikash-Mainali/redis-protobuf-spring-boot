package com.ecrr.fct.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person implements Serializable {
    //@JsonSetter(value = "0")
    private String name;
    //@JsonSetter(value = "1")
    private List<Address> address;
    //@JsonSetter(value = "2")
    private List<String> mobile;
    //@JsonSetter(value = "3")
    private List<String> email;
}
