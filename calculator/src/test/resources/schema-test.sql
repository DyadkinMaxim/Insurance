/* --ROLLBACK
 drop table if exists type_class;
 drop table if exists region;
 drop table if exists premium;
 */

create table if not exists type_class (
                            id LONG  NOT NULL AUTO_INCREMENT PRIMARY KEY,
                            class_name VARCHAR(255),
                            factor_value DOUBLE
);

create table if not exists region (
                            id LONG NOT NULL AUTO_INCREMENT PRIMARY KEY,
                            federal_state VARCHAR(255),
                            county VARCHAR(255),
                            city VARCHAR(255),
                            post_code  LONG,
                            location VARCHAR(255),
                            factor_value DOUBLE
);

create table if not exists premium (
                         id LONG NOT NULL AUTO_INCREMENT PRIMARY KEY,
                         premium_value DOUBLE,
                         mileage_factor DOUBLE,
                         type_class_factor_id LONG,
                         regional_factor_id LONG
);