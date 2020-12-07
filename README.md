## SJTU BPM Course Project

这是基于校园足迹的个人认证系统 (TogetherSJTU) 后端项目。


## API

|    Controller     |                  API                  |      参数       |                作用                |
| :---------------: | :-----------------------------------: | :-------------: | :--------------------------------: |
|  LoginController  |           `/api/login`, GET           |     `User`      |       登录，判断用户名和密码       |
|  LoginController  |           `/api/test`, GET            |     `void`      |        测试，返回一个字符串        |
| FlutterController | `/api/flutter/getUserActivities`, GET |    `userid`     |         返回用户参加的活动         |
| FlutterController |    `/api/flutter/isAttended`, GET     | `userid, actid` |    返回某个用户是否参加某个活动    |
| FlutterController |     `/api/flutter/addRecord`, GET     | `userid, actid` | 添加用户参加活动的记录（立即报名） |
| FlutterController |   `/api/flutter/removeRecord`, GET    | `userid, actid` | 删除用户参加活动的记录（取消报名） |
| FlutterController | `/api/flutter/getAllActivities`, GET  |     `void`      |            获取所有活动            |

## POST 请求格式

POST 请求需要设置 `Content-Type` 为 `application/json` (其默认值为 `text/plain` ) .

以 `ActivityController` 为例：
```java
@CrossOrigin
@PostMapping(path = "add")
@ResponseBody
public String addActivity(@RequestBody Activity activity) {
    activityService.addActivity(activity);
        return  JSON.toJSONString(true);
}
```

其传输的 `JSON` 格式需要和 `Activity` 类的各个成员变量对应：
```json
{
    "imageURL":"xxxx.com",
    "activityType": "学术讲座",
    "activityTitle":"《新时期我国信息技术产业的发展》",
    "activityDescription":"该书由中共中央文献研究室和上海交通大学合作编辑，由中央文献出版社和上海交通大学出版社联合出版。全书收入江泽民1983年至2008年间关于信息技术产业和信息化问题的重要论文、报告、讲话、文章27篇，附录2篇，17万余字，其中许多文稿是首次公开发表。",
    "startTime": "2021-01-01T12:00:00",
    "endTime": "2021-01-01T14:00:00",
    "activityPlace": "陈瑞球楼101A",
    "activityCreator": "张学友"
}
```
当然也可以根据前端传过来的 `JSON` 字段名，在后台实现字段间的绑定，假如前端传过来的 `JSON` 中， `activityPlace` 为 `"actplace":"XXXXX"` , 那么就需要在成员变量前加一句：
```java
@JsonAlias(value = {"actplace"})
String activityPlace;
```

