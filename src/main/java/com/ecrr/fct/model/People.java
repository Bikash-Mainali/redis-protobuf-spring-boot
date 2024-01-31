package com.ecrr.fct.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.google.gson.annotations.SerializedName;
import com.google.j2objc.annotations.Property;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class People implements Serializable {
    @JsonSetter(value = "0")
    private List<Person> person;
}
