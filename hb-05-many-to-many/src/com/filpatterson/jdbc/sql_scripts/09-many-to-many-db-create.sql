drop schema if exists `hb-05-many-to-many`;
create schema `hb-05-many-to-many`;

use `hb-05-many-to-many`;

set FOREIGN_KEY_CHECKS=0;

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

drop table if exists `course`;
create table `course` (
	`id`				int(11)			not null auto_increment,
    `title`				varchar(45)		default null,
    `instructor_id`		int(11)			default null,
    
    primary key(`id`),
    
    -- making such a key, that will not repeat (system, where course can be appended to the single one intructor)  
    unique key `TITLE_UNIQUE` (`title`),
    
    -- mark indexing of the key and then bind this foreign key to the `instructor` field called `id`
    key `FK_INSTRUCTOR_idx` (`instructor_id`),
    constraint `FK_INSTRUCTOR` foreign key (`instructor_id`) references `instructor` (`id`)
    on delete no action on update no action
) engine=InnoDB auto_increment=10 default charset=latin1;

drop table if exists `review`;
create table `review` (
	`id`		int(11)			not null auto_increment,
    `comment`	varchar(256)    default null,
    `course_id`	int(11)			default null,
     
    primary key(`id`),
    key `FK_REVIEW_idx` (`course_id`),
    constraint `FK_REVIEW` foreign key (`course_id`) references `course` (`id`)
    on delete no action on update no action
) engine=InnoDB auto_increment=1 default charset=latin1;

drop table if exists `student`;
CREATE TABLE `student` (
	`id` int (11) NOT NULL AUTO_INCREMENT,
    `first_name` varchar(45) DEFAULT NULL,
    `last_name` varchar(45) DEFAULT NULL,
    `email` varchar(45) DEFAULT NULL,
    PRIMARY KEY (`id`)
) engine=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

-- join table that will connect students with courses
drop table if exists `course_student`;
create table `course_student`(
	`course_id`		int(11)		not null,
    `student_id` 	int(11)		not null,
    
    primary key(`course_id`, `student_id`),
    key `FK_STUDENT_idx` (`student_id`),
    
    -- setting first foreign key that will reference to the courses
    constraint `FK_COURSE` foreign key (`course_id`) references `course` (`id`)
    on delete no action on update no action,
    
    -- setting another foreign key that will reference to the students
    constraint `FK_STUDENT` foreign key (`student_id`) references `student` (`id`)
    on delete no action on update no action
) engine=InnoDB auto_increment=1 default charset=latin1;

-- enable foreign key check
set FOREIGN_KEY_CHECKS = 1;