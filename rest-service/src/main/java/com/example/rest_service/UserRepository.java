package com.example.rest_service;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository {

    List<User> users = new ArrayList<>();

    public UserRepository() {
        users.add(new User(1, "joanferro@gmail.com", "Joan Ferro", "123"));
        users.add(new User(2, "benjaferra@gmail.com", "Benja Ferra", "123"));
        users.add(new User(3, "nicoleferri@gmail.com", "Nicole Ferri", "123"));
    }

    public  List<User> getUsers() {
        return users;
    }

    public User getUserById(int id) {
        Optional<User> u = users.stream().filter(user -> user.id() == id).findFirst();
        if (u.isPresent()) return  u.get();
        else return null;
    }

    public void save(User user) {
        users.add(user);
    }

    public void delete(int id) {
        users.removeIf(user -> user.id() == id);
    }
}
