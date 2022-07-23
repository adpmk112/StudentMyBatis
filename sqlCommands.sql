create table `user`(
`id` int not null auto_increment,`email` varchar(50),`password` varchar(30),primary key (`id`));

create table `student`(
`student_id` int not null 
auto_increment,
`name` varchar(50),
`birth` varchar(50),
`gender` varchar(30),
`phone` varchar(50),
`education` varchar(100),
primary key(`student_id`));

create table `course`(
`course_id` int not null auto_increment,`name` varchar(50),
 primary key (`course_id`));

create table student_course(
`id` int auto_increment not null,
`student_id` int,
`course_id` int,
primary key (`id`),
foreign key (`student_id`)
references `student`(`student_id`) on delete cascade,
foreign key (`course_id`)
references `course`(`course_id`) on delete set null);

select
s.`student_id`, s.`name` AS `student_name`, s.`birth`,s.`gender`,s.`phone`,s.`education`,
c.`course_id`, c.`name` AS `course_name` from `student` s join `student_course` sc join `course` c on
s.`student_id`=sc.`student_id` and c.`course_id` =sc.`course_id`;

select
s.`student_id`, s.`name` AS `student_name`, s.`birth`,s.`gender`,s.`phone`,s.`education`,
c.`course_id`, c.`name` AS `course_name` from `student` s join `student_course` sc join `course` c on
s.`student_id`=sc.`student_id` and c.`course_id` =sc.`course_id` where s.`student_id`=?;


