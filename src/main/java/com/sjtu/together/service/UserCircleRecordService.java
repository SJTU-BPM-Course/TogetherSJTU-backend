package com.sjtu.together.service;

import com.sjtu.together.dao.UserCircleRecordDAO;
import com.sjtu.together.entity.Circle;
import com.sjtu.together.entity.UserCircleRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
public class UserCircleRecordService {

    @Autowired
    UserCircleRecordDAO recordDAO;

    @Autowired
    CircleService circleDAO;

    public List<Circle> getCirclesByUserID(int userID) {
        List<UserCircleRecord> records = recordDAO.findByUserID(userID);
        List<Circle> circles = new ArrayList<>();
        for (UserCircleRecord record : records) {
            circles.add(circleDAO.getCircleByID(record.getCircleID()));
        }
        return circles;
    }

    public void addUserCircleRecord(int userID, int circleID) {
        if (recordDAO.findByUserIDAndCircleID(userID, circleID) == null) {
            recordDAO.save(new UserCircleRecord(userID, circleID));
        }
    }

    public void removeUserCircleRecord(int userID, int circleID) {
        recordDAO.deleteByUserIDAndCircleID(userID, circleID);
    }
}
