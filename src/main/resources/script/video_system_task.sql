DROM TABLE IF EXISTS `video_system_task`;
CREATE TABLE `video_system_task` (
     `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键id',
     `user_id` int(10) NOT NULL COMMENT '用户id',
     `task_name` varchar(20) NOT NULL COMMENT '任务名称',
     `task_type` int(2) NOT NULL COMMENT '0:日更任务,1:一次性任务',
     `gather_video_start_time` datetime DEFAULT NULL COMMENT '采集视频开始时间',
     `gather_video_end_time` datetime DEFAULT NULL COMMENT '采集视频结束时间',
     `gather_video_time` datetime DEFAULT NULL COMMENT '采集视频时间',
     `push_time` datatime NOT NULL COMMENT '推送时间',
     `gather_type` int(2) NOT NULL COMMENT '0:关键字采集,1:定源采集,2:关键字+定源采集',
     `media_scope` int(2) NOT NULL COMMENT '0:ALL,1:网站,2:YouTube,3:FaceBook,4:Twitter',
     `gather_auth_str` text DEFAULT NULL COMMENT '该用户的采集权限,可以为空,例如1,2,3,4,  以逗号隔开',
     `task_open_status` int(2) NOT NULL COMMENT '0:开启,1:关闭',
     `task_status` int(2) NOT NULL COMMENT '0:未开始,1:运行中,2:已结束,3:已停止',
     `is_delete` int(2) DEFAULT 0 COMMENT '逻辑删除,0:未删除,1:已删除',
     `create_time` datetime NOT NULL COMMENT '创建时间',
     `update_time` datetime NOT NULL COMMENT '更新时间',
     PRIMARY key (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;