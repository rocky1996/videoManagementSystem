#客户表
DROP TABLE IF EXISTS `video_system_customer`;
CREATE TABLE `video_system_customer` (
     `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键id',
     `customer_name` varchar(20) NOT NULL COMMENT '客户名称',
     `customer_secret_key` text NOT NULL COMMENT '客户密钥',
     `push_volume` int(10) NOT NULL COMMENT COMMENT '日推送量',
     `customer_status` int(2) NOT NULL COMMENT '是否开启,0:开启,1:关闭',
     `customer_gather_auth` text DEFAULT NULL COMMENT '采集内容配置,以逗号隔开',
     `is_delete` int(2) NOT NULL COMMENT '物理删除,0:未删除,1:已删除',
     `create_time` datetime NOT NULL COMMENT '创建时间',
     `update_time` datetime NOT NULL COMMENT '更新时间',
     PRIMARY key (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;