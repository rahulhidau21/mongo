package com.rahul.mongo.dto;

import lombok.Data;

@Data
public class UserRequest {
    private String id;
    private String name;
    private String email;
    private String password;
    private Integer mobileNumber;
}
