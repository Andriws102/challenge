CREATE TABLE IF NOT EXISTS booking (
    id bigint NOT NULL AUTO_INCREMENT,
    book_copy_id bigint NOT NULL,
    user_id bigint NOT NULL,
    booking_at datetime NOT NULL,
    booking_since datetime NOT NULL,
    booking_until datetime NOT NULL,
    returned_at datetime,
    status_id int,
    PRIMARY KEY (id),
    FOREIGN KEY (book_copy_id) REFERENCES books_copies(id),
    FOREIGN KEY (user_id) REFERENCES users(id)
 )