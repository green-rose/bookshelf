ALTER TABLE `book` ADD FOREIGN KEY (`series_id_series`) REFERENCES `series`(`id_series`) ON DELETE RESTRICT ON UPDATE RESTRICT;
