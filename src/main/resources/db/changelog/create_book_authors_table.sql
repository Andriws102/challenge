CREATE TABLE IF NOT EXISTS books_authors (
    id bigint NOT NULL AUTO_INCREMENT,
    book_id bigint NOT NULL,
    author_id bigint NOT NULL,
    order_position int,
    PRIMARY KEY (id),
    FOREIGN KEY (book_id) REFERENCES books(id),
    FOREIGN KEY (author_id) REFERENCES authors(id)
 )