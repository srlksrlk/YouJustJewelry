set names utf8;

drop database if exists youJustJewelry;
create database youJustJewelry default character set utf8;
use youJustJewelry;

/* 商品情報テーブル */
drop table if exists ticket_info;
create table ticket_info(
	ticket_id int(3) primary key auto_increment,
	ticket_name varchar(100) unique,
	price int(7),
	stock int(3)
);

/* 顧客情報テーブル	*/
drop table if exists customer_info;
create table customer_info(
	id int(4) primary key auto_increment,
	user_id varchar(30) unique,
	user_pass varchar(30),
	last_name varchar(30),
	first_name varchar(30),
	user_mail varchar(60),
	gender int(1),
	birthday date,
	user_ip varchar(40),
	register_date timestamp default current_timestamp on update current_timestamp,
	update_date date,
	delete_date date
);

/* 顧客住所情報テーブル */
drop table if exists customer_address;
create table customer_address(
	user_id varchar(30) unique,
	zipcode varchar(8),
	prefecture varchar(10),
	citytown varchar(10),
	house_number varchar(100)
);

/* 注文情報テーブル	*/
drop table if exists order_info;
create table order_info(
	user_ip	varchar(30),
	mac_address	varchar(17),
	user_id	varchar(30),
	ticket_id int(3),
	ticket_name	varchar(100),
	ticket_count int(3),
	total_amount int(9),
	token int(32)
);

/* 購入履歴テーブル	*/
drop table if exists history;
create table history(
	user_id varchar(30),
	ticket_id int(3),
	ticket_count int(3),
	total_amount int(9),
	user_ip varchar(40),
	order_day timestamp,
	delete_day date
);
/*テスト登録者情報の挿入*/
insert into customer_info (
user_id,user_pass,last_name,first_name,user_mail,gender
)value(
'1234',
'1234',
'一二三',
'四五郎',
'hogehoge@gmail.com',
1);


/*商品情報のレコード挿入*/
insert into ticket_info (
ticket_name,price,stock
)value(
'ブラックパール/ボルダーオパール鉱山',
350000,
100);
insert into ticket_info (
ticket_name,price,stock
)value(
'ピンクダイヤモンド/アーガイル鉱山',
400000,
100);
insert into ticket_info (
ticket_name,price,stock
)value(
'最高級エメラルド/コスクエス鉱山',
625000,
100);
insert into ticket_info (
ticket_name,price,stock
)value(
'パパラチアサファイア/ラトナプラ鉱山',
398000,
100);
insert into ticket_info (
ticket_name,price,stock
)value(
'ピジョンブラッドルビー/モゴク鉱山',
450000,
100);
insert into ticket_info (
ticket_name,price,stock
)value(
'ブルーダイヤモンド/カリナン鉱山',
500000,
100);