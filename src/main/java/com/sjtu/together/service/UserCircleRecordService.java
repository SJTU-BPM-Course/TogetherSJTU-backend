package com.sjtu.together.service;

import com.sjtu.together.dao.UserCircleRecordDAO;
import com.sjtu.together.entity.UserCircleRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class UserCircleRecordService {

    @Autowired
    UserCircleRecordDAO recordDAO;

    public List<UserCircleRecord> getCirclesByUserID(int userID) {
        return recordDAO.findByUserID(userID);
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
