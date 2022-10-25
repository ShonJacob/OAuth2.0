package com.shonjacob.oauth.ResourceServer.controller;

import com.shonjacob.oauth.ResourceServer.response.UserRest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping("/status/check")
    public String status(){
        return "Working...";
    }

    //@Secured("ROLE_developer")//we need to specify authority names who can access this method
    @PreAuthorize("hasRole('developer') or #id == #jwt.subject") // the user id is the "sub" in the JWT token which is the id of the current user
    @DeleteMapping(path="/{id}")
    public String deleteUser(@PathVariable String id, @AuthenticationPrincipal Jwt jwt){
        return "User deleted with id "+id+ " and JWT subject "+jwt.getSubject();
    }

    @PostAuthorize("returnObject.userId == #jwt.subject")//checks after the method is executed to validate against return values
    @GetMapping(path="/{id}")
    public UserRest getUser(@PathVariable String id, @AuthenticationPrincipal Jwt jwt){
        return UserRest.builder().userFirstName("Shon").userLastName("Jacob").userId(id).build();
    }
}
