package com.example.dput.dput.controller;

import com.example.dput.dput.model.Tag;
import com.example.dput.dput.repository.TagRepository;
import com.example.dput.dput.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class TagController {

    @Autowired
    TagRepository tagRepo;

    @Autowired
    TagService tagService;

    @GetMapping("/tags")
    public List<Tag> allTags()
    {
        List <Tag> tagList;
        tagList= (ArrayList)tagRepo.findAll();
        return tagList;
    }

    @PostMapping("/tag")
    public void addTag(@RequestBody Tag tag) throws IOException
    {
        tagRepo.save(tag);
        System.out.println("----------------fd-dasf----");

    }

    @DeleteMapping("/tag/{tagId}")
    public void deleteTag(@PathVariable("tagId") int tagId )
    {
        tagRepo.deleteById(tagId);

    }
}
