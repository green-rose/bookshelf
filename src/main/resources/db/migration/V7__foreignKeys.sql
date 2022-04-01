ALTER TABLE `book` ADD FOREIGN KEY (`publisher_id_publisher`) REFERENCES `publisher`(`id_publisher`) ON DELETE RESTRICT ON UPDATE RESTRICT;
ALTER TABLE `bookauthor` ADD FOREIGN KEY (`author_id_author`) REFERENCES `author`(`id_author`) ON DELETE RESTRICT ON UPDATE RESTRICT;
ALTER TABLE `bookauthor` ADD FOREIGN KEY (`book_id_book`) REFERENCES `book`(`id_book`)  ON DELETE CASCADE ON UPDATE RESTRICT;
