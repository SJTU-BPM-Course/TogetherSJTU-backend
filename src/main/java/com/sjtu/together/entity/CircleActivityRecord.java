package com.sjtu.together.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "record_circle_activity")
@JsonIgnoreProperties({"handler", "hibernateLazyInitializer"})

public class CircleActivityRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recid")
    int recordID;

    @Column(name = "cirid")
    int circleID;

    @Column(name = "actid")
    int activityID;

    public CircleActivityRecord() {
    }

    public CircleActivityRecord(int circleID, int activityID) {
        this.circleID = circleID;
        this.activityID = activityID;
    }

    public int getRecordID() {
        return recordID;
    }

    public void setRecordID(int recordID) {
        this.recordID = recordID;
    }

    public int getCircleID() {
        return circleID;
    }

    public void setCircleID(int circleID) {
        this.circleID = circleID;
    }

    public int getActivityID() {
        return activityID;
    }

    public void setActivityID(int activityID) {
        this.activityID = activityID;
    }
}
