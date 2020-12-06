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


