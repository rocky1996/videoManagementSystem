#角色表
DROM TABLE IF EXISTS `video_system_role`;
CREATE TABLE `video_system_role` (
     `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键id',
     `role_name` varchar(20) NOT NULL COMMENT '角色名称',
     `role_desc` text NOT NULL COMMENT '角色描述',
     `is_effective` int(2) NOT NULL COMMENT '是否开启,0:开启,1:关闭',
     `role_having_menu` text NOT NULL COMMENT '菜单权限,Json字符串格式',
     `is_delete` int(2) NOT NULL COMMENT '物理删除,0:未删除,1:已删除',
     `create_time` datetime NOT NULL COMMENT '创建时间',
     `update_time` datetime NOT NULL COMMENT '更新时间',
     PRIMARY key (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;