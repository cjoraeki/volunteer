package com.example.volunteer.pojo.user;


import lombok.Data;

@Data
public class SignUpRequest {

    private String name;
    private String email;
    private String password;
}
