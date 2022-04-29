DROM TABLE IF EXISTS `video_system_task`;
CREATE TABLE `video_system_task` (
     `id` int(10) NOT NULL AUTO_INCREMENT COMMIT '主键id',
     `user_id` int(10) NOT NULL COMMIT '用户id',
     `video_system_task_id` int(10) NOT NULL COMMIT '任务id',
     `include_arbitrarily_keyword` text DEFAULT NULL COMMIT '包含以下任一关键字,多个的话逗号隔开',
     `include_all_keyword` text DEFAULT NULL COMMIT '包含以下全部关键字,多个的话逗号隔开',
     `shield_arbitrarily_keyword` text DEFAULT NULL COMMIT '屏蔽以下任一关键字,多个的话逗号隔开',
     `website_name` varchar(50) DEFAULT NULL COMMIT '网站名称',
     `website_url` text DEFAULT NULL COMMIT '网站url',
     `create_time` datetime NOT NULL COMMIT '创建时间',
     `update_time` datetime NOT NULL COMMIT '更新时间',
     PRIMARY key (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;