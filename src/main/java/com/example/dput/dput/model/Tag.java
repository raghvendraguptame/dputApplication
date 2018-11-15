package com.example.dput.dput.model;

import com.example.dput.dput.model.enums.IsActive;

import javax.persistence.*;

import java.util.Date;
import static com.example.dput.dput.model.enums.IsActive.N;

@Entity
public class Tag {

    public Tag() {
    }

    public Tag(int tagId, String description, IsActive isActive, Date createdOn) {
        this.tagId = tagId;
        this.description = description;
        this.isActive = isActive;
        this.createdOn = createdOn;
    }

    @Id
    @GeneratedValue
    @Column(name = "tag_id")
    private int tagId;

    @Column(name = "description")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "is_active")
    private IsActive isActive= N;

    @Column(name = "created_on")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn = new Date();


    public int getTagId() {
        return tagId;
    }

    public void setTagId(int tagId) {
        this.tagId = tagId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if(description.length() >500 ){
            throw new IllegalArgumentException("Description can't be greater than 500 characters.");
        }
        this.description = description;
    }

    public IsActive getIsActive() {
        return isActive;
    }

    public void setIsActive(IsActive isActive) {
        this.isActive = isActive;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }
}
