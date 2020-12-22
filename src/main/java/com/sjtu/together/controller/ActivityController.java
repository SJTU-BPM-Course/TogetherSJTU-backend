package com.sjtu.together.controller;

import com.alibaba.fastjson.JSON;
import com.sjtu.together.entity.Activity;
import com.sjtu.together.entity.QRCodeData;
import com.sjtu.together.entity.User;
import com.sjtu.together.entity.UserActivityRecord;
import com.sjtu.together.service.ActivityService;
import com.sjtu.together.utils.HttpRequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;

@Controller
@RestController
@RequestMapping(path = "/api/activity")
public class ActivityController {

    @Autowired
    ActivityService activityService;

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
        if (conflicts.size() == 0) {
            activityService.addActivity(activity);
        } else {
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
}
