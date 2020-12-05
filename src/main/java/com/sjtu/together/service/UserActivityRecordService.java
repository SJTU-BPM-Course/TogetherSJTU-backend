package com.sjtu.together.service;

import com.sjtu.together.dao.UserActivityRecordDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserActivityRecordService {

    @Autowired
    UserActivityRecordDAO userActivityRecordDAO;

    public boolean isExisted(int userID, int activityID) {
        return userActivityRecordDAO.findByUserIDAndActivityID(userID, activityID) != null;
    }
}
