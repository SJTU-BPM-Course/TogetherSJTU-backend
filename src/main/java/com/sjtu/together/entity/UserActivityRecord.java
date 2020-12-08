package com.sjtu.together.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "record_user_activity")
@JsonIgnoreProperties({"handler", "hibernateLazyInitializer"})

public class UserActivityRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recid")
    int recordID;

    // 0 表示报名但未签到，1 表示已经签到
    @Column(name = "recstatus")
    int recordStatus;

    @Column(name = "userid")
    int userID;

    @Column(name = "actid")
    int activityID;

    public UserActivityRecord() {
    }

    public UserActivityRecord(int userID, int activityID) {
        this.userID = userID;
        this.activityID = activityID;
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

    public int getActivityID() {
        return activityID;
    }

    public void setActivityID(int activityID) {
        this.activityID = activityID;
    }

    public int getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(int recordStatus) {
        this.recordStatus = recordStatus;
    }
}
