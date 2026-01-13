package com.aragonsndev.api_users.users.controller;

import com.aragonsndev.api_users.users.dto.CreateUserRequest;
import com.aragonsndev.api_users.users.dto.UserResponse;
import com.aragonsndev.api_users.users.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserResponse> createUser(@Valid @RequestBody CreateUserRequest req){
        System.out.println(req);
        var res = userService.registerUser(req);
        return ResponseEntity.status(HttpStatus.CREATED).body(res);
    }

}
