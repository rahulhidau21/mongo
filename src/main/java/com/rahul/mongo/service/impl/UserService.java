package com.rahul.mongo.service.impl;

import com.rahul.mongo.dto.UserRequest;
import com.rahul.mongo.model.Permission;
import com.rahul.mongo.model.User;
import com.rahul.mongo.repository.UserRepository;
import com.rahul.mongo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User save(UserRequest userRequest) {

        User user = new User();
        user.setName(userRequest.getName());
        user.setEmail(userRequest.getEmail());
        user.setMobileNumber(userRequest.getMobileNumber());
        user.setPassword(userRequest.getPassword());
        Permission permission = new Permission();
        permission.setName("ROLE_ADMIN");
        user.setPermissions(List.of(permission));

        userRepository.save(user);
        return user;
    }

    @Override
    public User update(UserRequest userRequest) {
        Optional<User> user = userRepository.findById(userRequest.getId());
        if(user.isPresent()) {
            user.get().setId(userRequest.getId());
            user.get().setName(userRequest.getName());
            user.get().setEmail(userRequest.getEmail());
            user.get().setMobileNumber(userRequest.getMobileNumber());
            user.get().setPassword(userRequest.getPassword());
            userRepository.save(user.get());
        }
        return user.get();
    }

    @Override
    public void delete(String id) {
        userRepository.deleteById(id);
    }
}
