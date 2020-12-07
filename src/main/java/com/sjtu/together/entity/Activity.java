package com.sjtu.together.entity;


import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "activity")
@JsonIgnoreProperties({"handler", "hibernateLazyInitializer"})

public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "actid")
    int activityID;             // ID

    @Column(name = "acttype")
    String activityType;        // 活动类型

    @Column(name = "acttitle")
    String activityTitle;       // 活动标题

    @Column(name = "actdesc")
    String activityDescription; // 活动简介

    @Column(name = "actstarttime")
    Timestamp startTime;        // 开始时间

    @Column(name = "actendtime")
    Timestamp endTime;          // 结束

    @Column(name = "actplace")
    String activityPlace;       // 活动地点

    @Column(name = "actcreator")
    String activityCreator;     // 活动创建者

    @Column(name = "actimageurl")
    String imageURL;            // 图片 URL

    public int getActivityID() {
        return activityID;
    }

    public void setActivityID(int activityID) {
        this.activityID = activityID;
    }

    public String getActivityType() {
        return activityType;
    }

    public void setActivityType(String activityType) {
        this.activityType = activityType;
    }

    public String getActivityTitle() {
        return activityTitle;
    }

    public void setActivityTitle(String activityTitle) {
        this.activityTitle = activityTitle;
    }

    public String getActivityDescription() {
        return activityDescription;
    }

    public void setActivityDescription(String activityDescription) {
        this.activityDescription = activityDescription;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    public String getActivityPlace() {
        return activityPlace;
    }

    public void setActivityPlace(String activityPlace) {
        this.activityPlace = activityPlace;
    }

    public String getActivityCreator() {
        return activityCreator;
    }

    public void setActivityCreator(String activityCreator) {
        this.activityCreator = activityCreator;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
}
