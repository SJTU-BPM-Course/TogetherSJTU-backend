package com.sjtu.together.dao;

import com.sjtu.together.entity.UserActivityRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserActivityRecordDAO extends JpaRepository<UserActivityRecord, Integer> {

    UserActivityRecord findByUserIDAndActivityID(int userID, int activityID);
}
