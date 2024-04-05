package com.example.apireactevaluation.controller;
import com.example.apireactevaluation.entity.User;
import com.example.apireactevaluation.entity.UserLibrary;
import com.example.apireactevaluation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin ("*")
@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    // Endpoint pour récupérer tous les utilisateurs
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    // Endpoint pour ajouter un nouvel utilisateur
    @PostMapping
    public ResponseEntity<User> addUser(@RequestBody User user) {
        User newUser = userService.addUser(user);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    // Endpoint pour récupérer un utilisateur par son ID
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long id) {
        User user = userService.getUserById(id);
        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint pour supprimer un utilisateur par son ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserById(@PathVariable("id") Long id) {
        userService.deleteUserById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("/search")
    public List<User> searchUsers(@RequestParam(name="keyword",defaultValue = "")String keyword){
        return userService.searchUser("%"+keyword+"%");
    }
    @GetMapping("/user-library/{userId}")
    public ResponseEntity<UserLibrary> getUserLibraryById(@PathVariable Long userId) {
        UserLibrary userLibrary = userService.getUserLibraryByUserId(userId);
        return ResponseEntity.ok().body(userLibrary);
    }


}
