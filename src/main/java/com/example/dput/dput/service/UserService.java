package com.example.dput.dput.service;

import com.example.dput.dput.model.User;

import java.io.IOException;

public interface UserService {

    public User checkUser(User user) throws IOException;
}
