CREATE TABLE IF NOT EXISTS authors (
    id bigint NOT NULL AUTO_INCREMENT,
    name varchar(50) NOT NULL,
    lastname varchar(50) NOT NULL,
    country varchar(20),
    PRIMARY KEY (id)
 )