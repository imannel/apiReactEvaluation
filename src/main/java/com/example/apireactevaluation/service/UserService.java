package com.example.apireactevaluation.service;

import com.example.apireactevaluation.entity.User;
import com.example.apireactevaluation.entity.UserLibrary;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    User addUser(User user);

    User getUserById(Long id);

    void deleteUserById(Long id);

    List<User> searchUser(String keyword);

    UserLibrary getUserLibraryByUserId(Long userId);
}
