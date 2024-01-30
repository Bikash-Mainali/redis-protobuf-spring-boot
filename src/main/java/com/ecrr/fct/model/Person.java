package com.ecrr.fct.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person implements Serializable {
    private String name;
    private List<Address> address;
    private List<String> mobile;
    private List<String> email;
}
