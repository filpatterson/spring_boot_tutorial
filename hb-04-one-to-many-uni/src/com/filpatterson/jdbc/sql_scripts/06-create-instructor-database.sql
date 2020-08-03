drop schema if exists `hb-01-one-to-one-uni`;
create schema `hb-01-one-to-one-uni`;

-- switch to the required schema
use `hb-01-one-to-one-uni`;

-- disable foreign key check
set FOREIGN_KEY_CHECKS = 0;

drop table if exists `instructor_detail`;
create table `instructor_detail`(
	`id`				int(11)	       		not null auto_increment,
    `youtube_channel`	varchar(45)         default null,
    `hobby`				varchar(45)			default null,
    
    primary key (`id`)
) engine=InnoDB auto_increment=1 default charset=latin1;

drop table if exists `instructor`;
create table `instructor` (
	`id`					int(11)				not null auto_increment,
    `first_name`			varchar(45)			default null,
    `last_name`				varchar(45)			default null,
    `email`					varchar(45)			default null,
    `instructor_detail_id`	int(11)				default null,
    
    primary key (`id`),
    
    -- make name of indexing this key
    key `FK_DETAIL_idx` (`instructor_detail_id`),
    
    --      mark key as foreign one and show that it references to the instructor table with column `id`
    -- also set cascade operations over different scenarios
    constraint `FK_DETAIL` foreign key (`instructor_detail_id`) references `instructor_detail` (`id`)
    on delete no action on update no action
) engine=InnoDB auto_increment=1 default charset=latin1;

-- enable foreign key check
set FOREIGN_KEY_CHECKS = 1;
 