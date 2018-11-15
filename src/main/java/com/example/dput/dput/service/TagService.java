package com.example.dput.dput.service;

import com.example.dput.dput.model.Tag;

import java.io.IOException;

public interface TagService {

    public Tag checkTag(Tag tag) throws IOException;
}
