package com.example.lab.service;

import com.example.lab.model.User;
import java.util.List;

public interface UserService {

    User createUser(User user);
    User getUserById(Long id);
    List<User> getAllUsers();
    User updateUser(User user);
    void deleteUser(Long id);
    List<User> searchUser(String keyword);
}
