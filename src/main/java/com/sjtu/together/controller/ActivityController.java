package com.sjtu.together.controller;

import com.alibaba.fastjson.JSON;
import com.sjtu.together.entity.*;
import com.sjtu.together.global.ActivityStatus;
import com.sjtu.together.service.ActivityService;
import com.sjtu.together.service.FeedbackService;
import com.sjtu.together.service.UserActivityRecordService;
import com.sjtu.together.utils.HttpRequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

@Controller
@RestController
@RequestMapping(path = "/api/activity")
public class ActivityController {

    @Autowired
    ActivityService activityService;

    @Autowired
    FeedbackService feedbackService;

    @Autowired
    UserActivityRecordService userActivityService;


    // TODO: 完成活动的增删改查

    /**
     * POST 各个字段映射到参数:
     * public String addActivity(@RequestParam String activityID, @RequestParam String userID)
     * 或者
     * public String addActivity(
     *
     * @RequestParam(value = "actid") String activityID,
     * @RequestParam(value = "userid") String userID)
     **/
//    @CrossOrigin
//    @PostMapping(path = "add")
//    @ResponseBody
//    public String addActivity(@RequestParam(value = "actid") String activityID, @RequestParam(value = "userid") String userID) {
//        System.out.println(activityID);
//        System.out.println(userID);
//        return JSON.toJSONString(true);
//    }

    /**
     * JSON 数据注入到对象的传参方式
     * JSON 的各个字段必须要与对象的各个成员变量对应
     * 否则就需要在成员变量声明的地方添加 JSONAlias
     */
    @CrossOrigin
    @PostMapping(path = "add")
    @ResponseBody
    public String addActivity(@RequestBody Activity activity) throws UnsupportedEncodingException {
        System.out.println(JSON.toJSONString(activity));
        List<Activity> conflicts = activityService.isActivityConflict(activity);

        int actid = activityService.addActivity(activity);
        userActivityService.addUserActivityRecord(4, actid);

        activityService.setReviewStatus(actid, -100);
        for (Activity x : conflicts) {
            activityService.setReviewStatus(x.getActivityID(), -100);
        }

        if (conflicts.size() != 0) {
            String url = "http://47.103.222.155:3000/sendWeb";
            String str = URLEncoder.encode("有新的活动冲突待处理", "utf8");
            String name = URLEncoder.encode("Zhang Xueyou", "utf8");
            String params = "str=" + str + "&name=" + name;
            String result = HttpRequestUtil.sendGet(url, params);
            System.out.println("Activity conflict，get request ret = " + result);
            return JSON.toJSONString(conflicts);
        }
        return JSON.toJSONString(true);
    }

    @CrossOrigin
    @PostMapping(path = "update")
    @ResponseBody
    public String updateActivity(@RequestBody Activity activity) {
        System.out.println(JSON.toJSONString(activity));
        activity.setActivityStatus(ActivityStatus.Pending);
        activityService.addActivity(activity);
        return JSON.toJSONString(true);
    }

    @CrossOrigin
    @GetMapping(path = "delete")
    public String deleteActivity(@RequestParam int actid) {
        activityService.deleteActivityByID(actid);
        return JSON.toJSONString(true);
    }


    @CrossOrigin
    @GetMapping(path = "getUnreviewed")
    public String getUnreviewed() {
        return JSON.toJSONString(activityService.getAllUnreviewed());
    }

    @CrossOrigin
    @GetMapping(path = "setReviewStatus")
    public String setReviewStatus(int actid, int status) {
        return JSON.toJSONString(activityService.setReviewStatus(actid, status));
    }

    @CrossOrigin
    @PostMapping(path = "reject")
    @ResponseBody
    public String rejectActivity(@RequestBody Feedback feedback) {
        int actid = feedback.getActivityID();
        if (activityService.getActivityByID(actid) != null) {
            activityService.setReviewStatus(actid, ActivityStatus.Rejected);
            feedbackService.addFeedbackRecord(feedback);
            return JSON.toJSONString(true);
        } else {
            // 活动不存在
            return JSON.toJSONString(false);
        }
    }

    // 生成二维码 JSON 字符串
    @CrossOrigin
    @GetMapping(value = "getQRCodeData")
    public String getQRCodeData(@RequestParam int actid) {
        if (activityService.getActivityByID(actid) == null) {
            return JSON.toJSONString("活动不存在。");
        } else {
            return JSON.toJSONString(new QRCodeData(actid));
        }
    }

    @CrossOrigin
    @GetMapping(path = "getAll")
    public String getAllActivities() {
        return JSON.toJSONString(activityService.getAllActivities());
    }

    // 为了演示冲突功能
    // 设定了 2 组冲突，status 设置为 -100, -200
    @CrossOrigin
    @GetMapping(path = "getByStatus")
    public String getByStatus(@RequestParam int status) {
        return JSON.toJSONString(activityService.getAllByStatus(status));
    }
}
