package com.example.dput.dput.controller;

import com.example.dput.dput.model.User;
import com.example.dput.dput.repository.DeviceRepository;
import com.example.dput.dput.repository.UserRepository;
import com.example.dput.dput.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@RestController
public class UserController {

    @Autowired
    UserRepository userRepo;

    @Autowired
    DeviceRepository deviceRepo;

    @Autowired
    UserServiceImpl userService;


    @GetMapping("/users")
    @ResponseBody
    public List<User> allUsers()
    {
        List <User> userList = new ArrayList<User>();
        userList= (ArrayList)userRepo.findAll();
        return userList;
    }

    @PostMapping("/user")
    @ResponseBody
    public void addUser(@RequestBody User user) throws IOException
    {
        userRepo.save(userService.checkUser(user));

    }


    @DeleteMapping("/user/{userId}")
    public void deleteUser(@PathVariable("userId") int userId) {


        userRepo.deleteById(userId);


    }
}
