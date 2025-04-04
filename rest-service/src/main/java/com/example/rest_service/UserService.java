package com.example.rest_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserDAO userDAO;

    List<User> getUsers() {
        return  userDAO.findAll();
    }

    public User getUserById(int id) {
        Optional<User> user = userDAO.findById(id);
        if (user.isPresent()) return user.get();
        else return null;
    }

    public User newUser(UserDTO userDTO) {
        User user = new User(userDTO);
        return userDAO.save(user);
    }

    public void deleteUser(int id) {
        userDAO.deleteById(id);
    }

    //public void deleteUser(int id) {
    //    userRepository.delete(id);
    //}
}
