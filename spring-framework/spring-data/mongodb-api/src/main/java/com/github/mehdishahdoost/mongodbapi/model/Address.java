package com.github.mehdishahdoost.mongodbapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Address {
    private String province;
    private String city;
    private String address;
}
