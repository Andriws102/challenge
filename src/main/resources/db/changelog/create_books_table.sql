CREATE TABLE IF NOT EXISTS books (
    id bigint NOT NULL AUTO_INCREMENT,
    title varchar(100) NOT NULL,
    summary text,
    published_at datetime,
    created_at datetime NOT NULL,
    PRIMARY KEY (id)
 )