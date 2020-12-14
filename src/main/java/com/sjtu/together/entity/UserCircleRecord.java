package com.sjtu.together.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "record_user_circle")
@JsonIgnoreProperties({"handler", "hibernateLazyInitializer"})
public class UserCircleRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recid")
    int recordID;

    @Column(name = "userid")
    int userID;

    @Column(name = "cirid")
    int circleID;

    public UserCircleRecord() {
    }

    public UserCircleRecord(int userID, int circleID) {
        this.userID = userID;
        this.circleID = circleID;
    }

    public int getRecordID() {
        return recordID;
    }

    public void setRecordID(int recordID) {
        this.recordID = recordID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getCircleID() {
        return circleID;
    }

    public void setCircleID(int circleID) {
        this.circleID = circleID;
    }
}
