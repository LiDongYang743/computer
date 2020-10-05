
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
  computer_id INT AUTO_INCREMENT   COMMENT '电脑编号',
  Computer_name VARCHAR(20) DEFAULT NULL COMMENT '名称',
  MEMORY  INT DEFAULT 0 COMMENT '内存',
  cpu INT DEFAULT 0 COMMENT 'CPU',
  videocard INT DEFAULT 0 COMMENT '显卡',
  display INT DEFAULT 0 COMMENT '显示器',
  hdd INT DEFAULT 0 COMMENT'硬盘',
  price	INT DEFAULT 0 COMMENT '价格',
  PRIMARY KEY(computer_id)  ,	
  CONSTRAINT fk1_coumpetrs FOREIGN KEY(MEMORY) REFERENCES  computer_accessories(component_id) ,
  CONSTRAINT fk2_coumpetrs FOREIGN KEY(cpu) REFERENCES  computer_accessories(component_id)	,
  CONSTRAINT fk3_coumpetrs FOREIGN KEY(videocard) REFERENCES  computer_accessories(component_id),
  CONSTRAINT fk4_coumpetrs FOREIGN KEY(display) REFERENCES  computer_accessories(component_id),
  CONSTRAINT fk5_coumpetrs FOREIGN KEY(hdd) REFERENCES  computer_accessories(component_id)			
)ENGINE=INNODB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='computer_accessories';


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






