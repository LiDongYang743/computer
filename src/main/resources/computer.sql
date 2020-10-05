
# 创建数据库
CREATE DATABASE computer;

USE computer;

# 创建电脑配置类型表
DROP TABLE IF EXISTS computer_type;
CREATE TABLE computer_type(
  Type_id INT AUTO_INCREMENT   COMMENT'类型编号',
  typename VARCHAR(50) DEFAULT NULL COMMENT '类型名称',
  PRIMARY KEY(`Type_id`)
)ENGINE=INNODB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='computer_type';


# 创建电脑配置表
DROP TABLE IF EXISTS computer_accessories;
CREATE TABLE computer_accessories(
 component_id INT AUTO_INCREMENT  COMMENT '配件编号',
 Type_id INT NOT NULL COMMENT '类型编号',
 Component_name VARCHAR(200) DEFAULT NULL COMMENT '配件说明',
 capacity VARCHAR(20) DEFAULT NULL COMMENT '容量',
 price INT DEFAULT 0 COMMENT '价格',
 PRIMARY KEY(component_id),
 CONSTRAINT fk_type FOREIGN KEY(Type_id) REFERENCES  computer_type(Type_id)
)ENGINE=INNODB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='computer_accessories';



# 创建电脑表
DROP TABLE IF EXISTS coumpetrs;
CREATE TABLE coumpetrs(
  coumpetrs_id INT AUTO_INCREMENT   COMMENT '电脑编号',
  Computer_name VARCHAR(20) DEFAULT NULL COMMENT '名称',
  MEMORY  INT DEFAULT 0 UNIQUE COMMENT '内存',
  cpu INT DEFAULT 0  UNIQUE COMMENT 'CPU',
  videocard INT DEFAULT 0 UNIQUE COMMENT '显卡',
  display INT DEFAULT 0 UNIQUE COMMENT '显示器',
  hdd INT DEFAULT 0 UNIQUE COMMENT'硬盘',
  price	INT DEFAULT 0  COMMENT '价格',
  PRIMARY KEY(coumpetrs_id) 
 )ENGINE=INNODB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='computer_accessories';
 
 # 中间表 MEMORY
 DROP  TABLE IF EXISTS computer_accessories_coumpetrs_momory;
 CREATE TABLE computer_accessories_coumpetrs_momory(
   id INT AUTO_INCREMENT ,
   MEMORY  INT  NOT NULL,
   component_id INT NOT NULL,
   PRIMARY KEY(id),
   CONSTRAINT fk1 FOREIGN KEY(MEMORY) REFERENCES  coumpetrs(MEMORY),
   CONSTRAINT fk2 FOREIGN KEY(component_id) REFERENCES  computer_accessories(component_id)
 )
 
 # 中间表 cpu
 DROP  TABLE IF EXISTS computer_accessories_coumpetrs_cpu;
 CREATE TABLE computer_accessories_coumpetrs_cpu(
   id INT AUTO_INCREMENT ,
   cpu  INT  NOT NULL,
   component_id INT NOT NULL,
   PRIMARY KEY(id),
   CONSTRAINT fk3 FOREIGN KEY(cpu) REFERENCES  coumpetrs(cpu),
   CONSTRAINT fk4 FOREIGN KEY(component_id) REFERENCES  computer_accessories(component_id)
 )
 
 # 中间表 videocard
 DROP  TABLE IF EXISTS computer_accessories_coumpetrs_videocard;
 CREATE TABLE computer_accessories_coumpetrs_videocard(
   id INT AUTO_INCREMENT ,
   videocard  INT  NOT NULL,
   component_id INT NOT NULL,
   PRIMARY KEY(id),
   CONSTRAINT fk5 FOREIGN KEY(videocard) REFERENCES  coumpetrs(videocard),
   CONSTRAINT fk6 FOREIGN KEY(component_id) REFERENCES  computer_accessories(component_id)
 )
 
 # 中间表 display
 DROP  TABLE IF EXISTS computer_accessories_coumpetrs_display;
 CREATE TABLE computer_accessories_coumpetrs_display(
   id INT AUTO_INCREMENT ,
   display  INT  NOT NULL,
   component_id INT NOT NULL,
   PRIMARY KEY(id),
   CONSTRAINT fk7 FOREIGN KEY(display) REFERENCES  coumpetrs(display),
   CONSTRAINT fk8 FOREIGN KEY(component_id) REFERENCES  computer_accessories(component_id)
 )
 
 # 中间表 display
 DROP  TABLE IF EXISTS computer_accessories_coumpetrs_hdd;
 CREATE TABLE computer_accessories_coumpetrs_hdd(
   id INT AUTO_INCREMENT ,
   hdd  INT  NOT NULL,
   component_id INT NOT NULL,
   PRIMARY KEY(id),
   CONSTRAINT fk9 FOREIGN KEY(hdd) REFERENCES  coumpetrs(hdd),
   CONSTRAINT fk10 FOREIGN KEY(component_id) REFERENCES  computer_accessories(component_id)
 )
 
 


INSERT INTO computer_type(typename) VALUES('cpu');
INSERT INTO computer_type(typename) VALUES('硬盘');
INSERT INTO computer_type(typename) VALUES('内存');
INSERT INTO computer_type(typename) VALUES('显卡');
INSERT INTO computer_type(typename) VALUES('显示器');
SELECT * FROM computer_type;

INSERT INTO computer_accessories(Type_id,Component_name,capacity,price) VALUES(2,'金士顿硬盘','500',654);
INSERT INTO computer_accessories(Type_id,Component_name,capacity,price) VALUES(1,'AMDi7-1580U',DEFAULT,954);
INSERT INTO computer_accessories(Type_id,Component_name,capacity,price) VALUES(3,'金士顿内存','8',565);
INSERT INTO computer_accessories(Type_id,Component_name,capacity,price) VALUES(4,'三星GTX3.5显卡',DEFAULT,399);
INSERT INTO computer_accessories(Type_id,Component_name,capacity,price) VALUES(2,'三星孤星17寸显示器',DEFAULT,666);	
SELECT * FROM computer_accessories;
SELECT computer_accessories.* FROM computer_accessories,computer_type WHERE  computer_type.Type_id=computer_accessories.`Type_id` AND typename='cpu'

INSERT INTO coumpetrs 
	(Computer_name,MEMORY,cpu,videocard,display,hdd,price)
VALUES ('冲锋战神游戏本',3,2,4,4,1,5000);
INSERT INTO coumpetrs 
	(Computer_name,MEMORY,cpu,videocard,display,hdd,price)
VALUES ('神职者笔记本',3,5,4,2,1,5000);		
SELECT * FROM 	coumpetrs;

SELECT computer_accessories.* FROM computer_accessories,coumpetrs WHERE computer_accessories.`component_id`=coumpetrs.`cpu`  






