package cz.greenrose.bookshelf.services;

import cz.greenrose.bookshelf.DTO.AuthorBookauthorDTO;
import cz.greenrose.bookshelf.models.Book;
import cz.greenrose.bookshelf.models.Bookauthor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public interface BookauthorService {
    Bookauthor addAuthorDTOsToBook(Book book, AuthorBookauthorDTO authorBookauthorDTO);

    @Transactional
    Integer deleteAuthorsFromBook(Book book);
}
