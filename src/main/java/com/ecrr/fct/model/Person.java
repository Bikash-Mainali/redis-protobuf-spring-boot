package com.ecrr.fct.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Builder
@Getter
@Setter
@ToString
public class Person implements Serializable {
    private String name;
    private List<Address> address;
    private List<String> mobile;
    private List<String> email;
}
