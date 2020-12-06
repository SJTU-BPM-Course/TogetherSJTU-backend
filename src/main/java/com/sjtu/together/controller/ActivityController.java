package com.sjtu.together.controller;

import com.alibaba.fastjson.JSON;
import com.sjtu.together.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RestController
public class ActivityController {

    @Autowired
    ActivityService activityService;

    // TODO: 完成活动的增删改查

    @CrossOrigin
    @PostMapping(value = "/api/activity/add")
    @ResponseBody
    public String addActivity(@RequestBody String json, @RequestBody int actid) {
        System.out.println(json);
        return JSON.toJSONString(true);
    }
}
