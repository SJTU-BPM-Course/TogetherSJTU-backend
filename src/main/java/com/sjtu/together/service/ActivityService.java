package com.sjtu.together.service;

import com.sjtu.together.dao.ActivityDAO;
import com.sjtu.together.entity.Activity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityService {

    @Autowired
    ActivityDAO activityDAO;

    public Activity getActivityByID(int actid) {
        return activityDAO.findActivityByActivityID(actid);
    }

    public List<Activity> getAllActivities() {
        return activityDAO.findAll();
    }

    public void addActivity(Activity activity) {
        activityDAO.save(activity);
    }

}
