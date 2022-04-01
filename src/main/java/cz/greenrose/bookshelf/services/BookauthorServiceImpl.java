package cz.greenrose.bookshelf.services;

import cz.greenrose.bookshelf.DTO.AuthorBookauthorDTO;
import cz.greenrose.bookshelf.models.Author;
import cz.greenrose.bookshelf.models.Book;
import cz.greenrose.bookshelf.models.Bookauthor;
import cz.greenrose.bookshelf.repositories.AuthorRepository;
import cz.greenrose.bookshelf.repositories.BookauthorRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookauthorServiceImpl implements BookauthorService {
    private final BookauthorRepository bookauthorRepository;
    private final AuthorRepository authorRepository;

    public BookauthorServiceImpl(BookauthorRepository bookauthorRepository, AuthorRepository authorRepository) {
        this.bookauthorRepository = bookauthorRepository;
        this.authorRepository = authorRepository;
    }
    public Bookauthor addAuthorDTOsToBook(Book book, AuthorBookauthorDTO authorBookshelfDTO){
        Bookauthor bookuthor = new Bookauthor();
        bookuthor.setBook(book);
        Author author;
        if (authorBookshelfDTO.getId()!=null) {
            author = this.authorRepository.findById(authorBookshelfDTO.getId()).orElse(null);
        } else {
            author = this.authorRepository.findFirstByNamesAndSurname(authorBookshelfDTO.getNames(), authorBookshelfDTO.getSurname()).orElse(null);
        };
        bookuthor.setAuthor(author);
        bookuthor.setMainAuthor(authorBookshelfDTO.getMainAuthor());
        bookuthor.setEditor(authorBookshelfDTO.getEditor());

      return this.bookauthorRepository.save(bookuthor);
    }
    @Transactional
    public Integer deleteAuthorsFromBook(Book book){
        return this.bookauthorRepository.deleteAllByBook(book);
    }
}
