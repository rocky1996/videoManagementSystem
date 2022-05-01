#意见反馈表
DROM TABLE IF EXISTS `video_system_feedback`;
CREATE TABLE `video_system_feedback` (
     `id` int(10) NOT NULL AUTO_INCREMENT COMMIT '主键id',
     `task_id` int(10) NOT NULL COMMIT '任务id',
     `title_id` int(10) NOT NULL COMMIT '标题id',
     `user_id` int(10) NOT NULL COMMIT '用户id',
     `feedback_secret_key` text NOT NULL COMMIT '密钥',
     `feedback_time` datetime NOT NULL COMMIT '反馈时间',
     `is_delete` int(2) NOT NULL COMMIT '物理删除,0:未删除,1:已删除',
     `create_time` datetime NOT NULL COMMIT '创建时间',
     `update_time` datetime NOT NULL COMMIT '更新时间',
     PRIMARY key (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;