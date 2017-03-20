package com.lofitskyi.api;

import com.lofitskyi.entity.User;
import com.lofitskyi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping("/user")
public class UserApi {

    private final UserService service;

    @Autowired
    public UserApi(UserService service) {
        this.service = service;
    }

    @RequestMapping(path = "/all", method = GET)
    public List<User> getAll(){
       return service.getAllUsers();
    }
}
