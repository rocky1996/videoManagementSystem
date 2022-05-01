#客户表
DROM TABLE IF EXISTS `video_system_customer`;
CREATE TABLE `video_system_customer` (
     `id` int(10) NOT NULL AUTO_INCREMENT COMMIT '主键id',
     `customer_name` varchar(20) NOT NULL COMMIT '客户名称',
     `customer_secret_key` text NOT NULL COMMIT '客户密钥',
     `is_effective` int(2) NOT NULL COMMIT '是否开启,0:开启,1:关闭',
     `customer_gather_auth` text DEFAULT NULL COMMIT '采集内容配置,以逗号隔开',
     `is_delete` int(2) NOT NULL COMMIT '物理删除,0:未删除,1:已删除',
     `create_time` datetime NOT NULL COMMIT '创建时间',
     `update_time` datetime NOT NULL COMMIT '更新时间',
     PRIMARY key (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;