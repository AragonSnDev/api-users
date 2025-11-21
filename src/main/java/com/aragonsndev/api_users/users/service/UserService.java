package com.aragonsndev.api_users.users.service;

import com.aragonsndev.api_users.users.entity.User;
import com.aragonsndev.api_users.users.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService (UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public User registerUser(User user){
        if(userRepository.existsByEmail(user.getEmail())) {
            throw new RuntimeException("Email already registered!");
        }

        return userRepository.save(user);
    }

    public Optional<User> getCurrentUser(User user){
        return userRepository.findById(user.getId());
    }

    public User updateUser(Long id, User user){
       User userToUpdate =  userRepository.findById(id)
               .orElseThrow(() -> new RuntimeException("User not found"));
       applyUpdates(user,userToUpdate);

       return userRepository.save(userToUpdate);
    }

    public void deleteUser(Long id){
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        userRepository.delete(user);
    }

    public void applyUpdates(User user, User updatedUser){
        if(!Objects.equals(user.getName(), updatedUser.getName())){
            updatedUser.setName(user.getName());
        }
        if(!Objects.equals(user.getEmail(), updatedUser.getEmail())){
            updatedUser.setName(user.getEmail());
        }
        if(!Objects.equals(user.getPassword(), updatedUser.getPassword())){
            updatedUser.setPassword(user.getPassword());
        }
    }
}
