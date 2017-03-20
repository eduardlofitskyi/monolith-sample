package com.lofitskyi.services;

import com.lofitskyi.entity.User;

import java.util.List;

public interface UserService {
    User getUserById(Long id);
    List<User> getAllUsers();
}
