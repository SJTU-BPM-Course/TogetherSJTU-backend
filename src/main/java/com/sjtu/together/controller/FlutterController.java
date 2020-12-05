package com.sjtu.together.controller;


import com.alibaba.fastjson.JSON;
import com.sjtu.together.entity.Activity;
import com.sjtu.together.service.UserActivityRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@Controller
@RestController
public class FlutterController {
    @Autowired
    UserActivityRecordService recordService;

    @CrossOrigin
    @GetMapping(value = "/api/getUserActivities")
    public String getUserActivities(@RequestParam String username) {
        System.out.println(username);
        Activity activity = new Activity();
        activity.setActivityID(1);
        activity.setActivityTitle("物联网体系结构");
        activity.setActivityDescription("目前物联网架构通常分为感知层、网络层和应用层三个层次。");
        activity.setActivityPlace("陈瑞球楼303A");
        activity.setActivityCreator("王东");
        activity.setImageURL("https://www.jsr9.com/img/2020/relatedpic/p2558920738.jpg");
        List<Activity> list = Arrays.asList(activity);
        return JSON.toJSONString(list);
    }

    @CrossOrigin
    @GetMapping(value = "/api/isAttended")
    public String isAttended(@RequestParam int userid, @RequestParam int actid) {
        return JSON.toJSONString(recordService.isExisted(userid, actid));
    }

}
