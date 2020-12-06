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
  PRIMARY KEY (`actid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `activity` */

insert  into `activity`(`actid`,`acttype`,`acttitle`,`actdesc`,`actstarttime`,`actendtime`,`actplace`,`actcreator`,`actimageurl`) values (0000000001,'学术讲座','物联网体系结构','目前物联网架构通常分为感知层、网络层和应用层三个层次。 感知层 感知层是物联网的核心，是信息采集的关键部分。感知层位于物联网三层结构中的底层，其功能为“感知”，即通过传感网络获取环境信息。','2020-12-30 19:00:00','2020-12-30 21:00:00','陈瑞球楼303A','王东','https://tse3-mm.cn.bing.net/th/id/OIP.fhs62Czn5tpvw9QrTshy9gHaEo?pid=Api&rs=1'),(0000000002,'社团活动','习近平新时代中国特色社会主义学习讨论会','习近平，男，汉族，1953年6月生，陕西富平人，1969年1月参加工作，1974年1月加入中国共产党，清华大学人文社会学院马克思主义理论与思想政治教育专业毕业，在职研究生学历，法学博士学位。','2020-12-22 14:00:00','2020-12-22 16:00:00','软件学院3301','冼健邦','https://bkimg.cdn.bcebos.com/pic/54fbb2fb43166d22ca0c87944a2309f79052d2b3'),(0000000003,'社团活动','江泽民学长生平事迹研讨会','江泽民，男，汉族，1926年08月17日出生，江苏省扬州市人。1943年起参加地下党领导的学生运动，1946年04月加入中国共产党，1947年毕业于上海交通大学电机系。','2020-12-29 09:00:00','2020-12-29 11:00:00','软件学院3301','黄子昂','https://bkimg.cdn.bcebos.com/pic/267f9e2f07082838ac3a8f1bb899a9014c08f18e?x-bce-process=image/watermark,image_d2F0ZXIvYmFpa2U5Mg==,g_7,xp_5,yp_5'),(0000000004,'班级会议','2020专业硕士班会','班会','2020-12-26 14:00:00','2020-12-26 15:00:00','电院5301','张学友','https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=1836105702,2808570913&fm=26&gp=0.jpg');

/*Table structure for table `circle` */

DROP TABLE IF EXISTS `circle`;

CREATE TABLE `circle` (
  `cirid` int(10) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `cirname` varchar(64) NOT NULL,
  `cirdesc` varchar(512) DEFAULT NULL,
  `cirmembers` varchar(1024) NOT NULL,
  `ciractivities` varchar(1024) NOT NULL,
  PRIMARY KEY (`cirid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `circle` */

insert  into `circle`(`cirid`,`cirname`,`cirdesc`,`cirmembers`,`ciractivities`) values (0000000001,'肥宅艺术家','肥宅们的快乐基地','[1,2,3]','[1]');

/*Table structure for table `record_user_activity` */

DROP TABLE IF EXISTS `record_user_activity`;

CREATE TABLE `record_user_activity` (
  `recid` int(10) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `userid` int(11) NOT NULL,
  `actid` int(11) NOT NULL,
  PRIMARY KEY (`recid`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

/*Data for the table `record_user_activity` */

insert  into `record_user_activity`(`recid`,`userid`,`actid`) values (0000000001,2,1),(0000000002,2,2),(0000000003,2,4),(0000000004,2,3);

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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`userid`,`username`,`userpwd`,`userrole`,`userdepartment`,`userworkid`) values (0000000001,'root','123','root','root','root'),(0000000002,'冼健邦','123','Student','软件学院','120037910056'),(0000000003,'黄子昂','123','Student','软件学院','120037910001'),(0000000004,'张学友','123','Teacher','软件学院','T1234567');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
