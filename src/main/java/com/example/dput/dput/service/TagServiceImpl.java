package com.example.dput.dput.service;

import com.example.dput.dput.model.Tag;
import com.example.dput.dput.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class TagServiceImpl implements TagService {

    @Autowired
    TagRepository tagRepo;

    @Override
    public Tag checkTag(Tag tag) throws IOException {

        System.out.println("------------1------------");
        Tag tag1 = tagRepo.findByTagId( tag.getTagId());
        System.out.println("-----------2-------------");

        if(tag1 != null)
        {
            System.out.println("-------------3-----------");
            throw new IOException(" Tag already assigned to someone...");
        }

        System.out.println("-----------4-------------");

        return tag1;
    }
}
