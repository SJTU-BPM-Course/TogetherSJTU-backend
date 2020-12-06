package com.sjtu.together.entity;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "circle")
@JsonIgnoreProperties({"handler", "hibernateLazyInitializer"})
public class Circle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cirid")
    int circleID;

    @Column(name = "cirname")
    String circleName;

    @Column(name = "cirdesc")
    String circleDescription;

    @Column(name = "cirmembers")
    String circleMembersJsonStr;

    @Column(name = "ciractivities")
    String circleActivitiesJsonStr;


    public int getCircleID() {
        return circleID;
    }

    public void setCircleID(int circleID) {
        this.circleID = circleID;
    }

    public String getCircleName() {
        return circleName;
    }

    public void setCircleName(String circleName) {
        this.circleName = circleName;
    }

    public String getCircleDescription() {
        return circleDescription;
    }

    public void setCircleDescription(String circleDescription) {
        this.circleDescription = circleDescription;
    }

    public String getCircleMembersJsonStr() {
        return circleMembersJsonStr;
    }

    public void setCircleMembersJsonStr(String circleMembersJsonStr) {
        this.circleMembersJsonStr = circleMembersJsonStr;
    }

    public String getCircleActivitiesJsonStr() {
        return circleActivitiesJsonStr;
    }

    public void setCircleActivitiesJsonStr(String circleActivitiesJsonStr) {
        this.circleActivitiesJsonStr = circleActivitiesJsonStr;
    }

    private Set<Integer> parseSet(String jsonStr) {
        List<Integer> list = (List<Integer>) JSON.parse(jsonStr);
        HashSet<Integer> set = new HashSet<Integer>(list == null ? new ArrayList<>() : list);
        return set;
    }

    public void addMemeber(int userID) {
        Set<Integer> members = parseSet(circleMembersJsonStr);
        members.add(userID);
        circleMembersJsonStr = JSON.toJSONString(members);
    }

    public void addActivity(int activityID) {
        Set<Integer> activities = parseSet(circleActivitiesJsonStr);
        activities.add(activityID);
        circleActivitiesJsonStr = JSON.toJSONString(activities);
    }

    public void removeMember(int userID) {
        Set<Integer> members = parseSet(circleMembersJsonStr);
        members.remove(userID);
        circleMembersJsonStr = JSON.toJSONString(members);
    }

    public void removeActivity(int activityID) {
        Set<Integer> activities = parseSet(circleActivitiesJsonStr);
        activities.remove(activityID);
        circleActivitiesJsonStr = JSON.toJSONString(activities);
    }
}
