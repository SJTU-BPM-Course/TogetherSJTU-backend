## SJTU BPM Course Project

这是基于校园足迹的个人认证系统 (TogetherSJTU) 后端项目。

## API

### LoginController

|     Controller     |                  API                  |      参数       |                             作用                             |
| :----------------: | :-----------------------------------: | :-------------: | :----------------------------------------------------------: |
|  LoginController   |           `/api/login`, GET           |     `User`      |                    登录，判断用户名和密码                    |
|  LoginController   |           `/api/test`, GET            |     `void`      |                     测试，返回一个字符串                     |

### FlutterController

|     Controller     |                  API                  |      参数       |                             作用                             |
| :----------------: | :-----------------------------------: | :-------------: | :----------------------------------------------------------: |
| FlutterController  | `/api/flutter/getUserActivities`, GET |    `userid`     |                      返回用户参加的活动                      |
| FlutterController  | `/api/flutter/getAllActivities`, GET  |     `void`      |                         获取所有活动                         |
| FlutterController  |    `/api/flutter/isAttended`, GET     | `userid, actid` |                 返回用户是否报名参加某个活动                 |
| FlutterController  |    `/api/flutter/isSignedIn`, GET     | `userid, actid` |                 返回用户是否在活动中完成签到                 |
| FlutterController  |      `/api/flutter/signIn`, GET       | `userid, actid` |                       用户在活动中签到                       |
| FlutterController  |     `/api/flutter/addRecord`, GET     | `userid, actid` |              添加用户参加活动的记录（立即报名）              |
| FlutterController  |   `/api/flutter/removeRecord`, GET    | `userid, actid` |              删除用户参加活动的记录（取消报名）              |

### ActivityController

|     Controller     |                  API                  |      参数       |                             作用                             |
| :----------------: | :-----------------------------------: | :-------------: | :----------------------------------------------------------: |
| ActivityController |  `/api/activity/getQRCodeData`, GET   |     `actid`     | 获得活动签到二维码的 JSON 字符串，格式为：`{"activityID":1, md5:"xxx"}` |
| ActivityController |       `/api/activity/add`, POST       |   `Activity`    |                           添加活动                           |
| ActivityController |      `/api/activity/getAll`, GET      |     `void`      |                         获取所有活动                         |

### CircleController

|     Controller     |                  API                  |      参数       |                             作用                             |
| :----------------: | :-----------------------------------: | :-------------: | :----------------------------------------------------------: |
|  CircleController  |     `/api/circle/addMember`, GET      | `cirid, userid` |                        圈子内新增用户                        |
|  CircleController  |    `/api/circle/addActivity`, GET     | `cirid, actid`  |                        圈子内新增活动                        |
|  CircleController  |    `/api/circle/removeMember`, GET    | `cirid, userid` |                           移除用户                           |
|  CircleController  |   `/api/circle/removeActivity`, GET   | `cirid, actid`  |                           移除活动                           |
|  CircleController  |        `/api/circle/add`, POST        |    `Circle`     |                           新增圈子                           |

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

+ Activity POST 请求的 JSON 格式

```json
{
    "imageURL":"",
    "activityType": "",
    "activityTitle":"",
    "activityDescription":"",
    "startTime": "2021-01-01T12:00:00",
    "endTime": "2021-01-01T14:00:00",
    "activityPlace": "",
    "activityCreator": ""
}
```

+ Circle POST 请求的 JSON 格式

`circleCreatorID` 就是创建者的 `userid` .

```json
{
    "circleName":"快乐摸鱼人",
    "circleDescription":"摸鱼人的快乐源泉",
    "circleCreatorID": 1
}
```

