package com.shonjacob.oauth.ResourceServer.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

//To access JWT token information and claims
@RestController
@RequestMapping("/token")
public class TokenController {

    //when we authorize with access token, we can access the token through authentication principal which is of type Jwt
    @GetMapping
    public Map<String, Object> getToken(@AuthenticationPrincipal Jwt jwt){
        return Collections.singletonMap("principal", jwt);
    }
}
