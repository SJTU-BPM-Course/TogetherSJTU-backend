package com.sjtu.together.controller;


import com.alibaba.fastjson.JSON;
import com.sjtu.together.entity.Activity;
import com.sjtu.together.entity.UserActivityRecord;
import com.sjtu.together.service.ActivityService;
import com.sjtu.together.service.UserActivityRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RestController
public class FlutterController {
    @Autowired
    UserActivityRecordService recordService;

    @Autowired
    ActivityService activityService;

    @CrossOrigin
    @GetMapping(value = "/api/getUserActivities")
    public String getUserActivities(@RequestParam int userid) {
        System.out.println(userid);
        List<Activity> list = new ArrayList<>();
        List<UserActivityRecord> records = recordService.getRecordsByUserID(userid);
        for (UserActivityRecord record : records) {
            list.add(activityService.getActivityByID(record.getActivityID()));
        }
        return JSON.toJSONString(list);
    }

    @CrossOrigin
    @GetMapping(value = "/api/isAttended")
    public String isAttended(@RequestParam int userid, @RequestParam int actid) {
        return JSON.toJSONString(recordService.isExisted(userid, actid));
    }

}
