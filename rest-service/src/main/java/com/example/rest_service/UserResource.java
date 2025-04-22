package com.example.rest_service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<List<UserDTO>> getUsers() {
        return ResponseEntity.ok().body(userController.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUser(@PathVariable int id) {
        return ResponseEntity.ok().body(userController.getUser(id));
    }

    /*@DeleteMapping("/{id}")
    public ResponseEntity<UserDTO> removeUser(@PathVariable int id) {
        UserDTO removedUser = userController.getUser(id);
        userController.removeUser(id);
        return ResponseEntity.ok().body(removedUser);
    }*/

    //@GetMapping("/{id}")
    @DeleteMapping("/{id}")
    public ResponseEntity<UserDTO> removeUser(@PathVariable int id) {
        userController.removeUser(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<UserDTO> addUser(@RequestBody UserDTO user) {
        userController.newUser(user);
        return ResponseEntity.ok().body(user);
    }

    @PatchMapping(path = "/{id}")
    public ResponseEntity<UserDTO> updateCustomer(@PathVariable int id, @RequestBody JsonPatch patch) {
        try {

            UserDTO user = userController.getUser(id);
            UserDTO userPatched = applyPatchToUser(patch, user);
            userController.updateUser(userPatched);
            return ResponseEntity.ok(userPatched);
        } catch (JsonPatchException | JsonProcessingException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    private UserDTO applyPatchToUser(JsonPatch patch, UserDTO targetUser) throws JsonPatchException, JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode patched = patch.apply(objectMapper.convertValue(targetUser, JsonNode.class));
        return objectMapper.treeToValue(patched, UserDTO.class);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable int id, @RequestBody UserDTO userDTO) {
    userDTO.setId(id);
    userController.updateUser(userDTO);
    return ResponseEntity.ok().body(userDTO);
    }
}


/*
POST: http://localhost:8080/api/v0/users
{
    "id": 6,
    "email": "sis@email.com",
    "fullName": "Sise",
    "password": "1234"
}

PATCH: http://localhost:8080/api/v0/users/5

[
  {
    "op": "replace",
    "path": "/email",
    "value": "thanks4@help.com"
  }
]

DELETE: http://localhost:8080/api/v0/users/5

PUT: http://localhost:8080/api/v0/users/5

{
  "id": 5,
  "email": "updated@email.com",
  "fullName": "Updated User",
  "password": "newpass123"
}

 */