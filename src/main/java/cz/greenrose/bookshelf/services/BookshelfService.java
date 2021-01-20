package cz.greenrose.bookshelf.services;

import cz.greenrose.bookshelf.DTO.AuthorBookshelfDTO;
import cz.greenrose.bookshelf.models.Book;
import cz.greenrose.bookshelf.models.Bookshelf;
import org.springframework.stereotype.Service;

@Service
public interface BookshelfService {
    Bookshelf addAuthorDTOsToBook(Book book, AuthorBookshelfDTO authorBookshelfDTO);
}
