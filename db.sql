--tag


INSERT INTO `dput`.`tag` (`tag_id`, `created_on`, `description`, `is_active`) VALUES ('1', '2016-01-01 00:00:01', 'Operator', 'Y');
INSERT INTO `dput`.`tag` (`tag_id`, `created_on`, `description`, `is_active`) VALUES ('2', '2016-01-01 00:00:01', 'Admin', 'N');
INSERT INTO `dput`.`tag` (`tag_id`, `created_on`, `description`, `is_active`) VALUES ('3', '2016-01-01 00:00:01', 'Manager', 'Y');


--device

INSERT INTO `dput`.`device` (`device_id`, `description`, `status`) VALUES ('1', 'd1', 'Working');
INSERT INTO `dput`.`device` (`device_id`, `description`, `status`) VALUES ('2', 'd2', 'Working');
INSERT INTO `dput`.`device` (`device_id`, `description`, `status`) VALUES ('3', 'd3', 'Idle');


--- protocol

INSERT INTO `dput`.`protocol` (`protocol_id`, `created_on`, `effectivity_date`, `title`, `device_id`) VALUES ('1', '2017-01-01 00:00:01', '2015-02-03 00:00:01', 'p1', '1');
INSERT INTO `dput`.`protocol` (`protocol_id`, `created_on`, `effectivity_date`, `title`, `device_id`) VALUES ('2', '2017-01-01 00:00:01', '2016-02-03 00:00:01', 'p2', '1');
INSERT INTO `dput`.`protocol` (`protocol_id`, `created_on`, `effectivity_date`, `title`) VALUES ('3', '2018-01-01 00:00:01', '2018-03-01 00:00:01', 'p3');





--user

INSERT INTO `dput`.`device_user_map` VALUES (1,2);
INSERT INTO `dput`.`device_user_map` VALUES (2,1);


INSERT INTO `dput`.`user` (`user_id`, `email`, `username`, `tag_id`) VALUES ('1', 'vendra@gmail.com', 'Raghvendra', '1');
INSERT INTO `dput`.`user` (`user_id`, `email`, `username`, `tag_id`) VALUES ('2', 'rv@gmail.com', 'Raghav', '1');
INSERT INTO `dput`.`user` (`user_id`, `email`, `username`, `tag_id`) VALUES ('3', 'kushal@gmail.com', 'Kushal', '3');