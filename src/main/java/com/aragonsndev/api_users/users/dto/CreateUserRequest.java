package com.aragonsndev.api_users.users.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public record CreateUserRequest(
        @NotEmpty String name,
        @Email @NotBlank String email,
        @NotBlank @Size(min = 6) String password,
        @NotBlank String role
        ) { }
