package com.sjtu.together.controller;

import com.alibaba.fastjson.JSON;
import com.sjtu.together.service.CircleService;
import jdk.nashorn.internal.objects.annotations.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
public class CircleController {

    @Autowired
    CircleService circleService;

    @CrossOrigin
    @GetMapping(value = "/api/addMember")
    public String addMember(@RequestParam int cirid, @RequestParam int userid) {
        circleService.addCircleMemeber(cirid, userid);
        return JSON.toJSONString(true);
    }

    @CrossOrigin
    @GetMapping(value = "/api/addActivity")
    public String addActivity(@RequestParam int cirid, @RequestParam int actid) {
        circleService.addCircleActivity(cirid, actid);
        return JSON.toJSONString(true);
    }


}
