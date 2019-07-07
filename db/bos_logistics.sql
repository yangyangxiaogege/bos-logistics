/*
SQLyog Ultimate - MySQL GUI v8.2 
MySQL - 5.5.27 : Database - bos_logistics
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`bos_logistics` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `bos_logistics`;

/*Table structure for table `bc_archives` */

DROP TABLE IF EXISTS `bc_archives`;

CREATE TABLE `bc_archives` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '档案id',
  `archivesName` varchar(50) NOT NULL COMMENT '档案名称，名称唯一',
  `userId` int(11) NOT NULL COMMENT '操作人员，不可修改',
  `operationTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '操作时间，不可修改',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='系统的一些基础档案，主要应用在参照录入';

/*Data for the table `bc_archives` */

insert  into `bc_archives`(`id`,`archivesName`,`userId`,`operationTime`) values (1,'取派员类型',1,'2019-05-22 21:11:07'),(2,'线路类型',1,'2019-05-23 15:54:45');

/*Table structure for table `bc_archivesdetail` */

DROP TABLE IF EXISTS `bc_archivesdetail`;

CREATE TABLE `bc_archivesdetail` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `archivesDetailName` varchar(50) NOT NULL COMMENT '针对一个基本档案的子信息，不能重名',
  `archivesId` int(11) NOT NULL COMMENT '上级编码',
  `userId` int(11) NOT NULL COMMENT '操作用户,不可修改',
  `remark` varchar(255) NOT NULL COMMENT '备注',
  `operationTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '操作时间，不可修改',
  PRIMARY KEY (`id`),
  KEY `FK_Reference_2` (`archivesId`),
  CONSTRAINT `FK_Reference_2` FOREIGN KEY (`archivesId`) REFERENCES `bc_archives` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='基础档案明细';

/*Data for the table `bc_archivesdetail` */

insert  into `bc_archivesdetail`(`id`,`archivesDetailName`,`archivesId`,`userId`,`remark`,`operationTime`) values (1,'小件员',1,1,'取派较小物件','2019-05-22 21:13:17'),(2,'公路',2,1,'101国道运输','2019-05-23 15:55:27'),(3,'高铁',2,1,'这是一条光速运输路线','2019-05-25 15:04:00'),(4,'冷运员',1,1,'专门运输冷冻品','2019-05-29 10:51:45');

/*Table structure for table `courier` */

DROP TABLE IF EXISTS `courier`;

CREATE TABLE `courier` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '取派员id',
  `name` varchar(20) NOT NULL COMMENT '姓名',
  `hasPDA` int(11) NOT NULL DEFAULT '0' COMMENT '是否有PDA,0表示没有，1表示有',
  `delFlag` int(11) NOT NULL DEFAULT '1' COMMENT '删除标识，0，标识删除，1标识没有删除',
  `station` varchar(50) NOT NULL COMMENT '所属单位',
  `userId` int(11) NOT NULL COMMENT '录入人,当前登陆用户',
  `standard` varchar(50) NOT NULL COMMENT '手牌标准',
  `bcarchives_detailId` int(11) NOT NULL COMMENT '取派员类型',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='取派员信息';

/*Data for the table `courier` */

insert  into `courier`(`id`,`name`,`hasPDA`,`delFlag`,`station`,`userId`,`standard`,`bcarchives_detailId`) values (1,'张浩',0,1,'顺丰速运',1,'0~50kg',1),(2,'曹国枫',0,1,'京东快递',1,'0~50kg',1),(3,'君莫邪',1,1,'大汇超市',1,'100~200kg',4),(4,'梅雪烟',1,1,'唯品会',1,'0~50kg',1),(5,'楚器魂',0,0,'拼多多',1,'100~200kg',4),(6,'苗小苗',0,1,'圆通快递',1,'0~50kg',1),(7,'韩烟梦',0,0,'申通快递',1,'0~50kg',4),(8,'张无忌',0,1,'北大青鸟',1,'0~50kg',1),(9,'赵敏',1,1,'尚硅谷',1,'0~50kg',4);

/*Table structure for table `fixed_region` */

DROP TABLE IF EXISTS `fixed_region`;

CREATE TABLE `fixed_region` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '定区id',
  `name` varchar(50) NOT NULL COMMENT '定区名称',
  `courierId` varchar(20) NOT NULL COMMENT '定区负责人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='定区，一个定区下包含一组分区';

/*Data for the table `fixed_region` */

insert  into `fixed_region`(`id`,`name`,`courierId`) values (1,'雪月城区','1'),(2,'斗罗大陆','2');

