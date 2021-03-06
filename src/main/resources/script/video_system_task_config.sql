DROP TABLE IF EXISTS `video_system_task_config`;
CREATE TABLE `video_system_task_config` (
     `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键id',
     `user_id` int(10) NOT NULL COMMENT '用户id',
     `video_system_task_id` int(10) NOT NULL COMMENT '任务id',
     `media_scope` int(2) NOT NULL COMMENT '0:ALL,1:网站,2:YouTube,3:FaceBook,4:Twitter',
     `include_arbitrarily_keyword` text DEFAULT NULL COMMENT '包含以下任一关键字,多个的话逗号隔开',
     `include_all_keyword` text DEFAULT NULL COMMENT '包含以下全部关键字,多个的话逗号隔开',
     `shield_arbitrarily_keyword` text DEFAULT NULL COMMENT '屏蔽以下任一关键字,多个的话逗号隔开',
     `website_name` varchar(50) DEFAULT NULL COMMENT '网站名称',
     `website_url` text DEFAULT NULL COMMENT '网站url',
     `blogger_id_str` text DEFAULT NULL COMMENT '博主id字符串,多个以逗号隔开',
     `is_delete` int(2) DEFAULT 0 COMMENT '逻辑删除,0:未删除,1:已删除',
     `create_time` datetime NOT NULL COMMENT '创建时间',
     `update_time` datetime NOT NULL COMMENT '更新时间',
     PRIMARY key (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;