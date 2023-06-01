package com.rahul.mongo.service;

import com.rahul.mongo.dto.UserRequest;
import com.rahul.mongo.model.User;

import java.util.List;

public interface IUserService {
    List<User> getAll();

    User save(UserRequest userRequest);

    User update(UserRequest userRequest);

    void delete(String id);
}