/*Table structure for table `region` */

DROP TABLE IF EXISTS `region`;

CREATE TABLE `region` (
  `id` varchar(20) NOT NULL COMMENT '区域id',
  `province` varchar(20) DEFAULT NULL COMMENT '省',
  `city` varchar(20) DEFAULT NULL COMMENT '市',
  `county` varchar(50) DEFAULT NULL COMMENT '区|县',
  `postalCode` varchar(50) DEFAULT NULL COMMENT '邮编',
  `shortCode` varchar(50) DEFAULT NULL COMMENT '简码',
  `cityCode` varchar(50) DEFAULT NULL COMMENT '城市编码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='区域';

/*Data for the table `region` */

insert  into `region`(`id`,`province`,`city`,`county`,`postalCode`,`shortCode`,`cityCode`) values ('QY001','北京市','北京市','东城区','110101','BJBJDC','bei jing'),('QY002','北京市','北京市','西城区','110102','BJBJXC','bei jing'),('QY003','北京市','北京市','朝阳区','110105','BJBJCY','bei jing'),('QY004','北京市','北京市','丰台区','110106','BJBJFT','bei jing'),('QY005','北京市','北京市','石景山区','110107','BJBJSJS','bei jing'),('QY006','北京市','北京市','海淀区','110108','BJBJHD','bei jing'),('QY007','北京市','北京市','门头沟区','110109','BJBJMTG','bei jing'),('QY008','北京市','北京市','房山区','110111','BJBJFS','bei jing'),('QY009','北京市','北京市','通州区','110112','BJBJTZ','bei jing'),('QY010','北京市','北京市','顺义区','110113','BJBJSY','bei jing'),('QY011','北京市','北京市','昌平区','110114','BJBJCP','bei jing'),('QY012','北京市','北京市','大兴区','110115','BJBJDX','bei jing'),('QY013','北京市','北京市','怀柔区','110116','BJBJHR','bei jing'),('QY014','北京市','北京市','平谷区','110117','BJBJPG','bei jing'),('QY015','北京市','北京市','密云县','110228','BJBJMY','bei jing'),('QY016','北京市','北京市','延庆县','110229','BJBJYQ','bei jing'),('QY017','河北省','石家庄市','长安区','130102','HBSJZZA','shi jia zhuang'),('QY018','河北省','石家庄市','桥东区','130103','HBSJZQD','shi jia zhuang'),('QY019','河北省','石家庄市','桥西区','130104','HBSJZQX','shi jia zhuang'),('QY020','河北省','石家庄市','新华区','130105','HBSJZXH','shi jia zhuang'),('QY021','河北省','石家庄市','井陉矿区','130107','HBSJZJXK','shi jia zhuang'),('QY022','河北省','石家庄市','裕华区','130108','HBSJZYH','shi jia zhuang'),('QY023','河北省','石家庄市','井陉县','130121','HBSJZJX','shi jia zhuang'),('QY024','河北省','石家庄市','正定县','130123','HBSJZZD','shi jia zhuang'),('QY025','河北省','石家庄市','栾城县','130124','HBSJZLC','shi jia zhuang'),('QY026','河北省','石家庄市','行唐县','130125','HBSJZXT','shi jia zhuang'),('QY027','河北省','石家庄市','灵寿县','130126','HBSJZLS','shi jia zhuang'),('QY028','河北省','石家庄市','高邑县','130127','HBSJZGY','shi jia zhuang'),('QY029','河北省','石家庄市','深泽县','130128','HBSJZSZ','shi jia zhuang'),('QY030','河北省','石家庄市','赞皇县','130129','HBSJZZH','shi jia zhuang'),('QY031','河北省','石家庄市','无极县','130130','HBSJZWJ','shi jia zhuang'),('QY032','河北省','石家庄市','平山县','130131','HBSJZPS','shi jia zhuang'),('QY033','河北省','石家庄市','元氏县','130132','HBSJZYS','shi jia zhuang'),('QY034','河北省','石家庄市','赵县','130133','HBSJZZ','shi jia zhuang'),('QY035','河北省','石家庄市','辛集市','130181','HBSJZXJ','shi jia zhuang'),('QY036','河北省','石家庄市','藁城市','130182','HBSJZGC','shi jia zhuang'),('QY037','河北省','石家庄市','晋州市','130183','HBSJZJZ','shi jia zhuang'),('QY038','河北省','石家庄市','新乐市','130184','HBSJZXL','shi jia zhuang'),('QY039','河北省','石家庄市','鹿泉市','130185','HBSJZLQ','shi jia zhuang'),('QY040','天津市','天津市','和平区','120101','TJTJHP','tian jin'),('QY041','天津市','天津市','河东区','120102','TJTJHD','tian jin'),('QY042','天津市','天津市','河西区','120103','TJTJHX','tian jin'),('QY043','天津市','天津市','南开区','120104','TJTJNK','tian jin'),('QY044','天津市','天津市','河北区','120105','TJTJHB','tian jin'),('QY045','天津市','天津市','红桥区','120106','TJTJHQ','tian jin'),('QY046','天津市','天津市','滨海新区','120116','TJTJBHX','tian jin'),('QY047','天津市','天津市','东丽区','120110','TJTJDL','tian jin'),('QY048','天津市','天津市','西青区','120111','TJTJXQ','tian jin'),('QY049','天津市','天津市','津南区','120112','TJTJJN','tian jin'),('QY050','天津市','天津市','北辰区','120113','TJTJBC','tian jin'),('QY051','天津市','天津市','武清区','120114','TJTJWQ','tian jin'),('QY052','天津市','天津市','宝坻区','120115','TJTJBC','tian jin'),('QY053','天津市','天津市','宁河县','120221','TJTJNH','tian jin'),('QY054','天津市','天津市','静海县','120223','TJTJJH','tian jin'),('QY055','天津市','天津市','蓟县','120225','TJTJJ','tian jin'),('QY056','山西省','太原市','小店区','140105','SXTYXD','tai yuan'),('QY057','山西省','太原市','迎泽区','140106','SXTYYZ','tai yuan'),('QY058','山西省','太原市','杏花岭区','140107','SXTYXHL','tai yuan'),('QY059','山西省','太原市','尖草坪区','140108','SXTYJCP','tai yuan'),('QY060','山西省','太原市','万柏林区','140109','SXTYWBL','tai yuan'),('QY061','山西省','太原市','晋源区','140110','SXTYJY','tai yuan'),('QY062','山西省','太原市','清徐县','140121','SXTYQX','tai yuan'),('QY063','山西省','太原市','阳曲县','140122','SXTYYQ','tai yuan'),('QY064','山西省','太原市','娄烦县','140123','SXTYLF','tai yuan'),('QY065','山西省','太原市','古交市','140181','SXTYGJ','tai yuan');

/*Table structure for table `role` */

DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色id',
  `roleName` varchar(20) NOT NULL COMMENT '角色名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='用户角色表，决定了用户权限，具体可以做哪些操作';

/*Data for the table `role` */

insert  into `role`(`id`,`roleName`) values (1,'系统管理员');

/*Table structure for table `subregion` */

DROP TABLE IF EXISTS `subregion`;

CREATE TABLE `subregion` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '分区id',
  `addressKey` varchar(50) DEFAULT NULL COMMENT '地址关键字',
  `startNum` int(11) DEFAULT NULL COMMENT '起始号,用于匹配楼、街、号、段',
  `endNum` int(11) DEFAULT NULL COMMENT '终止号',
  `single` int(11) DEFAULT NULL COMMENT '单双号',
  `assistKey` varchar(255) DEFAULT NULL COMMENT '辅助关键字',
  `regionId` varchar(50) NOT NULL COMMENT '区域id',
  `fixedRegionId` varchar(50) DEFAULT NULL COMMENT '所属定区',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='管理分区';

/*Data for the table `subregion` */

insert  into `subregion`(`id`,`addressKey`,`startNum`,`endNum`,`single`,`assistKey`,`regionId`,`fixedRegionId`) values (1,'北京东城',1,50,0,'北京市东城区','QY001','1');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `username` varchar(20) NOT NULL COMMENT '用户名',
  `password` varchar(32) NOT NULL COMMENT '用户密码',
  `createDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建日期',
  `gender` varchar(10) NOT NULL COMMENT '性别',
  `address` varchar(50) DEFAULT NULL COMMENT '地址',
  `telephone` varchar(11) NOT NULL COMMENT '电话',
  `roleId` int(11) NOT NULL COMMENT '角色id',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`),
  KEY `FK_Reference_1` (`roleId`),
  CONSTRAINT `FK_Reference_1` FOREIGN KEY (`roleId`) REFERENCES `role` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='存储用户信息';

/*Data for the table `user` */

insert  into `user`(`id`,`username`,`password`,`createDate`,`gender`,`address`,`telephone`,`roleId`,`remark`) values (1,'admin','f6fdffe48c908deb0f4c3bd36c032e72','2019-05-22 20:15:27','男','三里屯','18680631790',1,NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
