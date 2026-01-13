package com.aragonsndev.api_users.users.service;

import com.aragonsndev.api_users.users.dto.CreateUserRequest;
import com.aragonsndev.api_users.users.dto.UserResponse;
import com.aragonsndev.api_users.users.entity.User;
import com.aragonsndev.api_users.users.repository.UserRepository;
import com.aragonsndev.api_users.users.utils.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper mapper;

    public UserResponse registerUser(CreateUserRequest req){
        if (userRepository.existsByEmail(req.email())) throw new RuntimeException("Email registrado");
        System.out.println(req);
        User user = mapper.toEntity(req);
        User savedUser = userRepository.save(user);
        return mapper.toResponse(savedUser);
    }
}
