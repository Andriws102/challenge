CREATE TABLE IF NOT EXISTS books_copies (
    id bigint NOT NULL AUTO_INCREMENT,
    book_id bigint NOT NULL,
    publisher_id bigint NOT NULL,
    status_id int,
    PRIMARY KEY (id),
    FOREIGN KEY (book_id) REFERENCES books(id),
    FOREIGN KEY (publisher_id) REFERENCES publishers(id)
 )