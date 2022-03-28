package cz.greenrose.bookshelf.repositories;

import cz.greenrose.bookshelf.models.Book;
import cz.greenrose.bookshelf.models.Bookshelf;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookshelfRepository extends JpaRepository<Bookshelf,Integer> {
 Integer deleteAllByBook(Book book);
}
