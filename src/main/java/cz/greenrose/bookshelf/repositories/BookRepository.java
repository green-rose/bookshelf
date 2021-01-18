package cz.greenrose.bookshelf.repositories;

import cz.greenrose.bookshelf.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {

}
