package com.example.dput.dput.service;

import com.example.dput.dput.model.User;
import com.example.dput.dput.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepo;

    @Override
    public User checkUser(User user) throws IOException {

        System.out.println("-------------1------------");
        User user1 = userRepo.findByEmail(user.getEmail());
        System.out.println("------------11-------------");
        if(user1!=null)
        {
            System.out.println("---------111----------------");
            throw new IOException("User already exists");
        }
        System.out.println("-------------1111------------");
        return user;
    }
}
