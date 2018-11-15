package com.example.dput.dput.repository;

import com.example.dput.dput.model.Tag;
import com.example.dput.dput.model.User;
import org.springframework.data.repository.CrudRepository;

public interface TagRepository extends CrudRepository<Tag, Integer> {

    public Tag findByTagId(int tagId);
}
