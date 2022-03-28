package cz.greenrose.bookshelf.services;

import cz.greenrose.bookshelf.DTO.AuthorBookshelfDTO;
import cz.greenrose.bookshelf.models.Book;
import cz.greenrose.bookshelf.models.Bookshelf;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public interface BookshelfService {
    Bookshelf addAuthorDTOsToBook(Book book, AuthorBookshelfDTO authorBookshelfDTO);

    @Transactional
    Integer deleteAuthorsFromBook(Book book);
}
