package com.sjtu.together.controller;

import com.alibaba.fastjson.JSON;
import com.sjtu.together.entity.Circle;
import com.sjtu.together.service.CircleService;
import com.sjtu.together.service.UserService;
import jdk.nashorn.internal.objects.annotations.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RestController
@RequestMapping(path = "/api/circle")
public class CircleController {

    @Autowired
    CircleService circleService;

    @Autowired
    UserService userService;

    @CrossOrigin
    @GetMapping(value = "addMember")
    public String addMember(@RequestParam int cirid, @RequestParam int userid) {
        circleService.addCircleMemeber(cirid, userid);
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


}
