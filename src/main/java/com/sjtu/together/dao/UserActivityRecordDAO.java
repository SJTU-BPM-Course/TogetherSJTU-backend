package com.sjtu.together.dao;

import com.sjtu.together.entity.UserActivityRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserActivityRecordDAO extends JpaRepository<UserActivityRecord, Integer> {

    UserActivityRecord findByUserIDAndActivityID(int userID, int activityID);

    List<UserActivityRecord> findUserActivityRecordsByUserID(int userID);

    void removeUserActivityRecordByUserIDAndActivityID(int userID, int activityID);
}
