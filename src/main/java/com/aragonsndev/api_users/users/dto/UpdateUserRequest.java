package com.aragonsndev.api_users.users.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UpdateUserRequest(
        String name,
        @Email String email,
        @Size(min = 6) String password,
        @NotBlank String role
) { }
