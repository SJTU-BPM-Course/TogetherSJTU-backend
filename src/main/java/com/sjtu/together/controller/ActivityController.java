package com.sjtu.together.controller;

import com.sjtu.together.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
public class ActivityController {

    @Autowired
    ActivityService activityService;

    // TODO: 完成活动的增删改查
}
