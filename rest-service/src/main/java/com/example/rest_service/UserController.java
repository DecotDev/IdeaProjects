package com.example.rest_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    public List<User> getAllUsers() {
        return userService.getUsers();
    }

    public User getUser(int id) {
        return userService.getUserById(id);
    }

    public void newUser(User user) {
        userService.newUser(user);
    }

    public void removeUser(int id) {
        userService.deleteUser(id);
    }
}
