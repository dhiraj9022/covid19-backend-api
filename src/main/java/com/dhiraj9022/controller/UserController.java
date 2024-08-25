package com.dhiraj9022.controller;

import com.dhiraj9022.dto.UserDto;
import com.dhiraj9022.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/logged")
    public UserDto getUser(){
        return userService.getAuthUser();
    }
}
