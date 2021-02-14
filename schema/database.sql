// 区域表
create table `tb_area`(
    area_id int(2) not null auto_increment,
    area_name varchar(200) not null,
    priority int(2) not null default 0,
    create_time datetime default null,
    last_edit_time datetime default null,
    primary key(`ared_id`),
    unique key `UK_AREA`(`area_name`) //唯一键,不可重复
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

// 用户信息表
create table `tb_person_info`(
    `user_id` int(10) not null auto_increment,
    `name` varchar(32) default null,
    `profile_img` varchar(1024) default null,
    `email` varchar(1024) default null,
    `gender` varchar(2) default null,
    `enable_status` int(2) not null default '0' comment '0:禁止使用本商城 1：允许使用本商城',
    `user_type` int(2) not null defualt '1' comment '1:顾客 2：店家 3：超级管理员',
    `create_time` datetime default null,
    `last_edit_time` datetime default null,
    primary key(`user_id`),
)ENGINE=InnoDB AUTO_INCREMENT = 1 DEFAULT CHARSET=utf8;

// 微信账号表
create table `tb_wechat_auth`(
    `wechat_auth_id` int(10) not null auto_increment comment '主键',
    `open_id` varchar(1024) not null comment '微信身份唯一标识',
    `create_time` datetime default null,
    `user_id` int(10) not null,
    primary key(`wechat_auth_id`),
    foreign key(`user_id`) references `tb_person_info`(`user_id`),
    unique index(`open_id`), //注意这里面是index,可以提高查询性能,而不是key,创建的是索引
)engine=innodb auto_increment=1 default charset=utf8;

// 账号密码表
create table `tb_local_auth`(
local_auth_id int(10) not null auto_increment,
user_id int(10) not null,
user_name varchar(128) not null,
password varchar(128) not null,
create_time datetime default null,
last_edit_time datetime default null,
primary key(local_auth_id),
unique key uk_local_profile(user_name),
constraint fk_localauth_profile foreign key(user_id) references tb_person_info(user_id)
)engine=innodb auto_increment=1 default charset=utf8;


// 头条类
create table tb_head_line(
line_id int(10) not null auto_increment,
line_name varchar(1024) not null,
line_link varchar(2000),
line_img varchar(2000) not null,
priority int(2) not null default 0,
enable_status int(2) not null default 1 comment '0不可用，1可用',
create_time datetime default null,
last_edit_time datetime default null,
primary key(line_id)
)engine=innodb auto_increment=1 default charset=utf8;

// 店铺类别
create table tb_shop_category(
shop_category_id int(11) not null auto_increment,
shop_category_name varchar(100) not null default '',
shop_category_desc varchar(1000) default '',
shop_category_img varchar(2000) default null,
priority int(2) not null default 0,
create_time datetime default null,
last_edit_time datetime default null,
parent_id int(11) default null comment '上级id（父id），当上级id为空，表示根',
primary key(shop_category_id),
foreign key(parent_id) references tb_shop_category(shop_category_id) //外键和自己连接起来
)engine=innodb auto_increment=1 default charset=utf8;

// 店铺类
create table `tb_shop`(
    `shop_id` int(10) not null auto_increment,
    `owner_id` int(10) not null comment '店铺创建人',
    shop_category_id int(11) default null,
    area_id int(5) default null,
    shop_name varchar(256) not null,
    shop_desc varchar(1024) default null,
    shop_addr varchar(200) default null,
    phone varchar(128) default null,
    shop_img varchar(1024) default null,
    priority int(3) default 0 comment '列表展示优先级',
    enable_status int(2) not null default 0 comment '-1:不可用，店家不可登陆,0:审核中,1:可用',
    create_time datetime default null,
    last_edit_time datetime default null,
    advice varchar(255) default null,
    primary key(shop_id),
    foreign key(owner_id) references tb_person_info(user_id),
    foreign key(shop_category_id) references tb_shop_category(shop_category_id),
    foreign key(area_id) references tb_area(area_id)
)engine=innodb auto_increment=1 default charset=utf8;

// 店铺商品类别
create table tb_product_category(
product_category_id int(11) not null auto_increment,
product_category_name varchar(100) not null,
priority int(2) default 0,
create_time datetime default null,
shop_id int(20) not null default 0,
primary key(product_category_id),
foreign key(shop_id) references tb_shop(shop_id)
)engine=innodb auto_increment=1 default charset=utf8;

// 商品详情图
create table tb_product_img(
product_img_id int(11) not null auto_increment,
img_addr varchar(2000) not null,
img_desc varchar(2000) default null,
priority int(2) default 0,
create_time datetime default null,
product_id int(20) default null,
primary key(product_img_id),
foreign key(product_id) references tb_product(product_id)
)engine=innodb auto_increment=1 default charset=utf8;

// 商品
create table tb_product(
product_id int(11) not null auto_increment,
product_name varchar(200) not null,
product_desc varchar(2000) default null,
img_addr varchar(2000) default null comment '商品缩略图',
normal_price varchar(100) default null,
promotion_price varchar(100) default null,
priority int(2) not null default 0,
create_time datetime default null,
last_edit_time datetime default null,
enable_status int(2) not null default 0 comment '0表示未上架',
product_category_id int(11) default null,
shop_id int(20) not null default 0,
primary key(product_id),
foreign key(product_category_id) references tb_product_category(product_category_id),
foreign key(shop_id) references tb_shop(shop_id)
)engine=innodb auto_increment=1 default charset=utf8;


// ****************** 项目2.0新建表 ********************
# 积分奖品表
create table tb_award(
award_id int(10) not null auto_increment,
award_name varchar(256) not null,
award_desc varchar(1024) not null,
award_img varchar(1024) not null,
point int(2) not null default '0' comment '奖品兑换积分，默认为0',
shop_id int(10) not null,
priority int(2) default null,
create_time datetime default null,
last_edit_time datetime default null,
enable_status int(2) not null default '0' comment '0：未上架 1：上架',
primary key(award_id),
foreign key(shop_id) references tb_shop(shop_id)
)engine=innodb auto_increment=1 default charset=utf8;

# 用户积分兑换记录表
create table tb_user_award_map(
user_award_id int(10) not null auto_increment,
user_id int(10) not null,
shop_id int(10) not null,
award_id int(10) not null,
operator_id int(10) default null comment '兑换操作员id',
point int(10) default null comment '消耗积分',
create_time datetime default null comment '兑换时间',
last_edit_time datetime default null comment '领取时间',
used_status int(2) not null default '0' comment '0：未领取 1：已领取',
primary key(user_award_id),
foreign key(user_id) references tb_person_info(user_id) ,
foreign key(shop_id) references tb_shop(shop_id),
foreign key(award_id) references tb_award(award_id),
foreign key(operator_id) references tb_person_info(user_id)
)engine=innodb auto_increment=1 default charset=utf8;

# 用户消费记录表
create table tb_user_product_map(
user_product_id int(10) not null auto_increment,
user_id int(10) not null,
shop_id int(10) not null,
product_id int(10) not null,
operator_id int(10) not null,
create_time datetime default null,
point int(10) default '0' comment '购买商品获得积分',
primary key(user_product_id),
foreign key(user_id) references tb_person_info(user_id),
foreign key(shop_id) references tb_shop(shop_id),
foreign key(product_id) references tb_product(product_id),
foreign key(operator_id) references tb_person_info(user_id)
)engine=innodb auto_increment=1 default charset=utf8;

# 用户-店铺积分表
create table tb_user_shop_map(
user_shop_id int(10) not null auto_increment,
user_id int(10) not null,
shop_id int(10) not null,
point int(2) default '0' comment '用户总积分',
create_time datetime default null,
primary key(user_shop_id),
unique key(user_id,shop_id),
foreign key(user_id) references tb_person_info(user_id),
foreign key(shop_id) references tb_shop(shop_id)
)engine=innodb auto_increment=1 default charset=utf8;

# 商家日统计顾客消费商品表,定时任务统计
create table tb_product_sell_daily(
product_sell_daily_id int(10) not null auto_increment,
product_id int(100) default null,
shop_id int(10) default null,
total int(10) default '0',
create_time datetime default null,
primary key(product_sell_daily_id),
unique(create_time, shop_id, product_id),
foreign key(shop_id) references tb_shop(shop_id),
foreign key(product_id) references tb_product(product_id)
)engine=innodb auto_increment=1 default charset=utf8;

create table tb_shop_auth_map(
shop_auth_id int(10) not null auto_increment,
shop_id int(10) not null,
employee_id int(10) not null,
title varchar(255) default null,
title_flag int(2) default null,
create_time datetime default null,
last_edit_time datetime default null,
enable_status int(2) not null default '0' comment '0：无效，1：有效',
primary key(shop_auth_id),
unique key(shop_id, employee_id),
foreign key(employee_id) references tb_person_info(user_id),
foreign key(shop_id) references tb_shop(shop_id)
)engine=innodb auto_increment=1 default charset=utf8;