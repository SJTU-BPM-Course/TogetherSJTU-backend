package com.sjtu.together.service;

import com.sjtu.together.dao.ActivityDAO;
import com.sjtu.together.entity.Activity;
import com.sjtu.together.global.ActivityStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
public class ActivityService {

    @Autowired
    ActivityDAO activityDAO;

    public List<Activity> getAllUnreviewed() {
        return activityDAO.findAllByActivityStatus(ActivityStatus.Pending);
    }

    public List<Activity> getAllByStatus(int status) {
        return activityDAO.findAllByActivityStatus(status);
    }


    public Activity getActivityByID(int actid) {
        return activityDAO.findActivityByActivityID(actid);
    }

    public List<Activity> getAllActivities() {
        return activityDAO.findAll();
    }

    public void addActivity(Activity activity) {
        activityDAO.save(activity);
    }

    public List<Activity> isActivityConflict(Activity activity) {
        ArrayList<Activity> conflicts = new ArrayList<>();
        List<Activity> list = activityDAO.findByActivityPlaceLike("%" + activity.getActivityPlace() + '%');
        Timestamp s1 = activity.getStartTime();
        Timestamp e1 = activity.getEndTime();
        for (Activity x : list) {
            Timestamp s2 = x.getStartTime();
            Timestamp e2 = x.getEndTime();
            if (((e1.equals(s2) || e1.after(s2)) && (e1.equals(e2) || e1.before(e2))) ||
                    ((s1.equals(s2) || s1.after(s2)) && (s1.equals(e2) || s1.before(e2)))) {
                conflicts.add(x);
            }
        }
        return conflicts;
    }

    public boolean setReviewStatus(int actid, int status) {
        Activity activity = getActivityByID(actid);
        if (activity != null) {
            activity.setActivityStatus(status);
            activityDAO.save(activity);
            return true;
        } else
            return false;
    }
}
