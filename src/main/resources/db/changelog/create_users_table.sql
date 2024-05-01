CREATE TABLE IF NOT EXISTS users (
    id bigint NOT NULL AUTO_INCREMENT,
    name varchar(50) NOT NULL,
    lastname varchar(50) NOT NULL,
    age int,
    email varchar(50) NOT NULL,
    contact_number varchar(50) NOT NULL,
    created_at datetime NOT NULL,
    status_id int NOT NULL,
    PRIMARY KEY (id)
 )