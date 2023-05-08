package com.asma.makeUp.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.asma.makeUp.entities.User;
import com.asma.makeUp.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor

public class UserController {

    private final UserService service;


    @PostMapping
    public void save(
            @RequestBody User user
    ) {
        System.out.println("dans le controller");
         service.save(user);
    }


}