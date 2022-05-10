#自动分配表
DROP TABLE IF EXISTS `video_system_auto_rules`;
CREATE TABLE `video_system_auto_rules` (
     `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键id',
     `rule_name` varchar(20) NOT NULL COMMENT '策略名称',
     `language_type` int(2) NOT NULL COMMENT '语种',
     `auditor` text NOT NULL COMMENT '审核员id,用逗号隔开',
     `allocation_rules` text NOT NULL COMMENT '审核员分配的权重,json字符串',
     `role_status` int(2) NOT NULL COMMENT '是否开启,0:开启,1:关闭',
     `role_desc` text DEFAULT NULL COMMENT '描述',
     `is_delete` int(2) NOT NULL COMMENT '逻辑删除,0:未删除,1:已删除',
     `create_time` datetime NOT NULL COMMENT '创建时间',
     `update_time` datetime NOT NULL COMMENT '更新时间',
     PRIMARY key (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
