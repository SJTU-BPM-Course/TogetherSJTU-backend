package com.sjtu.together.controller;


import com.alibaba.fastjson.JSON;
import com.sjtu.together.entity.Activity;
import com.sjtu.together.entity.QRCodeData;
import com.sjtu.together.entity.UserActivityRecord;
import com.sjtu.together.service.ActivityService;
import com.sjtu.together.service.UserActivityRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RestController
@RequestMapping(path = "/api/flutter")
public class FlutterController {
    @Autowired
    UserActivityRecordService recordService;

    @Autowired
    ActivityService activityService;

    @CrossOrigin
    @GetMapping(path = "getAllActivities")
    public String getAllActivities() {
        return JSON.toJSONString(activityService.getAllActivities());
    }

    @CrossOrigin
    @GetMapping(value = "getUserActivities")
    public String getUserActivities(@RequestParam int userid) {
        System.out.println(userid);
        List<Activity> list = new ArrayList<>();
        List<UserActivityRecord> records = recordService.getRecordsByUserID(userid);
        for (UserActivityRecord record : records) {
            list.add(activityService.getActivityByID(record.getActivityID()));
        }
        return JSON.toJSONString(list);
    }

    // 是否报名
    @CrossOrigin
    @GetMapping(value = "isAttended")
    public String isAttended(@RequestParam int userid, @RequestParam int actid) {
        return JSON.toJSONString(recordService.isExisted(userid, actid));
    }

    // 是否签到
    @CrossOrigin
    @GetMapping(value = "isSignedIn")
    public String isSignedIn(@RequestParam int userid, @RequestParam int actid) {
        UserActivityRecord record = recordService.getRecordByUserIDAndActivityID(userid, actid);
        if (record == null) {
            return JSON.toJSONString("用户还没报名，不能签到。");
        }
        boolean result = record.getRecordStatus() == 1;
        return JSON.toJSONString(result);
    }

    @CrossOrigin
    @GetMapping(value = "addRecord")
    public String addUserActivityRecord(@RequestParam int userid, @RequestParam int actid) {
        recordService.addUserActivityRecord(userid, actid);
        return JSON.toJSONString(true);
    }

    @CrossOrigin
    @GetMapping(value = "removeRecord")
    public String removeUserActivityRecord(@RequestParam int userid, @RequestParam int actid) {
        recordService.removeUserActivityRecord(userid, actid);
        return JSON.toJSONString(true);
    }


    // TODO: 增加二维码签到的功能，基于 MD5 实现
    @CrossOrigin
    @GetMapping(value = "signIn")
    public String activitySignIn(@RequestParam int userid, @RequestParam int actid) {
        recordService.changeRecordStatus(userid, actid);
        return JSON.toJSONString(true);
    }

}
