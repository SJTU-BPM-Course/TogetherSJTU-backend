package com.sjtu.together.service;

import com.sjtu.together.dao.UserActivityRecordDAO;
import com.sjtu.together.entity.User;
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

    public UserActivityRecord getRecordByUserIDAndActivityID(int userID, int activityID) {
        return userActivityRecordDAO.findByUserIDAndActivityID(userID, activityID);
    }

    public void addUserActivityRecord(int userid, int actid) {
        if (userActivityRecordDAO.findByUserIDAndActivityID(userid, actid) == null) {
            userActivityRecordDAO.save(new UserActivityRecord(userid, actid));
        }
    }

    public void removeUserActivityRecord(int userID, int activityID) {
        userActivityRecordDAO.removeUserActivityRecordByUserIDAndActivityID(userID, activityID);
    }

    public void changeRecordStatus(int userID, int activityID) {
        UserActivityRecord record = userActivityRecordDAO.findByUserIDAndActivityID(userID, activityID);
        record.setRecordStatus(1);
        userActivityRecordDAO.save(record);
    }
}
