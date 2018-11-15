package com.example.dput.dput.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.Date;


//this is used for the prevention from looping
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
        property  = "protocolId",
        scope     = Protocol.class)

@Entity
public class Protocol {

    public Protocol() {
    }

    public Protocol(int protocolId, String title, Date createdOn, Date effectivityDate) {
        this.protocolId = protocolId;
        this.title = title;
        this.createdOn = createdOn;
        this.effectivityDate = effectivityDate;
    }

    @Id
    @GeneratedValue
    @Column(name = "protocol_id")
    private int protocolId;

    @Column(name = "title")
    private String title;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "device_id")
    private Device device;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_on")
    private Date createdOn;

    @Column(name = "effectivity_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date effectivityDate;

    public int getProtocolId() {
        return protocolId;
    }

    public void setProtocolId(int protocolId) {
        if(protocolId == 0 ){
            throw new IllegalArgumentException("id can't be zero");
        }
        this.protocolId = protocolId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if(title.length() >200 ){
            throw new IllegalArgumentException("Description can't be greater than 200 characters.");
        }
        this.title = title;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Date getEffectivityDate() {
        return effectivityDate;
    }

    public void setEffectivityDate(Date effectivityDate) {
        this.effectivityDate = effectivityDate;
    }
}
