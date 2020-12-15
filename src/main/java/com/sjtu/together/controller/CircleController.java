package com.sjtu.together.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.sjtu.together.entity.Activity;
import com.sjtu.together.entity.Circle;
import com.sjtu.together.entity.UserCircleRecord;
import com.sjtu.together.service.ActivityService;
import com.sjtu.together.service.CircleService;
import com.sjtu.together.service.UserCircleRecordService;
import com.sjtu.together.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RestController
@RequestMapping(path = "/api/circle")
public class CircleController {

    @Autowired
    CircleService circleService;

    @Autowired
    UserService userService;

    @Autowired
    ActivityService activityService;

    @Autowired
    UserCircleRecordService recordService;

    @CrossOrigin
    @GetMapping(value = "addMember")
    public String addMember(@RequestParam int cirid, @RequestParam int userid) {
        circleService.addCircleMemeber(cirid, userid);
        // 同时修改一下 record_user_circle 表
        recordService.addUserCircleRecord(userid, cirid);
        return JSON.toJSONString(true);
    }

    @CrossOrigin
    @GetMapping(value = "addActivity")
    public String addActivity(@RequestParam int cirid, @RequestParam int actid) {
        circleService.addCircleActivity(cirid, actid);
        return JSON.toJSONString(true);
    }

    @CrossOrigin
    @GetMapping(value = "removeMember")
    public String removeMember(@RequestParam int cirid, @RequestParam int userid) {
        circleService.removeCircleMemeber(cirid, userid);
        // 同时修改一下 record_user_circle 表
        recordService.removeUserCircleRecord(userid, cirid);
        return JSON.toJSONString(true);
    }

    @CrossOrigin
    @GetMapping(value = "removeActivity")
    public String removeActivity(@RequestParam int cirid, @RequestParam int actid) {
        circleService.removeCircleActivity(cirid, actid);
        return JSON.toJSONString(true);
    }

    @CrossOrigin
    @PostMapping(value = "add")
    @ResponseBody
    public String addCircle(@RequestBody Circle circle) {
        String username = userService.getByUserID(circle.getCircleCreatorID()).getUsername();
        circle.setCircleCreator(username);
        circle.addMemeber(circle.getCircleCreatorID());
        circleService.addNewCircle(circle);
        return JSON.toJSONString(true);
    }

    @CrossOrigin
    @GetMapping(value = "getUserCircles")
    public String getUserCircles(@RequestParam int userid) {
        List<UserCircleRecord> records = recordService.getCirclesByUserID(userid);
        List<Circle> circles = new ArrayList<>();
        for (UserCircleRecord record : records) {
            circles.add(circleService.getCircleByID(record.getCircleID()));
        }
        return JSON.toJSONString(circles);
    }

    @CrossOrigin
    @GetMapping(value = "getActivities")
    public String getActivities(@RequestParam int cirid) {
        Circle circle = circleService.getCircleByID(cirid);
        List<Integer> listID = (List<Integer>) JSON.parse(circle.getCircleActivitiesJsonStr());
        if (listID == null) {
            listID = new ArrayList<>();
        }
        List<Activity> activities = new ArrayList<>();
        for (int id : listID) {
            activities.add(activityService.getActivityByID(id));
        }
        return JSON.toJSONString(activities);
    }


}
