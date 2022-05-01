#用户表
DROM TABLE IF EXISTS `video_system_user`;
CREATE TABLE `video_system_user` (
    `id` int(10) NOT NULL AUTO_INCREMENT COMMIT '主键id',
    `username` varchar(20) NOT NULL COMMIT '用户名',
    `password` varchar(20) NOT NULL COMMIT '密码',
    `user_desc` text NOT NULL COMMIT '用户描述',
    `is_effective` int(2) NOT NULL COMMIT '是否开启,0:开启,1:关闭',
    `role_id` int(10) NOT NULL COMMIT '角色id',
    `create_time` datetime NOT NULL COMMIT '创建时间',
    `update_time` datetime NOT NULL COMMIT '更新时间',
    PRIMARY key (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;