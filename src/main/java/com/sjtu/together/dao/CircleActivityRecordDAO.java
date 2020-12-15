package com.sjtu.together.dao;

import com.sjtu.together.entity.CircleActivityRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CircleActivityRecordDAO extends JpaRepository<CircleActivityRecord, Integer> {

    List<CircleActivityRecord> findAllByCircleID(int cirid);

    List<CircleActivityRecord> findAllByActivityID(int actid);

    CircleActivityRecord findByCircleIDAndActivityID(int cirid, int actid);

    void deleteByCircleIDAndActivityID(int cirid, int actid);
}
