package com.meac.todolistapi.controllers;

import com.meac.todolistapi.entities.UserAuthDTO;
import com.meac.todolistapi.services.AuthUserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.meac.todolistapi.security.TokenDTO;


@RestController
@RequestMapping("/login")
public class AuthUserController {

    @Autowired
    private AuthUserServices authUserServices;

    @PostMapping
    public ResponseEntity<TokenDTO> login(@RequestBody UserAuthDTO userAuthDTO) {
        TokenDTO token = authUserServices.auth(userAuthDTO);
        return ResponseEntity.ok(token);
    }
}
