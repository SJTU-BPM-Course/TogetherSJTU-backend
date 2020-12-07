package com.sjtu.together.service;

import com.sjtu.together.dao.CircleDAO;
import com.sjtu.together.entity.Circle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
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

    public void removeCircleMemeber(int circleID, int userID) {
        Circle circle = getCircleByID(circleID);
        circle.removeMember(userID);
        circleDAO.save(circle);
    }

    public void removeCircleActivity(int circleID, int activityID) {
        Circle circle = getCircleByID(circleID);
        circle.removeActivity(activityID);
        circleDAO.save(circle);
    }

    public void addNewCircle(Circle circle) {
        circleDAO.save(circle);
    }


    public Circle getCircleByID(int circleID) {
        return circleDAO.getCircleByCircleID(circleID);
    }

}
