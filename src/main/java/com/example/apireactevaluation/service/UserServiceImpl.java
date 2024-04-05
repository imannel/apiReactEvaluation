package com.example.apireactevaluation.service;

import com.example.apireactevaluation.entity.User;
import com.example.apireactevaluation.entity.UserLibrary;
import com.example.apireactevaluation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;
    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }
    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
    @Override
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }
    @Override
    public List<User> searchUser(String keyword) {
        return userRepository.searchUser(keyword);
    }
    @Override
    public UserLibrary getUserLibraryByUserId(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + userId));

        return user.getUserLibrary();
    }
}
