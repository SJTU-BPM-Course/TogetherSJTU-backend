package com.sjtu.together.dao;

import com.sjtu.together.entity.UserCircleRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserCircleRecordDAO extends JpaRepository<UserCircleRecord, Integer> {

    List<UserCircleRecord> findByUserID(int userid);

    UserCircleRecord findByUserIDAndCircleID(int userid, int cirid);

    void deleteByUserIDAndCircleID(int userid, int cirid);
}
