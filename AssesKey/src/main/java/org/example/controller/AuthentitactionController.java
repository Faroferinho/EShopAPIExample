package org.example.controller;

import org.example.models.ResponseToken;
import org.example.models.User;
import org.example.safety.Constant;
import org.example.safety.JwtTokenProvider;
import org.example.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class AuthentitactionController {
    @Autowired
    private JwtTokenProvider tokenProvider;

    @Autowired
    private UserService service;

    @PostMapping(Constant.USER)
    public ResponseToken login(@RequestBody User u){
        if(service.validadeLogin(u)){
            String token = tokenProvider.generateToken(u.getEmail());
            return new ResponseToken("Authenticated", token);
        }

        throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Incorrect User or Password");
    }
}
