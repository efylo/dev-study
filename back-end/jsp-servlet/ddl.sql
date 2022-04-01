create schema if not exists newlec;

use newlec;

create table notice (
	`id` int auto_increment,
    `title` varchar(100),
    `writer_id` varchar(20), 
    `content` varchar(1000), 
    `regdate` timestamp,
    `hit` int,
    `files` varchar(100),
    primary key (`id`)
);