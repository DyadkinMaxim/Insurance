/* --ROLLBACK
 drop table if exists comments;
 drop table if exists books;
 drop table if exists styles;
 drop table if exists authors;
 drop table if exists type_class;
 drop table if exists post_codes;
 drop table if exists premium;
 */

create table if not exists styles (
                        ID LONG  NOT NULL AUTO_INCREMENT PRIMARY KEY,
                        STYLE VARCHAR(255)
);

create table if not exists authors (
                         ID LONG NOT NULL AUTO_INCREMENT PRIMARY KEY,
                         AUTHOR VARCHAR(255)
);

create table if not exists books (
                       ID LONG NOT NULL AUTO_INCREMENT PRIMARY KEY,
                       BOOK VARCHAR(255),
                       AUTHOR_ID LONG,
                       STYLE_ID LONG,
                       FOREIGN KEY (AUTHOR_ID) REFERENCES authors(ID) ON DELETE CASCADE,
                       FOREIGN KEY (STYLE_ID) REFERENCES styles(ID) ON DELETE CASCADE
);

create table if not exists comments (
                          ID LONG NOT NULL AUTO_INCREMENT PRIMARY KEY,
                          COMMENT VARCHAR(255),
                          BOOK_ID LONG,
                          FOREIGN KEY (BOOK_ID) REFERENCES books(ID) ON DELETE CASCADE
);

create table if not exists type_class (
                            id LONG  NOT NULL AUTO_INCREMENT PRIMARY KEY,
                            class_name VARCHAR(255),
                            factor_value DOUBLE
);

create table if not exists post_codes (
                            id LONG NOT NULL AUTO_INCREMENT PRIMARY KEY,
                            post_code  LONG,
                            federal_state VARCHAR(255),
                            county VARCHAR(255),
                            city VARCHAR(255),
                            location VARCHAR(255),
                            factor_value DOUBLE
);

create table if not exists premium (
                         id LONG NOT NULL AUTO_INCREMENT PRIMARY KEY,
                         user_name VARCHAR(255),
                         premium DOUBLE,
                         mileage DOUBLE,
                         type_class_factor DOUBLE,
                         regional_factor DOUBLE
);