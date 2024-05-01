CREATE TABLE IF NOT EXISTS publishers (
    id bigint NOT NULL AUTO_INCREMENT,
    name varchar(50) NOT NULL,
    country varchar(20),
    PRIMARY KEY (id)
 )