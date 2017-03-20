package com.lofitskyi.services;

import com.lofitskyi.entity.User;
import com.lofitskyi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository repository;

    @Autowired
    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User getUserById(Long id) {
        return repository.findOne(id);
    }

    @Override
    public List<User> getAllUsers() {
        return repository.findAll();
    }
}
