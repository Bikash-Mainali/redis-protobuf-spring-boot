package com.ecrr.fct.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Builder
@Getter
@Setter
@ToString
public class Address  implements Serializable {
    private String street;
    private int number;
}
