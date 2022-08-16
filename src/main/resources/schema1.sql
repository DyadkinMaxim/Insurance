/* --ROLLBACK
 drop table if exists type_class;
 drop table if exists post_codes;
 drop table if exists premium;
 */

create table type_class (
                        id LONG  NOT NULL AUTO_INCREMENT PRIMARY KEY,
                        class_name VARCHAR(255),
                        value VARCHAR(255)
);

create table post_codes (
                         id LONG NOT NULL AUTO_INCREMENT PRIMARY KEY,
                         post_code VARCHAR(255),
                         federal_state VARCHAR(255),
                         county VARCHAR(255),
                         city VARCHAR(255),
                         location VARCHAR(255),
                         value DOUBLE
);

create table premium (
                       id LONG NOT NULL AUTO_INCREMENT PRIMARY KEY,
                       user VARCHAR(255),
                       premium DOUBLE,
                       mileage DOUBLE,
                       type_class_factor DOUBLE,
                       regional_factor DOUBLE
);