package com.sjtu.together.controller;

import com.alibaba.fastjson.JSON;
import com.sjtu.together.entity.Feedback;
import com.sjtu.together.service.ActivityService;
import com.sjtu.together.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping(path = "/api/feedback")
public class FeedbackController {

    @Autowired
    FeedbackService feedbackService;

    @Autowired
    ActivityService activityService;

    @CrossOrigin
    @GetMapping(path = "getAll")
    public String getAllFeedback() {
        List<Feedback> feedbacks = feedbackService.getAllFeedbacks();
        for (Feedback feedback : feedbacks) {
            feedback.setActivity(activityService.getActivityByID(feedback.getActivityID()));
        }
        return JSON.toJSONString(feedbacks);
    }

    @CrossOrigin
    @GetMapping(path = "delete")
    public String deleteFeedback(@RequestParam int feedbackID) {
        feedbackService.deleteFeedback(feedbackID);
        return JSON.toJSONString(true);
    }

}
