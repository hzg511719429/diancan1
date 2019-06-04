/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : diancan

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2019-06-04 20:36:04
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for address
-- ----------------------------
DROP TABLE IF EXISTS `address`;
CREATE TABLE `address` (
  `address_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `address_buyer_id` bigint(20) NOT NULL,
  `address_address` varchar(200) CHARACTER SET utf8 NOT NULL,
  `address_is_default` char(1) CHARACTER SET utf8 NOT NULL COMMENT '0否1是',
  PRIMARY KEY (`address_id`),
  KEY `user_id` (`address_buyer_id`),
  CONSTRAINT `user_id` FOREIGN KEY (`address_buyer_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of address
-- ----------------------------
INSERT INTO `address` VALUES ('4', '5', '13号楼215', '1');
INSERT INTO `address` VALUES ('5', '3', '河南周口', '0');
INSERT INTO `address` VALUES ('7', '3', '河南南阳', '1');
INSERT INTO `address` VALUES ('8', '5', '14号楼', '1');

-- ----------------------------
-- Table structure for car
-- ----------------------------
DROP TABLE IF EXISTS `car`;
CREATE TABLE `car` (
  `car_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `car_buyer_id` bigint(20) NOT NULL,
  `car_product_id` bigint(20) NOT NULL,
  `car_product_num` int(11) NOT NULL,
  `car_product_price` double(10,2) NOT NULL,
  PRIMARY KEY (`car_id`),
  KEY `car_buyer_id` (`car_buyer_id`),
  KEY `car_product_id` (`car_product_id`),
  CONSTRAINT `car_buyer_id` FOREIGN KEY (`car_buyer_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `car_product_id` FOREIGN KEY (`car_product_id`) REFERENCES `product` (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of car
-- ----------------------------

-- ----------------------------
-- Table structure for item
-- ----------------------------
DROP TABLE IF EXISTS `item`;
CREATE TABLE `item` (
  `item_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `item_order_id` bigint(20) NOT NULL,
  `item_product_id` bigint(20) NOT NULL,
  `item_product_num` int(11) NOT NULL,
  `item_product_price` double(10,2) NOT NULL,
  PRIMARY KEY (`item_id`),
  KEY `item_order_id` (`item_order_id`),
  KEY `item_product_id` (`item_product_id`),
  CONSTRAINT `item_order_id` FOREIGN KEY (`item_order_id`) REFERENCES `orders` (`order_id`),
  CONSTRAINT `item_product_id` FOREIGN KEY (`item_product_id`) REFERENCES `product` (`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1 COMMENT='订单明细表';

-- ----------------------------
-- Records of item
-- ----------------------------
INSERT INTO `item` VALUES ('1', '6', '6', '4', '60.00');
INSERT INTO `item` VALUES ('2', '6', '10', '3', '30.00');
INSERT INTO `item` VALUES ('3', '6', '12', '4', '20.00');
INSERT INTO `item` VALUES ('10', '12', '6', '7', '105.00');
INSERT INTO `item` VALUES ('11', '13', '6', '3', '45.00');
INSERT INTO `item` VALUES ('12', '14', '10', '1', '10.00');
INSERT INTO `item` VALUES ('13', '15', '10', '1', '10.00');

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `menu_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `menu_seller_id` bigint(20) NOT NULL,
  `menu_product_id` bigint(20) NOT NULL,
  PRIMARY KEY (`menu_id`),
  KEY `menu_seller_id` (`menu_seller_id`),
  KEY `menu_product_id` (`menu_product_id`),
  CONSTRAINT `menu_product_id` FOREIGN KEY (`menu_product_id`) REFERENCES `product` (`product_id`),
  CONSTRAINT `menu_seller_id` FOREIGN KEY (`menu_seller_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of menu
-- ----------------------------

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `order_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `order_buyer_id` bigint(20) NOT NULL,
  `order_seller_id` bigint(20) NOT NULL,
  `order_no` varchar(30) CHARACTER SET utf8 DEFAULT NULL,
  `order_address` varchar(200) CHARACTER SET utf8 DEFAULT NULL,
  `order_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `order_delieve_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `order_finish_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `order_total_price` double(10,2) DEFAULT NULL,
  `order_payment` varchar(20) CHARACTER SET utf8 DEFAULT NULL,
  `order_status` char(2) CHARACTER SET utf8 DEFAULT NULL,
  `order_comments` varchar(1000) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`order_id`),
  KEY `order_user_id` (`order_buyer_id`),
  KEY `order_sell_id` (`order_seller_id`),
  CONSTRAINT `order_sell_id` FOREIGN KEY (`order_seller_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `order_user_id` FOREIGN KEY (`order_buyer_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES ('6', '3', '3', '2018111789122', '河南周口', '2018-11-17 02:09:00', '2018-11-17 10:00:00', '2018-11-17 02:09:00', '110.00', '0', '0', 'qwe');
INSERT INTO `orders` VALUES ('12', '3', '3', '201811185401', '河南南阳', '2018-11-18 00:58:56', '2018-11-18 10:00:00', '2018-11-18 00:58:56', '105.00', '0', '0', '南阳的');
INSERT INTO `orders` VALUES ('13', '5', '3', '2018111899815', '13号楼', '2018-11-18 01:35:40', '2018-11-18 10:00:00', '2018-11-18 01:35:40', '45.00', '0', '0', '小黄黄');
INSERT INTO `orders` VALUES ('14', '5', '3', '2018111854199', '13号楼', '2018-11-18 03:04:17', '2018-11-18 18:00:00', '2018-11-18 03:04:17', '10.00', '0', '0', '第二次');
INSERT INTO `orders` VALUES ('15', '5', '3', '2019051819110', '13号楼215', '2019-05-18 14:26:09', '2019-05-18 10:00:00', '2019-05-18 14:26:09', '10.00', '0', '0', 'test');

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `product_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `product_no` varchar(30) CHARACTER SET utf8 NOT NULL,
  `product_name` varchar(50) CHARACTER SET utf8 NOT NULL,
  `product_seller_id` bigint(20) NOT NULL COMMENT '卖家id与user_id关联',
  `product_price` double(10,2) NOT NULL,
  `product_stock` int(255) NOT NULL,
  `product_taste` char(1) NOT NULL COMMENT '代表辣不辣 0否1是',
  `product_is_sell` char(1) NOT NULL COMMENT '是否上架 0否1是',
  `product_description` varchar(100) CHARACTER SET utf8 NOT NULL COMMENT '产品简介',
  `product_picture` varchar(50) CHARACTER SET utf8 NOT NULL COMMENT '产品图片',
  `product_hass_selled` int(11) NOT NULL COMMENT '已卖出多少',
  PRIMARY KEY (`product_id`),
  KEY `sell_id` (`product_seller_id`),
  CONSTRAINT `sell_id` FOREIGN KEY (`product_seller_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES ('6', '2018111268410', '小黄花儿', '3', '15.00', '1095', '0', '1', '美丽的小黄花', '不使用该字段', '16');
INSERT INTO `product` VALUES ('10', '2018111572273', '像葡萄的东西', '3', '10.00', '2215', '1', '1', '紫彤彤的', '', '7');
INSERT INTO `product` VALUES ('12', '2018111575305', '小麦', '3', '5.00', '3327', '0', '1', '好东西', 'data/images/20181115/1542213470795.jpg', '6');

-- ----------------------------
-- Table structure for productimg
-- ----------------------------
DROP TABLE IF EXISTS `productimg`;
CREATE TABLE `productimg` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `product_id` bigint(20) NOT NULL,
  `imgurl` varchar(255) NOT NULL,
  `beiyong` varchar(255) DEFAULT '' COMMENT '备用 可以为空',
  PRIMARY KEY (`id`),
  KEY `product_id` (`product_id`),
  CONSTRAINT `product_id` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1 COMMENT='商品图片表';

-- ----------------------------
-- Records of productimg
-- ----------------------------
INSERT INTO `productimg` VALUES ('6', '6', 'data/images/20181112/1541955792978.jpg', null);
INSERT INTO `productimg` VALUES ('8', '10', 'data/images/20181115/1542212927055.jpg', null);
INSERT INTO `productimg` VALUES ('9', '12', 'data/images/20181115/1542213470795.jpg', null);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_email` varchar(50) CHARACTER SET utf8 NOT NULL,
  `user_password` varchar(20) CHARACTER SET utf8 NOT NULL,
  `user_nickname` varchar(30) CHARACTER SET utf8 NOT NULL,
  `user_realname` varchar(30) CHARACTER SET utf8 NOT NULL,
  `user_phone` varchar(20) NOT NULL,
  `user_rol` char(1) CHARACTER SET utf8 NOT NULL COMMENT '0买1卖',
  `user_sex` char(1) CHARACTER SET utf8 NOT NULL COMMENT '0女1男',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '694058774@qq.com', 'qianmo220', '大锤', '黄光旭', '18239454142', '1', '1');
INSERT INTO `user` VALUES ('2', '123@qq.com', 'qianmo220', '王大成', '称大王', '12345678901', '1', '1');
INSERT INTO `user` VALUES ('3', '456@qq.com', '123456', 'sada', 'sadas', '11111111111', '1', '1');
INSERT INTO `user` VALUES ('5', '111@qq.com', '123456', '小黄', '黄黄', '12345678977', '0', '1');
