package com.example.dput.dput.model;

import com.example.dput.dput.model.enums.Status;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
        property  = "deviceId",
        scope     = Device.class)
@Entity
public class Device {

    public Device() {
    }

    public Device(int deviceId, String description, Status status, List<User> users, List<Protocol> protocols) {
        this.deviceId = deviceId;
        this.description = description;
        this.status = status;
        this.users = users;
        this.protocols = protocols;
    }

    @Id
    @GeneratedValue
    @Column(name = "device_id")
    private int deviceId;

    @Column(name = "description")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;

    //join column linked with current reference while inverseJoinColumns is linked with another table
    @ManyToMany(cascade = {CascadeType.MERGE})
    @JoinTable(
            name = "device_user_map",
            joinColumns = {@JoinColumn(name = "device_id", referencedColumnName = "device_id" )},
            inverseJoinColumns = {@JoinColumn(name = "user_id" , referencedColumnName = "user_id")}
    )
    private List<User> users = new ArrayList<User>();

    //mappedby is used to prevent from creating extra table
    @OneToMany(cascade = CascadeType.ALL ,
                mappedBy = "device")
    private List<Protocol> protocols = new ArrayList<Protocol>();

    public int getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(int deviceId) {
        this.deviceId = deviceId;
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Protocol> getProtocols() {
        return protocols;
    }

    public void setProtocols(List<Protocol> protocols) {
        this.protocols = protocols;
    }
}
