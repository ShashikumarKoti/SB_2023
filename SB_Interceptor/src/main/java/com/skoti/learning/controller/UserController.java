package com.skoti.learning.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
@RequestMapping("/v1/api")
public class UserController {

    @GetMapping("/users")
    public ResponseEntity<Object> getAllUsers() {
        HttpHeaders headers = new HttpHeaders();   //example to send headers in response
        headers.add("USERID", "response-userID");
        headers.add("COUNTRY", "response-country");
        return  ResponseEntity.status(200).headers(headers).body(Arrays.asList("shashi","kumar","koti"));
    }
}
