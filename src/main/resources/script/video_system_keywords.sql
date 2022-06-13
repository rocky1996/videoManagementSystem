#视频关键字存储表
DROP TABLE IF EXISTS `video_system_keywords`;
CREATE TABLE `video_system_keywords` (
     `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键id',
     `only_code` int(20) NOT NULL COMMENT '视频的唯一标识',
     `video_url` text NOT NULL COMMENT '视频url',
     `msg_body` text DEFAULT NULL COMMENT 'msgBody序列化字符串',
     `is_delete` int(2) NOT NULL COMMENT '逻辑删除,0:未删除,1:已删除',
     `create_time` datetime NOT NULL COMMENT '创建时间',
     `update_time` datetime NOT NULL COMMENT '更新时间',
     PRIMARY key (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;