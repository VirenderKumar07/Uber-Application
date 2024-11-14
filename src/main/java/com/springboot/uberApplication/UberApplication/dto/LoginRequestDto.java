package com.springboot.uberApplication.UberApplication.dto;


import lombok.Data;

@Data
public class LoginRequestDto {

    private String email;
    private String password;
}
