package com.example.rest_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    public List<UserDTO> getAllUsers() {
        List<User> users = userService.getUsers();
        return users.stream().map(UserDTO::new).toList();
    }

    public UserDTO getUser(int id) {
        User user =  userService.getUserById(id);
        return new UserDTO(user);
    }

    public void newUser(UserDTO user) {
        userService.newUser(user);
    }

    public void removeUser(int id) {
        userService.deleteUser(id);
    }

    public void updateUser(UserDTO userPatched) {
        userService.patchUser(userPatched);
    }

    //public void removeUser(int id) {
    //    userService.deleteUser(id);
    //}
}
