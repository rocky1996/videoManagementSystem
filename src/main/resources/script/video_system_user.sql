DROM TABLE IF EXISTS `video_system_user`;
CREATE TABLE `video_system_user` (
    `id` int(10) NOT NULL AUTO_INCREMENT COMMIT '主键id',
    `username` varchar(20) NOT NULL COMMIT '用户名',
    `password` varchar(20) NOT NULL COMMIT '密码',
    `user_role` int(2) NOT NULL COMMIT '0:管理员,1:任务管理员,2:视频管理员,3:推送管理员',
    `is_effective` int(2) NOT NULL COMMIT '用户名是否生效,0:已生效(开),1:未生效(关)',
    `gather_auth_str` text DEFAULT NULL COMMIT '该用户的采集权限,可以为空,例如1,2,3,4,  以逗号隔开',
    `create_time` datetime NOT NULL COMMIT '创建时间',
    `update_time` datetime NOT NULL COMMIT '更新时间',
    PRIMARY key (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
#主动创建管理员(admin),申请的'校对员'需要管理员同意才可以生效