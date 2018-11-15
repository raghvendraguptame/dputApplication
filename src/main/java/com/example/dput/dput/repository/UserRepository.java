package com.example.dput.dput.repository;

import com.example.dput.dput.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Integer> {

    public User findByEmail(String email);
}
