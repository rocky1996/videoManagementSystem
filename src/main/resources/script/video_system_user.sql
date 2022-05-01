#用户表
DROP TABLE IF EXISTS `video_system_user`;
CREATE TABLE `video_system_user` (
    `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `username` varchar(20) NOT NULL COMMENT '用户名',
    `password` varchar(20) NOT NULL COMMENT '密码',
    `user_desc` text NOT NULL COMMENT '用户描述',
    `user_status` int(2) NOT NULL COMMENT '是否开启,0:开启,1:关闭',
    `role_id` int(10) NOT NULL COMMENT '角色id',
    `is_delete` int(2) NOT NULL COMMENT '逻辑删除,0:未删除,1:已删除',
    `create_time` datetime NOT NULL COMMENT '创建时间',
    `update_time` datetime NOT NULL COMMENT '更新时间',
    PRIMARY key (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;