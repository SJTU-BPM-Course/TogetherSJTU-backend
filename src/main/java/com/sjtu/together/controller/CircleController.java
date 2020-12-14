package com.sjtu.together.controller;

import com.alibaba.fastjson.JSON;
import com.sjtu.together.entity.Circle;
import com.sjtu.together.entity.UserCircleRecord;
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
    public String getAllCircles(@RequestParam int userid) {
        List<UserCircleRecord> records = recordService.getCirclesByUserID(userid);
        List<Circle> circles = new ArrayList<>();
        for (UserCircleRecord record : records) {
            circles.add(circleService.getCircleByID(record.getCircleID()));
        }
        return JSON.toJSONString(circles);
    }


}
