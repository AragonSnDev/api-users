package com.aragonsndev.api_users.users.utils;

import com.aragonsndev.api_users.users.dto.CreateUserRequest;
import com.aragonsndev.api_users.users.dto.UpdateUserRequest;
import com.aragonsndev.api_users.users.dto.UserResponse;
import com.aragonsndev.api_users.users.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
    // Crear usuario: request -> entity
    User toEntity(CreateUserRequest request);

    // Respuesta: entity -> response
    UserResponse toResponse(User user);

    // Update parcial: aplica solo valores no nulos
    void updateFromDto(UpdateUserRequest request, @MappingTarget User user);
}
