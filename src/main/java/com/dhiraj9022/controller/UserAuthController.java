package com.dhiraj9022.controller;

import com.dhiraj9022.dto.LoginDto;
import com.dhiraj9022.dto.SignInDto;
import com.dhiraj9022.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/auth")
public class UserAuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<Map<String, Object>> registerHandler(@Valid @RequestBody SignInDto dto){
        return ResponseEntity.ok(authService.signIn(dto));
    }

    @PostMapping("/login")
    Map<String, Object> loginHandler(@Valid @RequestBody LoginDto dto) {
        return authService.login(dto);
    }
}
