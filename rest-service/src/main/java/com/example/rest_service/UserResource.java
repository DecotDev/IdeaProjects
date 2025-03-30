package com.example.rest_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(UserResource.USERS)
public class UserResource {
    public static final String USERS = "/api/v0/users";

    @Autowired
    UserController userController;

    @GetMapping
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok().body(userController.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable int id) {
        return ResponseEntity.ok().body(userController.getUser(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> removeUser(@PathVariable int id) {
        User removedUser = userController.getUser(id);
        userController.removeUser(id);
        return ResponseEntity.ok().body(removedUser);
    }

    @PostMapping
    public ResponseEntity<User> addUser(@RequestBody User user) {
        userController.newUser(user);
        return ResponseEntity.ok().body(user);
    }

}
