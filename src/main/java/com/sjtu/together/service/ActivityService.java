package com.sjtu.together.service;

import com.sjtu.together.dao.ActivityDAO;
import com.sjtu.together.entity.Activity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActivityService {

    @Autowired
    ActivityDAO activityDAO;

    public Activity getActivityByID(int actid) {
        return activityDAO.findActivityByActivityID(actid);
    }

}
