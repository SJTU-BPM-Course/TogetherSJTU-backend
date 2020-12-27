/*
SQLyog Ultimate v11.24 (32 bit)
MySQL - 5.7.32-0ubuntu0.16.04.1 : Database - SJTUBPM
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`SJTUBPM` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `SJTUBPM`;

/*Table structure for table `activity` */

DROP TABLE IF EXISTS `activity`;

CREATE TABLE `activity` (
  `actid` int(10) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `acttype` varchar(64) DEFAULT NULL,
  `acttitle` varchar(64) NOT NULL,
  `actdesc` varchar(1024) DEFAULT NULL,
  `actstarttime` datetime NOT NULL,
  `actendtime` datetime NOT NULL,
  `actplace` varchar(128) NOT NULL,
  `actcreator` varchar(32) DEFAULT NULL,
  `actimageurl` varchar(1024) DEFAULT NULL,
  `actstatus` int(5) DEFAULT '0' COMMENT '是否审核',
  `actcollege` varchar(64) DEFAULT '软件学院' COMMENT '相关学院',
  PRIMARY KEY (`actid`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

/*Data for the table `activity` */

insert  into `activity`(`actid`,`acttype`,`acttitle`,`actdesc`,`actstarttime`,`actendtime`,`actplace`,`actcreator`,`actimageurl`,`actstatus`,`actcollege`) values (0000000001,'学术讲座','物联网体系结构','物联网（ IoT ，Internet of things ）即“万物相连的互联网”，是互联网基础上的延伸和扩展的网络，将各种信息传感设备与互联网结合起来而形成的一个巨大网络，实现在任何时间、任何地点，人、机、物的互联互通。','2020-12-30 19:00:00','2020-12-30 21:00:00','陈瑞球楼303C','张学友','https://tse3-mm.cn.bing.net/th/id/OIP.fhs62Czn5tpvw9QrTshy9gHaEo?pid=Api&rs=1',0,'电子信息学院'),(0000000002,'社团活动','习近平新时代中国特色社会主义学习讨论会','习近平，男，汉族，1953年6月生，陕西富平人，1969年1月参加工作，1974年1月加入中国共产党，清华大学人文社会学院马克思主义理论与思想政治教育专业毕业，在职研究生学历，法学博士学位。','2020-12-22 14:00:00','2020-12-22 16:00:00','软件学院3301','冼健邦','https://bkimg.cdn.bcebos.com/pic/54fbb2fb43166d22ca0c87944a2309f79052d2b3',0,'机电学院'),(0000000003,'社团活动','江泽民学长生平事迹研讨会','江泽民，男，汉族，1926年08月17日出生，江苏省扬州市人。1943年起参加地下党领导的学生运动，1946年04月加入中国共产党，1947年毕业于上海交通大学电机系。','2020-12-29 09:00:00','2020-12-29 11:00:00','软件学院3301','黄子昂','https://bkimg.cdn.bcebos.com/pic/267f9e2f07082838ac3a8f1bb899a9014c08f18e?x-bce-process=image/watermark,image_d2F0ZXIvYmFpa2U5Mg==,g_7,xp_5,yp_5',0,'机电学院'),(0000000004,'班级会议','2020专业硕士班会','班会','2020-12-26 14:00:00','2020-12-26 15:00:00','电院5301','张学友','https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=1836105702,2808570913&fm=26&gp=0.jpg',0,'软件学院'),(0000000005,'学术讲座','《新时期我国信息技术产业的发展》','该书由中共中央文献研究室和上海交通大学合作编辑，由中央文献出版社和上海交通大学出版社联合出版。全书收入江泽民1983年至2008年间关于信息技术产业和信息化问题的重要论文、报告、讲话、文章27篇，附录2篇，17万余字，其中许多文稿是首次公开发表。','2021-01-01 20:00:00','2021-01-01 22:00:00','陈瑞球楼101A','张学友','https://static3.doxue.com/uploads/2020/04/11/aa71cfc7fec456e95849e1da649574c7.png',0,'计算机学院'),(0000000007,'社团活动','黑客大赛','sjtu hackergame','2020-12-09 00:49:08','2020-12-09 00:49:08','软件学院3301','Huang Ziang','https://bkimg.cdn.bcebos.com/pic/f3d3572c11dfa9ec948460b96ad0f703908fc1f1?x-bce-process=image/watermark,image_d2F0ZXIvYmFpa2UxNTA=,g_7,xp_5,yp_5',0,'网络安全学院'),(0000000014,'学术讲座','计算机体系结构','计算机体系结构是指根据属性和功能不同而划分的计算机理论组成部分及计算机基本工作原理、理论的总称。其中计算机理论组成部分并不单与某一个实际硬件相挂钩，如存储部分就包括寄存器、内存、硬盘等。','2021-01-01 20:00:00','2021-01-01 21:00:00','软件学院3301','张学友','https://tse4-mm.cn.bing.net/th/id/OIP.QxAGqoqN05cAW9flF9q7fAHaJO?pid=Api&rs=1',0,'软件学院'),(0000000017,'冲突活动演示1','艺术留学咨询会','陆尊波，从事艺术留学行业3年，帮助学生拿到过英国皇家艺术学院、伦敦艺术大学、爱丁堡大学、伦敦大学学院；美国罗德岛艺术学院、普瑞特艺术学院、帕森斯设计学院；意大利米兰布雷拉美术学院、卡拉拉美术学院、博洛尼亚美术学院等全球知名艺术院校的录取offer。','2021-01-10 15:00:00','2021-01-10 17:00:00','伍威权堂','冼健邦','https://tongqu.sjtu.edu.cn/upload/acts/20201217/origin_431b6d379fd1fa359c09f9c5e9629d1e.jpg',-1,'艺术学院'),(0000000018,'冲突活动演示1','3D多媒体音乐剧《梵高》中文版','作为一部音乐与画作相结合的作品，《梵高》将超过50幅的艺术巨作带出美术馆，呈上舞台，展现出线条与色彩的流动之美。','2021-01-10 16:00:00','2021-01-10 17:00:00','伍威权堂','黄子昂','https://tongqu.sjtu.edu.cn/upload/acts/20201202/origin_a574d743438166cdf1aa15307e539351.jpg',1,'传媒学院'),(0000000019,'冲突活动演示2','弗洛里安·大卫·菲茨影展','不知道你有没有想过，假如生命的保质期只剩下一天，你会去哪里，会见什么人，会做什么事？可能你会因为一路走来而不舍地大哭一场，又或许你想到了生命旅途中的美好点滴后选择会心一笑，总之，生命便是这么一个泪花与笑容交替翻涌的过程。','2021-01-25 16:00:00','2021-01-25 18:00:00','蔡翠菊楼101','张学友','https://tongqu.sjtu.edu.cn/upload/acts/20201215/origin_5e3fb72c3b9909f689d59d2f3f66757f.jpg',1,'艺术学院'),(0000000020,'冲突活动演示2','安娜·卡里娜纪念影展','本片由雅克·里韦特执导，法国新浪潮代表人物之一，与戈达尔同期被认为是最具实验性的新浪潮导演之一。本片是对启蒙哲学家丹尼斯·狄德罗对宗教滥用的猛烈抨击的忠实改编。获第19届戛纳电影节金棕榈奖提名。','2021-01-25 15:00:00','2021-01-25 17:00:00','蔡翠菊楼101','冼健邦','https://tongqu.sjtu.edu.cn/upload/acts/20201208/origin_be56d040da006d94851430843f8fb9e5.jpg',-1,'艺术学院');

/*Table structure for table `circle` */

DROP TABLE IF EXISTS `circle`;

CREATE TABLE `circle` (
  `cirid` int(10) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `cirname` varchar(64) NOT NULL,
  `cirdesc` varchar(512) DEFAULT NULL,
  `circreatorid` int(11) NOT NULL COMMENT '创建者的id',
  `circreator` varchar(32) DEFAULT NULL COMMENT '创建者',
  `cirmembers` varchar(1024) DEFAULT NULL,
  `ciractivities` varchar(1024) DEFAULT NULL,
  PRIMARY KEY (`cirid`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

/*Data for the table `circle` */

insert  into `circle`(`cirid`,`cirname`,`cirdesc`,`circreatorid`,`circreator`,`cirmembers`,`ciractivities`) values (0000000001,'肥宅艺术家','肥宅们的快乐基地',2,'冼健邦','[1,2,3]','[1,2,14]'),(0000000002,'一颗赛艇协会','一颗赛艇，是一种网络用语，为英文exciting的谐音，常用来形容令人兴奋和激动的事件或情形。',2,'冼健邦','[2]','[2]'),(0000000003,'快乐摸鱼人','摸鱼人的快乐源泉',3,'黄子昂','[1,2,3]','[5]'),(0000000014,'2020研究生','爬',2,'冼健邦','[2,3,4]','[1]');

/*Table structure for table `feedback` */

DROP TABLE IF EXISTS `feedback`;

CREATE TABLE `feedback` (
  `feedbackid` int(11) NOT NULL AUTO_INCREMENT,
  `actid` int(11) NOT NULL,
  `comment` varchar(1024) DEFAULT NULL,
  PRIMARY KEY (`feedbackid`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8;

/*Data for the table `feedback` */

insert  into `feedback`(`feedbackid`,`actid`,`comment`) values (39,20,'在该活动的时间段内，蔡翠菊楼101有其他活动进行。'),(40,17,'在该活动的时间段内，伍威权堂有其他活动进行。');

/*Table structure for table `record_circle_activity` */

DROP TABLE IF EXISTS `record_circle_activity`;

CREATE TABLE `record_circle_activity` (
  `recid` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `cirid` int(11) NOT NULL,
  `actid` int(11) NOT NULL,
  PRIMARY KEY (`recid`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Data for the table `record_circle_activity` */

insert  into `record_circle_activity`(`recid`,`cirid`,`actid`) values (1,1,1),(2,1,2),(3,2,2),(6,3,5),(7,14,1),(8,1,14);

/*Table structure for table `record_user_activity` */

DROP TABLE IF EXISTS `record_user_activity`;

CREATE TABLE `record_user_activity` (
  `recid` int(10) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `recstatus` int(10) unsigned zerofill NOT NULL COMMENT '0 表示未签到，1表示已签到',
  `userid` int(11) NOT NULL,
  `actid` int(11) NOT NULL,
  PRIMARY KEY (`recid`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

/*Data for the table `record_user_activity` */

insert  into `record_user_activity`(`recid`,`recstatus`,`userid`,`actid`) values (0000000001,0000000001,2,1),(0000000004,0000000000,2,3),(0000000005,0000000000,2,2),(0000000008,0000000000,4,1),(0000000009,0000000000,4,4),(0000000010,0000000001,2,4),(0000000011,0000000001,3,1),(0000000012,0000000000,4,5);

/*Table structure for table `record_user_circle` */

DROP TABLE IF EXISTS `record_user_circle`;

CREATE TABLE `record_user_circle` (
  `recid` int(10) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `cirid` int(11) DEFAULT NULL,
  `userid` int(11) DEFAULT NULL,
  PRIMARY KEY (`recid`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

/*Data for the table `record_user_circle` */

insert  into `record_user_circle`(`recid`,`cirid`,`userid`) values (0000000002,1,2),(0000000003,1,3),(0000000004,2,2),(0000000005,3,3),(0000000006,1,1),(0000000009,3,2),(0000000010,3,1),(0000000019,14,2),(0000000020,14,3),(0000000021,14,4);

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `userid` int(10) unsigned zerofill NOT NULL AUTO_INCREMENT COMMENT '内部ID',
  `username` varchar(64) NOT NULL COMMENT '用户名',
  `userpwd` varchar(32) NOT NULL COMMENT '密码',
  `userrole` varchar(32) NOT NULL COMMENT '用户角色',
  `userdepartment` varchar(128) NOT NULL COMMENT '所属学院/部门',
  `userworkid` varchar(32) NOT NULL COMMENT '学号/工号',
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`userid`,`username`,`userpwd`,`userrole`,`userdepartment`,`userworkid`) values (0000000001,'root','123','root','root','root'),(0000000002,'冼健邦','123','Student','软件学院','120037910056'),(0000000003,'黄子昂','123','Student','软件学院','120037910001'),(0000000004,'张学友','123','Teacher','软件学院','T1234567'),(0000000005,'肖战','123','Admin','行政人员','A7654321');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
