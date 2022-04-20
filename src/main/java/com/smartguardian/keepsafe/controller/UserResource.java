package com.smartguardian.keepsafe.controller;

import java.util.List;

import com.smartguardian.keepsafe.model.User;
import com.smartguardian.keepsafe.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("user")
public class UserResource {
    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @GetMapping("{id}")
    public User findById(@PathVariable int id) {
        try {
            User user = userRepository.findById(id).get();
            return user;
        } catch (Exception error) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "User not found", error);
        }
    }

    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping
    public User create(@RequestBody User user) {
        return userRepository.save(user);
    }

    @PutMapping("{id}")
    public User update(@RequestBody User user, @PathVariable int id) {
        User requestedUser = userRepository.findById(id).get();
        user.setId(id);
        user.setCreatedAt(requestedUser.getCreatedAt());
        return userRepository.save(user);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
        userRepository.deleteById(id);
    }
}
