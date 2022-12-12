package com.OOPSg22.major.service;

import com.OOPSg22.major.model.User;
import com.OOPSg22.major.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    public void addUser(User user)
    {
        userRepository.save(user);
    }
    public List<User> getAllUser()
    {
        return userRepository.findAll();
    }
    public void removerUserById(int id)
    {
        userRepository.deleteById(id);
    }

    public Optional<User> getUserById(int id)
    {
        return userRepository.findById(id);
    }
}
