CREATE TABLE IF NOT EXISTS reviews (
    id bigint NOT NULL AUTO_INCREMENT,
    book_id bigint NOT NULL,
    user_id bigint NOT NULL,
    comment text,
    rate int NOT NULL,
    commented_at datetime NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (book_id) REFERENCES books(id),
    FOREIGN KEY (user_id) REFERENCES users(id)
 )