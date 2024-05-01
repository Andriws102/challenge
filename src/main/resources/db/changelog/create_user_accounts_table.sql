CREATE TABLE IF NOT EXISTS user_accounts (
    id bigint NOT NULL AUTO_INCREMENT,
    user_id bigint NOT NULL,
    username varchar(30) NOT NULL,
    password varchar(30) NOT NULL,
    created_at datetime NOT NULL,
    status_id int NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES users(id)
 )