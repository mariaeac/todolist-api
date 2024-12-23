package com.meac.todolistapi.services;

import com.meac.todolistapi.entities.User;
import com.meac.todolistapi.services.exceptions.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import com.meac.todolistapi.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServices {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User insert(User obj) {
        validateNewUser(obj);
        return userRepository.save(obj);
    }

    public void validateNewUser(User user) {

        if (userRepository.existsByUsername(user.getUsername())) {
            throw new BusinessException("Username already exists");
        }

        if (userRepository.existsByEmail(user.getEmail())) {
            throw new BusinessException("Email already exists");
        }

    }



}
