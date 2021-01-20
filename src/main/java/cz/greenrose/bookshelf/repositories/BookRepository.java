package cz.greenrose.bookshelf.repositories;

import cz.greenrose.bookshelf.models.Book;
import cz.greenrose.bookshelf.models.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {

    Optional<Book> findFirstByBookTitleAndPublisherAndYearAndEditionNumberAndLanguage(String bookTitle, Publisher publisher, Integer year, Integer editionNumber, String language);
}
