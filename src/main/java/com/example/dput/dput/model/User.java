package com.example.dput.dput.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.ArrayList;
import java.util.List;


//used to prevent from loop
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
        property  = "userId",
        scope     = User.class)
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private int userId;

    @Column(name = "username")
    private String userName;

    @Column(name = "email")
    @Email
    private String email;

    @ManyToMany(mappedBy = "users")
    private List<Device> devices = new ArrayList<Device>();

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "tag_id")
    private Tag tag;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }




    public void setEmail(String email) {

        System.out.println("----------------------"+email);

        this.email = email;
    }

    @JsonIgnore
    @JsonProperty(value = "email")
    public String getEmail() {
        return email;
    }

    public List<Device> getDevices() {
        return devices;
    }

    public void setDevices(List<Device> devices) {
        this.devices = devices;
    }

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }
}
