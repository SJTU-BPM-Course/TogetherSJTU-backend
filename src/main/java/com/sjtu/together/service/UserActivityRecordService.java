package com.sjtu.together.service;

import com.sjtu.together.dao.UserActivityRecordDAO;
import com.sjtu.together.entity.UserActivityRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserActivityRecordService {

    @Autowired
    UserActivityRecordDAO userActivityRecordDAO;

    public boolean isExisted(int userID, int activityID) {
        return userActivityRecordDAO.findByUserIDAndActivityID(userID, activityID) != null;
    }

    public List<UserActivityRecord> getRecordsByUserID(int userID) {
        return userActivityRecordDAO.findUserActivityRecordsByUserID(userID);
    }
}
