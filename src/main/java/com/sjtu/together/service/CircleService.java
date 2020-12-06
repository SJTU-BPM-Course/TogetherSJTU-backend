package com.sjtu.together.service;

import com.sjtu.together.dao.CircleDAO;
import com.sjtu.together.entity.Circle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CircleService {

    @Autowired
    CircleDAO circleDAO;

    public void addCircleMemeber(int circleID, int userID) {
        Circle circle = getCircleByID(circleID);
        circle.addMemeber(userID);
        circleDAO.save(circle);
    }

    public void addCircleActivity(int circleID, int activityID) {
        Circle circle = getCircleByID(circleID);
        circle.addActivity(activityID);
        circleDAO.save(circle);
    }

    public Circle getCircleByID(int circleID) {
        return circleDAO.getCircleByCircleID(circleID);
    }

}
