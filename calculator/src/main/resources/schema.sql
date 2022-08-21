/* --ROLLBACK
 drop table if exists premium;
 */

create table if not exists premium
(
    id                LONG NOT NULL AUTO_INCREMENT PRIMARY KEY,
    premium_value     DOUBLE,
    mileage_factor    DOUBLE,
    type_class_factor DOUBLE,
    regional_factor   DOUBLE
);