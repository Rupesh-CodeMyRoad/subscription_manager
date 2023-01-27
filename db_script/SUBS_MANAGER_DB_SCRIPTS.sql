SET FOREIGN_KEY_CHECKS = 0;
CREATE DATABASE IF NOT EXISTS xgile_subs_manager;
USE xgile_subs_manager;

DROP TABLE IF EXISTS sub_type;
CREATE TABLE sub_type
(
    sub_type_id bigint       NOT NULL AUTO_INCREMENT,
    sub_name    varchar(100) NOT NULL,
    status      boolean      NULL,
    UNIQUE KEY (sub_name),
    PRIMARY KEY (sub_type_id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

DROP TABLE IF EXISTS sub_mapping;
CREATE TABLE sub_mapping
(
    sub_mapping_id   bigint       NOT NULL AUTO_INCREMENT,
    sub_reference_id varchar(255) NOT NULL,
    consumer_name    varchar(255) NOT NULL,
    status           boolean      NULL,
    date_logged      datetime     NOT NULL,
    sub_type_id      bigint       NOT NULL UNIQUE,
    PRIMARY KEY (sub_mapping_id),
    UNIQUE KEY (sub_reference_id),
    CONSTRAINT FOREIGN KEY (sub_type_id) REFERENCES sub_type (sub_type_id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;


-- ----------------------------
-- Records of subscription types
-- ----------------------------
insert into sub_type(sub_type_id, sub_name, status)
values (1, 'SMS', true);
insert into sub_type(sub_type_id, sub_name, status)
values (2, 'EMAIL', false);

SET FOREIGN_KEY_CHECKS = 1;
commit;