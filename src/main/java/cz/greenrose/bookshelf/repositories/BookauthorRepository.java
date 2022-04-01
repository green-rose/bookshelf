package cz.greenrose.bookshelf.repositories;

import cz.greenrose.bookshelf.models.Book;
import cz.greenrose.bookshelf.models.Bookauthor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookauthorRepository extends JpaRepository<Bookauthor,Integer> {
 Integer deleteAllByBook(Book book);
}
