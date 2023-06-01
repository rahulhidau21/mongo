package com.rahul.mongo.controller;

import com.rahul.mongo.dto.UserRequest;
import com.rahul.mongo.model.User;
import com.rahul.mongo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping
    public List<User> getAll () {
        return userService.getAll();
    }

    @PostMapping
    public User save (@RequestBody UserRequest userRequest) {
        return userService.save(userRequest);
    }

    @PutMapping
    public User update (@RequestBody UserRequest userRequest) {
        return userService.update(userRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id){
        userService.delete(id);
    }


}
