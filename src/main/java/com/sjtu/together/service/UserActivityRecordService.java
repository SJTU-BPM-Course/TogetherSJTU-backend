package com.sjtu.together.service;

import com.sjtu.together.dao.UserActivityRecordDAO;
import com.sjtu.together.entity.UserActivityRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
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

    public void addUserActivityRecord(int userid, int actid) {
        userActivityRecordDAO.save(new UserActivityRecord(userid, actid));
    }

    public void removeUserActivityRecord(int userID, int activityID) {
        userActivityRecordDAO.removeUserActivityRecordByUserIDAndActivityID(userID, activityID);
    }
}
