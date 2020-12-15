package com.sjtu.together.service;

import com.sjtu.together.dao.ActivityDAO;
import com.sjtu.together.dao.CircleActivityRecordDAO;
import com.sjtu.together.entity.Activity;
import com.sjtu.together.entity.CircleActivityRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
public class CircleActivityRecordService {

    @Autowired
    CircleActivityRecordDAO recordDAO;

    @Autowired
    ActivityDAO activityDAO;

    public List<Activity> getCircleActivities(int cirid) {
        List<CircleActivityRecord> records = recordDAO.findAllByCircleID(cirid);
        List<Activity> activities = new ArrayList<>();
        for (CircleActivityRecord record : records) {
            activities.add(activityDAO.findActivityByActivityID(record.getActivityID()));
        }
        return activities;
    }

    public void addCircleActivityRecord(int cirid, int actid) {
        if (recordDAO.findByCircleIDAndActivityID(cirid, actid) == null) {
            recordDAO.save(new CircleActivityRecord(cirid, actid));
        }
    }

    public void removeCircleActivityRecord(int cirid, int actid) {
        if (recordDAO.findByCircleIDAndActivityID(cirid, actid) != null) {
            recordDAO.deleteByCircleIDAndActivityID(cirid, actid);
        }
    }
}
